<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- class="was-validated" -->

  <form class="mt-6 mb-6">
  <input type="hidden" id="id" value="${board.id}"/>
  
    <div class="form-group">
      <input type="text" value="${board.title}" class="form-control mt-2 mb-3" id="title" placeholder="Title here"
        required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group">
      <textarea class="form-control summernote" id="content">${board.content}</textarea>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
  </form>
  <br>
  <div class="mt-5 text-center">
    <button class="btn btn-outline-success" id="btn-update">Update</button>
  </div>
</div>

<script>
	$('.summernote').summernote({
		placeholder : 'Write here',
		tabsize : 2,
		height : 300
	});
</script>

<script src="/js/board.js"></script>

<%@include file="../layout/footer.jsp"%>
