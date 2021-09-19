let index = {
	init: function() {
		$("#btn-imgUpload").on("click", () => {
			this.save();
		});

	},

	save: function() {

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "POST",
			url: "/api/board/register",
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