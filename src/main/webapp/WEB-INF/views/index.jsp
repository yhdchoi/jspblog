<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<div class="container mt-4 mb-5">

  <form class="d-flex me-4 mb-4">
    <input class="form-control" type="search" id="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success" type="submit" id="btn-search">Search</button>
  </form>
  <br/>
  <div class="card mb-4">
    <div class="card-body">
      <h4 class="card-title">Title</h4>
      <p class="card-text">Username</p>
      <a href="#" class="btn btn-outline-info">Read</a>
    </div>
  </div>

</div>

<%@include file="layout/footer.jsp"%>
