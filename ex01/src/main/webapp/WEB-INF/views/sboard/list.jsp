<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<%@ include file="../include/header.jsp" %>

<script>
	var result = '${msg}';
	
	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
	}
	
	$(document).ready(function() {
		$('#searchBtn').on('click', function(event) {
			self.location = 'list'
				+ '${ pm.makeQuery(1) }'
				+ '&searchType='
				+ $('select option:selected').val()
				+ '&keyword=' + $('#keywordInput').val();
		});
		
		$('#newBtn').on('click', function(evt) {
			self.location = 'register';
		});
	});
</script>

<!-- Search Area Start -->
<div class="box-body">
	<select name="searchType">
		<option value="n"   <c:out value="${ cri.searchType == null  ? 'selected' : '' }"/>>---</option>
		<option value="t"   <c:out value="${ cri.searchType eq 't'   ? 'selected' : '' }"/>>제목으로 검색</option>
		<option value="c"   <c:out value="${ cri.searchType eq 'c'   ? 'selected' : '' }"/>>내용으로 검색</option>
		<option value="w"   <c:out value="${ cri.searchType eq 'w'   ? 'selected' : '' }"/>>작성자으로 검색</option>
		<option value="tc"  <c:out value="${ cri.searchType eq 'tc'  ? 'selected' : '' }"/>>제목이나 내용으로 검색</option>
		<option value="cw"  <c:out value="${ cri.searchType eq 'cw'  ? 'selected' : '' }"/>>내용이나 작성자로 검색</option>
		<option value="tcw" <c:out value="${ cri.searchType eq 'tcw' ? 'selected' : '' }"/>>통합검색</option>
	</select>
	<input type="text" name="keyword" id="keywordInput" value="${ cri.keyword }" class=""/>
	<button id="searchBtn" class="btn btn-success">검색</button>
	<button id="newBtn" class="btn btn-warning">새글쓰기</button>
</div>
<!-- Search Area End -->

<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
	<c:forEach items="${ list }" var="boardVO">
		<tr>
			<td>${ boardVO.bno }</td>
			<td>
				<a href="/sboard/readPage${ pm.makeSearch(pm.cri.page) }&bno=${ boardVO.bno }">${ boardVO.title }</a>
			</td>
			<td>${ boardVO.writer }</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${ boardVO.regdate }" />
			</td>
			<td>
				<span class="badge bg-red">${ boardVO.viewcnt }</span>
			</td>
		</tr>
	</c:forEach>
</table>
<div class="text-center">
	<ul class="pagination">
		<c:if test="${ pm.prev }">
			<li><a href="list${ pm.makeSearch(pm.startPage - 1) }">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${ pm.startPage }"
			end="${ pm.endPage }" var="idx">
			<li <c:out value="${ pm.cri.page == idx ? 'class=active' : ''}" />>
				<a href="list${ pm.makeSearch(idx) }">${ idx }</a>
			</li>
		</c:forEach>
		<c:if test="${ pm.next && pm.endPage > 0 }">
			<li><a href="list${ pm.makeSearch(pm.endPage + 1) }">&raquo;</a></li>
		</c:if>
	</ul>
</div>

<%@ include file="../include/footer.jsp" %>