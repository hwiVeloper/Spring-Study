<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

<form action="/user/loginPost" method="post">
	<div class="form-group has-feedback">
		<input type="text" class="form-control" name="uid" placeholder="USER ID" />
		<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
	</div>
	<div class="form-group has-feedback">
		<input type="password" class="form-control" name="upw" placeholder="Password"/>
		<span class="glyphicon glyphicon-lock form-control-feedback"></span>
	</div>
	<div class="row">
		<div class="col-xs-8">
			<div class="icheck">
				<label>
					<input type="checkbox" class="" name="useCookie"/> Remember Me
				</label>
			</div>
		</div>
		<div class="col-xs-4">
			<button class="btn btn-primary btn-block btn-flat">Sign In</button>
		</div>
	</div>
</form>

<%@ include file="../include/footer.jsp" %>