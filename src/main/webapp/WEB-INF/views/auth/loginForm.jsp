<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5 text-center">

  <!-- class="was-validated" -->
  <h3>Login</h3>
  <br />
  <form action="/auth/loginProc" method="POST">
    <div class="form-group w-50 m-auto">
      <input type="text" class="form-control mt-2 mb-3" id="username" placeholder="Enter username"
        name="username" required>
    </div>
    <br />
    <div class="form-group w-50 mb-4 m-auto">
      <input type="password" class="form-control mt-2 mb-2" id="password" placeholder="Enter password"
        name="password" required> 
    </div>
    
    <a class="fs-6 fst-italic" href="/auth/password">Forgot your password?</a>
    
    <div class="mt-3 mb-4">
      <button class="btn btn-outline-primary btn-sm" id="btn-login">Login</button>
    </div>
    <div class="mb-4">
      <a class="btn btn-outline-success btn-sm" href="/auth/joinForm">Signup</a>
    </div>
    <a
      href="https://kauth.kakao.com/oauth/authorize?client_id=abcd6e06f02103cdd01e8fad0833bfe0&redirect_uri=http://localhost:8080/auth/kakao/callback&response_type=code">
      <img height="38" src="/image/kakao_login_large_narrow.png" />
    </a>

  </form>
</div>

<%@include file="../layout/footer.jsp"%>
