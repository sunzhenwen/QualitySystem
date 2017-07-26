<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业基本信息</title>
<script type="text/javascript">
	//查询
	function queryCorpInfo()
	{
		document.form1.action="<%=basepath %>/corpInfoAction_queryCorpInfo.action?type=1";
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
	
</script>
</head>
<body onload="querySpecialtyType()">
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
	<table width="100%" border="0" cellpadding="0" height="15%">
		<tr>
			<td>
			  <fieldset>
					<legend class="chaxuntj">公司信息查询</legend>
					<p style="margin-bottom: 10px; text-align: right;">
						<a href="#" ><span class="lbchx" onclick="queryCorpInfo()">查询</span></a> 
				    </p>
				  <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
					  <tr>
                        <td>企业名称：</td>
                        <td><input type="text" name="condition.corpName" value="<s:property value="condition.corpName"/>"/></td>
                        
                        <td>组织机构代码或统一社会信用代码：</td>
                        <td><input type="text" name="condition.corpCode" value="<s:property value="condition.corpCode"/>"/></td>
                      
                        <td>工商营业执照注册号：</td>
                        <td><input type="text" name="condition.licenseNum" value="<s:property value="condition.licenseNum"/>"/></td>
                       
                      </tr>
                      
                	  
				  </table>
			</fieldset>
			</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<th>序号</th>
       		<th>企业名称</th>
            <th>组织机构代码</th>
            <th>工商营业执照注册号</th>
            <th>办公电话</th>
            <th>操作</th>
        </tr>
        <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="corpName"/></td>
                            <td><s:property value="corpCode"/></td>
                            <td><s:property value="licenseNum"/></td>
                            <td><s:property value="officePhone"/></td>
                            <td align='center'><a href="corpInfoAction_detailCorpPage.action?corpId=<s:property value="corpId"/>"><span class="lbmingx">详细</span></a></td>
                         </tr>
		</s:iterator>
       </table>
  </form>
 
</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>