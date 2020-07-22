<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./commons/head.jsp" %>
<div class="page-header">
	<h1>欢迎${sessionScope.STAFF.staname },登录名庐职员系统 </h1>
</div><!-- /.page-header -->
<!-- content -->
	<div class="panel panel-info" style="margin-bottom: 60px;">
		<div class="panel-heading">
			<h4>增加会员</h4>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<fm:form modelAttribute="member" enctype="multipart/form-data" action="${pageContext.request.contextPath }/staff/save" method="post" class="form-horizontal">
						
						<div class="form-group ">
							<label class="control-label col-md-2">会员用户名</label>
							<div class="col-md-10">
								<fm:input path="memcode" type="text" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">会员密码</label>
							<div class="col-md-10">
								<fm:input path="mempassword" type="text" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">会员名称</label>
							<div class="col-md-10">
								<fm:input path="memname" type="text" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">会员电话</label>
							<div class="col-md-10">
								<fm:input path="memphone" type="text" class="form-control"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">充值的钱数</label>
							<div class="col-md-10">
								<fm:input path="membalance" type="text" class="form-control"/>
							</div>
							<div class="col-md-10 col-md-offset-2 ">
								<h4>充200送100，充400送288，充1000送600</h4>													
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-2">会员头像</label>
							<div class="col-md-10">
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
  </body>
</html>
