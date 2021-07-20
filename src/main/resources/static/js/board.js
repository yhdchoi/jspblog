let index = {
	init: function() {
		$("#btn-register").on("click", () => {
			this.save();
		});

		$("#btn-delete").on("click", () => {
			this.deleteById();
		});

		$("#btn-update").on("click", () => {
			this.updateById();
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

	deleteById: function() {

		let id = $("#id").text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/delete" + id,
			dataType: 'json'

		}).done(function(resp) {
			alert("Delete successful.");
			location.href = "/";

		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

	updateById: function() {

		let id = $("#id").text();

		let data = {
			title: $("#title").val(),
			content: $("#content").val()
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/update" + id,
			data: JSON.stringify(data),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json'

		}).done(function() {
			alert("Update successful.");
			location.href = "/";

		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},

};

index.init();