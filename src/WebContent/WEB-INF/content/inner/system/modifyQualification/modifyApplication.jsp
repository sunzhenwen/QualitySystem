<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业已获资质打回</title>
<script type="text/javascript">
  
	
	//审批通过
	function modify()
	{
		if(confirm("确认打回该资质")){
			document.form1.action="<%=basepath%>/modifyQualificationAction_modify.action";
			document.form1.submit();
		}
	}
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/modifyQualificationAction_goBack.action";
		document.form1.submit();
	}
	

	//查询市
	function queryCity() {
		$(document)
				.ready(
						function() {
							//获取省
							var provinceId = $("#provinceId").val();
							//执行城市ajax查询
							$
									.ajax({
										url : 'modifyQualificationAction_queryCity.action',
										type : 'post',
										dataType : 'json',
										data : 'provinceId=' + provinceId,
										success : function(data) {
											//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
											var items = eval("(" + data + ")");
											//清空城市列表避免重复
											$("#cityId").empty();
											$("#areaId").empty();
											$("#cityId")
													.append(
															"<option value=''>请选择</option>");
											$("#areaId")
													.append(
															"<option value=''>请选择</option>");
											//获取对象中标识用于判断选中
											var cityNum = '<s:property value="newQualification.cityNum"/>';
											//循环items,i为循环下标,(默认i从0开始取值)
											$
													.each(
															items,
															function(i) {
																//如果返回列表中有与对象中标识相等的执行
																if (items[i].code == cityNum) {
																	//拼接判断默认选中
																	$("#cityId")
																			.append(
																					"<option value='" + items[i].code+ "' selected >"
																							+ items[i].name
																							+ "</option>");
																	//自动执行ajax查询区
																	$
																			.ajax({
																				url : 'modifyQualificationAction_queryArea.action',
																				type : 'post',
																				dataType : 'json',
																				data : 'cityNum='
																						+ cityNum,
																				success : function(
																						data) {
																					//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
																					var itemss = eval("("
																							+ data
																							+ ")");
																					//循环items,i为循环下标,(默认i从0开始取值)
																					$(
																							"#areaId")
																							.empty();
																					var area = '<s:property value="newQualification.countyNum"/>';
																					$
																							.each(
																									itemss,
																									function(
																											i) {

																										if (itemss[i].code == area) {
																											$(
																													"#areaId")
																													.append(
																															"<option value='" + itemss[i].code+ "' selected >"
																																	+ itemss[i].name
																																	+ "</option>");
																										} else {
																											$(
																													"#areaId")
																													.append(
																															"<option value='" + itemss[i].code+ "' >"
																																	+ itemss[i].name
																																	+ "</option>");
																										}
																									});
																				}
																			});
																} else {
																	//如果没有清空区，让用户自己选择
																	$("#cityId")
																			.append(
																					"<option value='" + items[i].code+ "' >"
																							+ items[i].name
																							+ "</option>");
																	$("#areaId")
																			.empty();
																}

															});

										}
									});
						});
	}

	//查询区
	function queryArea() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var cityNum = $("#cityId").val();
					$.ajax({
						url : 'modifyQualificationAction_queryArea.action',
						type : 'post',
						dataType : 'json',
						data : 'cityNum=' + cityNum,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							//循环items,i为循环下标,(默认i从0开始取值)
							$("#areaId").empty();
							var area = '<s:property value="newQualification.countyNum"/>';
							$.each(items, function(i) {

								if (items[i].code == area) {
									$("#areaId").append(
											"<option value='" + items[i].code+ "' selected >"
													+ items[i].name
													+ "</option>");
								} else {
									$("#areaId").append(
											"<option value='" + items[i].code+ "' >"
													+ items[i].name
													+ "</option>");
								}
							});
						}
					});
				});
	}
	
	function changeWidth() {
		$('#qydjzclx').css("width","500px");
	}
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">企业已获资质打回</h2>
         <form id="form1" name="form1" method="post">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
               <tr>
						<td>企业名称：</td>
						<td><s:property value="newQualification.corpName" /> 
						<input type="hidden" name="newQualification.corpId" value="<s:property value="newQualification.corpId"/>" />
						<input type="hidden" name="newQualification.corpName" value="<s:property value="newQualification.corpName"/>" />
						<input type="hidden" name="newQualification.newQualId" value="<s:property value="newQualification.newQualId"/>" />
						<td>组织机构代码或统一社会信用代码：</td>
						<td><s:property value="newQualification.corpCode" />
							<input type="hidden" name="newQualification.corpCode" value="<s:property value="newQualification.corpCode"/>" />
						</td>
					</tr>

					<tr>
						<td>工商营业执照注册号：</td>
						<td><s:property value="newQualification.licenseNum" />
							<input type="hidden" name="newQualification.licenseNum" value="<s:property value="newQualification.licenseNum"/>" />
						</td>

						<td>企业营业地址：</td>
						<td><s:property value="newQualification.address" />
							<input type="hidden" name="newQualification.address" value="<s:property value="newQualification.address"/>" />
						</td>
					</tr>

					<tr>
						<td>注册所在省（自治区、直辖市）：</td>
						<td><select id="provinceId" name="newQualification.provinceNum"
							onchange="queryCity()" class="required">
								<s:iterator value="provinces">
									<option value="<s:property value="code"/>"
										<s:if test='newQualification.provinceNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select>
						<input type="hidden" name="newQualification.provinceName" value="<s:property value="newQualification.provinceName"/>" />
						</td>
						<td>注册所在地（市、州、盟）：</td>
						<td><select id="cityId" name="newQualification.cityNum"
							onchange="queryArea()" class="required">
								<s:iterator value="citys">
									<option value="<s:property value="code"/>"
										<s:if test='newQualification.cityNum==code'>selected</s:if>><s:property
											value="name" /></option>
								</s:iterator>
						</select>
						</td>

					</tr>
					<tr>
						<td>注册所在县（区、市、旗）：</td>
						<td><select id="areaId" name="newQualification.countyNum"
							class="required">
								<s:iterator value="areas">
									<option value="<s:property value="code"/>"
										<s:if test='newQualification.countyNum==code'>selected</s:if>><s:property
											value="name" />
									</option>
								</s:iterator>
						</select>
						</td>
						<td colspan="2">
						<font color="#FF0000">*审批报错主要因为企业的注册所在县(区、市、旗)填写错误，请核对正确信息后修改</font>
						<td>
					</tr>
					<tr>
						<td>注册资本（万元）：</td>
						<td>
							<input type="text" name="newQualification.regPrin" value="<s:property value="newQualification.regPrin"/>" />
						</td>
						<td>净资产(万元)：</td>
						<td>
							<input type="text" name="newQualification.assets" value="<s:property value="newQualification.assets"/>" />
						</td>
					</tr>
					<tr>
						<td>企业归属地：</td>
		               	<td>
		               	<s:if test="newQualification.spare1==230100">哈尔滨</s:if>
		               	<s:if test="newQualification.spare1==230200">齐齐哈尔</s:if>
		               	<s:if test="newQualification.spare1==231000">牡丹江</s:if> 
						<s:if test="newQualification.spare1==230600">大庆</s:if> 
						<s:if test="newQualification.spare1==230700">伊春</s:if>
						<s:if test="newQualification.spare1==230400">鹤岗</s:if> 
						<s:if test="newQualification.spare1==230800">佳木斯</s:if> 
						<s:if test="newQualification.spare1==231100">黑河</s:if> 
						<s:if test="newQualification.spare1==232700">大兴安岭地区</s:if>
						<s:if test="newQualification.spare1==400021">森工</s:if> 
						<s:if test="newQualification.spare1==400022">绥芬河</s:if> 
						<s:if test="newQualification.spare1==400023">抚远</s:if> 
						<s:if test="newQualification.spare1==230300">鸡西</s:if>
						<s:if test="newQualification.spare1==400020">农垦</s:if> 
						<s:if test="newQualification.spare1==230900">七台河</s:if>
						<s:if test="newQualification.spare1==230500">双鸭山</s:if> 
						<s:if test="newQualification.spare1==231200">绥化</s:if>
		               	<input type="hidden" name="newQualification.spare1" value="<s:property value="newQualification.spare1"/>" />
		               	</td>
					<td>资质名称：</td>
					<td>
						<s:property value="newQualification.certName" />
						<input type="hidden" name="newQualification.certName" value='<s:property value="newQualification.certName" />' />
					</td>
					</tr>
            </table>
            <div class="sp_bton"> 
            	<a href="#" onclick="modify()"><span class="sp_first">修改</span></a>
        	    <a href="#" onclick="goBack()"><span class="sp_last">返回</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>