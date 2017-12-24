<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("boardModBtn").on("click", function() {
		formObj.attr("action", "/sboard/modifyPage");
		formObj.attr("method", "get");
		formObj.submit();
	});
	
	$("#boardDelBtn").on("click", function() {
		formObj.attr("action", "/sboard/removePage");
		formObj.attr("method", "post");
		formObj.submit();
	});
	
	$("#boardAllBtn").on("click", function() {
		// self.location = "/board/listAll";
		formObj.attr("method", "get");
		formObj.attr("action", "/sboard/list");
		formObj.submit();
	});
	
	$("#repliesDiv").click(function() {
		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("/replies/" + bno + "/1");
	});
	
	$(".pagination").on("click", "li a", function(event) {
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("/replies/" + bno + "/" + replyPage);
	});
	
	$("#replyAddBtn").click(function() {
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		
		if (replyer == "" || replytext == "") {
			alert("빈값은 허용되지 않습니다.");
			return;
		}
		
		$.ajax({
			type:'post',
			url:'/replies/',
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "POST"
			},
			dataType: 'text',
			data: JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
			success: function(result) {
				console.log("result : " + result);
				if(result == 'SUCCESS') {
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					replyerObj.val("");
					replytextObj.val("");
				}
			}
		});
	});
	
	$(".timeline").on("click", ".replyLi", function(event) {
		var reply = $(this);
		
		$("#replytext").val(reply.find(".timeline-body").text());
		$(".modal-title").html(reply.attr("data-rno"));
	});
	
	$("#replyModBtn").click(function() {
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			type: 'put',
			url: '/replies/' + rno,
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "PUT"
			},
			data: JSON.stringify({replytext:replytext}),
			dataType:'text',
			success: function(result) {
				console.log("result : " + result);
				if (result == 'SUCCESS') {
					alert("수정 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
	
	$('#replyDelBtn').click(function() {
		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();
		
		$.ajax({
			type: 'delete',
			url: '/replies/' + rno,
			headers: {
				"Content-Type": "application/json",
				"X-HTTP-Method-Override": "DELETE"
			},
			dataType: 'text',
			success: function(result) {
				console.log("result: " + result);
				if(result == 'SUCCESS') {
					alert("삭제 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
});
</script>

<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="replyLi" data-rno={{ rno }}>
	<i class="fa fa-comments bg-blue"></i>
	<div class="timeline-item">
		<span class="time">
			<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
		</span>
		<h3 class="timeline-header">
			<strong>{{rno}}</strong> - {{replyer}}
		</h3>
		<div class="timeline-body">{{replytext}}</div>
		<div class="timeline-footer">
			<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">수정</a>
		</div>
	</div>
</li>
{{/each}}
</script>

<script>

Handlebars.registerHelper("prettifyDate", function(timeValue) {
	var dateObj = new Date(timeValue);
	var year = dateObj.getFullYear();
	var month = dateObj.getMonth() + 1;
	var date = dateObj.getDate();
	return year + "/" + month + "/" + date;
});

var printDate = function (replyArr, target, templateObject) {
	var template = Handlebars.compile(templateObject.html());
	
	var html = template(replyArr);
	$(".replyLi").remove();
	target.after(html);
}

var bno = ${boardVO.bno};
var replyPage = 1;

function getPage(pageInfo) {
	$.getJSON(pageInfo, function(data) {
		printDate(data.list, $("#repliesDiv"), $("#template"));
		printPaging(data.pageMaker, $(".pagination"));
	});
}

var printPaging = function (pageMaker, target) {
	var str = "";
	
	if (pageMaker.prev) {
		str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
	}
	
	for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
		var strClass = pageMaker.cri.page == i ? 'class="active"' : '';
		str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
	}
	
	if (pageMaker.next) {
		str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
	}
	
	target.html(str);
}
</script>

<form role="form" action="modifyPage" method="post">
	<input type="hidden" name="bno" value="${ boardVO.bno }" />
	<input type="hidden" name="page" value="${ cri.page }" />
	<input type="hidden" name="perPageNum" value="${ cri.perPageNum }" />
	<input type="hidden" name="searchType" value="${ cri.searchType }">
	<input type="hidden" name="keyword" value="${ cri.keyword }" />
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
	<button type="submit" class="btn btn-warning" id="boardModBtn">Modify</button>
	<button type="submit" class="btn btn-danger" id="boardDelBtn">REMOVE</button>
	<button type="submit" class="btn btn-primary" id="boardAllBtn">LIST ALL</button>
</div>

<!--댓글 작성란 -->
<div class="row">
	<div class="col-md-12">
		<div class="box box-success">
			<div class="box-header">
				<h3 class="box-title">댓글작성</h3>
			</div>
			<div class="box-body">
				<label for="">작성자</label>
				<input type="text" class="form-control" placeholder="USER ID" id="newReplyWriter" required />
				<label for="">내용</label>
				<input type="text" class="form-control" placeholder="REPLY TEXT" id="newReplyText" required />
			</div>
			
			<div class="box-footer">
				<button class="btn btn-secondary" id="replyAddBtn">작성완료</button>
			</div>
		</div>
		
		<!-- Timeline -->
		<ul class="timeline">
			<li class="time-label" id="repliesDiv"><span class="bg-green">댓글 목록</span></li>
		</ul>
		
		<div class="text-center">
			<ul id="pagination" class="pagination pagination-sm no-margin">
			</ul>
		</div>
	</div>
</div>

<!-- Modal -->
<div id="modifyModal" class="modal modal-primary fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal Content -->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"></h4>
			</div>
			<div class="modal-body" data-rno>
				<p><input type="text" id="replytext" class="form-control" /></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" id="replyModBtn">수정</button>
				<button type="button" class="btn btn-danger" id="replyDelBtn">삭제</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp" %>