<%@ include file="../include/header.jsp" %>
	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label>
				<input type="text" name="title" class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label>
				<input type="text" name="writer" class="form-control" placeholder="Enter writer">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Context</label>
				<textarea name="content" id="" rows="3" class="form-control" placeholder="Enter ..."></textarea>
			</div>
		</div>
		
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
	</form>
<%@ include file="../include/footer.jsp" %>