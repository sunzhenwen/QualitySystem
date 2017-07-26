<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资质注销申请</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath %>/writeOffAction_applythrough.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//申请退回
	function applyBack()
	{
		var nmv = document.getElementById("appId");
		if(nmv.value != "")
		{
			document.form1.action="<%=basepath %>/writeOffAction_applyBack.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/writeOffAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">资质注销申请</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="certificatePrint.corpName"/>
                	<input type="hidden" name="certificatePrint.corpCertId" value="<s:property value="certificatePrint.corpCertId"/>">
                	<input type="hidden" name="certificatePrint.relationId" value="<s:property value="certificatePrint.relationId"/>">
                	</td>
                    <td>营业执照注册号：</td>
               		<td>
               		<s:property value="certificatePrint.licenseNum"/>
               		</td>
                </tr>
               
                <tr>
                    <td>证书编号：</td>
               		<td>
               		<s:property value="certificatePrint.certId"/>
               		</td>
                    <td>资质类别及等级：</td>
                    <td>
                    <s:property value="certificatePrint.certName"/>
                    </td>
                </tr>
                 <tr>
                    <td>法定代表人：</td>
               		<td>
               		<s:property value="certificatePrint.legalMan"/>
               		</td>
                    <td>经济性质：</td>
                    <td>
                    <s:property value="certificatePrint.econmicName"/>
                    </td>
                </tr>
                <tr style="height:60px; border:0">
                    <td>审批建议：</td>
               		<td colspan="3"> <textarea id="appId" name="certificatePrint.writeAppOpinion"></textarea> </td>
                </tr>
            </table>
            <div class="sp_bton"> 
        		<a href="#"><span class="sp_first" onclick="applythrough()">审批通过</span></a>
        	    <a href="#"><span class="sp_second" onclick="applyBack()">申请退回</span></a>
        	    <a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>