<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- Image -->

  <div class="form-group">
    <input type="hidden" id="id" value="${principal.user.id}" />

    <label for="username">Username: </label>
    <input type="text" class="form-control" id="username" value="${principal.user.username}"
      readonly>

  </div>
  <br />

  <div class="form-group">
    <label for="email">Email: </label>
    <input type="email" class="form-control" id="email" value="${principal.user.email}">
  </div>
  <br />

  <div class="form-group">
    <label for="password">Password: </label>
    <input type="password" class="form-control" id="password">
  </div>
  <br />

  <div class="form-group">
    <label for="password">Confirm Password: </label>
    <input type="password" class="form-control" id="confirmpassword">
  </div>
  <br />

  <div class="form-group">
    <label for="regDate">Created on: </label>
    <input type="text" class="form-control" id="regDate" value="${principal.user.regDate}" readonly>

  </div>
  <br />

  <div class="form-group">
    <label for="modDate">Updated on: </label>
    <input type="text" class="form-control" id="modeDate" value="${principal.user.modDate}" readonly>

  </div>
  <hr />

  <div class="mt-2 ">
    <button class="btn btn-outline-warning" id="btn-update">Save Changes</button>
    <button class="btn btn-outline-danger" id="btn-delete">Delete</button>
  </div>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
