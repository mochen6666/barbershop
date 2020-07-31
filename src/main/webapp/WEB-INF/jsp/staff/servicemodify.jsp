<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@ include file="./commons/head.jsp" %>

<!-- content -->
	<div class="panel panel-info" style="margin-bottom: 60px;">
		<div class="panel-heading">
			<h4>修改服务</h4>
		</div>
		<div class="panel-body">
			<div class="row">
				<div class="col-md-10 col-md-offset-1">
					<fm:form modelAttribute="service" action="${pageContext.request.contextPath }/service/modify" method="post" class="form-horizontal">
						
						<div class="form-group hidden">
							<label class="control-label col-md-2">服务id</label>
							<div class="col-md-10">
								<fm:input type="text" path="serid" class="form-control"   />
							</div>
						</div>
						<div class="form-group ">
							<label class="control-label col-md-2">服务编号</label>
							<div class="col-md-10">
								<fm:input type="text" path="sernum" class="form-control"  placeholder="例:fw5" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">服务名称</label>
							<div class="col-md-10">
								<fm:input type="text" path="sername" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">服务价格</label>
							<div class="col-md-10">
								<fm:input type="text" path="serprice" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-md-2">负责职工</label>
							<!-- jobid 关联到staff 的staid  显示职工名称 -->
							<div class="col-md-10">
								<fm:select id="sta" path="vipjobname" class="form-control">
									
								</fm:select>
							</div>
						</div>
	
						<div class="form-group">
							<div class="col-md-10 col-md-offset-2">
								<button type="submit" class="btn btn-success">保存</button>
								<a type="${pageContext.request.contextPath }/service/servicecha" class="btn btn-warning">返回</a>
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
	//获取职工
	$.ajax({
		url:'${pageContext.request.contextPath }/staff/sta',
		dataType:'json',
		success:function(data){
			var sta = $('#sta');
			var defaultOption = $('<option value="0">选择负责职工</option>');
			defaultOption.appendTo(sta);
			$(data).each(function(index){
				var option = $('<option value="'+data[index].stajob+'">'+data[index].stajobname+'</option>');
				option.appendTo(sta);
			});
		}
	});
</script>
  </body>
</html>
