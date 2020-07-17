<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="./commons/head.jsp" %>
<div class="page-header">
				<h1>欢迎${sessionScope.STAFF.staname },登录名庐职员系统 </h1>
			</div><!-- /.page-header -->
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
  </body>
</html>
