<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>

<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑企业资质管理信息系统</title>
<script type="text/javascript">
$(function(){ 
		$(".nw_left h2:first").addClass("active"); 
		$(".nw_left ul:not(:first)").hide(); 
		$(".nw_left h2").click(function(){ 
			$(this).next("ul").slideToggle().siblings("ul").slideUp(); 
			$(this).toggleClass('nmli').siblings("h2").removeClass("nmli"); 
		}); 
	}); 
</script>
</head>	
<body>

<div class="nw_left">
	<div class="nmli">
        <h2><img src="<%=basepath %>/img/nw_left_01.jpg" /></h2>
        <ul>
            <%
            	Login login = (Login)session.getAttribute("login");
            %>
            <%
            	if(login.getPopedomid().indexOf(",1,") >=0){
            %>
            <a href="<%=basepath %>/countryApprovalAction_queryPage.action" target="rightshowframe"  ><li>国家资质审批</li></a>
            <%
            	} 
            %>
            <%
            	if(login.getPopedomid().indexOf(",2,") >=0){
            %>
            <a href="<%=basepath %>/provinceApprovalAction_queryPage.action" target="rightshowframe" ><li>省厅资质审批</li></a>
            <%
            	}
            %>
            <%
            	if(login.getPopedomid().indexOf(",3,") >=0){
            %>
            <a href="<%=basepath %>/cityApprovalAction_queryPage.action" target="rightshowframe" ><li>市级资质审批</li></a>
            <%
            	}
            %>
            <%
            	if(login.getPopedomid().indexOf(",4,") >=0){
            %>
            <a href="<%=basepath %>/twoApprovalAction_queryPage.action" target="rightshowframe" ><li>专业厅局审批</li></a>
            <%
            	}
            %>
            <%
            	if(login.getPopedomid().indexOf(",8,") >=0){
            %>
            <a href="<%=basepath %>/qualityChangePageAction_showQualityChangeInner.action" target="rightshowframe" ><li>资质变更</li></a>
            <%
            	}
            %>
            <%
            	if(login.getPopedomid().indexOf(",9,") >=0){
            %>
            <a href="<%=basepath %>/queryQualityChangeAction_showQualityChangeQueryInner.action" target="rightshowframe" ><li>资质变更查询</li></a>
            <%
            	}
            %>
            <%
            	if(login.getPopedomid().indexOf(",5,") >=0){
            %>
            <a href="<%=basepath %>/corpInfoAction_queryCorpInfo.action?type=2" target="rightshowframe" ><li>企业信息登记</li></a>
            <a href="<%=basepath %>/queryPeopleAction_queryIDCard.action" target="rightshowframe" ><li>人员查询</li></a>
            <%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",7,") >=0){
            %>
        	<a href="<%=basepath %>/queryApplicationHistoryAction_queryPage.action" target="rightshowframe" ><li>历史资质查询</li></a>
        	
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",15,") >=0){
            %>
        	<a href="<%=basepath %>/queryCorpAction_submitCertifiedService.action" target="rightshowframe" ><li>资质分类查询</li></a>
        	<%
            	}
        	%>
        	
        	<%
        	if(login.getPopedomid().indexOf(",16,") >=0){
        	%>
        	<a href="<%=basepath %>/queryAllApplicationAction_queryPage.action" target="rightshowframe" ><li>全省历史企业资质查询</li></a>
        	<%
        	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",10,") >=0){
            %>
        	<a href="<%=basepath %>/countryCertificatePrintAction_queryPage.action" target="rightshowframe" ><li>国家级证书确认</li></a>
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",11,") >=0){
            %>
        	<a href="<%=basepath %>/certificatePrintAction_queryPage.action" target="rightshowframe" ><li>省级资质证书打印</li></a>
        	<%
            	}
        	%>
        	
        	<%
            	if(login.getPopedomid().indexOf(",22,") >=0){
            %>
        	<a href="<%=basepath %>/certificateHisPrintAction_queryPage.action" target="rightshowframe" ><li>证书二维码链接</li></a>
        	<%
            	}
        	%>
        	
        	
        	<%
        	if(login.getPopedomid().indexOf(",12,") >=0){
        		if(login.getDepartmentID().equals("230100"))
        		{
        			if(login.getPersonalID().equals("400004"))
        			{
        	%>
        	<a href="<%=basepath %>/cityCertificatePrintAction_queryPage.action" target="rightshowframe" ><li>地市资质证书打印</li></a>
        	<%
        			}
        		}else
        		{
        	%>
        	<a href="<%=basepath %>/cityCertificatePrintAction_queryPage.action" target="rightshowframe" ><li>地市资质证书打印</li></a>
        	<%
        		}
        	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",13,") >=0){
            %>
        	<a href="<%=basepath %>/writeOffAction_queryPage.action" target="rightshowframe" ><li>企业资质注销</li></a>
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",14,") >=0){
            %>
        	<a href="<%=basepath %>/recoverAction_queryPage.action" target="rightshowframe" ><li>企业资质恢复</li></a>
        	
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",17,") >=0){
            %>
        	<a href="<%=basepath %>/changeAreaAction_queryPage.action" target="rightshowframe" ><li>企业归属地变更</li></a>
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",18,") >=0){
            %>
        	<a href="<%=basepath %>/queryChangeInfoAction_queryPage.action" target="rightshowframe" ><li>历史归属地变更查询</li></a>
        	<a href="<%=basepath %>/qualificationRevocationAction_queryPage.action" target="rightshowframe"><li>企业已获资质打回</li></a>
        	<a href="<%=basepath %>/revocationHistoryAction_historyList.action" target="rightshowframe"><li>历史企业资质打回</li></a>
        	<%
            	}
        	%>
        	<%
            	if(login.getPopedomid().indexOf(",19,") >=0){
            %>
        	<a href="<%=basepath %>/innerChangeAreaAction_queryPage.action" target="rightshowframe" ><li>更改企业归属地</li></a>
        	<a href="<%=basepath %>/queryInnerChangeAreaAction_queryPage.action" target="rightshowframe" ><li>更改企业归属地历史查询</li></a>
        	<%
            	}
        	%>
        	 <%
            	if(login.getPopedomid().indexOf(",20,") >=0){
            %>
            <a href="<%=basepath %>/corpInfoAction_queryCorpInfo.action?type=1" target="rightshowframe" ><li>企业信息查询</li></a>
            <%
            	}
        	%>
        	  
        	 <%
            	if(login.getPopedomid().indexOf(",21,") >=0){
            %>
         	<a href="<%=basepath %>/floorQueryCorpAction_queryPage.action" target="rightshowframe" ><li>企业基本信息</li></a>
         	<a href="<%=basepath %>/writeOffAction_queryPage.action" target="rightshowframe" ><li>企业资质注销</li></a>
         	<a href="<%=basepath %>/recoverAction_queryPage.action" target="rightshowframe" ><li>企业资质恢复</li></a>
         	<a href="<%=basepath %>/floorSeparateQualificationAction_queryPage.action" target="rightshowframe" ><li>企业分立/转移</li></a>
         	<a href="<%=basepath %>/querySeparateQualificationAction_queryPage.action" target="rightshowframe" ><li>分立/转移历史查询</li></a>
             <div  class="nmli">
              <h2><img src="<%=basepath %>/img/nw_left_03.jpg" /></h2>
              <ul>
        		 <a href="<%=basepath %>/changeCertAction_queryPage.action" target="rightshowframe" ><li>换证企业</li></a>
        		 <a href="<%=basepath %>/queryAllApplicationAction_queryPage.action" target="rightshowframe" ><li>历史查询</li></a>
        	 </div>
        	 </ul>
        	  <div  class="nmli">
              <h2><img src="<%=basepath %>/img/nw_left_4.jpg" /></h2>
              <ul>
              	<a href="<%=basepath %>/floorApprovalAction_queryPage.action" target="rightshowframe" ><li>申报企业</li></a>
        	 	<a href="<%=basepath %>/queryFloorApprovalAction_queryPage.action" target="rightshowframe" ><li>历史查询</li></a>
              </ul>
        	 <%
            	}
        	%>
        	 </ul>
    </div>
    <%
		if(login.getPopedomid().indexOf(",6,") >=0){
    %>
    <div  class="nmli">
        <h2><img src="<%=basepath %>/img/nw_left_02.jpg" /></h2>
        <ul>
            <a href="<%=basepath %>/certifiedService_queryPage.action" target="rightshowframe"><li>资质服务事项维护</li></a>
            
            <a href="<%=basepath %>/revocationHistoryAction_historyList.action" target="rightshowframe"><li>企业资质打回历史</li></a>
            <a href="<%=basepath %>/modifyQualificationAction_queryPage.action" target="rightshowframe"><li>企业资质申请信息修改</li></a>
            <a href="<%=basepath %>/certificateHisPrintAction_queryPage.action" target="rightshowframe" ><li>证书二维码链接</li></a>
            <a href="<%=basepath %>/statisticsAction_queryPage.action" target="rightshowframe" ><li>统计</li></a>
        </ul>
    </div>
    <%
		}
    %>
</div>

</body>
</html>