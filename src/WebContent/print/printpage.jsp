<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>打印文档</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
</head>
<body>

	<div class="libiao">
		<form id="form1" name="form1" method="post" action="">
			<table width="100%" border="0" cellpadding="0" height="15%">
				<tr>
					<td>
						<fieldset>
							<legend class="chaxuntj">打印页面</legend>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview1()"><font
										size="6">法人授权委托书打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_previewA()"><font
										size="6">行政许可申请书打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview2()"><font
										size="6">权力运行轨迹档案打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview3()"><font
										size="6">申 报 清 单(新)打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview4()"><font
										size="6">申 报 清 单(换证)打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview5()"><font
										size="6">申报清单(升级)打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview6()"><font
										size="6">申报清单(增项)打印</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview7()"><font
										size="6">受理行政许可申请通知书</font></span></a>
							</p>
							<p style="margin-bottom: 10px; text-align: middle;">
								<a href="#"><span onclick="prn_preview8()"><font
										size="6">不予受理行政许可申请通知书</font></span></a>
							</p>
						</fieldset>
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="table06" style="display: none">

		<p align="center">申请增项行政许可材料清单</p>
		<table border="1" width="100%" height="50%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="5%"><p align="center">序号</p></td>
				<td width="55%"><p align="center">申报材料</p></td>
				<td width="20%"><p align="center">数量</p></td>
				<td width="20%"><p align="center">备注</p></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">1</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;《建筑业企业资质申请表》一式二份
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">2</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;《营业执照》副本复印件</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">3</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp; 建筑业企业资质证书正本复印件</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">4</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;申报资质上一年度或当期的财务审计报告复印件</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">5</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;标准要求的主要设备购置发票</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">6</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;安全生产许可证复印件</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">7</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;中级及以上职称人员的身份证明、职称证（学历证明）复印件
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">8</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;现场管理人员的身份证明、岗位证书复印件
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">9</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;技术负责人身份证明、执业资格证书、职称证书或技能证书
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">10</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;技术工人的身份证明、职业培训合格证书或职业技能证书复印件
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">11</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;企业主要人员申报前3个月的社会保险证明
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">12</p></td>
				<td width="55%"><p align="left">&nbsp;&nbsp;技术负责人（或注册建造师）基本情况及业绩表
					</p></td>
				<td width="20%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td height="150">
					<p>&nbsp;</p>
					<p align="center">
						申<br />请<br />单<br />位
					</p>
					<p>&nbsp;</p>
				</td>
				<td colspan="3" valign="bottom">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;企业确认:____________________年_____月_____日&nbsp;&nbsp;&nbsp;&nbsp;(印章)
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p align="center">
						受<br />理<br />机<br />关
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>
				<td colspan="3" valign="bottom" height="150">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;承办人:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
				</td>
			</tr>
			<tr>
				<td colspan="3" valign="bottom" height="150">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;主管主任:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
				</td>
			</tr>

		</table>



	</div>

	<div id="table05" style="display: none">

		<p align="center">申请升级行政许可材料清单</p>
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="5%"><p align="center">序号</p></td>
				<td width="65%"><p align="center">申报材料</p></td>
				<td width="10%"><p align="center">数量</p></td>
				<td width="20%"><p align="center">备注</p></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">1</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;《建筑业企业资质申请表》一式二份
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">2</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;《营业执照》副本复印件</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">3</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp; 建筑业企业资质证书正本复印件</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">4</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;申报资质上一年度或当期的财务审计报告复印件</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">5</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;标准要求的厂房证明，属于自有产权的出具产权证复印件；属于租用或借用的，出具出租（借）方产权证和双方租赁合同或借用协议的复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">6</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;标准要求的主要设备购置发票</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">7</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;安全生产许可证复印件</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">8</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;中级及以上职称人员的身份证明、职称证（学历证明）复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">9</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;现场管理人员的身份证明、岗位证书复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">10</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;技术负责人身份证明、执业资格证书、职称证书或技能证书
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">11</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;技术工人的身份证明、职业培训合格证书或职业技能证书复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">12</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;企业主要人员申报前3个月的社会保险证明
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">13</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;技术负责人（或注册建造师）基本情况及业绩表
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">14</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;工程中标通知书复印件</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">15</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;工程合同（合同协议书和专用条款）复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">16</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;工程竣工（交工）验收文件或有关部门出具的工程质量鉴定书复印件（需包含参与验收的单位及人员、验收的内容、验收的结论、验收的时间等内容）；境外工程还应提供驻外使领馆经商部门出具的工程真实性证明文件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">17</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;涉及到层数、单体建筑面积、跨度、长度、高度、结构类型等方面指标，应提供反映该项技术指标的图纸复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td width="5%"><p align="center">18</p></td>
				<td width="65%"><p align="left">&nbsp;&nbsp;涉及到单项合同额、造价等指标的，应提供工程结算单复印件
					</p></td>
				<td width="10%"></td>
				<td width="20%"></td>
			</tr>
			<tr>
				<td>
					<p>&nbsp;</p>
					<p align="center">
						申<br />请<br />单<br />位
					</p>
					<p>&nbsp;</p>
				</td>
				<td colspan="3" valign="bottom">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;企业确认:____________________年_____月_____日&nbsp;&nbsp;&nbsp;&nbsp;(印章)
				</td>
			</tr>
			<tr>
				<td rowspan="2">
					<p align="center">
						受<br />理<br />机<br />关
				</td>
				<td colspan="3" valign="bottom">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;承办人:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
				</td>
			</tr>
			<tr>
				<td colspan="3" valign="bottom">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					&nbsp;&nbsp;主管主任:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日
				</td>
			</tr>

		</table>



	</div>

	<div id="table04" style="display: none">

		<p align="center">
			<strong><font size="6">申请换证行政许可材料清单</font></strong>
		</p>
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="3%"><p align="center">序 号</p></td>
				<td width="47%"><p align="center">
						<strong><font size="4"> 申&nbsp; 报&nbsp; 材&nbsp; 料
						</font></strong>
					</p></td>
				<td width="25%"><p align="center">
						<strong><font size="4"> 数&nbsp; 量 </font></strong>
					</p></td>
				<td width="25%"><p align="center">
						<strong><font size="4"> 备&nbsp; 注 </font></strong>
					</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">1</p></td>
				<td width="47%"><p>《建筑业企业资质申请表》一式二份</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">2</p></td>
				<td width="47%"><p>企业组织机构代码证书副本复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="3%"><p align="center">3</p></td>
				<td width="47%"><p>《营业执照》副本复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">4</p></td>
				<td width="47%"><p>建筑业企业资质证书副本复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">5</p></td>
				<td width="47%"><p>申报资质上一年度或当期的财务审计报告复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">6</p></td>
				<td width="47%"><p>标准要求的厂房证明，属于自有产权的出具产权证复印件；属于租用或借用的，出具出租（借）方产权证和双方租赁合同或借用协议的复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">7</p></td>
				<td width="47%"><p>标准要求的主要设备购置发票</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">8</p></td>
				<td width="47%"><p>安全生产许可证复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">9</p></td>
				<td width="47%"><p>中级及以上职称人员的身份证明、职称证（学历证明）复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">10</p></td>
				<td width="47%"><p>现场管理人员的身份证明、岗位证书复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">11</p></td>
				<td width="47%"><p>技术负责人身份证明、执业资格证书、职称证书或技能证书</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">12</p></td>
				<td width="47%"><p>技术工人的身份证明、职业培训合格证书或职业技能证书复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">13</p></td>
				<td width="47%"><p>企业主要人员申报前3个月的社会保险证明</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">申请单位</p></td>
				<td width="97%" colspan="3"><br> <br>&nbsp;&nbsp;
					<p>企业确认:_____________年_____月_____日</p>
					<p align="right">（印 章）</p></td>
			</tr>
			<tr>
				<td width="3%" rowspan="2"><p align="center">受理机关</p></td>
				<td width="97%" colspan="3"><br>
					<p>&nbsp;承办人：</p>
					<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日</p></td>

			</tr>
			<tr>
				<td width="97%" colspan="3"><br>&nbsp;
					<p>主管主任：</p>
					<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日</p></td>
			</tr>

		</table>


	</div>

	<div id="table03" style="display: none">

		<p align="center">
			<strong><font size="6">首次申请行政许可材料清单</font></strong>
		</p>
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="3%"><p align="center">序 号</p></td>
				<td width="47%"><p align="center">
						<strong><font size="4"> 材&nbsp; 料&nbsp; 名&nbsp; 称
						</font></strong>
					</p></td>
				<td width="25%"><p align="center">
						<strong><font size="4"> 数&nbsp; 量 </font></strong>
					</p></td>
				<td width="25%"><p align="center">
						<strong><font size="4"> 备&nbsp; 注 </font></strong>
					</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">1</p></td>
				<td width="47%"><p>《建筑业企业资质申请表》一式二份</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">2</p></td>
				<td width="47%"><p>企业组织机构代码证书副本复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="3%"><p align="center">3</p></td>
				<td width="47%"><p>《营业执照》副本复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">4</p></td>
				<td width="47%"><p>企业章程复印件（含原企业和新企业）</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">5</p></td>
				<td width="47%"><p>办公场所证明，属于自有产权的出具产权证复印件；属于租用或借用的，出具出租（借）方产权证和双方租赁合同或借用协议的复印件
					</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">6</p></td>
				<td width="47%"><p>标准要求的主要设备购置发票</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">7</p></td>
				<td width="47%"><p>经省级注册管理部门批准的注册建造师初始注册或变更注册材料（新企业无资质的）</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">8</p></td>
				<td width="47%"><p>中级及以上职称人员的身份证明、职称证（学历证明）复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">9</p></td>
				<td width="47%"><p>现场管理人员的身份证明、岗位证书复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">10</p></td>
				<td width="47%"><p>技术负责人身份证明、执业资格证书、职称证书或技能证书</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">11</p></td>
				<td width="47%"><p>技术工人的身份证明、职业培训合格证书或职业技能证书复印件</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">12</p></td>
				<td width="47%"><p>企业主要人员申报前1个月的社会保险证明</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">13</p></td>
				<td width="47%"><p>技术负责人（或注册建造师）基本情况及业绩表</p></td>
				<td width="25%"><p>&nbsp;</p></td>
				<td width="25%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="3%"><p align="center">申请单位</p></td>
				<td width="97%" colspan="3"><br> <br>&nbsp;&nbsp;
					<p>企业确认:_____________年_____月_____日</p>
					<p align="right">（印 章）</p></td>
			</tr>
			<tr>
				<td width="3%" rowspan="2"><p align="center">受理机关</p></td>
				<td width="97%" colspan="3"><br>
					<p>&nbsp;承办人：</p>
					<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日</p></td>

			</tr>
			<tr>
				<td width="97%" colspan="3"><br>&nbsp;
					<p>主管主任：</p>
					<p align="center">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 年
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 月
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 日</p></td>
			</tr>

		</table>


	</div>

	<div id="table02" style="display: none">

		<p align="center">黑龙江省住房和城乡建设厅权力运行轨迹档案</p>
		档案编号：
		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="65" rowspan="3"><p align="center">基本</p>
					<p align="center">情况</p></td>
				<td width="120" colspan="3"><p align="center">事项（项目）</p></td>
				<td width="456" colspan="5"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="40" rowspan="2">
					<p align="center">相</p>
					<p align="center">对</p>
					<p align="center">人</p>
				</td>
				<td width="80" colspan="2"><p align="center">姓名</p></td>
				<td width="180"><p align="center">&nbsp;</p></td>
				<td width="48" rowspan="2"><p align="center">联系</p>
					<p align="center">方式</p></td>
				<td width="102" colspan="2"><p align="center">办公电话</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="80" colspan="2"><p align="center">地址</p></td>
				<td width="180"><p align="center">&nbsp;</p></td>
				<td width="102" colspan="2"><p align="center">移动电话</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">受理</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">受理
					</p>
					<p align="center">意见</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">&nbsp;
					</p></td>
				<td width="150" colspan="3"><p align="center">受理人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">受理时间</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65"><p align="center">一次性告知</p></td>
				<td width="87" colspan="2"><p align="center">方式</p></td>
				<td width="213" colspan="2"><p align="center">&nbsp;</p></td>
				<td width="150" colspan="3"><p align="center">告知人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="3"><p align="center">初审</p></td>
				<td width="87" colspan="2" rowspan="3"><p align="center">初审意见
					</p></td>
				<td width="213" colspan="2" rowspan="3"><p align="center">无（同意上会）
					</p></td>
				<td width="72" colspan="2" rowspan="2"><p align="center">AB
						角</p>
					<p align="center">情况</p></td>
				<td width="78"><p align="center">A 角</p></td>
				<td width="126"><p align="center">于海洋</p></td>
			</tr>
			<tr>
				<td width="78"><p align="center">B 角</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">初审时间</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">实地</p>
					<p align="center">调查</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">调查
					</p>
					<p align="center">结果</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">无
					</p></td>
				<td width="150" colspan="3"><p align="center">责任人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">调查起止时间</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">专家</p>
					<p align="center">评审</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">评审意见
					</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">同意
					</p></td>
				<td width="150" colspan="3"><p align="center">责任人</p></td>
				<td width="126"><p align="center">张立志</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">评审起止时间</p></td>
				<td width="126"><p align="center">2012.9.4</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">处务会</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">处务会结论
					</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">同意
					</p></td>
				<td width="150" colspan="3"><p align="center">处务会责任人</p></td>
				<td width="126"><p align="center">张立志</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">处务会召开时间</p></td>
				<td width="126"><p align="center">2012-9-19</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">主管</p>
					<p align="center">领导</p>
					<p align="center">签批</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">签批
					</p>
					<p align="center">意见</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">同意
					</p></td>
				<td width="150" colspan="3"><p align="center">签批人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">签批时间</p></td>
				<td width="126"><p align="center">2012.9.20</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="3"><p align="center">拟批准项目</p>
					<p align="center">公示</p></td>
				<td width="87" colspan="2" rowspan="3"><p align="center">公示
					</p>
					<p align="center">结果</p></td>
				<td width="213" colspan="2" rowspan="3"><p align="center">同意
					</p></td>
				<td width="150" colspan="3"><p align="center">责任人</p></td>
				<td width="126"><p align="center">张立志</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p>公示起止时间</p></td>
				<td width="126"><p>2012.9.10 ～ 9.18</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">公示方式</p></td>
				<td width="126"><p align="center">网上公示</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="2"><p align="center">拟准项</p>
					<p align="center">目公告</p></td>
				<td width="87" colspan="2" rowspan="2"><p align="center">公告
					</p>
					<p align="center">方式</p></td>
				<td width="213" colspan="2" rowspan="2"><p align="center">网上公告黑建建
						[2012]80 号</p></td>
				<td width="150" colspan="3"><p align="center">责任人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">公告起止时间</p></td>
				<td width="126"><p align="center">2012.9.20</p></td>
			</tr>
			<tr>
				<td width="65" rowspan="3"><p align="center">告知</p></td>
				<td width="87" colspan="2" rowspan="3"><p align="center">告知
					</p>
					<p align="center">方式</p></td>
				<td width="213" colspan="2" rowspan="3"><p align="center">书面告知
					</p></td>
				<td width="150" colspan="3"><p align="center">责任人</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">签收时间</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="150" colspan="3"><p align="center">告知时间</p></td>
				<td width="126"><p align="center">&nbsp;</p></td>
			</tr>
			<tr>
				<td width="65"><p align="center">备注</p></td>
				<td width="576" colspan="8"><p align="center">&nbsp;</p>
					<p align="center">&nbsp;</p></td>
			</tr>

		</table>

		<div style="float: left">
			说明：<br /> 1、各部门应结合行权类别，参照上述样式统一设计适合本部门或处室的行权轨迹档案；<br />
			2、该行权轨迹档案自行权事项受理起建立，并跟随行权事项办理全过程，所涉及行权环节责任人在行权的同时，应按要求如实填写，最后由行使该项权力的责任单位负责存档，以
			便查阅；<br /> 3、属于形式审查的即来即办事项，可另行简要记录。
		</div>

	</div>

	<div id="table01" style="display: none">

		<p align="center">法人授权委托书</p>

		<table border="1" width="100%"
			style="border: solid 1px black; border-collapse: collapse">
			<tr>
				<td width="20%" colspan="2"><p align="center">委托单位</p></td>
				<td width="40%" colspan="3"><p>&nbsp;</p></td>
				<td width="10%"><p align="center">电话</p></td>
				<td width="30%"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="20%" colspan="2"><p align="center">法定代表人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
				<td width="10%"><p align="center">性别</p></td>
				<td width="15%"><p>&nbsp;</p></td>

				<td width="10%"><p align="center">身份证号码</p></td>
				<td width="30%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" colspan="2"><p align="center">受委托人</p></td>
				<td width="15%"><p>&nbsp;</p></td>
				<td width="10%"><p align="center">性别</p></td>
				<td width="15%"><p>&nbsp;</p></td>
				<td width="10%"><p align="center">身份证号码</p></td>
				<td width="30%"><p>&nbsp;</p></td>
			</tr>

			<tr>
				<td width="20%" colspan="2"><p align="center">所在单位及现任职务</p></td>
				<td width="25%" colspan="2"><p>&nbsp;</p></td>
				<td width="15%"><p align="center">电话</p></td>
				<td width="40%" colspan="2"><p>&nbsp;</p></td>
			</tr>
			<tr>
				<td width="10%">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p align="center">委托</p>
					<p align="center">职权</p>
					<p align="center">范围</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>
				<td width="90%" colspan="6">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;今委托&nbsp;
						&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;同志到黑龙江省住房和城乡建设厅全权办理申请许可手续的相关事宜</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>
			</tr>

			<tr>
				<td width="20%" colspan="2"><p align="center">委托期限</p></td>
				<td width="80%" colspan="5" align="center"><p>年&nbsp;
						&nbsp;&nbsp; &nbsp;月&nbsp; &nbsp;&nbsp; &nbsp;日始-- &nbsp;
						&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;年&nbsp; &nbsp;&nbsp; &nbsp;月&nbsp;
						&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;日止</p></td>
			</tr>

			<tr>
				<td width="100%" colspan="7">
					<p>&nbsp;</p>
					<p>&nbsp;</p>
					<p>委托单位（盖章）&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;委托人（签字或盖章）</p>
					<p>&nbsp;</p>
					<p>&nbsp;</p>
				</td>
			</tr>

			<tr>
				<td width="10%"><p align="center">备注</p></td>
				<td width="90%" colspan="6">&nbsp;</td>
			</tr>
		</table>

		<div id="Content">
			    
			<div id="Content-Left" style="float: left;">注：后附受委托人身份证复印件</div>
		</div>

	</div>
</body>
<script language="javascript" type="text/javascript">
	var LODOP; //声明为全局变量 

	function prn_preview1() {
		CreatePrintPageAB1();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};

	function CreatePrintPageAB1() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("法人授权委托书");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table01").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("15mm", "15mm", "RightMargin:15mm",
				"BottomMargin:15mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_TEXT(9,628,164,25,"监督注册号：");
		//LODOP.ADD_PRINT_TEXT(80,627,109,25,"文件编号 ZJ01-01");
	};

	function prn_previewA() {
		CreatePrintPageA();
		LODOP.SET_PRINT_PAGESIZE(0, "210mm", "297mm", "");
		LODOP.SET_PREVIEW_WINDOW(1, 0, 1, 0, 0, "");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口

		LODOP.PREVIEW();
	};

	function CreatePrintPageA() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("行政许可申请书");

		LODOP.ADD_PRINT_TEXT(89, 260, 397, 43, "行政许可申请书");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "黑体");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 22);

		LODOP
				.ADD_PRINT_TEXT(
						176,
						63,
						679,
						621,
						"申 请 人：_____________身份证号码：_________________________\n"
								+ "单位全称：____________________________法定代表人：__________\n"
								+ "单位地址：____________________________联系电话：____________\n"
								+ "委托代理人：___________身份证号码：_________________________\n"
								+ "联系电话:（固话）________________（手机）：_________________\n"
								+ "行政许可申请事项：\n"
								+ "____________________________________________________________\n"
								+ "____________________________________________________________\n"
								+ "____________________________________________________________\n"
								+ "____________________________________________________________\n"
								+ "申请人（签字）：\n" + "委托代理人（签字）：");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "FangSong");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "LineSpacing", 10);

		LODOP.ADD_PRINT_TEXT(837, 542, 206, 75, "（单位公章）\n" + "   年  月  日");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "FangSong");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);

		LODOP.ADD_PRINT_TEXT(911, 66, 79, 41, "注明：");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "FangSong");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);

		LODOP.ADD_PRINT_TEXT(912, 134, 577, 100, "1、此单为申请人本人填写，窗口受理人备案；\n"
				+ "2、此单与申请材料首页同时存档备查；\n" + "3、此单用于所有申请事项。");

		LODOP.SET_PRINT_STYLEA(0, "FontName", "FangSong");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);

	};

	function prn_preview2() {
		CreatePrintPageAB2();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB2() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table02").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("15mm", "15mm", "RightMargin:15mm",
				"BottomMargin:15mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
		//LODOP.ADD_PRINT_TEXT(9,628,164,25,"监督注册号：");
		//LODOP.ADD_PRINT_TEXT(80,627,109,25,"文件编号 ZJ01-01");
	};

	function prn_preview3() {
		CreatePrintPageAB3();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB3() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table03").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
				"BottomMargin:10mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};

	function prn_preview4() {
		CreatePrintPageAB4();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB4() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table04").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
				"BottomMargin:10mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);
	};

	function prn_preview5() {
		CreatePrintPageAB5();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB5() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table05").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
				"BottomMargin:10mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);

	};

	function prn_preview6() {
		CreatePrintPageAB6();
		//LODOP.SET_PRINT_PAGESIZE(0,"210mm","297mm","");
		//LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		//LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	function CreatePrintPageAB6() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("项目报建表");
		var strHTML = "<body style='margin:0;background-color: white'>"
				+ document.getElementById("table06").innerHTML + "</body>";
		LODOP.ADD_PRINT_HTM("10mm", "10mm", "RightMargin:10mm",
				"BottomMargin:10mm", strHTML);
		//LODOP.ADD_PRINT_HTM("5mm",34,"RightMargin:1.5cm","BottomMargin:15mm",strHTML);

	};

	function prn_preview7() {
		CreatePrintPageA7();
		LODOP.SET_PRINT_PAGESIZE(0, "210mm", "297mm", "");
		LODOP.SET_PREVIEW_WINDOW(1, 0, 1, 0, 0, "");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};

	function CreatePrintPageA7() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("行政审批A");
		LODOP.ADD_PRINT_TEXT(186, 203, 540, 40, "受理行政许可申请通知书");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 22);
		LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
		LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
		LODOP.ADD_PRINT_TEXT(229, 336, 406, 34, "许受字〔" + "  " + "〕第   号");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.ADD_PRINT_TEXT(368, 85, 306, 30, "__________：");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP
				.ADD_PRINT_TEXT(
						397,
						85,
						619,
						240,
						"    你单位于___年___月___日提出的___________行政许可申请收悉。经审查，符合法定受理条件，本机关决定自___年___月___日起受理。");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		//LODOP.SET_PRINT_STYLEA(0,"LineSpacing",5);
		LODOP.ADD_PRINT_TEXT(688, 410, 282, 40, "（行政机关许可专用印章）");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.ADD_PRINT_TEXT(728, 440, 265, 40, "   年   月   日");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
	};

	function prn_preview8() {
		CreatePrintPageB8();
		LODOP.SET_PRINT_PAGESIZE(0, "210mm", "297mm", "");
		LODOP.SET_PREVIEW_WINDOW(1, 0, 1, 0, 0, "");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW", 1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};

	function CreatePrintPageB8() {
		LODOP = getLodop();
		LODOP.PRINT_INIT("行政审批B");
		LODOP.ADD_PRINT_TEXT(187, 155, 469, 40, "不予受理行政许可申请通知书");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 22);
		LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
		LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
		LODOP.ADD_PRINT_TEXT(233, 346, 406, 34, "   许不字〔" + "  " + "〕第   号");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.ADD_PRINT_TEXT(368, 85, 306, 30, "________：");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP
				.ADD_PRINT_TEXT(
						397,
						85,
						619,
						240,
						"    于___年___月___日提出的_________行政许可申请收悉。经审查，不符合法定受理条件，本机关决定不予受理。\n    如不服本决定，可以自收到本决定书之日起六十日内向_________申请行政复议，或者三个月内向_________人民法院提起行政诉讼。");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.ADD_PRINT_TEXT(688, 410, 282, 40, "（行政机关许可专用印章）");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.ADD_PRINT_TEXT(728, 440, 265, 40, "   年   月   日");
		LODOP.SET_PRINT_STYLEA(0, "FontName", "仿宋");
		LODOP.SET_PRINT_STYLEA(0, "FontSize", 16);
		LODOP.SET_PRINT_STYLEA(0, "LetterSpacing", 5);
	};
</script>
</html>