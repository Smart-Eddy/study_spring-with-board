<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../includes/header.jsp" %>

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
		For more information about DataTables, please visit the <a target="_blank"
			href="https://datatables.net">official DataTables documentation</a>.</p>
	
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Bno</th>
							<th>Title</th>
							<th>Writer</th>
							<th>RegDate</th>
							<th>UpdateDate</th>
						</tr>
					</thead>
					<tbody>
					
					<!-- JSTL c:out 태그를 사용하여 XSS(Cross-Site Scripting)을 방지할 수 있다.-->
					<!-- c:out 태그는 HTML로 출력될 때 문자를 자동으로 이스케이프 처리해준다. (<, >, & 등의 문자를 &lt;, &gt;, $amp; 등으로 변환해서 처리) -->
					<!-- 또한, 값이 null일 경우 default로 빈 문자열로 출력해준다. (Null Pointer Exception 방지) default값을 지정할 수도 있다. -->
					<c:forEach var="board" items="${list}">
						<tr>
							<td><c:out value="${board.bno}"/></td>
							<td><c:out value="${board.title}"/></td>
							<td><c:out value="${board.content}"/></td>
							<td><c:out value="${board.regDate}"/></td>
							<td><c:out value="${board.updateDate}"/></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
<%@ include file="../includes/footer.jsp" %>

<%@ include file="../includes/end.jsp" %>