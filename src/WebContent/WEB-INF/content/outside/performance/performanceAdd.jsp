<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>企业工程业绩</title>
<script type="text/javascript">
	

	//保存
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
		document.form1.action="<%=basepath %>/performanceAction_goList.action";
		document.form1.submit();
	}

	
</script>
</head>
<body>
	<div class="ry_wrapp">
	<form id="form1" name="form1" method="post" action="<%=basepath %>/performanceAction_add.action">
		<div class="index_top">
			<img src="<%=basepath %>/img/zhindex_name.png" />
		</div>
		<input type="hidden" id="message" value="<s:property value="message" />" />

		<div class="ry_content">

			<div class="ry_lbxx">
				<div class="ry_lbcontent" cellpadding="0" cellspacing="0">
				  <h2>企业工程业绩添加</h2>
					<table class="" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<th>项目名称：</th>
								<td><input type="text" maxlength='200'  name="performance.proName" value="<s:property value="performance.proName"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
								<th>项目类型：</th>
								<td>
								<input type="text" maxlength='50'  name="performance.proType" value="<s:property value="performance.proType"/>" class="required"/><strong><font color="#FF0000">*</font></strong>
								</td>

							</tr>
							<tr>
								<th>开工时间：</th>
								<td>
								<input id="time1" type="text" name="performance.startsDate" value="<s:date name="performance.startsDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong>
								</td>
								<th>竣工时间：</th>
								<td><input id="time2" type="text" name="performance.completedDate" value="<s:date name="performance.completedDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
							</tr>
							<tr>
								<th>工程规模：</th>
								<td><input type="text" maxlength='50'  name="performance.proScale" value="<s:property value="performance.proScale"/>"  class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>工程造价：</th>
								<td><input type="text" maxlength='50'  name="performance.proCost" value="<s:property value="performance.proCost"/>" class="{required:true,number:true}"/>&nbsp;万<strong><font color="#FF0000">*</font></strong></td>
							</tr>
							<tr>
								<th>建设单位：</th>
								<td><input type="text" maxlength='50'  name="performance.construction" value="<s:property value="performance.construction"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>总承包单位：</th>
								<td><input type="text" maxlength='50'  name="performance.contractor"  value="<s:property value="performance.contractor"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>

							</tr>
							<tr>
								<th>设计单位：</th>
								<td><input type="text" maxlength='50'  name="performance.design" value="<s:property value="performance.design"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
								<th>监理：</th>
								<td><input type="text" maxlength='50'  name="performance.supervisor" value="<s:property value="performance.supervisor"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
							</tr>
						</tbody>
					</table>
					<div class="ry_lbreturn">
						<input type="image" src="<%=basepath %>/img/qy_02.png" />
						<input type="image" src="<%=basepath %>/img/fanhui_03.png" onclick="goBack()" />
				  </div>
				</div>
			</div>
		</div>
		</form>
		<%@include file="/WEB-INF/content/outside/footer.jsp"%>
	</div>
</body>
</html>