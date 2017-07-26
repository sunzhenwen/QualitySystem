<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>初审审批详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/twoQueryAction_queryPage.action";
		document.form1.submit();
	}
</script>
</head>
<body>
<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">初审历史审批详细信息</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
          <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
          		<tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="newQualification.corpName"/>
                	</td>
                	
                    <td>企业所在地：</td>
               		<td><s:property value="newQualification.provinceName"/><s:property value="newQualification.cityName"/><s:property value="newQualification.countyName"/></td>
                </tr>
          		<tr>
                	<td>初审审批结果：</td>
                	<td>
                	<s:property value="newQualification.oneResults"/>
                	
                	</td>
                    <td>终审审批结果：</td>
               		<td><s:property value="newQualification.ultimateResults"/>
               		</td>
               	</tr>
          		<tr>
                	<td>初审审批意见：</td>
                	<td>
                	<s:property value="newQualification.oneUltimateOpinion"/>
                	
                	</td>
                    <td>终审审批意见：</td>
               		<td><s:property value="newQualification.ultimateOpinion"/>
               		</td>
               	</tr>
          		<tr>
                	<td>初审审批人员：</td>
                	<td>
                	<s:property value="newQualification.twoApprovalStaff"/>
                	
                	</td>
                    <td>终审审批人员：</td>
               		<td><s:property value="newQualification.approvalStaff"/>
               		</td>
               	</tr>
          		<tr>
                	<td>服务事项名称：</td>
                	<td>
                	<s:property value="newQualification.certName"/>
                	</td>
                	
                    <td>资质类型名称：</td>
               		<td><s:property value="newQualification.cretTypeName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>资质等级：</td>
                	<td>
                	<s:property value="newQualification.cretLevelName"/>
                	
                	</td>
                    <td>资质序列名称：</td>
               		<td><s:property value="newQualification.cretSequenceName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>资质专业类别：</td>
                	<td>
                	<s:property value="newQualification.specialtyTypeName"/>
                	
                	</td>
                    <td>资质级别：</td>
               		<td><s:property value="newQualification.cretGradeName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>初审审批部门名称：</td>
                	<td>
                	<s:property value="newQualification.twoApprovalDeptName"/>
                	</td>
                    <td>终审审批部门名称：</td>
               		<td><s:property value="newQualification.approvalDeptName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>资质资格取得方式：</td>
                	<td>
                	<s:property value="newQualification.addTypeName"/></td>
                	
                    <td>申请日期：</td>
               		<td><s:property value="newQualification.creatDate"/></td>
               	</tr>
               	</table>
            <div class="sp_bton"> 
        	    <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a>
            </div>
         </form>
         </div>
         </div>
</body>
</html>