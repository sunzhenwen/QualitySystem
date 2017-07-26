<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业申请资质查看</title>

</head>
<body>
<form id="form1" name="form1" method="post" action="">
<div class="libiao">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >企业申请资质查看</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          
              <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				<tr>
			    	<td colspan="4">
						企业名称：<s:iterator status="i" value="currentPage.data" > 
									<s:if test="#i.count==1">
									<s:property value="corpName"/>
									</s:if>
								</s:iterator>
					</td>
  		        </tr>
		      </table>
	      </fieldset>
		</td>
   </tr>
</table>
<table width = "100%" border  = "0"  cellpadding = "0"  cellspacing="0"   onmouseover="changeto()"  onmouseout="changeback()" >
	<tr >
		<th>序号</th>
		<th>资质名称</th>
		<th>申请方式</th>
		<th>资质层级</th>
		<th>资质服务事项</th>
		<th>资质服务事项等级</th>
		<th>资质服务事项类型</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="certName"/></td>
		<td><s:property value="addTypeName"/></td>
		<td><s:property value="cretGradeName"/></td>
		<td><s:property value="specialtyTypeName"/></td>
		<td><s:property value="cretLevelName"/></td>
		<td><s:property value="cretSequenceName"/></td>
	</tr>
	</s:iterator>
	
</table>
</div>
</form>
 <%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>