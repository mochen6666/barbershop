<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

<!-- content -->
	<div class="right_col" role="main">
		
		<div class="row">
			<div class="clo-md-12">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h4>查看非会员消费记录</h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="clo-md-12">
								<table class="table table-bordered table-hover table-striped">
									<thead>
										<tr>
											<th>客人名称</th>
											<th>消费金额</th>
											<th>负责的职工</th>
											<!-- conJobid 关联的是staff表里的staid -->
											<th>消费时间</th>
											<!-- ditionary表里的memstatus -->
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${conList }" var="con">
												<tr>
													<td>${con.servicename}</td>
													<td>${con.conmoney}</td>
													<td>${con.conjobname}</td>
													<td>${con.concreatetime}</td>
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
