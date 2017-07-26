<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业归属地变更</title>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/corpChangeAreaAction_goBack().action";
		document.form1.submit();
	}

	//查询是否需要跨省变更
	function checkStatusInfo() {
		var node = $("#checkStatus").val();
		if (node == "2") {

			$('#provinceName').show();
			$('#cityName').show();
			$('#HarbinName').hide();
		}
		else if (node == "1")
		{
			$('#provinceName').hide();
			$('#cityName').hide();
			$('#HarbinName').show();
		}
		else
		{
			$('#provinceName').hide();
			$('#cityName').hide();
			$('#HarbinName').hide();
		}
	}

	//查询市
	function queryCity() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var provinceId = $("#provinceId").val();
					$.ajax({
						url : 'corpAction_queryCity.action',
						type : 'post',
						dataType : 'json',
						data : 'provinceId=' + provinceId,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#cityId").empty();
							$("#areaId").empty();
							$("#cityId")
									.append("<option value=''>请选择</option>");
							$("#areaId")
									.append("<option value=''>请选择</option>");
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#cityId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						}
					});
				});
	}
</script>
</head>
<body onload="checkStatusInfo();">
	<form id="form1" name="form1" method="post"
		action="<%=basepath%>/corpChangeAreaAction_approvalSubmit.action"
		onsubmit="return validateForm()">
		<div class="qy_wrapp">
			<div class="index_top">
				<img src="<%=basepath%>/img/zhindex_name.png" />

			</div>

			<div class="qyxg_main">

				<h2 class="f16 fb">企业归属地变更</h2>

				<table class="qyxg_mtable qyxgtop " cellpadding="0" cellspacing="0">


					<tr>
						<td>企业名称：</td>
						<td><s:property value="corp.corpName" /> <input
							type="hidden" value="<s:property value="corp.corpName" />"
							name="change.corpName" /></td>
					</tr>
					<tr>
						<td>企业原归属地：</td>
						<td><input type="hidden" value="<s:property value="corp.spare1" />"
							name="change.beforeArea" />
									<s:if test='corp.spare1==230100'>哈尔滨</s:if>
									<s:if test='corp.spare1==230200'>齐齐哈尔</s:if>
									<s:if test='corp.spare1==231000'>牡丹江</s:if>
									<s:if test='corp.spare1==230600'>大庆</s:if>
									<s:if test='corp.spare1==230700'>伊春</s:if>
									<s:if test='corp.spare1==230400'>鹤岗</s:if>
									<s:if test='corp.spare1==230800'>佳木斯</s:if>
									<s:if test='corp.spare1==231100'>黑河</s:if>
									<s:if test='corp.spare1==232700'>大兴安岭地区</s:if>
									<s:if test='corp.spare1==400021'>森工</s:if>
									<s:if test='corp.spare1==400022'>绥芬河</s:if>
									<s:if test='corp.spare1==400023'>抚远</s:if>
									<s:if test='corp.spare1==230300'>鸡西</s:if>
									<s:if test='corp.spare1==400020'>农垦</s:if>
									<s:if test='corp.spare1==230900'>七台河</s:if>
									<s:if test='corp.spare1==230500'>双鸭山</s:if>
									<s:if test='corp.spare1==231200'>绥化</s:if>
							</td>
					</tr>
					<tr>
						<td>是否需要跨省变更归属地：</td>
						<td><select id="checkStatus" name="change.status"
							onchange="checkStatusInfo()" class="required">
								<option value="">请选择</option>
								<option value="2" <s:if test='change.status'>selected</s:if>>是</option>
								<option value="1" <s:if test='change.status'>selected</s:if>>否</option>
						</select>  
					</tr>

					<tr id="provinceName">
						<td>新归属地所在省：</td>
						<td><select id="provinceId" name="change.afterProvinceArea"
							onchange="queryCity()" class="required">
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='corp.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select>
						</td>
					</tr>

					<tr id="cityName">
						<td>新归属地所在市：</td>
						<td><select id="cityId" name="change.afterProvinceCityArea"  class="required" >
                     <s:iterator value="citys">
						<option value="<s:property value="code"/>" <s:if test='corp.cityNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select>
                        </td>
					</tr>

					<tr id="HarbinName">
						<td>新归属地所属：</td>
						<td><select id="" name="change.afterCityArea">
								<option value="230100"
									<s:if test='login.spare1==230100'>selected</s:if>>哈尔滨</option>
								<option value="230200"
									<s:if test='login.spare1==230200'>selected</s:if>>齐齐哈尔</option>
								<option value="231000"
									<s:if test='login.spare1==231000'>selected</s:if>>牡丹江</option>
								<option value="230600"
									<s:if test='login.spare1==230600'>selected</s:if>>大庆</option>
								<option value="230700"
									<s:if test='login.spare1==230700'>selected</s:if>>伊春</option>
								<option value="230400"
									<s:if test='login.spare1==230400'>selected</s:if>>鹤岗</option>
								<option value="230800"
									<s:if test='login.spare1==230800'>selected</s:if>>佳木斯</option>
								<option value="231100"
									<s:if test='login.spare1==231100'>selected</s:if>>黑河</option>
								<option value="232700"
									<s:if test='login.spare1==232700'>selected</s:if>>大兴安岭地区</option>
								<option value="400021"
									<s:if test='login.spare1==400021'>selected</s:if>>森工</option>
								<option value="400022"
									<s:if test='login.spare1==400022'>selected</s:if>>绥芬河</option>
								<option value="400023"
									<s:if test='login.spare1==400023'>selected</s:if>>抚远</option>
								<option value="230300"
									<s:if test='login.spare1==230300'>selected</s:if>>鸡西</option>
								<option value="400020"
									<s:if test='login.spare1==400020'>selected</s:if>>农垦</option>
								<option value="230900"
									<s:if test='login.spare1==230900'>selected</s:if>>七台河</option>
								<option value="230500"
									<s:if test='login.spare1==230500'>selected</s:if>>双鸭山</option>
								<option value="231200"
									<s:if test='login.spare1==231200'>selected</s:if>>绥化</option>
						</select></td>
					</tr>
				</table>
				<hr />
				<div class="botn">
					<input type="image" src="<%=basepath%>/img/qy_02.png"
						onclick="document.form.submit()" /> <input type="image"
						src="<%=basepath%>/img/qy_01.png" onclick="goBack()" />
				</div>

			</div>
			<%@include file="/WEB-INF/content/outside/footer.jsp"%>
		</div>
	</form>
</body>
</html>