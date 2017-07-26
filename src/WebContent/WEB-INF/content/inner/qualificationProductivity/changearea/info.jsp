<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>归属地变更审批</title>
<script type="text/javascript">
	
	//审批通过
	function applythrough()
	{
		var nm = document.getElementById("appId");
		if(nm.value != "")
		{
			document.form1.action="<%=basepath %>/changeAreaAction_approvalSuccess.action";
			document.form1.submit();
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
			document.form1.action="<%=basepath %>/changeAreaAction_approvalFailed.action";
			document.form1.submit();
		}else
		{
			alert("请输入审批意见!");	
		}
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/changeAreaAction_goBack.action";
		document.form1.submit();
	}
	
</script>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">归属地变更审批</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
               
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="change.corpName"/>
                	<input type="hidden" name="change.changeId" value="<s:property value="change.changeId"/>" />
                	<input type="hidden" name="change.mark" value="<s:property value="change.mark"/>" />
                	</td>
                    <td>原归属地：</td>
               		<td><s:if test='change.beforeArea==230100'>哈尔滨</s:if> <s:if
								test='change.beforeArea==230200'>齐齐哈尔</s:if> <s:if
								test='change.beforeArea==231000'>牡丹江</s:if> <s:if
								test='change.beforeArea==230600'>大庆</s:if> <s:if
								test='change.beforeArea==230700'>伊春</s:if> <s:if
								test='change.beforeArea==230400'>鹤岗</s:if> <s:if
								test='change.beforeArea==230800'>佳木斯</s:if> <s:if
								test='change.beforeArea==231100'>黑河</s:if> <s:if
								test='change.beforeArea==232700'>大兴安岭地区</s:if> <s:if
								test='change.beforeArea==400021'>森工</s:if> <s:if
								test='change.beforeArea==400022'>绥芬河</s:if> <s:if
								test='change.beforeArea==400023'>抚远</s:if> <s:if
								test='change.beforeArea==230300'>鸡西</s:if> <s:if
								test='change.beforeArea==400020'>农垦</s:if> <s:if
								test='change.beforeArea==230900'>七台河</s:if> <s:if
								test='change.beforeArea==230500'>双鸭山</s:if> <s:if
								test='change.beforeArea==231200'>绥化</s:if></td>
                </tr>
               
                <tr>
                    <td>企业欲变更归属地：</td>
               		<td><s:if test='change.status==2'>跨省变更</s:if> <s:if test='change.status==1'>
								<s:if test='change.afterCityArea==230100'>哈尔滨</s:if>
								<s:if test='change.afterCityArea==230200'>齐齐哈尔</s:if>
								<s:if test='change.afterCityArea==231000'>牡丹江</s:if>
								<s:if test='change.afterCityArea==230600'>大庆</s:if>
								<s:if test='change.afterCityArea==230700'>伊春</s:if>
								<s:if test='change.afterCityArea==230400'>鹤岗</s:if>
								<s:if test='change.afterCityArea==230800'>佳木斯</s:if>
								<s:if test='change.afterCityArea==231100'>黑河</s:if>
								<s:if test='change.afterCityArea==232700'>大兴安岭地区</s:if>
								<s:if test='change.afterCityArea==400021'>森工</s:if>
								<s:if test='change.afterCityArea==400022'>绥芬河</s:if>
								<s:if test='change.afterCityArea==400023'>抚远</s:if>
								<s:if test='change.afterCityArea==230300'>鸡西</s:if>
								<s:if test='change.afterCityArea==400020'>农垦</s:if>
								<s:if test='change.afterCityArea==230900'>七台河</s:if>
								<s:if test='change.afterCityArea==230500'>双鸭山</s:if>
								<s:if test='change.afterCityArea==231200'>绥化</s:if>
							</s:if></td>
					<s:if test='change.status==2'>
                   	 	<td>企业欲变更归属地所在省市：</td>
                    	<td>
                   	 		<s:property value="provinceName"/><s:property value="cityName"/>
                    	</td>
                    </s:if>
                </tr>
                <s:if test='change.beforeOp!=null'>
                	<tr>
                		<td>企业原所在地审批意见：</td>
                		<td><s:property value="change.beforeOp"/></td>
                	</tr>
                </s:if>
                <s:if test='change.afterOp!=null'>
                	<tr>
                		<td>企业欲变更所在地审批意见：</td>
                		<td><s:property value="change.afterOp"/></td>
                	</tr>
                </s:if>
                <tr style="height:60px; border:0">
                    <td>审批建议：</td>
                    <s:if test='change.process==1'>
                    	<s:if test='change.status==1'>
               				<td colspan="3"> <textarea id="appId" name="change.beforeOp"></textarea> </td>
               			</s:if>
               			<s:if test='change.status==2'>
               				<td colspan="3"> <textarea id="appId" name="change.lastOp"></textarea> </td>
               			</s:if>
               		</s:if>
               		<s:if test='change.process==2'>
               		<td colspan="3"> <textarea id="appId" name="change.afterOp"></textarea> </td>
               		</s:if>
               		<s:if test='change.process==4'>
               		<td colspan="3"> <textarea id="appId" name="change.lastOp"></textarea> </td>
               		</s:if>
                </tr>
            </table>
            <div class="sp_bton"> 
        		<a href="#"><span class="sp_first" onclick="applythrough()">审批通过</span></a>
        	    <a href="#"><span class="sp_second" onclick="applyBack()">申请退回</span></a>
        	    <a href="#"><span class="sp_last" onclick="goBack()">取消</span></a>
            </div>
        </form>
    	</div>
  </div>
</body>
</html>