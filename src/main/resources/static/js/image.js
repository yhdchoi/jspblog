let index = {
	init: function() {
		$("#btn-imgUpload").on("click", () => {
			this.save();
		});

	},

	save: function() {

		let data = {
			
			file: $("#image").files
		};

		$.ajax({
			type: "POST",
			url: "/image/uploadImageFile",
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'

		}).done(function() {
			location.href = "/";

		}).fail(function() {
			alert(JSON.stringify(error));
		});
	},


};

index.init();