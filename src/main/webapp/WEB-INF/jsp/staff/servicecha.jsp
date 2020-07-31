<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

<!-- content -->
	<div class="right_col" role="main">
		
		<div class="row">
			<div class="clo-md-12">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h4>查看本店服务信息</h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="clo-md-12">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr>
											<th>服务编号</th><!-- serid和sernum都行 哪个好用哪个 -->
											<th>服务名称</th>
											<th>服务价格</th>
											<th>负责职工</th><!-- jobid关联的是staid staff表里的名字 -->
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${serList }" var="service">
										<tr>
											<td>${service.serid }</td>
											<td>${service.sername }</td>
											<td>${service.serprice }</td>
											<td>${service.vipjobname }</td>
											<td>
												<div class="dropdown ">
												  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="btn-danger">
												    选择操作
												    <span class="caret"></span>
												  </button>
												  <ul class="dropdown-menu" aria-labelledby="dLabel">
												    <li>
												    	<a href="${pageContext.request.contextPath }/service/modify_form?serid=${service.serid}">修改</a>
												    </li>
												    <li>
												    	<a href="${pageContext.request.contextPath }/service/del?serid=${service.serid}">删除</a>
												    </li>	
												  </ul>
												</div>
											</td>
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
<%@ include file="./commons/foot.jsp" %>
  </body>
</html>
