let index={
	init:function(){
		$("#btn-join").on("click", ()=>{
			this.save();
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
		}).fail(function(){
			alert(JSON.stringify(error));			
		});
	}

};

index.init();