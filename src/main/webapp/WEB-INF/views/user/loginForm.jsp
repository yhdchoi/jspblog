<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <!-- class="was-validated" -->
  <h3>Login</h3>
  <br />
  <form action="/auth/loginProc" method="POST">
    <div class="form-group w-50 m-auto">
      <input type="text" class="form-control mt-1 mb-3" id="username" placeholder="Enter username"
        name="username" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 mb-4 m-auto">
      <input type="password" class="form-control mt-1 " id="password" placeholder="Enter password"
        name="password" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>

<!--     <div class="form-group form-check mt-5 ">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" id="remember">
        Remember me.
      </label>
    </div> -->

    <div class="mt-5">
      <button class="btn btn-outline-primary" id="btn-login">Submit</button>
    </div>
  </form>

</div>

<%@include file="../layout/footer.jsp"%>
