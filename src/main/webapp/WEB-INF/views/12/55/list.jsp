<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="/WEB-INF/views/common/head.jsp" />
</head>
<body class="skin-3">
	<c:import url="/WEB-INF/views/common/navbar.jsp" />
	<div class="main-container container-fluid">
		<c:import url="/WEB-INF/views/common/sidebar.jsp" />
		<div class="main-content">
			<div class="page-content">




				<div class="page-header position-relative">
					<h1 class="pull-left">품목별 매입매출 현황</h1>
					<a class="btn btn-link pull-right"
						href="${pageContext.request.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }/add"><i
						class="icon-plus-sign bigger-120 green"></i> 팀 추가</a>
				</div>
				<div class="row-fluid">
					<div class="span9 center">
							<div class="control-group">
								<label class="control-label span2" for="form-field-1">년 월</label>
								<div class="controls span3">
									<input type="text" id="form-field-1" placeholder="년월6자리">
								</div>
								<label class="control-label span3" for="form-field-2">품목 코드</label>
								<div class="controls span3">
								<select id="form-field-select-1">
								<option value>&nbsp;</option>
								<option value="품1">품목코드11111</option>
								<option value="품2">품목코드22222</option>
								</select>
								</div>
								<button class="btn btn-default span1">조회</button>
								<table id="sample-table-1" class="table table-striped table-bordered table-hover">
									<thead>
									<tr>
										<th>품목코드</th>
										<th>품목명</th>
										<th>입고수량</th>
										<th>입고금액</th>
										<th>입고부가세</th>
										<th>출고수량</th>
										<th>출고금액</th>
										<th>출고부가세</th>
										<th>재고수량</th>
										<th>재고금액</th>
										<th>재고부가세</th>
									</tr>
									</thead>
									<tbody>
									<tr>
										<td>품목코드123456</td>
										<td>IBM서버</td>
										<td>10</td>
										<td>10000</td>
										<td>1000</td>
										<td>5</td>
										<td>5000</td>
										<td>500</td>
										<td>5</td>
										<td>5000</td>
										<td>500</td>
									</tr>
									</tbody>
								</table>
								</div>
								<div class="pagination no-margin">
										<ul>
											<li class="prev disabled">
												<a href="#">
													<i class="icon-double-angle-left"></i>
												</a>
											</li>
											<li class="active">
												<a href="#">1</a>
											</li>
											<li>
												<a href="#">2</a>
											</li>
											<li>
												<a href="#">3</a>
											</li>
											<li class="next">
												<a href="#">
													<i class="icon-double-angle-right"></i>
												</a>
											</li>
										</ul>
									</div>
								
						
						</div>
					</div>



			</div>
			<!-- /.page-content -->
		</div>
		<!-- /.main-content -->
	</div>
	<!-- /.main-container -->
	<!-- basic scripts -->
	<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>