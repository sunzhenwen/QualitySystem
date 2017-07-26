<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<script type="text/javascript">
	
	//跳转资质级别选择页面
	function newApplication(addTypeNum)
	{
		document.form1.action="<%=basepath %>/newQualificationAction_newApplication.action?addTypeNum="+addTypeNum;
		document.form1.submit();
	}
	
	//企业资质升级
	function updateApplication(addTypeNum)
	{
		document.form1.action="<%=basepath %>/updateQualificationAction_updateApplication.action?addTypeNum="+addTypeNum;
		document.form1.submit();
	}
	
	
	//企业资质就位
	function perchApplication(addTypeNum)
	{
		document.form1.action="<%=basepath %>/perchQualificationAction_perchApplication.action?addTypeNum="+addTypeNum;
		document.form1.submit();
	}
	
	
	//跳转企业资质查询页面
	function queryApplication()
	{
		document.form1.action="<%=basepath %>/queryQualificationAction_queryQualificationPage.action";
		document.form1.submit();
	}
	
	//查询企业审批中的资质状态
	function queryApplicationInfo()
	{
		document.form1.action="<%=basepath %>/queryQualificationInfoAction_queryQualificationInfoPage.action";
		document.form1.submit();
	}
	
	//查询经过认证的企业信息
	function queryCorp()
	{
		document.form1.action="<%=basepath %>/certifiedCorpAction_modifyCorpPage.action";
		document.form1.submit();
	}
	
	//查询经过认证的外商企业信息
	function queryForeignCorp()
	{
		document.form1.action="<%=basepath %>/certifiedForeignCorpAction_modifyForeignCorpPage.action";
		document.form1.submit();
	}
	
	//查询注册建造师
	function queryConstructo()
	{
		document.form1.action="<%=basepath %>/constructorAction_queryPage.action";
		document.form1.submit();
	}

	//查询岗位人员
	function queryPositions()
	{
		document.form1.action="<%=basepath %>/positionsAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询技术工人
	function querySkilledworker()
	{
		document.form1.action="<%=basepath %>/skilledworkerAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询注册人员基本信息
	function queryPersonBasicInfo()
	{
		document.form1.action="<%=basepath %>/personBasicInfoAction_queryPage.action";
		document.form1.submit();
	}
	

	//职称人员
	function queryTitle()
	{
		document.form1.action="<%=basepath %>/titleAction_queryPage.action";
		document.form1.submit();
	}
	
	//操作提示信息

	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
	//资质变更
	function queryQualityList()
	{
		document.form1.action="<%=basepath %>/qualityChangeAction_showQualityList.action";
		document.form1.submit();
	}
	//资质变更查询
	function queryQualityListPage()
	{
		document.form1.action="<%=basepath %>/qualityChangeAction_queryCorpQualityChange.action";
		document.form1.submit();
	}
	
	//工程业绩
	function queryPerformance()
	{
		document.form1.action="<%=basepath %>/performanceAction_queryPage.action";
		document.form1.submit();
	}
	
	//资质注销申请
	function writeOffApproval()
	{
		document.form1.action="<%=basepath %>/writeOffApprovalAction_queryPage.action";
		document.form1.submit();
	}
	
	//资质注销查询
	function queryWriteOffApproval()
	{
		document.form1.action="<%=basepath %>/queryWriteOffTypeAction_queryPage.action";
		document.form1.submit();
	}
	
	//跨地市变更
	function changeArea()
	{
		document.form1.action="<%=basepath %>/corpChangeAreaAction_queryPage.action";
		document.form1.submit();
	}
	
	//查询归属地变更
	function queryChangeArea()
	{
		document.form1.action="<%=basepath %>/queryCorpChangeAreaAction_queryPage.action";
		document.form1.submit();
	}
	
	//资质分立
	function querySeparateList() 
	{
		document.form1.action="<%=basepath %>/separateQualificationAction_queryCorp.action";
		document.form1.submit();
	}
	
</script>
</head>
<body onload="getMessage()" style="background:#6aa0cf url(<%=basepath %>/img/zhindexbg.jpg) no-repeat;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover; min-width:1366px;">
 <form id="form1" name="form1" method="post" action="">
	 <%
 	Login login = (Login)session.getAttribute("login");
 %>
	<div class="index_wrapp">
    	<div class="index_top">
    	<input type="hidden" id="message" value="<s:property value="message" />" />
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	<span style="position:absolute;top:30px;left:800px;font-size:1.5em;color:fff;font-weight:bold">企业归属地：<%=login.getSpareName() %></span>
        	<a href="<%=basepath %>/direction/outerDirectionForUse.docx"><img class="inhelp" src="<%=basepath %>/img/help.jpg" /></a>
        </div>
        <div class="index_bottom">
        	<div class="inb_left inba left">
            	
                <ul>
                   <a href="#" onclick="queryCorp()"><li>企业基本信息修改</li></a>
                    <a href="#" onclick="queryPerformance()"><li>企业工程业绩(企业填报)</li></a>
                    <!-- <a href="#" onclick="queryForeignCorp()"><li>外商投资企业基本信息修改</li></a> -->
                    <!-- <a href="#"><li>注册基础人员</li></a> -->
                    <a href="#" onclick="queryConstructo()"><li>企业注册建造师(自动获取)</li></a>
                    <a href="#" onclick="queryPositions()"><li>企业岗位人员(自动获取)</li></a>
                    <a href="#" onclick="querySkilledworker()"><li>企业技术工人(企业填报)</li></a>
                    <a href="#" onclick="queryTitle()"><li>企业职称人员(企业填报)</li></a>
                </ul>
            
            </div>
            	<div class="inb_left inbb left">
            	
                <ul>
                    <a href="#" onclick="newApplication('001')"><li>企业资质申请</li></a>
                    <a href="#" onclick="newApplication('003')"><li>企业资质增项</li></a>
                    <a href="#" onclick="updateApplication('002')"><li>企业资质升级</li></a>
                    <!-- <a href="#" onclick="perchApplication('007')"><li>企业资质换证</li></a> -->
                  	<a href="#"><li><font color="gray">企业资质换证(已停办)</font></li></a>
                    <a href="#" onclick="queryQualityList()"><li>企业资质变更</li></a>
                    <a href="#" onclick="querySeparateList()"><li>企业资质分立/转移</li></a>
                    <a href="#" onclick="writeOffApproval()"><li>资质注销申请</li></a>
                    <a href="#" onclick="changeArea()"><li>企业归属地变更</li></a>
                </ul>
            
            </div>
            <div class="inb_left inbc left">
            	
            
				 <ul>
                    <a href="#" onclick="queryQualityListPage()"><li>企业资质变更查询</li></a>
                    <a href="#" onclick="queryApplicationInfo()"><li>企业资质审批查询</li></a>
                 	<a href="#" onclick="queryApplication()"><li>企业拥有资质查询</li></a>
                 	<a href="#" onclick="queryWriteOffApproval()"><li>企业资质注销查询</li></a>
                 	<a href="#" onclick="queryChangeArea()"><li>企业归属地变更查询</li></a>
                 </ul>
            </div>
        
        </div>
        
        
    </div>
    </form>
</body>
</html>