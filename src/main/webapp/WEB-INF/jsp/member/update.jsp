<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./commons/head.jsp" %>
<div class="main-container ace-save-state" id="main-container">
			<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
			</script>

			<div id="sidebar" class="sidebar                  responsive                    ace-save-state">
				<script type="text/javascript">
					try{ace.settings.loadState('sidebar')}catch(e){}
				</script>

				

				<ul class="nav nav-list">
					<li class="active open">
						<a href="index.html">
							<i class="menu-icon fa fa-pencil-square-o"></i>
							<span class="menu-text"> 查看并修改会员信息 </span>
						</a>

						<b class="arrow"></b>
					</li>

					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-credit-card"></i>
							<span class="menu-text">
								充值会员卡
							</span>
						</a>

						
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list"></i>
							<span class="menu-text"> 查看消费信息 </span>							
						</a>

										
					</li>

					

					<li class="">
						<a href="widgets.html">
							<i class="menu-icon fa fa-list-alt"></i>
							<span class="menu-text"> 查看服务信息 </span>
						</a>
					</li>					

				<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse" style="margin-top: 500px;">
					<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
				</div>
			</div>

			<div class="main-content">
				<div class="main-content-inner">
					

					<div class="page-content">
						<div class="ace-settings-container" id="ace-settings-container">
							<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
								<i class="ace-icon fa fa-cog bigger-130"></i>
							</div>
					
							<div class="ace-settings-box clearfix" id="ace-settings-box">
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<div class="pull-left">
											<select id="skin-colorpicker" class="hide">
												<option data-skin="no-skin" value="#438EB9">#438EB9</option>
												<option data-skin="skin-1" value="#222A2D">#222A2D</option>
												<option data-skin="skin-2" value="#C6487E">#C6487E</option>
												<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
											</select>
										</div>
										<span>&nbsp; 选择皮肤</span>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
										<label class="lbl" for="ace-settings-navbar"> 固定导航栏</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
										<label class="lbl" for="ace-settings-sidebar"> 固定侧栏</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
										<label class="lbl" for="ace-settings-breadcrumbs"> 固定面包屑</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
										<label class="lbl" for="ace-settings-rtl"> 从左到右</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
										<label class="lbl" for="ace-settings-add-container">
											内部
											<b>.容器</b>
										</label>
									</div>
								</div><!-- /.pull-left -->
					
								<div class="pull-left width-50">
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
										<label class="lbl" for="ace-settings-hover"> 悬停子菜单</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
										<label class="lbl" for="ace-settings-compact"> 紧凑型侧边栏</label>
									</div>
					
									<div class="ace-settings-item">
										<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
										<label class="lbl" for="ace-settings-highlight"> 提示侧边栏活动项目</label>
									</div>
								</div><!-- /.pull-left -->
							</div><!-- /.ace-settings-box -->
						</div><!-- /.ace-settings-container -->

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
