<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./commons/head.jsp" %>

<div class="page-header">
	<h1>欢迎${sessionScope.STAFF.staname },登录名庐职员系统 </h1>
</div><!-- /.page-header -->
<!-- content -->
	<div class="panel panel-info" style="margin-bottom: 60px;">
		<div class="panel-heading">
			<h4>查看并修改职工信息</h4>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<fm:form modelAttribute="staff" enctype="multipart/form-data" action="${pageContext.request.contextPath }/staff/modify" method="post" class="form-horizontal">
						<div class="form-group">
							<label class="control-label col-md-2">职工名称</label>
							<div class="col-md-10">
								<fm:input type="text" path="staname" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">职工性别</label>
							<div class="col-md-10">
								<fm:select path="sex" id="stasex" class="form-control">
									
								</fm:select>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">职工电话</label>
							<div class="col-md-10">
								<fm:input path="staphone" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">职工职位</label>
							<div class="col-md-10">
								<fm:select path="zw" id="stazw" class="form-control">
									
								</fm:select>
							</div>
							<!-- dictionary表里的stajob -->
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">职工地址</label>
							<div class="col-md-10">
								<fm:input path="staaddress" type="text" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">职工状态</label>
							<div class="col-md-10">
								<fm:select path="zt" id="stazt" class="form-control">
									
								</fm:select>
							</div>
							<!-- dictionary表里的stastatus -->
						</div>
						
						<div class="form-group">
							<label class="control-label col-md-2">职员头像</label>
							<div class="col-md-10">
										<div class="row">
											<img src="${pageContext.request.contextPath }/uploads/${staff.staheadpath}" alt="" class="thumbnail"  style="float: left;">
											<a href="#" style="float: left; margin-top: 90px; margin-left: 10px;">删除</a>
										</div>
										<input name="file" type="file" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-10 col-md-offset-2">
								<button type="submit" class="btn btn-success">保存</button>
								<a type="${pageContext.request.contextPath }/staff/memcha" class="btn btn-warning">返回</a>
							</div>
						</div>
					</fm:form>
				</div>
			</div>
		</div>
	</div>
<!-- content -->
<%@ include file="./commons/foot.jsp" %>
<script type="text/javascript">
	//职工状态
	$.ajax({
		url:'${pageContext.request.contextPath }/data/zt',
		dataType:'json',
		success:function(data){
			var stazt = $('#stazt');
			var defaultOption = $('<option value="0">选择职工状态</option>');
			defaultOption.appendTo(stazt);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].valueid+'">'+data[index].valuenmae+'</option>');
				option.appendTo(stazt);
			});
		}
	});
	//职工职位状态
	$.ajax({
		url:'${pageContext.request.contextPath }/data/zw',
		dataType:'json',
		success:function(data){
			var stazw = $('#stazw');
			var defaultOption = $('<option value="0">选择职工职位</option>');
			defaultOption.appendTo(stazw);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].valueid+'">'+data[index].valuenmae+'</option>');
				option.appendTo(stazw);
			});
		}
	});
	//职工性别
	$.ajax({
		url:'${pageContext.request.contextPath }/data/sex',
		dataType:'json',
		success:function(data){
			var stasex = $('#stasex');
			var defaultOption = $('<option value="0">选择职工性别</option>');
			defaultOption.appendTo(stasex);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].valueid+'">'+data[index].valuenmae+'</option>');
				option.appendTo(stasex);
			});
		}
	});
</script>
  </body>
</html>
