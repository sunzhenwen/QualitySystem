<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大厅换证受理</title>
<script type="text/javascript">
  
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			if(confirm("请确认是否通过"))
			{
				document.form1.action="<%=basepath%>/separateQualificationAction_approvalSuccess.action?s="+Math.random();
				document.form1.submit();
			}
			else
			{
			}
			
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
			if(confirm("请确认是否不通过"))
			{
				document.form1.action="<%=basepath%>/separateQualificationAction_approvalFailed.action";
				document.form1.submit();
			}
			else
			{
			}
			
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/separateQualificationAction_goBack.action";
		document.form1.submit();
	}
	
	//注册建造师
	function getCountConstructor(corpName)
	{
		var openUrl = "<%=basepath%>/queryConstructorAction_getConstructor.action?condition.corpName="+corpName;
		openUrl = encodeURI(openUrl);
		openUrl = encodeURI(openUrl);
		window.open(openUrl)   
	}
	//技术工人
	function getSkilledworker(corpId)
	{
		window.open('<%=basepath%>/querySkilledworkerAction_getSkilledworker.action?condition.corpId='+corpId)   
	}
	//职称人员
	function getTitle(corpId)
	{
		window.open('<%=basepath%>/queryTitleAction_getTitle.action?condition.corpId='+corpId)   
	}
	//岗位人员
	function getCountPositions(corpName)
	{
		var url = "<%=basepath%>/queryPositionsAction_getPositions.action?condition.corpName="+corpName;
		url = encodeURI(url);
	    url = encodeURI(url);
		window.open(url)   
	}
	//企业工程业绩
	function getPerformance(corpId)
	{
		window.open('<%=basepath%>/queryPerformanceAction_queryPage.action?condition.corpId='
						+ corpId)
	}
</script>
</head>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">企业申请信息</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<tr>
						<td>企业名称：</td>
						<td><s:property value="corp.corpName" /> </td>
						<td>组织机构代码：</td>
						<td><s:property value="corp.corpCode" /></td>
					</tr>
					<tr>
						<td>办公电话：</td>
						<td><s:property value="corp.officePhone" /></td>
						<td>邮编：</td>
						<td><s:property value="corp.postalCode" /></td>
					</tr>
					<tr>
						<td>详细地址：</td>
						<td colspan="3"><s:property value="corp.address" />
						</td>
					</tr>
					<tr>
						<td>经济性质：</td>
						<td><s:property value="corp.economicNum" /></td>
						<td>注册资本金：</td>
						<td><s:property value="corp.regPrin" />万 人民币
						</td>
					</tr>
					<tr>
						<td>营业执照注册号：</td>
						<td><s:property value="corp.licenseNum" /></td>
						<td>法定代表人：</td>
						<td><s:property value="corp.legalMan" />
						</td>
					</tr>
					<tr>
						<td>建立日期：</td>
						<td><s:date name="corp.corpBirthDate" format="yyyy-MM-dd"/></td>
						<td>法定代表人职务：</td>
						<td><s:property value="corp.legalManDuty" />
						</td>
					</tr>
					
					
					<tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="newQualification.corpName"/>
                	<input type="hidden" name="id" value="<s:property value="newQualification.newQualId"/>" />
                	<input type="hidden" name="corpName" value="<s:property value="newQualification.corpName"/>" />
                	</td>
                    <td>所属部门：</td>
               		<td><s:property value="newQualification.provinceName"/><s:property value="newQualification.cityName"/><s:property value="newQualification.countyName"/></td>
                </tr>
               <tr>
						<td>资质名称：</td>
						<td colspan="3">
							<s:property value="newQualification.certName" />
						</td>
					</tr>
                <tr>
                    <td>资质资格类型：</td>
               		<td>
               		<s:property value="newQualification.cretTypeName"/>
               		</td>
                    <td>资质资格序列：</td>
                    <td>
                    <s:property value="newQualification.cretSequenceName"/>
                    </td>
                </tr>
                 <tr>
                    <td>专业类别：</td>
               		<td>
               		<s:property value="newQualification.specialtyTypeName"/>
                    </td>
                    <td>资质资格等级：</td>
                    <td>
                    <s:property value="newQualification.cretLevelName"/>
                    </td>
                </tr>
                <tr>
                    <td>资质资格取得方式：</td>
               		<td>
               		<s:property value="newQualification.addTypeName"/>
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
                    </td>
                    <td>机械设备：</td>
               		<td>
               		<s:property value="newQualification.machinery"/>
                    </td>
                </tr>
                <tr>
					<td>被分立企业名称：</td>
					<td><s:property value="newQualification.preCorpName" /> </td>
					<td>组织机构代码：</td>
					<td><s:property value="newQualification.preCorpCode" /></td>
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
					<tr style="height: 60px; border: 0">
						<td>企业工程业绩：</td>
						<td><a href="#"
							onclick="getPerformance('<s:property value="newQualification.corpId"/>')">详细查看</a>
						</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr style="height: 60px; border: 0">
						<td>受理建议：</td>
						<td colspan="3"><textarea id="appId" name="op"
								class="required"></textarea></td>
					</tr>
				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_first" onclick="applythrough()">提交</span></a>
					<a href="#"><span class="sp_second" onclick="applyBack()">打回</span></a>
					<a href="#"><span class="sp_last" onclick="history.back()">取消</span></a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>