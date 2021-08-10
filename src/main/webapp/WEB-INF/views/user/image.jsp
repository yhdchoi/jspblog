<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- Image -->

  <h3>Profile Image</h3>
  <br />

  <form>
    <div class="form-group">
      <input type="hidden" id="id" value="${principal.user.id}" />

      <label for="username">Username: </label>
      <input type="text" class="form-control" id="username" value="${principal.user.username}">
    </div>


  </form>
  <br />

  <hr />

  <div class="mt-2 ">
    <button class="btn btn-outline-success" id="btn-imgUpload">Upload</button>
  </div>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
