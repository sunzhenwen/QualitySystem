<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>国家资质审批</title>
<script type="text/javascript">
	
	//推送外审
	function pushApply()
	{
		if(confirm("请确认是否推送外审"))
		{
			document.form1.action="<%=basepath %>/countryApprovalAction_pushApply.action";
			document.form1.submit();
		}
		else
		{
		}
		
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/countryApprovalAction_goBack.action";
		document.form1.submit();
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">省级资质审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="newQualification.corpName"/>
                	<input type="hidden" name="newQualification.corpName" value="<s:property value="newQualification.corpName"/>" />
                	<input type="hidden" name="newQualification.newQualId" value="<s:property value="newQualification.newQualId"/>" />
                	<input type="hidden" name="newQualification.corpCode" value="<s:property value="newQualification.corpCode"/>" />
                	
                	</td>
                    <td>所属部门：</td>
               		<td><s:property value="newQualification.provinceName"/><s:property value="newQualification.cityName"/><s:property value="newQualification.countyName"/></td>
                </tr>
               
                <tr>
                    <td>资质资格类型：</td>
               		<td>
               		<s:property value="newQualification.cretTypeName"/>
               		<input type="hidden" name="newQualification.cretType" value="<s:property value="newQualification.cretType"/>" />
               		</td>
                    <td>资质资格序列：</td>
                    <td>
                    <s:property value="newQualification.cretSequenceName"/>
                    <input type="hidden" name="newQualification.cretSequence" value="<s:property value="newQualification.cretSequence"/>" />
                    </td>
                </tr>
                 <tr>
                    <td>专业类别：</td>
               		<td>
               		<s:property value="newQualification.specialtyTypeName"/>
               		<input type="hidden" name="newQualification.specialtyType" value="<s:property value="newQualification.specialtyType"/>" />
                    </td>
                    <td>资质资格等级：</td>
                    <td>
                    <s:property value="newQualification.cretLevelName"/>
                    <input type="hidden" name="newQualification.cretLevel" value="<s:property value="newQualification.cretLevel"/>" />
                    </td>
                </tr>
                <tr>
                    <td>资质资格取得方式：</td>
               		<td>
               		<s:property value="newQualification.addTypeName"/>
               		<input type="hidden" name="newQualification.addTypeNum" value="<s:property value="newQualification.addTypeNum"/>" />
                    </td>
                    <td>申请日期：</td>
                    <td>
                    <s:date name="newQualification.creatDate" format="yyyy-MM-dd" />
                    </td>
                </tr>
                <tr>
                    <td>企业净资产：</td>
               		<td>
               		<s:property value="newQualification.assets"/>万元
               		<input type="hidden" name="newQualification.assets" value="<s:property value="newQualification.assets"/>" />
                    </td>
                    <td>机械设备：</td>
               		<td>
               		<s:property value="newQualification.machinery"/>
               		<input type="hidden" name="newQualification.machinery" value="<s:property value="newQualification.machinery"/>" />
                    </td>
                </tr>
                <tr>
                    <td>专业厅局审批部门：</td>
               		<td>
               			<s:property value="newQualification.twoApprovalDeptName"/>
               			<input type="hidden" name="newQualification.twoApprovalDept" value="<s:property value="newQualification.twoApprovalDept"/>" />
                    	<input type="hidden" name="newQualification.twoApprovalDeptName" value="<s:property value="newQualification.twoApprovalDeptName"/>" />
                    </td>
                    <td>专业厅局审批人员：</td>
                    <td>
                    	<s:property value="approvalStaff"/>
                    	<input type="hidden" name="newQualification.twoApprovalStaff" value="<s:property value="approvalStaff"/>" />
                    	<input type="hidden" name="newQualification.twoApprovalStaffId" value="<s:property value="twoApprovalStaffId"/>" />
                    	<input type="hidden" name="newQualification.corpId" value="<s:property value="newQualification.corpId"/>" />
                    </td>
                </tr>
                <tr>
                    <td>注册建造师：</td>
               		<td>
               			共&nbsp;<s:property value="countConstructor"/>&nbsp;人
               		</td>
                    <td>岗位人员：</td>
                    <td>
                    	共&nbsp;<s:property value="countPositions"/>&nbsp;人
                    </td>
                </tr>
                <tr>
                    <td>技术工人：</td>
               		<td>
               			共&nbsp;<s:property value="countSkilledworker"/>&nbsp;人
               		</td>
                    <td>职称人员：</td>
                    <td>
                    	共&nbsp;<s:property value="countTitle"/>&nbsp;人
                    </td>
                </tr>
                
            </table>
            <div class="sp_bton"> 
        		<a href="#"><span class="sp_first" onclick="pushApply()">推送外审</span></a>
            	<a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
            </div>
       	</form>
    	</div>
  </div>
</body>
</html>