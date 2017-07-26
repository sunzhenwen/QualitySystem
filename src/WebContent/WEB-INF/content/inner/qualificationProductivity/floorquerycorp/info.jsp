<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/floorQueryCorpAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">企业详细信息</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td><s:property value="corp.corpName"/></td>
                    <td>企业组织机构代码：</td>
               		<td><s:property value="corp.corpCode"/></td>
                </tr>
               
                <tr>
                	<td>注册企业所在市（地）、区（县）：</td>
                	<td><s:property value="corp.cityNum"/><s:property value="corp.countyNum"/></td>
                    <td>详细地址：</td>
               		<td><s:property value="corp.address"/></td>
                </tr>
               
                <tr>
                	<td>办公电话：</td>
                	<td><s:property value="corp.officephone"/></td>
                    <td>邮编：</td>
               		<td><s:property value="corp.postalCode"/></td>
                </tr>
               
                <tr>
                	<td>经济性质：</td>
                	<td><s:property value="corp.economicNum"/></td>
                    <td>注册资本金（万元）：</td>
               		<td><s:property value="corp.regPrin"/>万元</td>
                </tr>
               
                <tr>
                	<td>营业执照注册号：</td>
                	<td><s:property value="corp.licenseNum"/></td>
                    <td>建立时间：</td>
               		<td><s:date name="corp.corpBirthDate" format="yyyy-mm-dd"/></td>
                </tr>
                
                <tr>
                	<td>法定代表人：</td>
                	<td><s:property value="corp.legalMan"/></td>
                    <td>电话：</td>
               		<td><s:property value="corp.linkTel"/></td>
                </tr>
               
                <tr>
                	<td>单位负责人：</td>
                	<td><s:property value="corp.linkMan"/></td>
                    <td>电话：</td>
               		<td><s:property value="corp.linkPhone"/></td>
                </tr>
               
            </table>
            <div class="sp_bton"> 
        	    <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>