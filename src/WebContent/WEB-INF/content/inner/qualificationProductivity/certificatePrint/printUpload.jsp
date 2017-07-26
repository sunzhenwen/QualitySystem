<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>证书信息预览</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
</object>
<script type="text/javascript" src="<%=basepath%>/js/validator.js"></script>
<script type="text/javascript">
	function validateForm()
	{

		return Validator.Validate(form1,2);
	}	
	
	function save()
	{
		$("#baocun").hide();
		document.getElementById("mes").innerHtml="请稍等!";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">证书信息预览</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="<%=basepath %>/certificatePrintAction_uploadCertificate.action" onsubmit="return validateForm()">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
                
                <tr>             
                	<td colspan="4">
                	<p align="center">
                	<s:if test="certificatePrint.updateType==1">
                		第<s:property value="certificatePrint.updateType"/>次打印
                	</s:if>
                	<s:else>
                		重新打印
                	</s:else>
                	</p>
                	
                	<input type="hidden" name="updateType" id="updateType" value="<s:property value="certificatePrint.updateType" />" />
                	</td>
                </tr>
                
                <tr>
                	<td>企业名称：</td>
                	<td colspan="3">
                	<s:property value="certificatePrint.corpName"/>
                	<input type="hidden" name="corpName" id="corpName" value="<s:property value="certificatePrint.corpName" />"  />
                	<input type="hidden" name="corpCertId" id="corpCertId" value="<s:property value="certificatePrint.certId" />"  />
                	<input type="hidden" name="corpCode" id="corpCode" value="<s:property value="certificatePrint.corpCode" />"  />
                	</td>
                </tr>            
                <tr>
                  <td>详细地址：</td>
                  <td colspan="3">
                  	<s:property value="certificatePrint.address"/>
				  </td>
                </tr>
                <tr>
                  <td>营业执照注册号：</td>
                  <td>
                  	 <s:property value="certificatePrint.licenseNum"/>	
                  </td>
                  <td>法定代表人：</td>
                  <td>
                  	 <s:property value="certificatePrint.legalMan"/>                 		
                  </td>
                </tr>
                <tr>
                  <td>注册资本：</td>
                  <td>                 
                  	<s:property value="certificatePrint.regPrin"/>万元                         
                  </td>
                  <td>经济性质：</td>
                  <td>
                  	<s:property value="certificatePrint.econmicName"/>                 
                  </td>
                </tr>
                <tr>
                    <td>证书编号：</td>
               		<td>
               			<s:property value="certificatePrint.certId"/>             		
               		</td>
                    <td>有效期：</td>
                    <td>
                    	<s:date name="certificatePrint.organDate" format="yyyy-MM-dd" />至<s:date name="certificatePrint.endDate" format="yyyy-MM-dd" />                  
                    </td>
                </tr>
                 <tr>
                    <td>资质类别及等级：</td>
               		<td>
	               		<s:iterator id="list" status="i" value="certificatePrint.certNames" >
	                    	<s:property value="#list"/><br />
	                    </s:iterator>                    
               		</td>
                    <td>打证日期：</td>
               		<td>
               			<s:date name="certificatePrint.printDate" format="yyyy-MM-dd" />
               		</td>
                </tr>    
                <tr>
                    <td>正本流水号：</td>
               		<td>       		
						<input type="text" maxlength='10' name="PRINTNUMBER" dataType="Integer" msg="正本流水号不能为空且是数字" />
               		</td>
                    <td>副本流水号：</td>
               		<td>       		
						<input type="text" maxlength='10' name="FBPRINTNUMBER" dataType="Integer" msg="副本流水号不能为空且是数字" />
               		</td>
               </tr>
             
	          <s:if test="!certificatePrint.updateType.equals(\"1\") ">             
		          <tr>
		            <td>重新打印原因：</td>
		            <td colspan="3">             	
		               <textarea name="printReason" rows="2" cols="20" maxlength='40' dataType="Require" msg="打印原因不能为空"><s:property value="printReason"/></textarea>           
		            </td>
		          </tr>  
	          </s:if>
	          
	          <s:if test="uploadState.equals(\"2\") "> 
		          <tr>
		            <td>上传状态：</td>
		            <td colspan="3">             	
		               <font color="red">证书信息上传国家接口失败</font>
		            </td>
		          </tr> 
		          
		          <tr>
		            <td>失败原因：</td>
		            <td colspan="3">             	
		               <font color="red"><s:property value="errorString"/></font>
		            </td>
		          </tr> 		          		          
	          </s:if> 
	        <!--  
	          	<tr>
		            <td><font color="red">通知：</font></td>
		            <td colspan="3">             			                                                                                                
		            <p>
					  <font color="red">住建部证书上传接口有调整，今日暂停资质证书打印!，明日恢复。</font>
					</p>                                        		                                                                           
		            </td>
		         </tr>
	              -->
            </table>
      
      
				<div id="mes" class="botn">
					<input id="baocun" type="image" src="<%=basepath%>/img/qy_02.png" onclick="save()"/> 
				</div>
 
        </form>
    	</div>
  </div>

</body>
</html>