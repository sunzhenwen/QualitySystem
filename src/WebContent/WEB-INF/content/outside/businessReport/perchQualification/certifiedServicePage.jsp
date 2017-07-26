<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<script type="text/javascript">

	//提交资质服务事项
	function submitCertifiedService()
	{
		if(check()==true){
			if(confirm("您确定要提交选中的记录吗？")==true){
				var message = document.getElementById("typeNum").value;
				document.form1.action="<%=basepath %>/perchQualificationAction_submitCertifiedService.action?typeNum="+message;
				document.form1.submit();
			}
		}else
		{
			alert("请选择所要申请的资质！");
		}
	}
	
	//返回业务办理页面
	function goBack()
	{
		document.form1.action="<%=basepath %>/perchQualificationAction_perchApplication.action";
		document.form1.submit();
	}
	
    //表单验证
    function check(){               
        var ids = document.getElementsByName("certIds");               
        var flag = false ;               
        for(var i=0;i<ids.length;i++){
            if(ids[i].checked){
                flag = true;
                break ;
            }else
            {
            	flag = false;
            }
        }
        return flag;
    }
</script>
<body>
<div class="qy_wrapp">
		<div class="index_top">
			<img src="<%=basepath%>/img/zhindex_name.png" />
			<input name="typeNum" type="hidden" value="<s:property value="typeNum"/>" id="typeNum"/>
		</div>

		<div class="yw_main">

			<h2 class="f16 fb"><s:property value="levelName"/></h2>
			<table cellpadding="0" style="text-algin:center" class="yw_gwy">
				<tr>
					<td>企业名称：</td>
					<td>
					<s:property value="corpName"/>
					</td>
				</tr>
			</table>
			<form id="form1" name="form1" method="post" action="">
			<input name="addTypeNum" type="hidden" value="<s:property value="addTypeNum"/>" />
				<table class="yw_mtable left" style="margin:0 140px" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds" > 
					<s:if test="#i.odd">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				<table class="yw_mtable left" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds" > 
					<s:if test="#i.even">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				<div class="botn">
					<input type="image" src="<%=basepath%>/img/qy_02.png" onclick="submitCertifiedService()"/> 
					<input type="image" src="<%=basepath%>/img/fanhui_03.png" onclick="goBack()" />
				</div>
			</form>

		</div>
	</div>
</body>
</html>