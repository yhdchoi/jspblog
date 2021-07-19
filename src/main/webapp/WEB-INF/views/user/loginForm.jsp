<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container text-center mt-5 mb-5">

  <!-- class="was-validated" -->
  <h3>Login</h3>
  <br />
  <form>
    <div class="form-group w-50 m-auto">
      <label for="email">Email</label>
      <input type="email" class="form-control mt-3 mb-3" id="email" placeholder="Enter email"
        name="email" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>
    <br />
    <div class="form-group w-50 mb-4 m-auto">
      <label for="password">Password</label>
      <input type="password" class="form-control mt-3 " id="password" placeholder="Enter password"
        name="password" required>
      <!-- <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">Please fill out this field.</div> -->
    </div>

    <div class="form-group form-check mt-5 ">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" id="remember">
        Remember me.
      </label>
    </div>
  </form>
  <br>
  
  <div class="mt-5">
    <button class="btn btn-outline-primary" id="btn-login">Submit</button>
  </div>
</div>

<script src="/js/user.js"></script>
<%@include file="../layout/footer.jsp"%>
