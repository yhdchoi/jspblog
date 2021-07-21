<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5 text-center">

  <!-- class="was-validated" -->
  <h3>Join</h3>
  <br />
  <form>
    <div class="form-group w-50 m-auto">
      <input type="text" class="form-control mt-2 mb-3" id="username" placeholder="Enter Username"
        name="username" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 m-auto">
      <input type="email" class="form-control mt-2 mb-3" id="email" placeholder="Enter email"
        name="email" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 m-auto">
      <input type="password" class="form-control mt-2" id="password" placeholder="Enter password"
        name="password" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
  </form>

  <br>

  <div class="mt-5 mb-4">
    <button class="btn btn-outline-success btn-sm" id="btn-join">Submit</button>
  </div>

</div>

<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>
