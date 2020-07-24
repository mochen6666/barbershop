<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./commons/head.jsp" %>


						<div class="page-header">
							<h1>欢迎登录名庐会员系统 </h1>
						</div><!-- /.page-header -->
						<!-- content -->
						<div class="panel panel-info" style="margin-bottom: 60px;">
										<div class="panel-heading">
											<h4>修改会员基本信息</h4>
										</div>
										<div class="panel-body">
											<div class="row">
												<div class="col-md-10 col-md-offset-1">
													<fm:form class="form-horizontal" action="${pageContext.request.contextPath }/member/modify"
													 modelAttribute="member" method="post" enctype="multipart/form-data">
														<div class="form-group hidden">
															<label class="control-label col-md-2">会员id</label>
															<div class="col-md-10">
																<fm:input type="text" path="memid" class="form-control" />
															</div>
														</div>
														<div class="form-group ">
															<label class="control-label col-md-2">会员名称</label>
															<div class="col-md-10">
																<fm:input type="text" path="memname" class="form-control" />
															</div>
														</div>
														
														<div class="form-group">
															<label class="control-label col-md-2">会员电话</label>
															<div class="col-md-10">
																<fm:input type="text" path="memphone" class="form-control" />
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-2">会员余额</label>
															<div class="col-md-10">
																<fm:input type="text" path="membalance" class="form-control" />
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-2">会员状态</label>
															<div class="col-md-10">
																<fm:select class="form-control" path="memstatus" id="vip_status">
																
																</fm:select>
															</div>
														</div>
														<div class="form-group">
															<label class="control-label col-md-2">会员头像</label>
															<div class="col-md-10">
																 <img src="${pageContext.request.contextPath }/uploads/${member.memheadpath}" class="thumbnail" style="float: left;">
																 <a href="#" style="float: left;margin-top: 80px;margin-left: 10px;">删除</a>
																 <input type="file" name="file" id="" value="" class="form-control" />
															</div>
														</div>
														<div class="form-group">
															<div class="col-md-10 col-md-offset-2">
																<button type="submit" class="btn btn-success">保存</button>
																<a href="${pageContext.request.contextPath }/member/main" class="btn btn-warning">返回</a>
															</div>
														</div>
													</fm:form>
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
