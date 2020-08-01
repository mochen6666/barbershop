<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="./commons/head.jsp" %>

<div class="page-header">
							<h1>欢迎登录名庐会员系统 </h1>
						</div><!-- /.page-header -->
						<!-- content -->
							<div class="row">
								<div class="col-md-12">
									<div class="panel panel-warning">
										<div class="panel-heading">
											<h4>充值会员卡</h4>
										</div>
										<div class="panel-body">
											<fm:form modelAttribute="member"  action="${pageContext.request.contextPath }/member/cz" class="form-horizontal" method="post">
											
												<div class="form-group hidden">
															<label class="control-label col-md-2">会员id</label>
															<div class="col-md-10">
																<fm:input type="text" path="memid" class="form-control" />
															</div>
												</div>
												<div class="form-group">
													<label class="control-label col-md-2">请输入您要充值的钱数</label>
													<div class="col-md-5">
														<fm:input type="text" path="membalance" name="" class="form-control" />
													</div>
													<div class="col-md-5 ">
														<h4>充200送100，充400送288，充1000送600</h4>													
													</div>
													<div class="col-md-2 col-md-offset-3">
														<button type="submit" class="btn btn-success btn-block">充值</button>
													</div>
												</div>
											</fm:form>
										</div>
									</div>					
								</div>
							</div>
<%@ include file="./commons/foot.jsp" %>
  </body>
</html>
