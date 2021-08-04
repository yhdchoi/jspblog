<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- Image -->

  <form>
    <div class="form-group">
      <input type="hidden" id="id" value="${principal.user.id}" />

      <label for="username">Username: </label>
      <input type="text" class="form-control" id="username" value="${principal.user.username}"
        readonly>
    </div>
    <br />

    <div class="form-group">
      <label for="newemail">Email: </label>
      <input type="email" class="form-control" id="newemail" placeholder="Enter new email">
    </div>
    <br />

    <div class="form-group">
      <label for="newpassword">New Password: </label>
      <input type="password" class="form-control" id="newpassword" placeholder="Enter new password">
    </div>
    <br />

    <div class="form-group">
      <label for="confirmpassword">Confirm New Password: </label>
      <input type="password" class="form-control" id="confirmpassword"
        placeholder="Confirm new password">
    </div>
  </form>
  <br />

  <hr />

  <div class="mt-2 ">
    <a class="btn btn-outline-warning" id="btn-update">Update</a>
    <button class="btn btn-outline-danger" id="btn-delete">Delete</button>
  </div>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
