<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>
<div class="page-header">
				<h1>欢迎${sessionScope.STAFF.staname },登录名庐职员系统 </h1>
			</div><!-- /.page-header -->
			<!-- content -->
			<div class="right_col" role="main">
				
				<div class="row">
					<div class="clo-md-12">
						<div class="panel panel-warning">
							<div class="panel-heading">
								<h4>查看全部会员信息</h4>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="clo-md-12">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr>
													<th>会员名称</th>
													<th>会员电话</th>
													<th>会员余额</th>
													<th>会员状态</th>
													<!-- ditionary表里的memstatus -->
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${ListMem }" var="member">
												<tr>
													<td>member.memname</td>
													<td>member.memphone</td>
													<td>member.membalance</td>
													<td>member.memstatusname</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
										 <ul class="pagination pull-right">
										    <li>
										      <a href="#" aria-label="Previous">
										        <span aria-hidden="true">&laquo;</span>
										      </a>
										    </li>
										    <li><a href="#">1</a></li>
										    <li><a href="#">2</a></li>
										    <li>
										      <a href="#" aria-label="Next">
										        <span aria-hidden="true">&raquo;</span>
										      </a>
										    </li>
										  </ul>
									</div>
								</div>
							</div>						
						</div>
						<div class="panel panel-info" style="margin-bottom: 60px;">
							<div class="panel-heading">
								<h4>查看会员消费信息</h4>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-md-12">
										<form action="${pageContext.request.contextPath }/staff/memcha" class="form-horizontal">
											<div class="row">
										
												<div class="col-md-3">
													<div class="form-group">
														<label class="control-label col-md-4">会员名称</label>
														<div class="col-md-8">
															<input name="vipname" id="vip_name" type="text">
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
														<label class="control-label col-md-4">会员状态</label>
														<div class="col-md-8">
															<select name="vipstatus" id="vip_status" class="form-control"></select>
														</div>
													</div>
												</div>
												<div class="col-md-3">
													<div class="form-group">
													<div class="col-md-8 col-md-offset-4">
														<button type="submit" class="btn btn-danger btn-block">搜索消费信息</button>
													</div>
													</div>
												</div>
											</div>								
										</form>
									</div>
									<div class="clo-md-12">
										<table class="table table-bordered table-hover table-striped">
											<thead>
												<tr>
													<th>会员编号</th>
													<th>会员名称</th>
													<th>服务类型</th>
													<th>负责的职工</th>
													<th>消费时间</th>
													<th>会员状态</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach items="${vipList }" var="vipconsumer">
												<tr>
													<td>${vipconsumer.vipid }</td>
													<td>${vipconsumer.vipname }</td>
													<td>${vipconsumer.servicename }</td>
													<td>${vipconsumer.vipjobname }</td>
													<td>${vipconsumer.vipcreatetime }</td>
													<td>${vipconsumer.memstatusname }</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
										 <ul class="pagination pull-right">
										    <c:choose>
									    	<c:when test="${param.pageNum != null and param.pageNum > 1 }">
									    		 <li>
									      <a href="?pageNum=${param.pageNum - 1 }${queryString}">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
									    	</c:when>
									    	<c:otherwise>
									    		<li class="disabled">
									      <a href="#">
									        <span aria-hidden="true">&laquo;</span>
									      </a>
									    </li>
									    	</c:otherwise>
									    </c:choose>
									   
									    <c:forEach begin="1" end="${pageCount }" var="page">
									    	<li><a href="?pageNum=${page }${queryString}">${page }</a></li>
									    </c:forEach>
									   	<c:choose>
									   		<c:when test="${param.pageNum != null and param.pageNum < pageCount}">
									   			<li>
									      <a href="?pageNum=${param.pageNum + 1 }${queryString}">
									        <span>&raquo;</span>
									      </a>
									    </li>
									   		</c:when>
									   		<c:otherwise>
									   			<li class="disabled">
									      <a href="#">
									        <span>&raquo;</span>
									      </a>
									    </li>
									   		</c:otherwise>
									   	</c:choose>
										  </ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- content -->
			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					

					<div class="alert alert-info hidden-md hidden-lg">
						<button type="button" class="close" data-dismiss="alert">
							<i class="ace-icon fa fa-times"></i>
						</button>
						When device is smaller than
						<span class="blue bolder">992px</span>
						wide, side menu is hidden and will be visible by clicking on the toggle button.
					</div>

					<div class="hidden-md hidden-lg">
						<a href="#" class="btn btn-primary btn-white btn-bold" id="id-change-style">
							<i class="ace-icon fa fa-exchange"></i>
							Show older Ace toggle button
						</a>

						<div class="space-4"></div>

						<div>
							<label>
								Push Content :
								<input type="checkbox" class="ace ace-switch ace-switch-6" id="id-push-content" />
								<span class="lbl middle"></span>
							</label>
						</div>

						<div class="hr hr-16"></div>
					</div>

					<!-- PAGE CONTENT ENDS -->
				</div><!-- /.col -->
			</div><!-- /.row -->
		</div><!-- /.page-content -->
	</div>
</div><!-- /.main-content -->
<%@ include file="./commons/foot.jsp" %>
<script type="text/javascript">
	//获取会员状态
	$.ajax({
		url:'${pageContext.request.contextPath }/data/status',
		dataType:'json',
		success:function(data){
			var vip_stauts = $('#vip_status');
			var defaultOption = $('<option value="0">选择会员状态</option>');
			defaultOption.appendTo(vip_stauts);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].valueid+'">'+data[index].valuenmae+'</option>');
				option.appendTo(vip_stauts);
			});
		}
	});
</script>
  </body>
</html>
