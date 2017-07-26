<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>国家级证书确认</title>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/countryCertificatePrintAction_queryPage.action";
		document.form1.submit();
	}
	
	//确认详细
	function confirmPage(corpId,certName){
		var openUrl = "<%=basepath %>/countryCertificatePrintAction_confirmPage.action?corpId="+corpId+"&certName="+certName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		//window.open(openUrl); 
		window.location.href = openUrl ;
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
		  <legend  class="chaxuntj" >国家级证书确认</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          <a href="#" onclick="query()"><span class="lbchx">查询</span></a>
              <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				
		        <tr>
			        <td>企业名称：</td>
			  		<td>
			  			<input type="text" name="condition.corpName" value="<s:property value="condition.corpName"/>" />
			  		</td>
					<td>营业执照注册号：</td>
			        <td>
			        	<input type="text" name="condition.licenseNum" value="<s:property value="condition.licenseNum"/>" />
			  		</td>
	  	        </tr>
		        <tr>
			    	<td>法定代表人：</td>
			  		<td>
			  	    	<input type="text" name="condition.legalMan" value="<s:property value="condition.legalMan"/>" />
			  		</td>
					<td>经济性质：</td>
			        <td>
			  	 		<select name="condition.econmicNum">
                          <option value="">请选择</option>
							<s:iterator value="econmicNums">
								<option value="<s:property value="code"/>" <s:if test='condition.econmicNum==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
			  		</td>
	  	        </tr>
	  	        <tr>
			    	<td>资质类别及等级：</td>
			  		<td>
			  	    	<input type="text" name="condition.certName" value="<s:property value="condition.certName"/>" />
			  		</td>
					<td>证书编号：</td>
			        <td>
			  	 		<input type="text" name="condition.certId" value="<s:property value="condition.certId"/>" />
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
		<th>企业名称</th>
		<th>营业执照注册号</th>
		<th>注册资本</th>
		<th>证书编号</th>
		<th>资质类别及等级</th>
		<th>法定代表人</th>
		<th>经济性质</th>
		<th>有效期</th>
		<th>操作</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="corpName"/></td>
		<td><s:property value="licenseNum"/></td>
		<td><s:property value="regPrin"/></td>
		<td><s:property value="certId"/></td>
		<td><s:property value="certName"/></td>
		<td><s:property value="legalMan"/></td>
		<td><s:property value="econmicName"/></td>
		<td><s:date name="organDate" format="yyyy-MM-dd" />~<s:date name="endDate" format="yyyy-MM-dd" /></td>
		<td align='center'>
			<s:if test="certId == null">
				<%-- <a href="countryCertificatePrintAction_confirmPage.action?corpId=<s:property value="corpId"/>&certName=<s:property value="certName"/>">确认</a> --%>
				<a href="javascript:confirmPage('<s:property value="corpId"/>','<s:property value="certName"/>')">确认</a>
			</s:if>
		 </td>
		
	</tr>
	</s:iterator>
</table>
</form>
</div>
 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
</div>
</body>
</html>