<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审批详细信息</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryAllApplicationAction_queryPage.action";
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
        
         <h2 class="f16 fb" style="background:#80aced;">历史审批详细信息</h2>
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
                	<td>外厅审批结果：</td>
                	<td>
                	<s:property value="newQualification.oneResults"/>
                	
                	</td>
                    <td>审批结果：</td>
               		<td><s:property value="newQualification.ultimateResults"/>
               		</td>
               	</tr>
          		<tr>
                	<td>外厅审批意见：</td>
                	<td>
                	<s:property value="newQualification.oneUltimateOpinion"/>
                	
                	</td>
                    <td>审批意见：</td>
               		<td><s:property value="newQualification.ultimateOpinion"/>
               		</td>
               	</tr>
          		<tr>
                	<td>外厅审批人员：</td>
                	<td>
                	<s:property value="newQualification.twoApprovalStaff"/>
                	
                	</td>
                    <td>审批人员：</td>
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
                	<td>外厅审批部门名称：</td>
                	<td>
                	<s:property value="newQualification.twoApprovalDeptName"/>
                	</td>
                    <td>审批部门名称：</td>
               		<td><s:property value="newQualification.approvalDeptName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>资质资格取得方式：</td>
                	<td>
                	<s:property value="newQualification.addTypeName"/></td>
                	
                    <td>申请日期：</td>
               		<td><s:date name="newQualification.creatDate" format="yyyy-MM-dd" /></td>
               	</tr>
          		<tr>
                	<td>外厅审批日期：</td>
                	<td>
                	<s:date name="newQualification.oneAppDate" format="yyyy-MM-dd" /></td>
                	
                    <td>审批日期：</td>
               		<td><s:date name="newQualification.ultimateDate" format="yyyy-MM-dd" /></td>
               	</tr>
          		<tr>
                	<td>原资质名称：</td>
                	<td><s:property value="oldQualification.specialtyTypeName"/>
               		</td>
                	
                    <td>原资质等级：</td>
               		<td><s:property value="oldQualification.cretLevelName"/>
               		</td>
               	</tr>
          		<tr>
                	<td>原资质申请日期：</td>
                	<td>
                	<s:date name="oldQualification.creatDate" format="yyyy-MM-dd" /></td>
                	
                    <td>原资质审批日期：</td>
               		<td><s:date name="oldQualification.ultimateDate" format="yyyy-MM-dd" /></td>
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
                <tr style="height:60px; border:0">
                    <td>企业工程业绩：</td>
               		<td>
					<a href="#" onclick="getPerformance('<s:property value="newQualification.corpId"/>')">详细查看</a>
					</td>
					<td>&nbsp;</td>
                	<td>&nbsp;</td>
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