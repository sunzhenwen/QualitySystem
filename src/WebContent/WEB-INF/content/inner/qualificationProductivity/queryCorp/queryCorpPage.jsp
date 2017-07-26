<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资质分类查询</title>
<script type="text/javascript">

	//资质信息选择弹出页面 
	function getCretInfo()
	{
		var provinceNum = $("#provinceId").val();
		var cityNum = $("#cityId").val();
		window.open('<%=basepath %>/queryCretAction_getCretInfo.action?provinceNum='+provinceNum+'&cityNum='+cityNum,'_self');
		
	}
	
	//获取公司详细信息
	function getCorpInfo(corpId)
	{
		window.open('<%=basepath %>/corpInfoAction_detailCorpPage.action?corpId='+corpId) 
	}
	
	//获取资质详细信息
	function getCorpCretInfo(corpId)
	{
		window.open('<%=basepath %>/queryQualificationAction_detailCretPage.action?corpId='+corpId) 
	}
	
	//查询市
	function queryCity() {
		$(document).ready(
				function() {
					//获取部门下拉列表的值
					var provinceId = $("#provinceId").val();
					$.ajax({
						url : 'queryCorpAction_queryCity.action',
						type : 'post',
						dataType : 'json',
						data : 'provinceId=' + provinceId,
						success : function(data) {
							//将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
							var items = eval("(" + data + ")");
							$("#cityId").empty();
							$("#cityId").append("<option value=''>请选择</option>");
							//循环items,i为循环下标,(默认i从0开始取值)
							$.each(items, function(i) {
								$("#cityId").append(
										"<option value='" + items[i].code+ "'>"
												+ items[i].name + "</option>");
							});
						},
						error : function(data){
							alert("error:"+data);
						}
					});
				});
	}
	
	function getCertInfo2() {
		document.form1.action="<%=basepath %>/queryCorpAction_submitCertifiedService.action";
		document.form1.submit();
	}

</script>
</head>
<body>
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
<table width="100%" border="0" cellpadding="0" height="15%">
		<tr>
			<td>
			  <fieldset>
					<legend class="chaxuntj">资质分类查询：</legend>
			</fieldset>
			</td>
		</tr>
		<tr>
			<td>
			<legend>
			注册所在省(自治区、直辖市):
						<select id="provinceId" name="condition.provinceNum"
							onchange="queryCity()" class="required">
								<option value="">请选择</option>
								<s:iterator value="provinces">
								<s:if test="230000==code">
									<option value="<s:property value="code"/>" selected><s:property
											value="name" /></option>
								</s:if>
								<s:else>
									<option value="<s:property value="code"/>"><s:property
											value="name" /></option>
								</s:else>
								</s:iterator>
						</select>
			&nbsp;&nbsp;&nbsp;&nbsp;
			注册所在地(市、州、盟):
			<select id="cityId" name="condition.cityNum" class="required">
				<option value="">请选择</option>
				<s:iterator value="citys">
					<s:if test="condition.cityNum==code">
					<option value="<s:property value="code"/>" selected><s:property value="name" /></option>
					</s:if>
					<s:else>
					<option value="<s:property value="code"/>" ><s:property value="name" /></option>	
					</s:else>
				</s:iterator>
			</select>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="#" onclick="getCertInfo2()" class="lbmingx">查询</a>
			
			</td>
		</tr>
		<tr>
			<td>
				<legend class="chaxuntj">资质信息选择:
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="#" onclick="getCretInfo()"><span class="lbmingx">资质选择</span></a></legend>
			</td>
		</tr>
		<tr>
			<td>
				<s:if test="condition.certIds != null">
				<legend class="chaxuntj">资质信息：</legend>
					<s:iterator status="i" value="certName"> 
						<s:property value="name" />, &nbsp;&nbsp;
					</s:iterator>
				</s:if>
			</td>
		</tr>
		<tr>
			<td>企业数量：<s:property value="currentPage.totalCount"/> </td>
		</tr>
	</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
		<tr>
			<th>序号</th>
       		<th>企业名称</th>
            <th>组织机构代码</th>
            <th>工商营业执照注册号</th>
            <th>办公电话</th>
            <th>详细</th>
        </tr>
        <s:iterator status="i" value="currentPage.data" > 
                          <tr>
                          	<td><s:property value="#i.count"/> </td>
                            <td><s:property value="corpName"/></td>
                            <td><s:property value="corpCode"/></td>
                            <td><s:property value="licenseNum"/></td>
                            <td><s:property value="officePhone"/></td>
                            <td align='center'>
                            <a href="#" onclick="getCorpInfo('<s:property value="corpId"/>')"><span class="lbmingx">公司详细</span></a>
                           		&nbsp;&nbsp;
                            <a href="#" onclick="getCorpCretInfo('<s:property value="corpId"/>')"><span class="lbmingx">资质详细</span></a>
                            </td>
                         </tr>
		</s:iterator>
       </table>
  </form>
               			
               			
     </div>     
        <%@include file="/WEB-INF/content/inc/page.jsp"%>
</body>
</html>
