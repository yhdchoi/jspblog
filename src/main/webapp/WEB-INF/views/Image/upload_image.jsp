<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- Image -->

  <h3>Profile Image</h3>
  <br />

  <form>
    <div class="form-group">
      <input type="hidden" id="id" value="${principal.user.id}" />

      <label for="username">Upload your profile image: </label>
      <input type="file" id="image" name="image" placeholder="Image File">
    </div>
  </form>
  <br />

  <hr />

  <div class="mt-2 ">
    <button class="btn btn-outline-success" id="btn-imgUpload">Upload</button>
  </div>

</div>

<script src="/js/image.js"></script>

<%@include file="../layout/footer.jsp"%>
