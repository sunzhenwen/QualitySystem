<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<script language="javascript">
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
                    $.each(items,function(i){
                    	var specialtyType='<s:property value="certifiedService.specialtyType"/>';
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
    
    //修改
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/certifiedService_goBack.action";
		document.form1.submit();
	}
	//二级审批
	function getSelectText()
	{
		var selectIndex = document.getElementById("selectText").selectedIndex;//获得是第几个被选中了
		var selectText = document.getElementById("selectText").options[selectIndex].text; 
		document.getElementById("twoApp").value = selectText;
	}
	
	function getAppSelectText()
	{
		var appSelectIndex = document.getElementById("appSelectText").selectedIndex;//获得是第几个被选中了
		var appSelectText = document.getElementById("appSelectText").options[appSelectIndex].text;
		document.getElementById("appSelect").value = appSelectText;
	}
    </script>
</head>
<body onload="querySpecialtyType(),getSelectText(),getAppSelectText()">

	<div class="qy_wrapp">

		<div class="qy_main" style="width: 100%; background: #FFF; border: 0;">

			<h2 class="f16 fb" style="background: #80aced;">资质服务事项修改</h2>
			<form id="form1" name="form1" method="post" action="<%=basepath%>/certifiedService_modifyCertifiedService.action" style="margin: 50px;">
				<table class="qy_mtable p_left60" cellpadding="0" cellspacing="0">

					<tr>
						<td>服务事项名称：</td>
						<td><input type="text" name="certifiedService.certName" value="<s:property value="certifiedService.certName" />" class="required" />
						<input type="hidden" name="certifiedService.certId" value="<s:property value="certifiedService.certId" />" />
						<input type="hidden" name="certifiedService.oldCertName" value="<s:property value="certifiedService.certName" />" /></td>
						<td>是否是最低等级：</td>
						<td>
                        	<select name="certifiedService.lowestType" class="required">
							<s:if test="certifiedService.lowestType==1">
								<option value="1" selected>是</option>
								<option value="2">否</option>
							</s:if>
							<s:if test="certifiedService.lowestType==2">
								<option value="1">是</option>
								<option value="2" selected>否</option>
							</s:if>
						</select>
                        </td>
					</tr>
					<tr>
						<td>资质序列：</td>
						<td>
                        <select name="certifiedService.cretSequence" id="cretSequenceId" onchange="querySpecialtyType()">
							
						  <s:iterator value="cretSequences">
								<option value="<s:property value="code"/>" <s:if test='certifiedService.cretSequence==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
						</td>
						<td>资质专业类别：</td>
						<td>
                        	<select name="certifiedService.specialtyType" id="specialtyTypeId">
							<option value="">请选择</option>
						</select>
                        </td>
					</tr>
					<tr>
						<td>资质等级：</td>
						<td>
						<select name="certifiedService.cretLevel">
							<s:iterator value="cretLevels">
								<option value="<s:property value="code"/>" <s:if test='certifiedService.cretLevel==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
						</td>
						<td>资质级别：</td>
						<td>
                        <select name="certifiedService.cretGrade">
							<s:iterator value="cretGrades">
								<option value="<s:property value="code"/>" <s:if test='certifiedService.cretGrade==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
                        </td>
					</tr>

					<tr>
						<td>资质类型：</td>
						<td>
						<select name="certifiedService.cretType">
							<s:iterator value="cretTypes">
								<option value="<s:property value="code"/>" <s:if test='certifiedService.specialtyType==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
						</td>
						<td>审批部门：</td>
						<td>
                        <select id="appSelectText" onchange="getAppSelectText()" name="certifiedService.approvalDept" class="required">
							<s:iterator value="depts">
								<option value="<s:property value="code"/>" <s:if test='certifiedService.approvalDept==code'>selected</s:if>><s:property value="name"/></option>
							</s:iterator>
						</select>
						<input type="hidden" id="appSelect" name="certifiedService.approvalDeptName" value="<s:property value="certifiedService.approvalDeptName"/>" />
                        </td>
					</tr>
                    
                    <tr>
						<td>二级审批初审部门：</td>
						<td>
						<select id="selectText" name="certifiedService.twoApprovalDept" onchange="getSelectText()" class="required">
							<s:if test="certifiedService.twoApprovalDept==0">
								<s:iterator value="twoDepts">
									<option value="<s:property value="code"/>"><s:property value="name"/></option>
								</s:iterator>
								<option value="0" selected>无</option>
							</s:if>
							<s:if test="certifiedService.twoApprovalDept!=0">
								<s:iterator value="twoDepts">
									<option value="<s:property value="code"/>" <s:if test='certifiedService.twoApprovalDept==code'>selected</s:if>><s:property value="name"/></option>
								</s:iterator>
								<option value="0">无</option>
							</s:if>
						</select>
						<input type="hidden" id="twoApp" name="certifiedService.twoApprovalDeptName" value="<s:property value="certifiedService.twoApprovalDeptName"/>" />
						</td>
						<td>是否可升级：</td>
						<td>
                        <select name="certifiedService.isUpgrade" class="required">
							<s:if test="certifiedService.isUpgrade==1">
								<option value="1" selected>是</option>
								<option value="2">否</option>
							</s:if>
							<s:elseif test="certifiedService.isUpgrade==2">
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
					<tr>
					<td>是否是当前最高等级：</td>
						<td>
                        <select name="certifiedService.isMax" class="required">
							<s:if test="certifiedService.isMax==1">
								<option value="1" selected>是</option>
								<option value="2">否</option>
							</s:if>
							<s:elseif test="certifiedService.isMax==2">
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
				<table class="qy_mtable1" cellpadding="0" cellspacing="0" style="margin: 3px 64px;">
					<tr>
						<td>审批流程：</td>
						<td colspan="3"><textarea name="certifiedService.approvalProcess" id="textarea2" style="height:80px;width:530px"><s:property value="certifiedService.approvalProcess"/></textarea></td>
					</tr>
                    <tr>
                      <td>申办条件：</td>
                      <td colspan="3">
                      <textarea name="certifiedService.approvalCondition" id="textarea" style="height:80px;width:530px" ><s:property value="certifiedService.approvalCondition"/></textarea>
                      </td>
                    </tr>
					
				</table>
				<div class="nw_bton">
					<input type="image" src="<%=basepath%>/img/qy_02.png" /> 
					<input type="image" src="<%=basepath%>/img/fanhui_03.png" onclick="goBack()" />
			  </div>


		  </form>
		</div>
	</div>

</body>
</html>