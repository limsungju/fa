<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html lang="ko">
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/ace/css/chosen.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/assets/ace/css/datepicker.css" />
<c:import url="/WEB-INF/views/common/head.jsp" />
<style>
		
.form-horizontal .control-label {text-align: left;}

h4{
   font-size:13px;
   font-family: 'Apple SD Gothic Neo','나눔고딕',NanumGothic,'맑은 고딕',Malgun Gothic,'돋움',dotum,'굴림',gulim,applegothic,sans-serif;
}

.textarea{
   resize: none;
   width: 282px;
   height: 84px;
}

tr td:first-child {
   padding-right: 10px;
}

.radio {
   float: left;
   width: 17%;
}

.search-input-width-first {
   width: 130px;
}

.search-input-width-second {
   width: 235px;
}

.debt-name-input {
   width: 420px;
}

.mgr-input {
   width: 90px;
   display: inline;
}

.mgr-number-input-h4 {
   display: inline;
   margin-left: 42px;
   margin-right: 20px;
}

.mgr-call-input {
   width: 150px;
   display: inline;
}

.number-input{
   text-align:right;
}

.mybtn{margin-right:10px;}

#staticBackdrop {
   z-index: -1;
}

.selected{
   background-color:#ddd;
}

#simple-table{
   min-width: 2000px; 
   margin-bottom: 0; 
   width: auto;"
}

html,body{
         overflow-x:hidden;
      height:100%;
   }
   .main-container{
      height:calc(100% - 45px);
      overflow-x: hidden;
   }
   .main-content{
      overflow:auto;
   }
   .page-content{
      min-width:1280px;
   }
   @media screen and (max-width: 920px) {
      .main-container{
         height:calc(100% - 84px);
      }
   }

/* table columns  */
.first-column {width:120px; padding-left:20px;}
.second-column {width:70px; padding-right:190px;}
.third-column {width:140px;}
.fourth-column {width:80px; padding-right:190px;}
.fifth-column {width:170px;}
.sixth-column {width:60px;}
.seventh-column {padding-left:20px;}
.eight-column {}

/* second row */
.span2 {padding-left:40px; padding-top:20px;}

</style>
</head>
<body class="skin-3">
	<c:import url="/WEB-INF/views/common/navbar.jsp" />
	<div class="main-container container-fluid">
		<c:import url="/WEB-INF/views/common/sidebar.jsp" />
		<div class="main-content">
			<div class="page-content">
			
				<div class="page-header position-relative">
					<h1 class="pull-left">은행코드현황조회</h1>
				</div><!-- /.page-header -->
				
				<!-- PAGE CONTENT BEGINS -->
			<div>
				<div>
				<form id='myform' class="form-horizontal">
					<table style="width:100%;">
						<tbody>
						<tr>
							<td class="first-column center"><label class="control-label">은행명</label></td>
							<td class="second-column">
				               		<input type="text" name="name"  value='${vo.name }'/>
				            </td>
				            
							<td class="third-column center"><label class="control-label">지점명</label></td>
							<td class="fourth-column">
				                <input type="text" name="store" value='${vo.store }' />
				            </td>
				            
							<td class="fifth-column center"><label class="control-label">거래시작월</label></td>
							<td class="sixth-column">
									<div class="row-fluid input-append">
										<input class="cl-date-picker" id="datepicker" name="dealDate" type="text" 
										data-date-format="yyyy-mm" value='${vo.dealDate }' readOnly />
										<span class="add-on">
										<i class="icon-calendar"></i>
										</span>
									</div>
							</td>
							</tr>
						</tbody>
					</table>
					<div class="row-fluid">
						<div class="span12"> 
							<div class="checkbox" style="float:right; margin-top: 5px;">
								<label>
									<c:choose>
										<c:when test='${vo.deleteFlag eq ""}'>
											<input id='deleteFlag' name="deleteFlag" type="checkbox" class="ace" value="" checked="checked"/>
										</c:when>
										<c:otherwise>
											<input id='deleteFlag' name="deleteFlag" type="checkbox" class="ace" value="" />
										</c:otherwise>
									</c:choose>
									<span class="lbl">삭제포함</span>
								</label>
							</div>	
						</div>
					</div>
					<hr>
						<div class="row-fluid">
							<button id="search" class="btn btn-info btn-small" formaction="${pageContext.request.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }">조회</button>
							<button type="button" id="clearbtn" class="btn btn-default btn-small mybtn">초기화</button>
						</div>
					<hr>
				</form>
			</div>
		</div>
		<!-- PAGE CONTENT BEGINS -->
		
		<!-- list -->
		<p>총 ${dataResult.pagination.totalCnt }건</p>
		<div style="overflow: auto;">
		<table id="simple-table" class="table  table-bordered table-hover" style=" min-width: 2000px; margin-bottom: 0; width: auto;">
            <thead>
                <tr>
                   <th class="center">은행코드</th>
                   <th class="center">은행명</th>
                   <th class="center">지점명</th>
                   <th class="center">거래시작일</th>
                   <th class="center">전화번호</th>
                   <th class="center">FAX</th>
                   <th class="center">우편번호</th>
                   <th class="center">은행주소</th>
                   <th class="center">담당자</th>
                   <th class="center">담당자전화번호</th>
                   <th class="center">담당자이메일</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${dataResult.datas }" var="bankvo">
                      <tr>
                      	<td>${bankvo.code }</td>
                        <td>${bankvo.name }</td>
                        <td>${bankvo.store }</td>
                        <td>${bankvo.dealDate }</td>
                        <td>${bankvo.phone }</td>
                        <td>${bankvo.fax }</td>
                        <td>${bankvo.post }</td>
                        <td>${bankvo.address }</td>
                        <td>${bankvo.mgr }</td>
                        <td>${bankvo.mgrPhone }</td>
                        <td>${bankvo.mgrEmail }</td>
                     </tr>
				</c:forEach>
           </tbody>
       </table>
       </div>
					
		<div class="pagination">
			<ul>
				<c:choose>
					<c:when test="${dataResult.pagination.prev }">
						<li><a href="${pageContext.servletContext.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }${uri}&page=${dataResult.pagination.startPage - 1 }">
						<i class="icon-double-angle-left"></i></a></li>
					</c:when>
					<c:otherwise>
						<li class="disabled"><a href="#"><i class="icon-double-angle-left"></i></a></li>
					</c:otherwise>
				</c:choose>
				<c:forEach begin="${dataResult.pagination.startPage }" end="${dataResult.pagination.endPage }" var="pg">
					<c:choose>
						<c:when test="${pg eq dataResult.pagination.page }">
							<li class="active">
								<a href="${pageContext.servletContext.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }${uri}&page=${pg }">${pg }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageContext.servletContext.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }${uri}&page=${pg}">${pg }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>

					<c:choose>
						<c:when test="${dataResult.pagination.next }">
							<li><a href="${pageContext.servletContext.contextPath }/${menuInfo.mainMenuCode }/${menuInfo.subMenuCode }${uri}&page=${dataResult.pagination.endPage + 1 }"><i class="icon-double-angle-right"></i></a></li>
								</c:when>
								<c:otherwise>
									<li class="disabled"><a href="#"><i class="icon-double-angle-right"></i></a></li>
								</c:otherwise>
							</c:choose>
				</ul>
			</div>
		</div><!-- /.page-content -->
	</div><!-- /.main-content -->
</div><!-- /.main-container -->

<!-- basic scripts -->
<c:import url="/WEB-INF/views/common/footer.jsp" />
<script src="${pageContext.request.contextPath }/assets/ace/js/chosen.jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/ace/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="${pageContext.request.contextPath }/ace/assets/js/date-time/daterangepicker.min.js"></script>
<script>
   $(function() {
	    $(".chosen-select").chosen();
	 // 데이트피커 한글설정
		$.fn.datepicker.dates['ko'] = {
			days : [ "일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일" ],
			daysShort : [ "일", "월", "화", "수", "목", "금", "토" ],
			daysMin : [ "일", "월", "화", "수", "목", "금", "토" ],
			months : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월",
					"10월", "11월", "12월" ],
			monthsShort : [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
					"9월", "10월", "11월", "12월" ],
			today : "Today",
			clear : "Clear",
			format : "yyyy-mm",
			titleFormat : "yyyy MM", /* Leverages same syntax as 'format' */
			weekStart : 0
		};

		// 년월 설정 데이트피커
		$('#datepicker').datepicker({
			maxViewMode : 4,
			minViewMode : 1,
			language : 'ko'
		}).next().on(ace.click_event, function() {
			$(this).prev().focus();
		});

		$('.cl-date-picker').datepicker({
			language : 'ko'
		}).next().on(ace.click_event, function() {
			$(this).prev().focus();
		});		
		$('.date-picker').datepicker().next().on(ace.click_event, function(){
			$(this).prev().focus();
		});
		
		// 초기화버튼 이벤트 연결
		$('#clearbtn').click(function(){
			$('input[name=name]').val('');
			$('input[name=store]').val('');
			$('input[name=dealDate]').val('');
			
		    $('input[name=deleteFlag]').each(function(index, item){
		    	if($(item).prop('checked') == true){
		    		$(item).prop('checked', false);
		    	}
		    });
		});
	});
					
</script>
</body>
</html>