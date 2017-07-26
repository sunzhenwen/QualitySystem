<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专业厅局审批</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath %>/twoApprovalAction_applythrough.action";
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
			document.form1.action="<%=basepath %>/twoApprovalAction_applyBack.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/twoApprovalAction_goBack.action";
		document.form1.submit();
	}
	//注册建造师
	function getCountConstructor(corpName)
	{
		var openUrl = "<%=basepath %>/queryConstructorAction_getConstructor.action?condition.corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)   
	}
	//技术工人
	function getSkilledworker(corpId)
	{
		window.open('<%=basepath %>/querySkilledworkerAction_getSkilledworker.action?condition.corpId='+corpId)   
	}
	//职称人员
	function getTitle(corpId)
	{
		window.open('<%=basepath %>/queryTitleAction_getTitle.action?condition.corpId='+corpId)   
	}
	//岗位人员
	function getCountPositions(corpName)
	{
		var url = "<%=basepath %>/queryPositionsAction_getPositions.action?condition.corpName="+corpName;
		url = encodeURI(url);
	    url = encodeURI(url);
		window.open(url)   
	}
	//企业工程业绩
	function getPerformance(corpId)
	{
		window.open('<%=basepath %>/queryPerformanceAction_queryPage.action?condition.corpId='+corpId)   
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">专业厅局审批</h2>
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
                    <td>审批部门：</td>
               		<td>
               			<s:property value="newQualification.twoApprovalDeptName"/>
               			<input type="hidden" name="newQualification.twoApprovalDept" value="<s:property value="newQualification.approvalDept"/>" />
                    	<input type="hidden" name="newQualification.twoApprovalDeptName" value="<s:property value="newQualification.approvalDeptName"/>" />
                    </td>
                    <td>审批人员：</td>
                    <td>
                    	<s:property value="approvalStaff"/>
                    	<input type="hidden" name="newQualification.twoApprovalStaff" value="<s:property value="approvalStaff"/>" />
                    	<input type="hidden" name="newQualification.twoApprovalStaffId" value="<s:property value="approvalStaffId"/>" />
                    	<input type="hidden" name="newQualification.corpId" value="<s:property value="newQualification.corpId"/>" />
                    </td>
                </tr>
                <tr>
                    <td>注册建造师：</td>
               		<td>
               			<a href="#" onclick="getCountConstructor('<s:property value="newQualification.corpName"/>')">共&nbsp;<s:property value="countConstructor"/>&nbsp;人</a>
               		</td>
                    <td>岗位人员：</td>
                    <td>
                    	<a href="#" onclick="getCountPositions('<s:property value="newQualification.corpName"/>')">共&nbsp;<s:property value="countPositions"/>&nbsp;人</a>
                    </td>
                </tr>
                <tr>
                    <td>技术工人：</td>
               		<td>
               			<a href="#" onclick="getSkilledworker('<s:property value="newQualification.corpId"/>')">共&nbsp;<s:property value="countSkilledworker"/>&nbsp;人</a>
               		</td>
                    <td>职称人员：</td>
                    <td>
                    	<a href="#" onclick="getTitle('<s:property value="newQualification.corpId"/>')">共&nbsp;<s:property value="countTitle"/>&nbsp;人</a>
                    </td>
                </tr>
                <tr>
                	<td>原资质专业类别：</td>
               		<td>
               			<s:property value="newQualification.oldSpecialtyTypeName"/>
               		</td>
                    <td>原资质等级：</td>
               		<td>
               			<s:property value="newQualification.oldCretLevelName"/>
               		</td>
                    
                </tr>
                <tr>
                    <td>原资质申请时间：</td>
                    <td>
                    	<s:date name="newQualification.oldCreatDate" format="yyyy-MM-dd" />
                    </td>
                    <td>原资审批时间：</td>
               		<td>
               			<s:date name="newQualification.oldUltimateDate" format="yyyy-MM-dd" />
               		</td>
                </tr>
                <tr style="height:60px; border:0">
                    <td>企业工程业绩：</td>
               		<td>
					<a href="#" onclick="getPerformance('<s:property value="newQualification.corpId"/>')">详细查看</a>
					</td>
					<td>&nbsp;</td>
                	<td>&nbsp;</td>
                </tr>
                <tr style="height:60px; border:0">
                    <td>审批建议：</td>
               		<td colspan="3"> <textarea id="appId" name="newQualification.oneUltimateOpinion"></textarea> </td>
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