<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <h3>Profile Image</h3>
  <br />

  <form method="post" action="/image/post" enctype="multipart/form-data">
    <div class="form-group">
      <input type="hidden" id="id" value="${principal.user.id}" />

      <input type="file" id="image" name="image" placeholder="Image File">
      <br />
      <input type="submit" value="submit" />
    </div>
  </form>
  <br />

</div>

<%@include file="../layout/footer.jsp"%>
