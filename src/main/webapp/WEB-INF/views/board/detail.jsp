<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <div class="mb-2 text-end">
    <c:if test="${board.user.id == principal.user.id }">
      <a class="btn btn-outline-warning" href="/board/update/${board.id}">Update</a>
      <button class="btn btn-outline-danger" id="btn-delete">Delete</button>
    </c:if>
  </div>
  <br />

  <div class="form-group">
    Article#:
    <span id="id">
      <i>${board.id} </i>
    </span>
    Written by:
    <span>
      <i> ${board.user.username} </i>
    </span>
    Written on:
    <span>
      <i> ${board.user.modDate} </i>
    </span>
  </div>
  
  <hr>

  <div class="form-group">
    <h3 id="title">${board.title}</h3>
  </div>

  <hr />

  <div class="form-group">
    <div class="" id="content">${board.content}</div>
  </div>
  <br>

  <div class="text-end">
    <button class="btn btn-outline-success" onclick="history.back()">Back to list</button>
  </div>

</div>

<script src="/js/board.js"></script>

<%@include file="../layout/footer.jsp"%>
