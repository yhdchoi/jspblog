let index = {
	init: function() {
		$("#btn-join").on("click", () => {
			this.save();
		});

		$("#btn-update").on("click", () => {
			this.update();
		});
		
		$("#btn-recoverpassword").on("click", () => {
			this.recoverPassword();
		});
	},

	save: function() {

		let pw = $("#password").val();
		let confirmpw = $("#confirmpassword").val();

		let data = {
			username: $("#username").val(),
			email: $("#email").val(),
			password: $("#password").val(),
			file: $("#profile_image").files[0]
		};

		if (pw != confirmpw) {
			alert("The passwords do not match! Please try again");
			location.href = "/auth/joinForm";
		} else {
			$.ajax({
				type: "POST",
				url: "/auth/joinProc",
				data: JSON.stringify(data),
				contentType: 'application/json; charset=utf-8',
				dataType: 'json'

			}).done(function(resp) {
				if (resp.status == 500) {
					alert("Existing account Please Login.");
				} else {
					alert("Join successful! Please Login again.");
				}
				location.href = "/";

			}).fail(function(error) {
				alert(JSON.stringify(error));
			});

		}
 
	},

	update: function() {

		let id = $("#id").val();

		let newpw = $("#newpassword").val();
		let confirmpw = $("#confirmpassword").val();

		let data = {
			newemail: $("#newemail").val(),
			newpassword: $("#newpassword").val()
		};

		if (newpw != confirmpw) {
			alert("The new passwords do not match! Please try again");
			location.href = "/user/profile";
		} else {

			$.ajax({
				type: "PUT",
				url: "/user/reset/" + id,
				data: JSON.stringify(data),
				contentType: 'application/json; charset=utf-8',
				dataType: 'json'

			}).done(function() {
				alert("Update successful! Please login again.");
				location.href = "/logout";
			}).fail(function(error) {
				alert(JSON.stringify(error));
			});
		}
	},

	recoverPassword: function() {

		let data = {
			username: $("#username").val(),
			email: $("#email").val()
		};
		
		$.ajax({
			type: "PUT",
			url: "/auth/recover",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'

		}).done(function() {
			alert("Recover successful! Please check your email for the instruction.");
			location.href = "/index";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}


};

index.init();