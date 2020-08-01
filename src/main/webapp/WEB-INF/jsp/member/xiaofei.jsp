<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

<div class="page-header">
				<h1>欢迎${sessionScope.MEMBER.memname },登录名庐理发店会员系统 </h1>
			</div><!-- /.page-header -->
			<div>
				<c:if test="${message!=null and message!='' }">
				<h2>${message }</h2>
				</c:if>
			</div>
			<!-- content -->
			
						<!-- content -->
						<div class="row">
								<div class="clo-md-12">
									<div class="panel panel-warning">
										<div class="panel-heading">
											<h4>搜索类型</h4>
										</div>
										<div class="panel-body">
											<form action="${pageContext.request.contextPath }/member/cha" method="post" class="form-horizontal">
												<div class="row">

													<div class="col-md-3">
														<div class="form-group">
															<label class="control-label col-md-4">消费类型</label>
															<div class="col-md-8">
																<select class="form-control" name="servicename" id="vip_sername">
																	
																</select>
															</div>
														</div>
													</div>
													<div class="col-md-3">
														<div class="form-group">
															<label class="control-label col-md-4">负责职工</label>
															<!-- vipjobid 关联staff的staid 显示职工名称 -->
															<div class="col-md-8">
																<select class="form-control"  name="vipjobid" id="vip_staname">
																	
																</select>
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
									</div>
									<div class="panel panel-info" style="margin-bottom: 60px;">
										<div class="panel-heading">
											<h4>消费信息</h4>
										</div>
										<div class="panel-body">
											<div class="row">
												<div class="clo-md-12">
													<table class="table table-bordered table-hover table-striped">
														<thead>
															<tr>
																<th>会员编号</th>
																<th>会员名称</th>
																<th>服务类型</th>
																<th>负责的职工</th>
																<th>消费时间</th>
															</tr>
														</thead>
														<tbody>
															<c:forEach items="${listvip }" var="a">
															<tr>
																<td>${a.vipnum }</td>
																<td>${a.vipname }</td>
																<td>${a.servicename }</td>
																<td>${a.staname }</td>
																<td>${a.vipcreatetime }</td>												
															</tr>
															</c:forEach>
														</tbody>
													</table>
													 
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- content -->
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
		url:'${pageContext.request.contextPath }/data/staname',
		dataType:'json',
		success:function(data){
			var vip_staname = $('#vip_staname');
			var defaultOption = $('<option value="0">选择职工姓名</option>');
			defaultOption.appendTo(vip_staname);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].staid+'">'+data[index].staname+'</option>');
				option.appendTo(vip_staname);
			});
		}
	});
	$.ajax({
		url:'${pageContext.request.contextPath }/data/sername',
		dataType:'json',
		success:function(data){
			var vip_sername = $('#vip_sername');
			var defaultOption = $('<option value="0">选择服务类型</option>');
			defaultOption.appendTo(vip_sername);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].sername+'">'+data[index].sername+'</option>');
				option.appendTo(vip_sername);
			});
		}
	});
</script>
  </body>
</html>
