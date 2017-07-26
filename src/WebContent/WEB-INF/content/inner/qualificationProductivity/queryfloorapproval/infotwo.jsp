<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>大厅资质受理不通过页面历史查询</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<script type="text/javascript">
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath%>/queryFloorApprovalAction_goBack.action";
		document.form1.submit();
	}
	
	function ExportWord()
	{
		document.form1.action="<%=basepath %>/wordAction_createWord.action?newQualId="+document.getElementById("newQualId").value;
		document.form1.submit();
	}
	
</script>
</head>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
}

input {
	border-bottom: 1px solid #000;
	border-top: 1px solid #fff;
	border-right: 1px solid #fff;
	border-left: 1px solid #fff;
}

P {
	text-align: center;
	font-size: 24px;
	font-weight: bold;
}

div {
	line-height: 36px;
	text-align: left;
	width: 80%;
	margin: auto;
}
</style>
<body>
	<div class="qy_wrapp">

		<div class="sp_main">

			<h2 class="f16 fb" style="background: #80aced;">大厅资质受理失败历史界面</h2>
			<form style="margin: 50px;" id="form1" name="form1" method="post"
				action="">
				<input type="hidden"  id="newQualId" value="<s:property value="floor.newQualId"/>" />
				<table class="sp_mtable" style="border-collapse: collapse;"
					cellpadding="0" cellspacing="0">

					<p>不予受理行政许可申请通知书</p>
					<div style="text-align: right;">
						<input type="text" size="20" value="<s:property value="floor.mes1"/>"id="mes1"/>许不字〔<input  type="text"
							size="10" value="<s:property value="floor.mes2"/>"id="mes2"/>〕第<input  id="mes3" type="text" size="10" value="<s:property value="floor.mes3"/>"/>号
					</div>
					<div>
						<input type="text" size="25" value="<s:property value="floor.mes4"/>" id="mes4"/>：
					</div>
					<div style="text-indent: 2em;">
						于<input type="text" size="10" value="<s:property value="floor.mes5"/>" id="mes5"/>年<input  type="text"
							size="10" value="<s:property value="floor.mes6"/>" id="mes6"/>月<input  type="text" size="10" value="<s:property value="floor.mes7"/>" id="mes7"/>日
							提出的<input type="text" size="22" value="<s:property value="floor.mes8"/>" id="mes8"/>行政许可申请收愁。经审查，不符合法定受理条件，本机关决定不予受理。
					</div>
					<div style="text-indent: 2em;">
						如不服本决定，可以自收到本决定书之日起六十日内向<input type="text"
							size="25" value="<s:property value="floor.mes9"/>" id="mes9"/>申请行政复议，或者三个月内向 <input type="text"
							size="25" value="<s:property value="floor.mes10"/>" id="mes10"/>人民法院提起行政诉讼。
					</div>
					<div style="text-align: right; width: 80%; margin-top: 100px;">（行政机关许可专用印章）</div>
					<div style="text-align: right; width: 80%;">
						<input type="text" size="10" value="<s:property value="floor.mes11"/>" id="mes11"/>年<input  type="text"
							size="10" value="<s:property value="floor.mes12"/>" id="mes12"/>月<input  type="text" size="10" value="<s:property value="floor.mes13"/>" id="mes13"/>日
					</div>
					<div></div>
					<div></div>

					<tr>
					<tr style="height: 60px; border: 0">
						<td>业务受理意见：</td>
						<td colspan="3"><textarea id="appId"
								><s:property
									value="floor.approvalOpinion" /></textarea><input type="hidden"
							
							value="<s:property value="newQualification.corpName"/>" /> <input
							type="hidden" 
							value="<s:property value="newQualification.newQualId"/>" /> <input
							type="hidden" 
							value="<s:property value="newQualification.corpCode"/>" /></td>
					</tr>

					

					<tr>
						<td>受理人：<s:property value="floor.approvalPerson" />
						</td>
						<td>受理时间：<s:date name="floor.approvalDate"
								format="yyyy-MM-dd" />
						</td>
					</tr>



				</table>
				<div class="sp_bton">
					<a href="#"><span class="sp_last" onclick="prn_preview()">打印</span></a>
					<a href="#"><span class="sp_last" onclick="ExportWord()">导出</span></a>
					<!-- <a href="#"><span class="sp_last" onclick="goBack()">返回</span></a> -->
					<a href="#"><span class="sp_last" onclick="history.back()">返回</span></a>
				</div>
			</form>
		</div>
	</div>

	<script language="javascript" type="text/javascript">
		var LODOP; //声明为全局变量 

		function prn_preview() {
			CreatePrintPageB();
			LODOP.SET_PRINT_PAGESIZE(0, "210mm", "297mm", "");
			LODOP.SET_PREVIEW_WINDOW(1, 0, 1, 0, 0, "");//打印前弹出选择打印机的对话框	
			LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口
			LODOP.PREVIEW();
		};

		function CreatePrintPageB() {
			LODOP = getLodop();
			LODOP.PRINT_INIT("行政审批B");
			LODOP.ADD_PRINT_TEXT(187, 155, 469, 40, "不予受理行政许可申请通知书");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 22);
			LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
			LODOP.ADD_PRINT_TEXT(233, 346, 406, 34, document
					.getElementById("mes1").value
					+ "许不字〔"
					+ document.getElementById("mes2").value
					+ "〕第"
					+ document.getElementById("mes3").value + "号");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(368, 85, 306, 30, document
					.getElementById("mes4").value
					+ "：");
			//LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			//LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(
							397,
							85,
							619,
							240,
						document.getElementById("mes4").value+"：\n"+"    于"
									+ document.getElementById("mes5").value
									+ "年"
									+ document.getElementById("mes6").value
									+ "月"
									+ document.getElementById("mes7").value
									+ "日提出的"
									+ document.getElementById("mes8").value
									+ "行政许可申请收悉。经审查，不符合法定受理条件，本机关决定不予受理。\n    如不服本决定，可以自收到本决定书之日起六十日内向"
									+ document.getElementById("mes9").value
									+ "申请行政复议，或者三个月内向"
									+ document.getElementById("mes10").value
									+ "人民法院提起行政诉讼。");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(688, 410, 282, 40, "（行政机关许可专用印章）");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.ADD_PRINT_TEXT(728, 440, 265, 40, document
					.getElementById("mes11").value
					+ "年"
					+ document.getElementById("mes12").value
					+ "月"
					+ document.getElementById("mes13").value + "日");
			LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
			LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
			LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
		};
	</script>

</body>
</html>