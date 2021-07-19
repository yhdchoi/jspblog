<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container h-auto text-center mt-5 mb-5">

  <!-- class="was-validated" -->
  <h3>Join</h3>
  <br />
  <form class="mt-6 mb-6">
    <div class="form-group w-50 m-auto">
      <label for="username">Username</label>
      <input type="text" class="form-control mt-2 mb-3" id="username" placeholder="Enter Username"
        name="username" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 m-auto">
      <label for="email">Email</label>
      <input type="email" class="form-control mt-2 mb-3" id="email" placeholder="Enter email"
        name="email" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 m-auto">
      <label for="password">Password</label>
      <input type="password" class="form-control mt-2" id="password" placeholder="Enter password"
        name="password" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
  </form>

  <br>

  <div class="mt-5">
    <button class="btn btn-outline-success" id="btn-join">Submit</button>
  </div>

</div>

<script src="/jblog/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>
