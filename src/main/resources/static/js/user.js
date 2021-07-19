let index={
	init:function(){
		$("#btn-join").on("click", ()=>{
			this.save();
		});
	},
	
	save:function(){
		
		let data = {
			username:$("#username").val(),
			email:$("#email").val(),
			password:$("#password").val()
		};		
		
		$.ajax({
			type: "POST",
			url: "/jblog/api/user/join",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'
			
		}).done(function(resp){
			alert("OK");
			alert(resp);
			
			// location.href = '/jblog/user/login'
		}).fail(function(){
			alert("FAIL");
			
		});
	}
};

index.init();