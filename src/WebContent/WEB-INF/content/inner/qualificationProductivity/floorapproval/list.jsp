<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大厅资质受理</title>
<script type="text/javascript">
function querySpecialtyType(){
    $(document).ready(function(){
        //获取部门下拉列表的值
        var cretSequenceId = $("#cretSequenceId").val();
        $.ajax({
            url: 'certifiedService_querySpecialtyTypes.action',
            type: 'post',
            dataType: 'json',
            data: 'cretSequenceId='+cretSequenceId,
            success: function(data){ 
                //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                var items = eval("("+data+")");
                //循环items,i为循环下标,(默认i从0开始取值)
                //移除列表中已存在的值，防止切换部门时，上次查询结果还在
                $("#specialtyTypeId").empty();
                $("#specialtyTypeId").append("<option value=''>请选择</option>");
                $.each(items,function(i){
                	var specialtyType='<s:property value="condition.specialtyType"/>';
                    if(items[i].code==specialtyType)
                    {
                        $("#specialtyTypeId").append("<option value='" + items[i].code+ "' selected>" + items[i].name + "</option>");
                    }else
                    {
                        $("#specialtyTypeId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
                    }
                });  
            }
        });
    });
}
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath%>/floorApprovalAction_queryPage.action";
		document.form1.submit();
	}

	//操作提示信息
	function getMessage() {
		var message = document.getElementById("message").value;
		if (message != "") {
			alert(message);
		}
	}
	
	//批量审批通过
	function batchApplythrough(){   
		if(hasChecked(form1)==false){
			alert("请选择要审批的记录!");
			return;
		}
		if(confirm("您确定要审批选中的记录吗？(只能批量通过！！)")==true){
			document.form1.action="<%=basepath%>/floorApprovalAction_batchApplythrough.action";
			document.form1.submit();
		}
	}
	
</script>
</head>
<body onload="querySpecialtyType();getMessage()">
<input type="hidden" id="message" value="<s:property value="message" />" />
	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">大厅资质受理</legend>
							<p style="margin-bottom: 10px; text-align: right;">
								<a href="#" onclick="query()"><span class="lbchx">查询</span></a>
								<a href="#" onclick="batchApplythrough()"><span
									class="lbchx">批量受理</span></a>
							<table width="100%" border="0" align="left" cellpadding="0"
								cellspacing="0" height="10%">
								<tr>
									<td colspan="4">日期选择： <input id="time1"
										value="<s:date name="condition.startDate" format="yyyy-MM-dd" />"
										type="text" name="condition.startDate"
										onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
										~ <input id="time2"
										value="<s:date name="condition.endDate" format="yyyy-MM-dd" />"
										type="text" name="condition.endDate"
										onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
									</td>
								</tr>
								<tr>
									<td>企业名称：</td>
									<td><input type="text" name="condition.corpName"
										value="<s:property value="condition.corpName"/>" /></td>
									<td>资质序列：</td>
									<td><select name="condition.cretSequence"
										id="cretSequenceId" onchange="querySpecialtyType()">
											<option value="">请选择</option>
											<s:iterator value="cretSequences">
												<option value="<s:property value="code"/>"
													<s:if test='condition.cretSequence==code'>selected</s:if>><s:property
														value="name" /></option>
											</s:iterator>
									</select></td>
								</tr>
								<tr>
									<td>申请类型：</td>
									<td><select name="condition.addTypeNum">
											<option value="">请选择</option>
											<s:iterator value="addTypeNums">
												<option value="<s:property value="code"/>"
													<s:if test='condition.addTypeNum==code'>selected</s:if>><s:property
														value="name" /></option>
											</s:iterator>
									</select></td>
									<td>资质等级：</td>
									<td><select name="condition.cretLevel">
											<option value="">请选择</option>
											<s:iterator value="cretLevels">
												<option value="<s:property value="code"/>"
													<s:if test='condition.cretLevel==code'>selected</s:if>><s:property
														value="name" /></option>
											</s:iterator>
									</select></td>
								</tr>

							</table>
						</fieldset>
					</td>
				</tr>
			</table>

			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				onmouseover="changeto()" onmouseout="changeback()">
				<tr>
					<th>序号</th>
					<th>企业名称</th>
					<th>资质名称</th>
					<th>所属部门</th>
					<th>业务类型</th>
					<th>资质序列</th>
					<th>资质类别</th>
					<th>资质等级</th>
					<th>申请日期</th>
					<th>申请类型</th>
					<th>二级审批部门</th>
					<th><input type="checkbox" name="all"
						onclick="javascript:check(form1,form1.all);" class="henglan"></th>
					<th>操作</th>
				</tr>
				<s:iterator status="i" value="currentPage.data">
					<tr>
						<td><s:property value="#i.count" /></td>
						<td><s:property value="corpName" /></td>
						<td><s:property value="certName" /></td>
						<td><s:property value="provinceName" /> <s:property
								value="cityName" /> <s:property value="countyName" /></td>
						<td><s:property value="cretTypeName" /></td>
						<td><s:property value="cretSequenceName" /></td>
						<td><s:property value="specialtyTypeName" /></td>
						<td><s:property value="cretLevelName" /></td>
						<td><s:date name="creatDate" format="yyyy-MM-dd" /></td>
						<td><s:property value="addTypeName" /></td>
						<td><s:property value="twoApprovalDeptName" /></td>
						<td><input type="checkbox" name="ids"
							value="<s:property value="newQualId"/>"
							onclick="javascript:setChecked(form1);" /></td>
						<td align='center'>
							<s:if test="addTypeNum==007"><a href="floorApprovalAction_queryPerchInfo.action?id=<s:property value="newQualId"/>">查看</a></s:if>
							<s:if test="addTypeNum!=007"><a href="floorApprovalAction_queryInfoPage.action?id=<s:property value="newQualId"/>">查看</a></s:if>
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