<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <form>
    <div class="form-group w-50 m-auto">
      <input type="text" class="form-control mt-2 mb-3" id="username" placeholder="Enter your Username"
        name="username" required>
    </div>
    <br />
    <div class="form-group w-50 m-auto">
      <input type="email" class="form-control mt-2 mb-3" id="email" placeholder="Enter your Email"
        name="email" required>
    </div>
  </form>
  
  <br />  
  <hr />

  <div class="mt-2 ">
    <button class="btn btn-outline-danger" id="btn-recoverpassword">Recover Password</button>
  </div>

</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
