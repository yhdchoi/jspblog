let index={
	init:function(){
		$("#btn-join").on("click", ()=>{
			this.save();
		});
		
		$("#btn-login").on("click", ()=>{
			this.login();
		});
	},
	
	save:function(){
		
		//TODO: Confirm Password check
		
		let data = {
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val()
		};		
		
		$.ajax({
			type: "POST",
			url: "/api/user/join",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			
		}).done(function(){
			alert("Join successful! Please Login again.");
			location.href = "/";
		}).fail(function(){
			alert(JSON.stringify(error));			
		});
	},
	
	
	login:function(){
		
		let data = {
			email:$("#email").val(),
			password:$("#password").val()
		};		
		
		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			
		}).done(function(){
			alert("Login successful!");			
			location.href = "/";
		}).fail(function(){
			alert("Failed to login. Please try again.");			
		});
	}
};

index.init();