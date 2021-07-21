<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<div class="container mt-4 mb-5 min-vh-100">

<!-- Search -->
  <form action="/" method="GET" class="d-flex me-4 mb-4">
    <input class="form-control mr-2" type="search" id="search" name="search" placeholder="Search keyword" aria-label="Search">
    <button class="btn btn-outline-success" type="submit" id="btn-search">Search</button>
  </form>
  <br />

<!-- List -->
  <c:forEach var="board" items="${boards.content}">
    <div class="card mb-4">
      <div class="card-body">
        <h4 class="card-title">${board.title}</h4>
        <p class="card-text">${board.user.username}</p>
        <a href="/board/${board.id}" class="btn btn-outline-info">Read</a>
      </div>
    </div>
  </c:forEach>

  <ul class="pagination justify-content-center">

    <!-- Previous -->
    <c:choose>
      <c:when test="${boards.first}"></c:when>
      <c:otherwise>
        <li class="page-item">
          <a class="page-link" href="?search=${param.search}&page=0">First</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="?search=${param.search}&page=${boards.number-1}">&larr;</a>
        </li>
      </c:otherwise>
    </c:choose>

    <!-- Page Group -->
    <c:forEach begin="${startBlockPage}" end="${endBlockPage}" var="i">
      <c:choose>
        <c:when test="${boards.pageable.pageNumber+1 == i}">
          <li class="page-item disabled">
            <a class="page-link" href="?search=${param.search}&page=${i-1}">${i}</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="page-item">
            <a class="page-link" href="?search=${param.search}&page=${i-1}">${i}</a>
          </li>
        </c:otherwise>
      </c:choose>
    </c:forEach>

    <!-- Next -->
    <c:choose>
      <c:when test="${boards.last}"></c:when>
      <c:otherwise>
        <li class="page-item ">
          <a class="page-link" href="?search=${param.search}&page=${boards.number+1}">&rarr;</a>
        </li>
        <li class="page-item ">
          <a class="page-link"
            href="?search=${param.search}&page=${boards.totalPages-1}">Last</a>
        </li>
      </c:otherwise>
    </c:choose>

  </ul>
</div>

<%@include file="layout/footer.jsp"%>
