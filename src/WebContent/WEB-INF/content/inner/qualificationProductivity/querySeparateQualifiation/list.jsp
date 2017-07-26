<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审批查询</title>
<script type="text/javascript">

	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/queryAllApplicationAction_queryPage.action";
		document.form1.submit();
	}
	
	

</script>
</head>
<body>
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >全部历史审批查询</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          <a href="#" onclick="query()"><span class="lbchx">查询</span></a> 
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				<tr>
			    	<td colspan="4">日期选择：
						<input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						~
						<input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
					</td>
  		        </tr>
		        <tr>
			        <td>企业名称：</td>
			  		<td>
			  			<input type="text" name="condition.corpName" value="<s:property value="condition.corpName"/>" />
			  		</td>
			  		<td>资质等级：</td>
			        <td>
			  	 		<select name="condition.cretLevel">
                          <option value="">请选择</option>
							<s:iterator value="cretLevels">
								<option value="<s:property value="code"/>" <s:if test='condition.cretLevel==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
			  		</td>
			  	</tr>
			  	 <tr>
		         
		          <td>审批层级：</td>
		          <td>
		          <select name="condition.level">
		          <s:property value = "condition.level"/>
	                        <option value="">请选择</option>
	                        <option value="1" <s:if test="condition.level == 1">selected</s:if>>无外厅审批</option>
	                        <option value="2" <s:if test="condition.level == 2">selected</s:if>>外厅审批</option>
					</select>
		          </td>
		          <td>审批结果：</td>
		          <td>
		          <select name="condition.ultimateresults">
		          <s:property value = "condition.ultimateresults"/>
	                         <option value="">请选择</option>
	                        <option value="5" <s:if test="condition.ultimateresults == 5">selected</s:if>>审批通过</option>
	                        <option value="6" <s:if test="condition.ultimateresults == 6">selected</s:if>>审批未通过</option>
	                        <option value="2" <s:if test="condition.ultimateresults == 2">selected</s:if>>待外厅处理</option>
	                        <option value="a" <s:if test='%{condition.ultimateresults == "a"}'>selected</s:if>>待大厅受理</option>
	                        <option value="q" <s:if test='%{condition.ultimateresults == "q"}'>selected</s:if>>待建管受理</option>
	                        <option value="w" <s:if test='%{condition.ultimateresults == "w"}'>selected</s:if>>待地市受理</option>
	                       
					</select>
		          </td>
		         </tr>
    		</table>
	      </fieldset>
		</td>
   	</tr>
</table>
</form>
<table width = "100%" border  = "0"  cellpadding = "0"  cellspacing="0"   onmouseover="changeto()"  onmouseout="changeback()" >
	<tr >
		<th>序号</th>
		<th>企业名称</th>
		<th>资质等级</th>
		<th>申请日期</th>
		<th>申请类型</th>
		<th>审批层级</th>
		<th>审批状态</th>
		<th>操作</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="corpName"/></td>
		<td><s:property value="cretLevelName"/></td>
		<td><s:date name="creatDate" format="yyyy-MM-dd" /></td>
		<td><s:property value="addTypeName"/></td>
		<td><s:property value="oneResults"/>-<s:property value="twoApprovalDeptName"/></td>
		<td><s:property value="ultimateResults"/></td>
		<td align='center'> <a href="querySeparateQualificationAction_infoPage.action?newQualId=<s:property value="newQualId"/>">详细</a> </td>
	</tr>
	</s:iterator>
</table>
</div>
 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
</div>
</body>
</html>