<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>统计</title>
<script type="text/javascript">
  
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/statisticsAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">统计</h2>
         <form id="form1" name="form1" method="post">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
               <tr>
						<td style="text-align: center;">建筑行业企业数量：</td>
						<td style="text-align: center;"><s:property value="countCorps" /> 
					</tr>

					<tr>
						<td style="text-align: center;">技术人员数量：</td>
						<td style="text-align: center;"><s:property value="countSkillWorkers" />
						</td>
					</tr>

					<tr>
						<td style="text-align: center;">职称人员数量：</td>
						<td style="text-align: center;">
							<s:property value="countTitles" />
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">地市级资质证书数量：</td>
						<td style="text-align: center;">
							<s:property value="countCertificateCity" />
						</td>
					</tr>
					<tr>
						<td style="text-align: center;">省级资质证书数量：</td>
						<td style="text-align: center;"><s:property value="countCertificateProvince" />
						</td>
					</tr>

					<tr>
						<td style="text-align: center;">国家级证书数量：</td>
						<td style="text-align: center;"><s:property value="countCertificateCountry" />
						</td>
					</tr>
            </table>
        </form>
    	</div>
  </div>
</body>
</html>