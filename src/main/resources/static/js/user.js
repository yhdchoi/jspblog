let index={
	init:function(){
		$("#btn-join").on("click", ()=>{
			this.save();
		});	
		
		$("#btn-update").on("click", ()=>{
			this.updateUser();
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
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			
		}).done(function(){
			alert("Join successful! Please Login again.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));			
		});
	},
	
	updateUser:function(){
		
		//TODO: Confirm Password check
		
		let id = $("#id").val();
		
		let data = {			
			email:$("#email").val(),
			password:$("#password").val()
		};		
		
		$.ajax({
			type: "PUT",
			url: "/user/update/" + id,
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			
		}).done(function(){
			alert("Update successful! Please login again.");
			location.href = "/logout";
		}).fail(function(error){
			alert(JSON.stringify(error));			
		});
	}

};

index.init();