<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>

<div class="container min-vh-100 mt-5 mb-5">

  <div class="mb-2 text-end">
    <c:if test="${board.user.id == principal.user.id }">
      <button class="btn btn-outline-success" onclick="history.back()">Back to list</button>
      <a class="btn btn-outline-warning" href="/board/update/${board.id}">Update</a>
      <button class="btn btn-outline-danger" id="btn-delete">Delete</button>
    </c:if>
  </div>

  <hr />

  <div class="form-group d-flex justify-content-between">
    <div>
      Article#:
      <span id="id">
        <i>${board.id} </i>
      </span>
    </div>
    <div class="d-flex">
      <span>
        By:
        <i> ${board.user.username} </i>
      </span>
    </div>
  </div>

  <hr />

  <div class="form-group">
    <h3 id="title">${board.title}</h3>
  </div>

  <hr />

  <div class="form-group">
    <div class="" id="content">${board.content}</div>
  </div>

  <br />

  <div class="card">
    <form>
     <input type="hidden" id="userId" value="${principal.user.id}" />
      <input type="hidden" id="boardId" value="${board.id}" />
      <div class="card-body">
        <textarea class="form-control summernote" rows="2" id="comment--content"></textarea>
      </div>

      <div class="card-footer">
        <button type="button" class="btn btn-info" id="btn-comment--post">Post</button>
      </div>
    </form>
  </div>

  <br />

  <div class="card">
    <div class="card-header">Comments:</div>
    <ul class="list-group" id="comment--box">
      <c:forEach var="comment" items="${board.comments}">
        <li class="list-group-item d-flex justify-content-between" id="coment--1">
          <div>${comment.content}</div>
          <div class="d-flex">
            <div class="font-italic">By: ${comment.user.username}</div>
            <button class="badge ">Delete</button>
          </div>
        </li>
      </c:forEach>
    </ul>
  </div>

</div>
<script>
	$('.summernote').summernote({
		placeholder : 'Comment here',
		tabsize : 2,
		height : 100
	});
</script>
<script src="/js/board.js"></script>
<%@include file="../layout/footer.jsp"%>
