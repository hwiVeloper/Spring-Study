<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>
<form role="form" action="post">
	<input type="hidden" name="bno" value="${ boardVO.bno }" />
</form>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${ boardVO.title }" readonly />
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Content</label>
		<textarea name="content" id="" rows="3" class="form-control" readonly>${ boardVO.content }</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="writer" class="form-control" value="${ boardVO.writer }" readonly />
	</div>
</div>

<div class="box-footer">
	<button type="submit" class="btn btn-warning">Modify</button>
	<button type="submit" class="btn btn-warning">REMOVE</button>
	<button type="submit" class="btn btn-warning">LIST ALL</button>
</div>
<%@ include file="../include/footer.jsp" %>