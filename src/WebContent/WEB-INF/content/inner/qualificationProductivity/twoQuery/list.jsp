<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初审审批查询</title>
<script type="text/javascript">

	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/twoQueryAction_queryPage.action";
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
		  <legend  class="chaxuntj" >初审历史审批查询</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          <a href="#" onclick="query()"><span class="lbchx">查询</span></a> 
			<table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				<tr>
			    	<td colspan="4">日期选择：
						<input id="time1"  type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						~
						<input id="time2"  type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
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
		          <td>申请类型：</td>
		          <td>
		          <select name="condition.addTypeNum" >
	                        <option value="">请选择</option>
						<s:iterator value="addTypeNums">
							<option value="<s:property value="code"/>" <s:if test='condition.addTypeNum==code'>selected</s:if>><s:property value="name"/></option>
						</s:iterator>
					</select>
		          </td>
		          <td>初审申请审批结果：</td>
		          <td>
		          <select name="condition.oneResults">
		          <s:property value = "condition.oneResults"/>
	                        <option value="">请选择</option>
	                        <option value="3" <s:if test="condition.oneResults == 3">selected</s:if>>通过</option>
	                        <option value="4" <s:if test="condition.oneResults == 4">selected</s:if>>不通过</option>
					</select>
		          </td>
		         </tr>
			  	 <tr>
		          <td>终审申请审批结果：</td>
		          <td>
		          <select name="condition.ultimateresults">
		          <s:property value = "condition.ultimateresults"/>
	                        <option value="">请选择</option>
	                        <option value="5" <s:if test="condition.ultimateresults == 5">selected</s:if>>通过</option>
	                        <option value="6" <s:if test="condition.ultimateresults == 6">selected</s:if>>不通过</option>
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
		<th>初审审批结果</th>
		<th>终审审批结果</th>
		<th>操作</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="corpName"/></td>
		<td><s:property value="cretLevelName"/></td>
		<td><s:date name="creatDate" format="yyyy-MM-dd" /></td>
		<td><s:property value="addTypeName"/></td>
		<td><s:property value="oneResults"/></td>
		<td><s:property value="ultimateResults"/></td>
		<td align='center'> <a href="twoQueryAction_infoPage.action?newQualId=<s:property value="newQualId"/>">详细</a> </td>
	</tr>
	</s:iterator>
</table>
</div>
 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
</div>
</body>
</html>