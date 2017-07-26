<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>国家级证书确认</title>
<script type="text/javascript">
	//审批通过
	function applythrough()
	{
		if(check())
		{
			document.form1.action="<%=basepath %>/countryCertificatePrintAction_confirm.action";
			document.form1.submit();
		}
		
	}
	function check()
	{
		var checkType = true;
		var certId=document.getElementById("certId").value;
		var time1=document.getElementById("time1").value;
		var time2=document.getElementById("time2").value;
		if(certId=="")
		{
			alert("请输入证书编号!");
			checkType = false;
		}else if(time1=="")
		{
			alert("请输入发证日期!");
			checkType = false;
		}else if(time2=="")
		{
			alert("请输入证书有效截止日期!");
			checkType = false;
		}
		return checkType;
	}
	function applythroughback()
	{
		document.form1.action="<%=basepath %>/countryCertificatePrintAction_confirmBack.action";
		document.form1.submit();
	}
	function goBack()
	{
		document.form1.action="<%=basepath %>/countryCertificatePrintAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">国家级证书确认</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               <input type="hidden" name="countryPrint.relationId" value="<s:property value="countryPrint.relationId"/>">
               <input type="hidden" name="countryPrint.corpId" value="<s:property value="countryPrint.corpId"/>">
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="countryPrint.corpName"/>
                	</td>
                    <td>营业执照注册号：</td>
               		<td><s:property value="countryPrint.licenseNum"/></td>
                </tr>
               
                <tr>
                    <td>注册资本(万元)：</td>
               		<td>
               		<s:property value="countryPrint.regPrin"/>
               		</td>
                    <td>资质类别及等级：</td>
                    <td>
                    <s:property value="countryPrint.certName"/>
                     <input type="hidden" name="countryPrint.certName" value="<s:property value="countryPrint.certName"/>">
                    </td>
                </tr>
                 <tr>
                    <td>法定代表人：</td>
               		<td>
               		<s:property value="countryPrint.legalMan"/>
               		</td>
                    <td>经济性质：</td>
                    <td>
                    <s:property value="countryPrint.econmicName"/>
                    </td>
                </tr>
                <tr>
                    <td>证书编号：</td>
               		<td>
               		<input id="certId" type="text" name="countryPrint.certId" value="<s:property value="countryPrint.certId"/>">
               		
               		</td>
                    <td>发证日期：</td>
                    <td>
                    <input id="time1" value="<s:date name="countryPrint.organDate" format="yyyy-MM-dd" />" type="text" name="countryPrint.organDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
                    </td>
                </tr>
                <tr>
                    <td>证书有效期截止日期：</td>
               		<td>
               		<input id="time2" value="<s:date name="countryPrint.endDate" format="yyyy-MM-dd" />" type="text" name="countryPrint.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
               		</td>
                    <td>&nbsp;</td>
                	<td>&nbsp;</td>
                </tr>
            </table>
            <div class="sp_bton"> 
        		<a href="#"><span class="sp_first" onclick="applythrough()">审批通过</span></a>
        		<a href="#"><span class="sp_first" onclick="applythroughback()">申请退回</span></a>
        	    <a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>