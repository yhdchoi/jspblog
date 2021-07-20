<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- Image -->

  <div class="form-group">
    <label for="username">${user.username}</label>
  </div>
  <br />

  <div class="form-group">
    <label for="username">${user.email}</label>
  </div>
  <br />

  <div class="form-group">
    <label for="username">Created on: ${user.regDate}</label>
  </div>
  <br />

  <div class="form-group">
    <label for="username">Updated on: ${user.modDate} </label>
  </div>
  <hr />

  <div class="mt-2 ">
    <button class="btn btn-outline-warning" id="btn-edit">Edit</button>
    <button class="btn btn-outline-danger" id="btn-delete">Delete</button>
  </div>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
