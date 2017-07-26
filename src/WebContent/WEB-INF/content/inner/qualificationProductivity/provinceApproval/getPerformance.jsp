<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业工程业绩</title>

</head>
<body>
<form id="form1" name="form1" method="post" action="">
<div class="libiao">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >企业工程业绩</legend>	
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
        <th>项目名称</th>
        <th>项目类型</th>
        <th>工程规模</th>
        <th>工程造价</th>
        <th>开工时间</th>
        <th>竣工时间</th>
        <th>建设单位</th>
        <th>总承包单位</th>
        <th>设计单位</th>
        <th>监理</th>
    </tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/> </td>
        <td><s:property value="proName"/></td>
        <td><s:property value="proType"/></td>
        <td><s:property value="proScale"/></td>
        <td><s:property value="proCost"/></td>
        <td><s:date name="startsDate" format="yyyy-MM-dd" /></td>
        <td><s:date name="completedDate" format="yyyy-MM-dd" /></td>
        <td><s:property value="construction"/></td>
        <td><s:property value="contractor"/></td>
        <td><s:property value="design"/></td>
        <td><s:property value="supervisor"/></td>
    </tr>
	</s:iterator>
	
</table>
</div>
</form>
 <%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>