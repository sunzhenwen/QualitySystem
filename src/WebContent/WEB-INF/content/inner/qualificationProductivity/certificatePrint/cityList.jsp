<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资质证打印</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
</object>
<script type="text/javascript">
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/cityCertificatePrintAction_queryPage.action";
		document.form1.submit();
	}
	//注册建造师
	function getPrint(corpCode)
	{	
		try
		{ 
		   var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
		   if ((LODOP!=null)&&(typeof(LODOP.VERSION)!="undefined")) 
			{
				//alert("本机已成功安装过Lodop控件!\n  版本号:"+LODOP.VERSION); 
				var openUrl = "<%=basepath %>/cityCertificatePrintAction_queryPrint.action?corpCode="+corpCode;
				openUrl = encodeURI(openUrl);
				openUrl = encodeURI(openUrl);
				window.open(openUrl) 			
			}						 
		}catch(err)
		{ 
			//alert("Error:本机未安装或需要升级!"); 
 		} 
	}
	
	function CheckIsInstall() 
	{	 
		try
		{ 
		   var LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM')); 
			//if ((LODOP!=null)&&(typeof(LODOP.VERSION)!="undefined")) alert("本机已成功安装过Lodop控件!\n  版本号:"+LODOP.VERSION); 		 
		}catch(err)
		{ 
			//alert("Error:本机未安装或需要升级!"); 
 		} 
	}; 
</script>
</head>
<body>
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >资质证打印</legend>	
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

					<td>证书编号：</td>
			        <td>
			  	 		<input type="text" name="condition.certId" value="<s:property value="condition.certId"/>" />
			  		</td>
			  		
			  	
			  		<td></td>
			  		<td>
			  	    	
			  		</td>			  		
			  		
			  		<!--  
			  		<td>资质类别及等级：</td>
			  		<td>
			  	    	<input type="text" name="condition.certName" value="<s:property value="condition.certName"/>" />
			  		</td>
			  		-->
			  		
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
		<th>法定代表人</th>
		<th>经济性质</th>
		<th>上传次数</th>
		<th>是否打印上传过</th>
		<th>操作</th>
	</tr>
	<s:iterator status="i" value="currentPage.data" > 
	<tr>
		<td><s:property value="#i.count"/></td>
		<td><s:property value="corpName"/></td>
		<td><s:property value="licenseNum"/></td>
		<td><s:property value="regPrin"/></td>
		<td><s:property value="certId"/></td>		
		<td><s:property value="legalMan"/></td>
		<td><s:property value="econmicName"/></td>
		<td><s:property value="PRINTCOUNT"/></td>
		<td><s:property value="ISPRINT"/></td>
		<td align='center'> 
		<a href="#" onclick="getPrint('<s:property value="corpCode"/>')">打印</a> 
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