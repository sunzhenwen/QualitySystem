<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
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
	function queryCertderail()
	{
		document.form1.action="<%=basepath %>/certifiedService_queryPage.action";
		document.form1.submit();
	}

	//添加
	function addCertderail()
	{
		document.form1.action="<%=basepath %>/certifiedService_addCertifiedServicePage.action";
		document.form1.submit();
	}
	//删除
	function remove(){   
		if(hasChecked(form1)==false){
			alert("请选择要删除的记录!");
			return;
		}
		if(confirm("您确定要删除选中的记录吗？")==true){
			document.form1.action ="<%=basepath %>/certifiedService_delectCertifiedService.action"; 
			document.form1.submit();
		}
	}
</script>
</head>
<body onload="querySpecialtyType()">
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
	<table width="100%" border="0" cellpadding="0" height="15%">
		<tr>
			<td>
			  <fieldset>
					<legend class="chaxuntj">资质服务事项查询</legend>
				<p style="margin-bottom: 10px; text-align: right;">
						<a href="#" ><span class="lbchx" onclick="queryCertderail()">查询</span></a> 
						<a href="#"><span class="lbchx" onclick="addCertderail()">添加</span></a> 
						<a href="#"><span class="lbchx" onclick="remove()">删除</span></a>
				  </p>
				  <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
					  <tr>
						  <td>日期选择：</td>
						  <td colspan="3">
							  <input id="time1" value="<s:date name="condition.startDate" format="yyyy-MM-dd" />" type="text" name="condition.startDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
							  ~
							  <input id="time2" value="<s:date name="condition.endDate" format="yyyy-MM-dd" />" type="text" name="condition.endDate" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						  </td>
						  <td colspan="2">服务事项名称</td>
						  <td colspan="2"><input value="<s:property value="condition.certName"/>" type="text" name="condition.certName" /></td>
					  </tr>
					  <tr>
					    <td>资质等级</td>
					    <td>
                          <select name="condition.cretLevel">
                          <option value="">请选择</option>
									<s:iterator value="cretLevels">
										<option value="<s:property value="code"/>" <s:if test='condition.cretLevel==code'>selected</s:if>><s:property value="name"/></option>
									</s:iterator>
							  </select>
                        </td>
					    <td>资质序列</td>
					    <td>
                          <select name="condition.cretSequence" id="cretSequenceId" onchange="querySpecialtyType()">
									<option value="">请选择</option>
									<s:iterator value="cretSequences">
										<option value="<s:property value="code"/>" <s:if test='condition.cretSequence==code'>selected</s:if>><s:property value="name"/></option>
									</s:iterator>
							  </select>
                        </td>
					    <td>资质专业类别</td>
					    <td>
                          <select name="condition.specialtyType" id="specialtyTypeId">
									<option value="">请选择</option>
							  </select>
                        </td>
					    <td>资质级别</td>
					    <td>
                          <select name="condition.cretGrade" >
							      	<option value="">请选择</option>
									<s:iterator value="cretGrades">
										<option value="<s:property value="code"/>" <s:if test='condition.cretGrade==code'>selected</s:if>><s:property value="name"/></option>
									</s:iterator>
					          </select>
                        </td>
  </tr>
					  <tr>
					    <td>是否是最低等级</td>
					    <td colspan="3">
                          <select name="condition.lowestType">
                          	<option value="">请选择</option>
                          	<s:if test="condition.lowestType==1">
                          		<option value="1" selected>是</option>
                          		<option value="2">否</option>
                          	</s:if>
                          	
                          	<s:elseif test="condition.lowestType==2">
                          		<option value="1">是</option>
                          		<option value="2" selected>否</option>
                          	</s:elseif>
                          	
                          	<s:else>
                          		<option value="1">是</option>
                          		<option value="2">否</option>
                          	</s:else>
						  </select>
                        </td>
						  <td>是否可升级</td>
						  <td colspan="3">
                          <select name="condition.isUpgrade" class="required">
                          <option value="">请选择</option>
							<s:if test="condition.isUpgrade==1">
								<option value="1" selected>是</option>
								<option value="2">否</option>
							</s:if>
							<s:elseif test="condition.isUpgrade==2">
								<option value="1">是</option>
								<option value="2" selected>否</option>
							</s:elseif>
							<s:else>
                          		<option value="1">是</option>
                          		<option value="2">否</option>
                          	</s:else>
						</select>
                          </td>
				    </tr>
				  </table>
				</fieldset>
			</td>
		</tr>
	</table>
	<table width="100%" border="0" cellpadding="0" cellspacing="0" onmouseover="changeto()" onmouseout="changeback()">
		<tr>
			<th>序号</th>
			<th><input type="checkbox" name="all" onclick="javascript:check(form1,form1.all);" /></th>
			<th>服务事项名称</th>
			<th>资质类型</th>
			<th>资质等级</th>
			<th>资质序列</th>
			<th>资质专业类别</th>
			<th>资质级别</th>
			<th>初审部门</th>
			<th>是否最低等级</th>
			<th>是否可升级</th>
			<th>操作</th>
		</tr>
		<s:iterator status="i" value="currentPage.data" > 
		<tr>
			<td><s:property value="#i.count"/></td>
			<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>" onclick="javascript:setChecked(form1);"/></td>
			<td><s:property value="certName"/></td>
			<td><s:property value="cretTypeName"/></td>
			<td><s:property value="cretLevelName"/></td>
			<td><s:property value="cretSequenceName"/></td>
			<td><s:property value="specialtyTypeName"/></td>
			<td><s:property value="cretGradeName"/></td>
			<td>
				<s:property value="twoApprovalDeptName"/>
			</td>
			<td>
				<s:if test="lowestType==1">是</s:if>
				<s:if test="lowestType==2">否</s:if>
			</td>
			<td>
				<s:if test="isUpgrade==1">是</s:if>
				<s:if test="isUpgrade==2">否</s:if>
			</td>
			<td align='center'><a href="certifiedService_modifyCertifiedServicePage.action?certId=<s:property value="certId"/>"><span class="lbmingx">修改</span></a></td>

		</tr>
		</s:iterator>
	</table>
</form>
</div>
	<%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>