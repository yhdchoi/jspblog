package com.yhdc.jspblog.oauth2;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhdc.jspblog.model.KakaoProfile;
import com.yhdc.jspblog.model.OAuthToken;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.model.enums.OauthType;
import com.yhdc.jspblog.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class KakaoOauthController {
	
	private final UserService userService;
//	private final AuthenticationManager authenticationManager;
	

	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) {

		// Token
		String contentType = "application/x-www-form-urlencoded;charset=utf-8";
		String grantType = "authorization_cod";
		String clientId = "abcd6e06f02103cdd01e8fad0833bfe0";
		String redirectUri = "http://localhost:8080/auth/kakao/callback";

		RestTemplate rt = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", contentType);

		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grantType);
		params.add("client_id", clientId);
		params.add("redirect_uri", redirectUri);
		params.add("code", code);

		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params, headers);

		ResponseEntity<String> response = rt.exchange("https://kauth.kakao.com/oauth/token", HttpMethod.POST,
				kakaoTokenRequest, String.class);

		ObjectMapper obMapper = new ObjectMapper();
		OAuthToken oauthToken = null;

		try {
			oauthToken = obMapper.readValue(response.getBody(), OAuthToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// User info GET:
		String accessToken = "Bearer " + oauthToken.getAccess_token();

		RestTemplate rt2 = new RestTemplate();

		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", accessToken);
		headers2.add("Content-type", contentType);

		HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers2);

		ResponseEntity<String> response2 = rt2.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST,
				kakaoProfileRequest, String.class);

		ObjectMapper obMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;

		try {
			kakaoProfile = obMapper2.readValue(response2.getBody(), KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// Add info to User DB
		Integer tempPasswordkakaoId = kakaoProfile.getId();
		String kakaoEmail = kakaoProfile.getKakao_account().getEmail();				

		User kakaoUser = User.builder().username(kakaoEmail)
				.email(kakaoEmail).password(tempPasswordkakaoId.toString()).oauth(OauthType.KAKAO).build();
				
		User originUser = userService.findUserByEmail(kakaoEmail);
		
		if (originUser.getUsername() == null) {
			// Join n Login
			userService.joinUser(kakaoUser);			
		}else {
			// Only Login (Existing User)
//			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(kakaoUser.getUsername(), kakaoUser.getPassword()));
//			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		
		return "redirect:/";
	}
}
