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
				document.form1.action="<%=basepath %>/separateQualificationAction_submitCertified.action";
				//alert(message)
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
		document.form1.action="<%=basepath %>/updateQualificationAction_updateApplication.action";
		document.form1.submit();
	}
	
    //表单验证
    function check(){               
        var ids = document.getElementsByName("relationIds");               
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

		</div>

		<div class="yw_main">

			<h2 class="f16 fb"><s:property value="levelName"/></h2>
			<table cellpadding="0" style="text-algin:center" class="yw_gwy">
				<tr>
					<td>被分立/转移企业名称：</td>
					<td>
					<s:property value="corpName"/>
					</td>
				</tr>
			</table>
			<form id="form1" name="form1" method="post" action="">
				<br>
				<table class="yw_mtable center" style="padding-left:10px" cellpadding="0" cellspacing="0">
					<td>企业拥有资质</td>
					<s:iterator status="i" value="separateQualification" > 
					<s:if test="certName != null">
					<s:if test="#i.odd">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="relationIds" value="<s:property value="relationId"/>"></td>
					</tr>
					</s:if>
					</s:if>
					</s:iterator>
				
					
					<s:iterator status="i" value="separateQualification" > 
					<s:if test="certName != null">
					<s:if test="#i.even">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="relationIds" value="<s:property value="relationId"/>"></td>
					</tr>
					</s:if>
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