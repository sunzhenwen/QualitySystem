package com.tj.jst.inner.qualificationProductivity.provinceApproval.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.UtilDate;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.base.util.judgedate.JudgeDateAction;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 省级资质审批
 * 
 * @author Administrator
 *
 */
public class ProvinceApprovalDaoImpl extends BaseDao implements
		IProvinceApprovalDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection baseConn = null;
	PreparedStatement basePstmt = null;

	public Page pagedQuery(Condition condition) {

		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					NewQualification certifiedService = new NewQualification();

					// 主键
					certifiedService.setNewQualId(rs.getString("newQualId"));
					// 企业主键
					certifiedService.setCorpId(rs.getString("corpId"));
					// 企业名称
					certifiedService.setCorpName(rs.getString("corpName"));
					// 企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode"));
					// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService
							.setProvinceNum(rs.getString("provinceNum"));
					// 企业所在省名称
					certifiedService.setProvinceName(rs
							.getString("provinceName"));
					// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					// 企业所在市名称
					certifiedService.setCityName(rs.getString("cityName"));
					// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					// 企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName"));
					// 申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType"));
					// 服务事项主键
					certifiedService.setCertId(rs.getString("certId"));
					// 服务事项名称
					certifiedService.setCertName(rs.getString("certName"));
					// 资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					// 资质级别名称
					certifiedService.setCretGradeName(rs
							.getString("cretGradeName"));
					// 资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// 资质等级名称
					certifiedService.setCretLevelName(rs
							.getString("cretLevelName"));
					// 资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// 资质序列名称
					certifiedService.setCretSequenceName(rs
							.getString("cretSequenceName"));
					// 资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					// 资质类型名称
					certifiedService.setCretTypeName(rs
							.getString("cretTypeName"));
					// 资质专业类别
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// 资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs
							.getString("specialtyTypeName"));
					// 审批部门
					certifiedService.setApprovalDept(rs
							.getString("approvalDept"));
					// 审批部门名称
					certifiedService.setApprovalDeptName(rs
							.getString("approvalDeptName"));
					// 二级审批初审部门
					certifiedService.setTwoApprovalDept(rs
							.getString("twoApprovalDept"));
					// 二级审批初审部门名称
					certifiedService.setTwoApprovalDeptName(rs
							.getString("twoApprovalDeptName"));
					// 申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// 资质取得方式方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					// 资质取得方式名称
					certifiedService
							.setAddTypeName(rs.getString("addTypeName"));
					certifiedService.setAssets(rs.getString("assets"));
					certifiedService.setMachinery(rs.getString("machinery"));
					certifiedService.setFloorDate(rs.getDate("floorDate"));
					if (rs.getDate("floorDate") != null) {
						// 截止日期
						certifiedService.setDeadDate(JudgeDateAction
								.getDeadDate(rs.getDate("floorDate")));
						// 判断是否超期
						int days = JudgeDateAction
								.getDifferDate(JudgeDateAction.getDeadDate(rs
										.getDate("floorDate")));
						if (days > 5) {
							certifiedService.setDateMark("0");
						} else if (days >= 0 && days <= 5) {
							certifiedService.setDateMark("1");
						} else if (days < 0) {
							certifiedService.setDateMark("2");
						}
						certifiedService.setDifferDay(Integer.toString(days));
					}

					page.getData().add(certifiedService);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 跳转审批页面查询 (无需二级审批)
	 */
	public NewQualification queryApproval(String newQualId) {
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ newQualId + "'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// 主键
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				// 企业主键
				certifiedService.setCorpId(rs.getString("corpId").trim());
				// 企业名称
				certifiedService.setCorpName(rs.getString("corpName").trim());
				// 企业住址机构代码证
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum")
						.trim());
				// 企业所在省名称
				certifiedService.setProvinceName(rs.getString("provinceName")
						.trim());
				// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				// 企业所在市名称
				certifiedService.setCityName(rs.getString("cityName").trim());
				// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// 企业所在区名称
				certifiedService.setCountyName(rs.getString("countyName")
						.trim());
				// 申请状态(1：已申请)
				certifiedService.setQualifType(rs.getString("qualifType")
						.trim());
				// 服务事项主键
				certifiedService.setCertId(rs.getString("certId").trim());
				// 服务事项名称
				certifiedService.setCertName(rs.getString("certName").trim());
				// 资质级别
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				// 资质级别名称
				certifiedService.setCretGradeName(rs.getString("cretGradeName")
						.trim());
				// 资质等级
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				// 资质等级名称
				certifiedService.setCretLevelName(rs.getString("cretLevelName")
						.trim());
				// 资质序列
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				// 资质序列名称
				certifiedService.setCretSequenceName(rs.getString(
						"cretSequenceName").trim());
				// 资质类型
				certifiedService.setCretType(rs.getInt("cretType"));
				// 资质类型名称
				certifiedService.setCretTypeName(rs.getString("cretTypeName")
						.trim());
				// 资质专业类别
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				// 资质专业类别名称
				certifiedService.setSpecialtyTypeName(rs.getString(
						"specialtyTypeName").trim());
				// 申请日期
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				// 资质资格取得方式
				certifiedService.setAddTypeNum(rs.getString("addTypeNum")
						.trim());
				// 资质资格取得方式名称
				certifiedService.setAddTypeName(rs.getString("addTypeName")
						.trim());
				// 审批部门Id
				certifiedService.setApprovalDept(rs.getString("approvalDept")
						.trim());
				// 审批部门名称
				certifiedService.setApprovalDeptName(rs.getString(
						"approvalDeptName").trim());
				// 企业登记注册类型
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// 二级审批部门
				certifiedService.setTwoApprovalDept(rs.getString(
						"twoApprovalDept").trim());
				// 二级审批部门名称
				certifiedService.setTwoApprovalDeptName(rs.getString(
						"twoApprovalDeptName").trim());
				// 初审人员
				certifiedService.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff"));
				// 初审人员Id
				certifiedService.setTwoApprovalStaffId(rs
						.getString("twoApprovalStaffId"));
				// 初审时间
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				// 初审状态
				certifiedService.setOneResults(rs.getString("oneResults"));
				// 初审建议
				certifiedService.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion"));
				// 企业登记注册类型
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// 工商营业执照注册号
				certifiedService.setLicenseNum(rs.getString("licenseNum"));
				// 法定代表人姓名
				certifiedService.setLegalMan(rs.getString("legalMan"));
				// 法定代表人证件类型
				certifiedService
						.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				// 法定代表人证件号码
				certifiedService.setLegalManIdCard(rs
						.getString("legalManIdCard"));
				// 法定代表人职务
				certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
				// 法定代表人职称
				certifiedService.setLegaManProtitle(rs
						.getString("legaManProtitle"));
				// 企业营业地址
				certifiedService.setAddress(rs.getString("address"));
				// 注册资本
				certifiedService.setRegPrin(rs.getString("REGPRIN"));
				certifiedService.setAssets(rs.getString("assets"));
				certifiedService.setMachinery(rs.getString("machinery"));
				certifiedService.setEndDate(rs.getDate("endDate"));
				certifiedService.setPreCorpCode(rs.getString("preCorpCode"));
				certifiedService.setPreCorpName(rs.getString("preCorpName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certifiedService;
	}

	/**
	 * 审批通过 (无需二级审批)
	 * 
	 * @return
	 */
	public void applyThrough(NewQualification newQualification,
			String certifiedCode) {
		//判断是否是升级，如果是升级，需将该资质的低级等级注销掉
		if( "002".equals(newQualification.getAddTypeNum()) ){
			this.cancalQualification(newQualification.getCorpId(),newQualification.getSpecialtyType(),newQualification.getCretLevel());
		}
		try {
			String relationId = UUID.randomUUID().toString();
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
							+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1, "5");
			pstmt.setString(2, newQualification.getUltimateOpinion()); // 审批意见
			pstmt.setString(3, newQualification.getApprovalStaff()); // 审批人员名称
			pstmt.setString(4, newQualification.getApprovalStaffId()); // 审批人员Id
			pstmt.setDate(5, new Date(new java.util.Date().getTime())); // 审批时间
			pstmt.setString(6, "5"); // 审批结果
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
			
			pstmt = conn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
							+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
							+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
							+ "legalManIdCard,legaLManDuty,legaManProtitle,address,RELATIONID,CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, certifiedCode);
			// 资质资格序列
			pstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			pstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			pstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			pstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			pstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			pstmt.setString(11, "1");
			// 系统来源
			pstmt.setString(12, "01");
			// 审批状态
			pstmt.setString(13, "5");
			// 审批部门
			pstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			pstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			pstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			pstmt.setString(20, "5");

			// 企业登记注册类型
			pstmt.setInt(21, newQualification.getEconomicNum());
			// 工商营业执照注册号
			pstmt.setString(22, newQualification.getLicenseNum());
			// 法定代表人姓名
			pstmt.setString(23, newQualification.getLegalMan());
			// 法定代表人证件类型
			pstmt.setString(24, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			pstmt.setString(25, newQualification.getLegalManIdCard());
			// 法定代表人职务
			pstmt.setString(26, newQualification.getLegaLManDuty());
			// 法定代表人职称
			pstmt.setString(27, newQualification.getLegaManProtitle());
			// 企业营业地址
			pstmt.setString(28, newQualification.getAddress());
			pstmt.setString(29, relationId);
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into tbcorpcertinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
							+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
							+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
							+ "ORGANDATE,ENDDATE,ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 资质资格类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, certifiedCode);
			// 资质资格最高等级
			pstmt.setInt(5, newQualification.getCretLevel());
			// 发证机关
			//如果资质级别为国家级
//			if (newQualification.getCretGrade().equals("1")) {
//				pstmt.setString(6, "中华人民共和国住房和城乡建设部");
//			} else if (newQualification.getCretGrade().equals("2")) {
//				//如果资质级别为省级
//				pstmt.setString(6, "黑龙江省住建厅");
//			} else {
//				//如果资质级别为地市级
//				pstmt.setString(6, newQualification.getCityName() + "建设局");
//			}
			pstmt.setString(6, "黑龙江省住建厅");
			// 资质类别及等级
			pstmt.setString(7, newQualification.getCertName());
			// 审批部门
			pstmt.setString(8, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(9, newQualification.getApprovalStaff());
			// 审批人Id
			pstmt.setString(10, newQualification.getApprovalStaffId());
			// 审批时间
			pstmt.setDate(11, new Date(new java.util.Date().getTime()));
			// 资质级别
			pstmt.setString(12, newQualification.getCretGrade());
			// 资质资格取得方式
			pstmt.setString(13, newQualification.getAddTypeNum());
			// 工商营业执照注册号
			pstmt.setString(14, newQualification.getLicenseNum());
			// 审批部门名称
			pstmt.setString(15, newQualification.getApprovalDeptName());
			pstmt.setString(16, newQualification.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(17, newQualification.getCityNum());// 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(18, newQualification.getCountyNum());// 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(19, newQualification.getAddress());// 企业营业地址
			pstmt.setString(20, newQualification.getLegalMan());// 法定代表人姓名
			pstmt.setString(21, newQualification.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(22, newQualification.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(23, newQualification.getLegaLManDuty());// 法定代表人职务
			pstmt.setString(24, newQualification.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(25, newQualification.getEconomicNum());// 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setString(26, newQualification.getRegPrin());// 注册资本

			pstmt.setDate(27, new Date(new java.util.Date().getTime()));// 发证日期
			if (newQualification.getAddTypeNum().equals("006")) {
				pstmt.setDate(28, newQualification.getEndDate());// 证书有效截止日期
			} else {
				pstmt.setDate(28, UtilDate.getStringChangeDate());// 证书有效截止日期
			}
			
			pstmt.setInt(29, 1);// 证书状态
			pstmt.setString(30, newQualification.getCorpId());
			pstmt.setString(31, relationId);
			pstmt.setString(32, "0");
			pstmt.executeUpdate();

			conn.commit();
			this.applyThroughBase(newQualification, certifiedCode, relationId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 将已升级的资质的低等级资质注销
	 * @param corpId
	 * @param specialtyType
	 * @param cretLevel
	 */
	private void cancalQualification(String corpId, int specialtyType,
			int cretLevel) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TBCORPCERTDETAILINFO " +
					"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=? and CERTTRADESTATUSNUM=?" ;
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			pstmt.setInt(2, specialtyType);
			pstmt.setInt(3, cretLevel-1);
			pstmt.setString(4, "001");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=? " +
						"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=?");
				pstmt.setString(1, "002");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, specialtyType);
				pstmt.setInt(4, cretLevel-1);
				pstmt.executeUpdate();
				
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set certtradestatusnum=? " +
						"where corpId=? and tradeboundnum=? and titlelevelnum=?");
				pstmt.setString(1, "002");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, specialtyType);
				pstmt.setInt(4, cretLevel-1);
				pstmt.executeUpdate(); 
				//this.cancalQualification(corpId, specialtyType, cretLevel-1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}

	/**
	 * 基础数据库存入审批信息 (无需二级审批)
	 * 
	 * @return
	 */
	public void applyThroughBase(NewQualification newQualification,
			String certifiedCode, String relationId) {

		try {
			baseConn = ConnectionFactory.getBasicConnection();
			baseConn.setAutoCommit(false);
			basePstmt = baseConn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,"
							+ "CERTID,"
							+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
							+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
							+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
							+ "legalManIdCard,legaLManDuty,legaManProtitle,address,relationId,CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			// 企业名称
			basePstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			basePstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			basePstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			basePstmt.setString(4, certifiedCode);
			// 资质资格序列
			basePstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			basePstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			basePstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			basePstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			basePstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			basePstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			basePstmt.setString(11, "1");
			// 系统来源
			basePstmt.setString(12, "01");
			// 审批状态
			basePstmt.setString(13, "5");
			// 审批部门
			basePstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			basePstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			basePstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			basePstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			basePstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			basePstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			basePstmt.setString(20, "5");

			// 企业登记注册类型
			basePstmt.setInt(21, newQualification.getEconomicNum());
			// 工商营业执照注册号
			basePstmt.setString(22, newQualification.getLicenseNum());
			// 法定代表人姓名
			basePstmt.setString(23, newQualification.getLegalMan());
			// 法定代表人证件类型
			basePstmt.setString(24, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			basePstmt.setString(25, newQualification.getLegalManIdCard());
			// 法定代表人职务
			basePstmt.setString(26, newQualification.getLegaLManDuty());
			// 法定代表人职称
			basePstmt.setString(27, newQualification.getLegaManProtitle());
			// 企业营业地址
			basePstmt.setString(28, newQualification.getAddress());
			basePstmt.setString(29, relationId);
			basePstmt.executeUpdate();
			
			basePstmt = baseConn
					.prepareStatement("insert into tbcorpcertinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
							+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
							+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,OLDORNEW,"
							+ "DATASOURCE,REGPRIN,ORGANDATE,ENDDATE,ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			basePstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			basePstmt.setString(2, newQualification.getCorpCode());
			// 资质资格类型
			basePstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			basePstmt.setString(4, certifiedCode);
			// 资质资格最高等级
			basePstmt.setInt(5, newQualification.getCretLevel());
			// 发证机关
//			if (newQualification.getCretGrade().equals("1")) {
//				basePstmt.setString(6, "中华人民共和国住房和城乡建设部");
//			} else if (newQualification.getCretGrade().equals("2")) {
//				basePstmt.setString(6, "黑龙江省住建厅");
//			} else {
//				basePstmt.setString(6, newQualification.getCityName() + "建设局");
//			}
			basePstmt.setString(6, "黑龙江省住建厅");
			// 资质类别及等级
			basePstmt.setString(7, newQualification.getCertName());
			// 审批部门
			basePstmt.setString(8, newQualification.getApprovalDept());
			// 审批人
			basePstmt.setString(9, newQualification.getApprovalStaff());
			// 审批人Id
			basePstmt.setString(10, newQualification.getApprovalStaffId());
			// 审批时间
			basePstmt.setDate(11, new Date(new java.util.Date().getTime()));
			// 资质级别
			basePstmt.setString(12, newQualification.getCretGrade());
			// 资质资格取得方式
			basePstmt.setString(13, newQualification.getAddTypeNum());
			// 工商营业执照注册号
			basePstmt.setString(14, newQualification.getLicenseNum());
			// 审批部门名称
			basePstmt.setString(15, newQualification.getApprovalDeptName());
			basePstmt.setString(16, newQualification.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			basePstmt.setString(17, newQualification.getCityNum());// 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			basePstmt.setString(18, newQualification.getCountyNum());// 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			basePstmt.setString(19, newQualification.getAddress());// 企业营业地址
			basePstmt.setString(20, newQualification.getLegalMan());// 法定代表人姓名
			basePstmt.setString(21, newQualification.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			basePstmt.setString(22, newQualification.getLegalManIdCard());// 法定代表人证件号码
			basePstmt.setString(23, newQualification.getLegaLManDuty());// 法定代表人职务
			basePstmt.setString(24, newQualification.getLegaManProtitle());// 法定代表人职称
			basePstmt.setInt(25, newQualification.getEconomicNum());// 企业登记注册类型(字典表：TBECONTYPEDIC)
			basePstmt.setString(26, "1");// 0：老数据 1：新数据
			basePstmt.setString(27, "01");// 数据来源系统
			basePstmt.setString(28, newQualification.getRegPrin());// 注册资本
			basePstmt.setDate(29, new Date(new java.util.Date().getTime()));// 发证日期
			if (newQualification.getAddTypeNum().equals("006")) {
				basePstmt.setDate(30, newQualification.getEndDate());// 证书有效截止日期
			} else {
				basePstmt.setDate(30, UtilDate.getStringChangeDate());// 证书有效截止日期
			}
			basePstmt.setInt(31, 1);// 证书状态
			basePstmt.setString(32, newQualification.getCorpId());
			basePstmt.setString(33, relationId);
			basePstmt.setString(34, "0"); 
			basePstmt.executeUpdate();

			// //就位删除老数据
			// if(newQualification.getAddTypeNum().equals("007"))
			// {
			// basePstmt =
			// baseConn.prepareStatement("delete from tbcorpcertdetailinfo where CORPID=? and TITLELEVELNUM=? "
			// + "and TRADEBOUNDNUM=? and OLDORNEW=?");
			// basePstmt.setString(1, newQualification.getCorpId());//企业Id
			// basePstmt.setInt(2, newQualification.getCretLevel());//资质等级
			// basePstmt.setInt(3, newQualification.getSpecialtyType());//资质类别
			// basePstmt.setString(4, "0");//新老数据
			// basePstmt.executeUpdate();
			// }

			baseConn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				baseConn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(baseConn, basePstmt, null);
		}
	}

	/**
	 * 申请退回(无需二级审批)
	 * 
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
							+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1, "6");
			pstmt.setString(2, newQualification.getUltimateOpinion()); // 审批意见
			pstmt.setString(3, newQualification.getApprovalStaff()); // 审批人员名称
			pstmt.setString(4, newQualification.getApprovalStaffId()); // 审批人员Id
			pstmt.setDate(5, newQualification.getUltimateDate()); // 审批时间
			pstmt.setString(6, "6"); // 审批结果
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
			pstmt = conn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
							+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
							+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
							+ "legalManIdCard,legaLManDuty,legaManProtitle,address,CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, "");
			// 资质资格序列
			pstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			pstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			pstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			pstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			pstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			pstmt.setString(11, "1");
			// 系统来源
			pstmt.setString(12, "01");
			// 审批状态
			pstmt.setString(13, "6");
			// 审批部门
			pstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			pstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			pstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			pstmt.setString(20, "6");

			// 企业登记注册类型
			pstmt.setInt(21, newQualification.getEconomicNum());
			// 工商营业执照注册号
			pstmt.setString(22, newQualification.getLicenseNum());
			// 法定代表人姓名
			pstmt.setString(23, newQualification.getLegalMan());
			// 法定代表人证件类型
			pstmt.setString(24, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			pstmt.setString(25, newQualification.getLegalManIdCard());
			// 法定代表人职务
			pstmt.setString(26, newQualification.getLegaLManDuty());
			// 法定代表人职称
			pstmt.setString(27, newQualification.getLegaManProtitle());
			// 企业营业地址
			pstmt.setString(28, newQualification.getAddress());

			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 审批通过(经过二级审批进行终审)
	 * 
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification,
			String certifiedCode) {
		//判断是否是升级，如果是升级，需将该资质的低级等级注销掉
		if( "002".equals(newQualification.getAddTypeNum()) ){
			this.cancalQualification(newQualification.getCorpId(),newQualification.getSpecialtyType(),newQualification.getCretLevel());
		}
		try {
			String relationId = UUID.randomUUID().toString();
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
							+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1, "5");
			pstmt.setString(2, newQualification.getUltimateOpinion()); // 审批意见
			pstmt.setString(3, newQualification.getApprovalStaff()); // 审批人员名称
			pstmt.setString(4, newQualification.getApprovalStaffId()); // 审批人员Id
			pstmt.setDate(5, new Date(new java.util.Date().getTime())); // 审批时间
			pstmt.setString(6, "5"); // 审批结果
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
			
			
			
			
			pstmt = conn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,qualifType,"
							+ "approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,ULTIMATEDATE,"
							+ "ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,"
							+ "ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
							+ "legalManIdCard,legaLManDuty,legaManProtitle,address,relationId,CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, certifiedCode);
			// 资质资格序列
			pstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			pstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			pstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			pstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			pstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			pstmt.setString(11, "1");
			// 系统来源
			pstmt.setString(12, "01");
			// 审批状态
			pstmt.setString(13, "5");
			// 审批部门
			pstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			pstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			pstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			pstmt.setString(20, "5");
			// 初审部门
			pstmt.setString(21, newQualification.getTwoApprovalDeptName());
			// 初审部门Id
			pstmt.setString(22, newQualification.getTwoApprovalDept());
			// 初审人员
			pstmt.setString(23, newQualification.getTwoApprovalStaff());
			// 初审人员Id
			pstmt.setString(24, newQualification.getTwoApprovalStaffId());
			// 初审意见
			pstmt.setString(25, newQualification.getOneUltimateOpinion());
			// 初审时间
			pstmt.setDate(26, newQualification.getOneAppDate());
			// 初审结果
			pstmt.setString(27, newQualification.getOneResults());

			// 企业登记注册类型
			pstmt.setInt(28, newQualification.getEconomicNum());
			// 工商营业执照注册号
			pstmt.setString(29, newQualification.getLicenseNum());
			// 法定代表人姓名
			pstmt.setString(30, newQualification.getLegalMan());
			// 法定代表人证件类型
			pstmt.setString(31, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			pstmt.setString(32, newQualification.getLegalManIdCard());
			// 法定代表人职务
			pstmt.setString(33, newQualification.getLegaLManDuty());
			// 法定代表人职称
			pstmt.setString(34, newQualification.getLegaManProtitle());
			// 企业营业地址
			pstmt.setString(35, newQualification.getAddress());
			pstmt.setString(36, relationId);
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into TBCORPCERTINFO(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
							+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
							+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
							+ "ORGANDATE,ENDDATE,ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 资质资格类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, certifiedCode);
			// 资质资格最高等级
			pstmt.setInt(5, newQualification.getCretLevel());
			// 发证机关
//			if (newQualification.getCretGrade().equals("1")) {
//				pstmt.setString(6, "中华人民共和国住房和城乡建设部");
//			} else if (newQualification.getCretGrade().equals("2")) {
//				pstmt.setString(6, "黑龙江省住建厅");
//			} else {
//				pstmt.setString(6, newQualification.getCityName() + "建设局");
//			}
			pstmt.setString(6, "黑龙江省住建厅");
			// 资质类别及等级
			pstmt.setString(7, newQualification.getCertName());
			// 审批部门
			pstmt.setString(8, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(9, newQualification.getApprovalStaff());
			// 审批人Id
			pstmt.setString(10, newQualification.getApprovalStaffId());
			// 审批时间
			pstmt.setDate(11, new Date(new java.util.Date().getTime()));
			// 资质级别
			pstmt.setString(12, newQualification.getCretGrade());
			// 资质资格取得方式
			pstmt.setString(13, newQualification.getAddTypeNum());
			// 工商营业执照注册号
			pstmt.setString(14, newQualification.getLicenseNum());
			// 审批部门名称
			pstmt.setString(15, newQualification.getApprovalDeptName());
			pstmt.setString(16, newQualification.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(17, newQualification.getCityNum());// 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(18, newQualification.getCountyNum());// 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(19, newQualification.getAddress());// 企业营业地址
			pstmt.setString(20, newQualification.getLegalMan());// 法定代表人姓名
			pstmt.setString(21, newQualification.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(22, newQualification.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(23, newQualification.getLegaLManDuty());// 法定代表人职务
			pstmt.setString(24, newQualification.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(25, newQualification.getEconomicNum());// 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setString(26, newQualification.getRegPrin());// 注册资本
			pstmt.setDate(27, new Date(new java.util.Date().getTime()));// 发证日期
			if (newQualification.getAddTypeNum().equals("006")) {
				pstmt.setDate(28, newQualification.getEndDate());// 证书有效截止日期
			} else {
				pstmt.setDate(28, UtilDate.getStringChangeDate());// 证书有效截止日期
			}
			pstmt.setInt(29, 1);// 证书状态
			pstmt.setString(30, newQualification.getCorpId());
			pstmt.setString(31, relationId);
			pstmt.setString(32, "0");
			pstmt.executeUpdate();
			conn.commit();
			this.applyUltimateThroughBase(newQualification, certifiedCode,
					relationId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 基础数据库存入审批信息 (经过二级审批进行终审)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBase(NewQualification newQualification,
			String certifiedCode, String relationId) {

		try {
			baseConn = ConnectionFactory.getBasicConnection();
			baseConn.setAutoCommit(false);
			basePstmt = baseConn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,"
							+ "CERTID,TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,"
							+ "DATASOURCE,qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,"
							+ "APPROVALDEPTNAME,ULTIMATEDATE,ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,"
							+ "TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,"
							+ "licenseNum,legalMan,idCardTypeNum,legalManIdCard,legaLManDuty,legaManProtitle,address,RELATIONID,"
							+ "CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			// 企业名称
			basePstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			basePstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			basePstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			basePstmt.setString(4, certifiedCode);
			// 资质资格序列
			basePstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			basePstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			basePstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			basePstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			basePstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			basePstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			basePstmt.setString(11, "1");
			// 系统来源
			basePstmt.setString(12, "01");
			// 审批状态
			basePstmt.setString(13, "5");
			// 审批部门
			basePstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			basePstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			basePstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			basePstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			basePstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			basePstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			basePstmt.setString(20, "5");
			// 初审部门
			basePstmt.setString(21, newQualification.getTwoApprovalDeptName());
			// 初审部门Id
			basePstmt.setString(22, newQualification.getTwoApprovalDept());
			// 初审人员
			basePstmt.setString(23, newQualification.getTwoApprovalStaff());
			// 初审人员Id
			basePstmt.setString(24, newQualification.getTwoApprovalStaffId());
			// 初审意见
			basePstmt.setString(25, newQualification.getOneUltimateOpinion());
			// 初审时间
			basePstmt.setDate(26, newQualification.getOneAppDate());
			// 初审结果
			basePstmt.setString(27, newQualification.getOneResults());
			// 企业登记注册类型
			basePstmt.setInt(28, newQualification.getEconomicNum());
			// 工商营业执照注册号
			basePstmt.setString(29, newQualification.getLicenseNum());
			// 法定代表人姓名
			basePstmt.setString(30, newQualification.getLegalMan());
			// 法定代表人证件类型
			basePstmt.setString(31, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			basePstmt.setString(32, newQualification.getLegalManIdCard());
			// 法定代表人职务
			basePstmt.setString(33, newQualification.getLegaLManDuty());
			// 法定代表人职称
			basePstmt.setString(34, newQualification.getLegaManProtitle());
			// 企业营业地址
			basePstmt.setString(35, newQualification.getAddress());
			basePstmt.setString(36, relationId);
			basePstmt.executeUpdate();

			basePstmt = baseConn
					.prepareStatement("insert into TBCORPCERTINFO(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
							+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
							+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
							+ "ORGANDATE,ENDDATE,OLDORNEW,DATASOURCE,ISVALID,corpId,RELATIONID,WRITEOFFTYPE,CORPCERTID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			basePstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			basePstmt.setString(2, newQualification.getCorpCode());
			// 资质资格类型
			basePstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			basePstmt.setString(4, certifiedCode);
			// 资质资格最高等级
			basePstmt.setInt(5, newQualification.getCretLevel());
			// 发证机关
//			if (newQualification.getCretGrade().equals("1")) {
//				basePstmt.setString(6, "中华人民共和国住房和城乡建设部");
//			} else if (newQualification.getCretGrade().equals("2")) {
//				basePstmt.setString(6, "黑龙江省住建厅");
//			} else {
//				basePstmt.setString(6, newQualification.getCityName() + "建设局");
//			}
			basePstmt.setString(6, "黑龙江省住建厅");
			// 资质类别及等级
			basePstmt.setString(7, newQualification.getCertName());
			// 审批部门
			basePstmt.setString(8, newQualification.getApprovalDept());
			// 审批人
			basePstmt.setString(9, newQualification.getApprovalStaff());
			// 审批人Id
			basePstmt.setString(10, newQualification.getApprovalStaffId());
			// 审批时间
			basePstmt.setDate(11, new Date(new java.util.Date().getTime()));
			// 资质级别
			basePstmt.setString(12, newQualification.getCretGrade());
			// 资质资格取得方式
			basePstmt.setString(13, newQualification.getAddTypeNum());
			// 工商营业执照注册号
			basePstmt.setString(14, newQualification.getLicenseNum());
			// 审批部门名称
			basePstmt.setString(15, newQualification.getApprovalDeptName());
			basePstmt.setString(16, newQualification.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			basePstmt.setString(17, newQualification.getCityNum());// 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			basePstmt.setString(18, newQualification.getCountyNum());// 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			basePstmt.setString(19, newQualification.getAddress());// 企业营业地址
			basePstmt.setString(20, newQualification.getLegalMan());// 法定代表人姓名
			basePstmt.setString(21, newQualification.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			basePstmt.setString(22, newQualification.getLegalManIdCard());// 法定代表人证件号码
			basePstmt.setString(23, newQualification.getLegaLManDuty());// 法定代表人职务
			basePstmt.setString(24, newQualification.getLegaManProtitle());// 法定代表人职称
			basePstmt.setInt(25, newQualification.getEconomicNum());// 企业登记注册类型(字典表：TBECONTYPEDIC)
			basePstmt.setString(26, newQualification.getRegPrin());// 注册资本
			basePstmt.setDate(27, new Date(new java.util.Date().getTime()));// 发证日期
			if (newQualification.getAddTypeNum().equals("006")) {
				basePstmt.setDate(28, newQualification.getEndDate());// 证书有效截止日期
			} else {
				basePstmt.setDate(28, UtilDate.getStringChangeDate());// 证书有效截止日期
			}
			basePstmt.setString(29, "1");// 0：老数据 1：新数据
			basePstmt.setString(30, "01");// 数据来源系统
			basePstmt.setInt(31, 1);// 证书状态
			basePstmt.setString(32, newQualification.getCorpId());
			basePstmt.setString(33, relationId);
			basePstmt.setString(34, "0");
			basePstmt.executeUpdate();

			// //就位删除老数据
			// if(newQualification.getAddTypeNum().equals("007"))
			// {
			// basePstmt =
			// baseConn.prepareStatement("delete from tbcorpcertdetailinfo where CORPID=? and TITLELEVELNUM=? "
			// + "and TRADEBOUNDNUM=? and OLDORNEW=?");
			// basePstmt.setString(1, newQualification.getCorpId());//企业Id
			// basePstmt.setInt(2, newQualification.getCretLevel());//资质等级
			// basePstmt.setInt(3, newQualification.getSpecialtyType());//资质类别
			// basePstmt.setString(4, "0");//新老数据
			// basePstmt.executeUpdate();
			// }

			baseConn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				baseConn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(baseConn, basePstmt, null);
		}
	}

	/**
	 * 申请退回(经过初审终审退回)
	 * 
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification) {
		try {

			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
							+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1, "6");
			pstmt.setString(2, newQualification.getUltimateOpinion()); // 审批意见
			pstmt.setString(3, newQualification.getApprovalStaff()); // 审批人员名称
			pstmt.setString(4, newQualification.getApprovalStaffId()); // 审批人员Id
			pstmt.setDate(5, new Date(new java.util.Date().getTime())); // 审批时间
			pstmt.setString(6, "6"); // 审批结果
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
			pstmt = conn
					.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
							+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,qualifType,"
							+ "approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,ULTIMATEDATE,"
							+ "ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,"
							+ "ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
							+ "legalManIdCard,legaLManDuty,legaManProtitle,address,CERTDETAILID) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			// 企业名称
			pstmt.setString(1, newQualification.getCorpName());
			// 组织机构代码
			pstmt.setString(2, newQualification.getCorpCode());
			// 企业类型
			pstmt.setInt(3, newQualification.getCretType());
			// 证书编号
			pstmt.setString(4, "");
			// 资质资格序列
			pstmt.setInt(5, newQualification.getCretSequence());
			// 专业类别
			pstmt.setInt(6, newQualification.getSpecialtyType());
			// 资质资格等级
			pstmt.setInt(7, newQualification.getCretLevel());
			// 首次批准资质资格日期
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			// 资质资格取得方式
			pstmt.setString(9, newQualification.getAddTypeNum());
			// 企业id
			pstmt.setString(10, newQualification.getCorpId());
			// 新老数据
			pstmt.setString(11, "1");
			// 系统来源
			pstmt.setString(12, "01");
			// 审批状态
			pstmt.setString(13, "6");
			// 审批部门
			pstmt.setString(14, newQualification.getApprovalDept());
			// 审批人
			pstmt.setString(15, newQualification.getApprovalStaff());
			// 审批意见
			pstmt.setString(16, newQualification.getUltimateOpinion());
			// 审批人Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			// 审批部门名称
			pstmt.setString(18, newQualification.getApprovalDeptName());
			// 审批时间
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			// 审批结果
			pstmt.setString(20, "6");
			// 初审部门
			pstmt.setString(21, newQualification.getTwoApprovalDeptName());
			// 初审部门Id
			pstmt.setString(22, newQualification.getTwoApprovalDept());
			// 初审人员
			pstmt.setString(23, newQualification.getTwoApprovalStaff());
			// 初审人员Id
			pstmt.setString(24, newQualification.getTwoApprovalStaffId());
			// 初审意见
			pstmt.setString(25, newQualification.getOneUltimateOpinion());
			// 初审时间
			pstmt.setDate(26, newQualification.getOneAppDate());
			// 初审结果
			pstmt.setString(27, newQualification.getOneResults());

			// 企业登记注册类型
			pstmt.setInt(28, newQualification.getEconomicNum());
			// 工商营业执照注册号
			pstmt.setString(29, newQualification.getLicenseNum());
			// 法定代表人姓名
			pstmt.setString(30, newQualification.getLegalMan());
			// 法定代表人证件类型
			pstmt.setString(31, newQualification.getIdCardTypeNum());
			// 法定代表人证件号码
			pstmt.setString(32, newQualification.getLegalManIdCard());
			// 法定代表人职务
			pstmt.setString(33, newQualification.getLegaLManDuty());
			// 法定代表人职称
			pstmt.setString(34, newQualification.getLegaManProtitle());
			// 企业营业地址
			pstmt.setString(35, newQualification.getAddress());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * 推送外审
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? , PUSHTWODATE=? where NEWQUALID=?");
			pstmt.setString(1, "2");
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			pstmt.setString(3, newQualification.getNewQualId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	// 查询职称人员
	public int queryCountTitle(String userId) {
		int countTitle = 0;
		try {
			String sql = "select count(*) from v_persontitleinfo where corpId='"
					+ userId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countTitle = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countTitle;
	}

	// 查询注册建造师
	public int queryCountConstructor(String userName) {
		int countConstructor = 0;
		try {
			String sql = "select count(*) from V_CONSTRUCTOR where corpName='"
					+ userName + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}

	// 查询岗位人员
	public int queryCountPositions(String corpName) {
		int countConstructor = 0;
		try {
			String sql = "select count(*) from Position_Certificate where FEntName='"
					+ corpName.trim() + "'";
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}

	// 查询技术工人总数
	public int queryCountSkilledworker(String userId) {
		int countSkilledworker = 0;
		try {
			String sql = "select count(*) from V_SKILLEDWORKER where corpId='"
					+ userId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				countSkilledworker = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countSkilledworker;
	}

	// 资质类型(字典表：TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE")
						.trim());
				dictionaryClass.setCode(rs.getString("code").trim());
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 资质等级(字典表：TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 资质序列(字典表：TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEDIC where code like '104%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("codeName").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 资质专业类别(字典表：TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if (!cretSequenceId.equals("")) {
			String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"
					+ cretSequenceId + "%'";
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setName(rs.getString("SPECIALTYTYPE")
							.trim());
					dictionaryClass.setCode(rs.getString("code").trim());
					list.add(dictionaryClass);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}
		}
		return list;
	}

	// 资质级别(字典表：TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCRETGRADEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// 申请类型(字典表：TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBADDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("GETMETHODNAME").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	/**
	 * 注册建造师
	 */
	public Page queryConstructor(Condition constructocondition) {

		Page page = super.basePagedQuery(constructocondition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Constructor constructor = new Constructor();
					constructor.setPersonId(rs.getString("personId"));// 主键
					constructor.setCertNum(rs.getString("certNum"));
					constructor.setCorpCode(rs.getString("corpCode"));// 组织机构代码
					constructor.setPersonName(rs.getString("personName"));// 人名
					constructor.setSexNum(rs.getString("sexNum"));// 性别编码
					constructor.setSexName(rs.getString("sexName"));// 性别名称
					constructor.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 证件类型
					constructor.setIdCard(rs.getString("idCard"));// 身份证号
					constructor.setEduLevelNum(rs.getString("eduLevelNum"));// 学历code
					constructor.setEduLevelName(rs.getString("eduLevelName"));// 学历名称
					constructor.setDegreeNum(rs.getString("degreeNum"));// 学位code
					constructor.setDegreeName(rs.getString("degreeName"));// 学位名称
					constructor.setSepecialtyTypNum(rs
							.getString("specialtytypnum"));// 注册类型及等级
					constructor.setSepecialtyTypName(rs
							.getString("specialtytypName"));// 注册类型及等级名称
					constructor.setRegTradeTypeName(rs
							.getString("regTradeTypeName"));// 注册专业编号名称
					constructor.setStateName(rs.getString("qstateName"));// 证书状态
					constructor.setCorpName(rs.getString("corpName"));// 企业名称
					constructor.setCallingTypeName(rs
							.getString("CALLINGTYPENAME"));// 所在企业行业类型
					page.getData().add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	// 岗位人员
	public Page queryPositions(Condition constructocondition) {

		Page page = super.positionsPagedQuery(constructocondition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("fPersonID"));
					constructor.setName(rs.getString("fName"));// 姓名
					constructor.setCardId(rs.getString("fCardId"));// 身份证
					constructor.setSex(rs.getString("fSex"));// 性别
					constructor.setEntName(rs.getString("fEntName"));// 公司名称
					constructor.setDuty(rs.getString("fDuty"));// 岗位名称
					constructor.setFCertNumber(rs.getString("FCertNumber"));

					switch (rs.getString("fDuty")) {
					case "安全员":
						constructor.setAnquan(rs.getString("fDuty"));
						break;
					case "标准员":
						constructor.setBiaozhun(rs.getString("fDuty"));
						break;
					case "材料员":
						constructor.setCailiao(rs.getString("fDuty"));
						break;
					case "工程测量员":
						constructor.setCeliang(rs.getString("fDuty"));
						break;
					case "工程造价员":
						constructor.setZaojia(rs.getString("fDuty"));
						break;
					case "工程检测员":
						constructor.setJiance(rs.getString("fDuty"));
						break;
					case "合同员":
						constructor.setHetong(rs.getString("fDuty"));
						break;
					case "机械员":
						constructor.setJixie(rs.getString("fDuty"));
						break;
					case "技术人员":
						constructor.setJishu(rs.getString("fDuty"));
						break;
					case "见证员":
						constructor.setJianzheng(rs.getString("fDuty"));
						break;
					case "劳务员":
						constructor.setLaowu(rs.getString("fDuty"));
						break;
					case "取样员":
						constructor.setQuyang(rs.getString("fDuty"));
						break;
					case "施工现场技术负责人":
						constructor.setFuze(rs.getString("fDuty"));
						break;
					case "施工员":
						constructor.setShigong(rs.getString("fDuty"));
						break;
					case "质量员":
						constructor.setZhiliang(rs.getString("fDuty"));
						break;
					case "资料员":
						constructor.setZiliao(rs.getString("fDuty"));
						break;
					default:
						break;
					}

					page.getData().add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	// 技术工人list
	public Page querySkilledworker(Condition constructocondition) {

		Page page = super.basePagedQuery(constructocondition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Skilledworker constructor = new Skilledworker();
					constructor.setPersonId(rs.getString("personId"));// 注册人员Id
					constructor.setPersonName(rs.getString("personName")); // 注册人员姓名
					constructor.setSexName(rs.getString("sexName"));// 注册人员性别
					constructor.setIdentityCard(rs.getString("IDENTITYCARD"));// 注册人员证件号码
					constructor.setDegreeName(rs.getString("degreeName")); // 注册人员学历
					constructor.setEduLevelName(rs.getString("eduLevelName"));// 注册人员学位
					constructor.setSkilledType(rs.getString("typeName"));// 注册人员工种类型
					constructor.setSkilledLevel(rs.getString("levelName"));// 注册人员工种级别
					constructor.setCorpCode(rs.getString("corpCode"));// 注册人员的企业编码
					constructor.setCorpName(rs.getString("corpName"));// 企业名称
					page.getData().add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	// 职称人员list
	public Page queryTitle(Condition constructocondition) {

		Page page = super.basePagedQuery(constructocondition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Title constructor = new Title();
					constructor.setPersonId(rs.getString("personId"));// 注册人员Id
					constructor.setPersonName(rs.getString("personName")); // 注册人员姓名
					constructor.setSexName(rs.getString("sexName"));// 注册人员性别
					constructor.setIdCard(rs.getString("IDCARD"));// 证件号码
					constructor.setCorpCode(rs.getString("corpCode"));// 注册人员的企业编码
					constructor.setCorpName(rs.getString("corpName"));// 企业名称
					constructor.setTitleName(rs.getString("titleName"));// 职称
					constructor.setTitleMajor(rs.getString("titleMajor"));// 职称专业
					constructor.setTitleLevel(rs.getString("titleLevel"));// 职称级别
					constructor.setGraduatedSchool(rs
							.getString("graduatedSchool"));// 毕业学校
					constructor.setGraduatedDate(rs.getDate("graduatedDate"));// 毕业时间
					constructor.setStudyMajor(rs.getString("studyMajor"));// 所学专业
					page.getData().add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	// 查询升级前,原资质信息
	public NewQualification queryOldCretLevel(NewQualification newQualification) {
		// TODO Auto-generated method stub
		// String sql =
		// "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
		// +
		// "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
		// +
		// "where qualifType=? and corpId=? and cretLevel=? and cretGrade=? and specialtyType=? ";
		// String sql =
		// "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
		// +
		// "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
		// +
		// "where qualifType=? and corpId=? and cretLevel=? and specialtyType=? ";

		int cretLevel = 0;
		if (newQualification.getCretLevel() == 76) {
			cretLevel = 75;
		}
		if (newQualification.getCretLevel() == 77) {
			cretLevel = 76;
		}
		if (newQualification.getCretLevel() == 78) {
			cretLevel = 77;
		}

		String sql = "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
				+ "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
				+ "where qualifType=5 and corpId='"
				+ newQualification.getCorpId()
				+ "' "
				+ "and cretLevel='"
				+ cretLevel
				+ "' "
				+ "and specialtyType='"
				+ newQualification.getSpecialtyType() + "' ";

		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			// pstmt.setString(1, "5");
			// pstmt.setString(2, newQualification.getCorpId());
			// if(newQualification.getCretLevel()==76)
			// {
			// pstmt.setInt(3, 75);
			// }
			// if(newQualification.getCretLevel()==77)
			// {
			// pstmt.setInt(3, 76);
			// }
			// if(newQualification.getCretLevel()==78)
			// {
			// pstmt.setInt(3, 77);
			// }
			// pstmt.setInt(4, newQualification.getSpecialtyType());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				newQualification.setCorpId(rs.getString("corpId"));
				newQualification.setCorpName(rs.getString("corpName"));
				newQualification.setOldCretLevel(rs.getInt("cretLevel"));
				newQualification.setOldCretLevelName(rs
						.getString("cretLevelName"));
				newQualification.setOldCretGrade(rs.getString("cretGrade"));
				newQualification.setOldCretGradeName(rs
						.getString("cretGradeName"));
				newQualification
						.setOldSpecialtyType(rs.getInt("specialtyType"));
				newQualification.setOldSpecialtyTypeName(rs
						.getString("specialtyTypeName"));
				newQualification.setOldCreatDate(rs.getDate("CREATDATE"));
				newQualification.setOldUltimateDate(rs.getDate("ULTIMATEDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return newQualification;
	}

	// 根据ids插叙已提交的资质服务事项
	public List<NewQualification> queryQualification(String[] ids) {
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			for (int i = 0; i < ids.length; i++) {
				int j = 1;
				String sql = "select * from V_QUALIFICATIONAPPLY where newQualId=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(j, ids[i]);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// 主键
					certifiedService.setNewQualId(rs.getString("newQualId")
							.trim());
					// 企业主键
					certifiedService.setCorpId(rs.getString("corpId").trim());
					// 企业名称
					certifiedService.setCorpName(rs.getString("corpName")
							.trim());
					// 企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode")
							.trim());
					// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum")
							.trim());
					// 企业所在省名称
					certifiedService.setProvinceName(rs.getString(
							"provinceName").trim());
					// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum").trim());
					// 企业所在市名称
					certifiedService.setCityName(rs.getString("cityName")
							.trim());
					// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum")
							.trim());
					// 企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName")
							.trim());
					// 申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType")
							.trim());
					// 服务事项主键
					certifiedService.setCertId(rs.getString("certId").trim());
					// 服务事项名称
					certifiedService.setCertName(rs.getString("certName")
							.trim());
					// 资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade")
							.trim());
					// 资质级别名称
					certifiedService.setCretGradeName(rs.getString(
							"cretGradeName").trim());
					// 资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// 资质等级名称
					certifiedService.setCretLevelName(rs.getString(
							"cretLevelName").trim());
					// 资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// 资质序列名称
					certifiedService.setCretSequenceName(rs.getString(
							"cretSequenceName").trim());
					// 资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					// 资质类型名称
					certifiedService.setCretTypeName(rs.getString(
							"cretTypeName").trim());
					// 资质专业类别
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// 资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs.getString(
							"specialtyTypeName").trim());
					// 申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// 资质资格取得方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum")
							.trim());
					// 资质资格取得方式名称
					certifiedService.setAddTypeName(rs.getString("addTypeName")
							.trim());
					// 审批部门Id
					certifiedService.setApprovalDept(rs.getString(
							"approvalDept").trim());
					// 审批部门名称
					certifiedService.setApprovalDeptName(rs.getString(
							"approvalDeptName").trim());
					// 企业登记注册类型
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// 二级审批部门
					certifiedService.setTwoApprovalDept(rs.getString(
							"twoApprovalDept").trim());
					// 二级审批部门名称
					certifiedService.setTwoApprovalDeptName(rs.getString(
							"twoApprovalDeptName").trim());
					// 初审人员
					certifiedService.setTwoApprovalStaff(rs
							.getString("twoApprovalStaff"));
					// 初审人员Id
					certifiedService.setTwoApprovalStaffId(rs
							.getString("twoApprovalStaffId"));
					// 初审时间
					certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
					// 初审状态
					certifiedService.setOneResults(rs.getString("oneResults"));
					// 初审建议
					certifiedService.setOneUltimateOpinion(rs
							.getString("oneUltimateOpinion"));
					// 企业登记注册类型
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// 工商营业执照注册号
					certifiedService.setLicenseNum(rs.getString("licenseNum"));
					// 法定代表人姓名
					certifiedService.setLegalMan(rs.getString("legalMan"));
					// 法定代表人证件类型
					certifiedService.setIdCardTypeNum(rs
							.getString("idCardTypeNum"));
					// 法定代表人证件号码
					certifiedService.setLegalManIdCard(rs
							.getString("legalManIdCard"));
					// 法定代表人职务
					certifiedService.setLegaLManDuty(rs
							.getString("legaLManDuty"));
					// 法定代表人职称
					certifiedService.setLegaManProtitle(rs
							.getString("legaManProtitle"));
					// 企业营业地址
					certifiedService.setAddress(rs.getString("address"));
					// 注册资本
					certifiedService.setRegPrin(rs.getString("REGPRIN"));
					list.add(certifiedService);
					certifiedService.setEndDate(rs.getDate("endDate"));
					certifiedService.setPreCorpCode(rs.getString("preCorpCode"));
					certifiedService.setPreCorpName(rs.getString("preCorpName"));
				}
				j++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询证书编号是否已存在
	 */
	@Override
	public String queryCertId(NewQualification newQualification) {
		String certId = "";
		try {
			String sql = "select CERTID from tbcorpcertinfo where cretgrade=2 and ISVALID=1 "
					+ "and corpId=? ";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newQualification.getCorpId());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				certId = rs.getString("certId");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certId;
	}

	/**
	 * 岗位人员数目
	 */
	@Override
	public List queryPositionsNum(String corpName) {
		// TODO Auto-generated method stub
		String sql = "select * from Position_Certificate where FEntName = ? and fisdeleted = '0'";
		List<Positions> list = new ArrayList<Positions>();

		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Positions constructor = new Positions();
					switch (rs.getString("fDuty")) {
					case "安全员":
						constructor.setAnquan(rs.getString("fDuty"));
						break;
					case "标准员":
						constructor.setBiaozhun(rs.getString("fDuty"));
						break;
					case "材料员":
						constructor.setCailiao(rs.getString("fDuty"));
						break;
					case "工程测量员":
						constructor.setCeliang(rs.getString("fDuty"));
						break;
					case "工程造价员":
						constructor.setZaojia(rs.getString("fDuty"));
						break;
					case "工程检测员":
						constructor.setJiance(rs.getString("fDuty"));
						break;
					case "合同员":
						constructor.setHetong(rs.getString("fDuty"));
						break;
					case "机械员":
						constructor.setJixie(rs.getString("fDuty"));
						break;
					case "技术人员":
						constructor.setJishu(rs.getString("fDuty"));
						break;
					case "见证员":
						constructor.setJianzheng(rs.getString("fDuty"));
						break;
					case "劳务员":
						constructor.setLaowu(rs.getString("fDuty"));
						break;
					case "取样员":
						constructor.setQuyang(rs.getString("fDuty"));
						break;
					case "施工现场技术负责人":
						constructor.setFuze(rs.getString("fDuty"));
						break;
					case "施工员":
						constructor.setShigong(rs.getString("fDuty"));
						break;
					case "质量员":
						constructor.setZhiliang(rs.getString("fDuty"));
						break;
					case "资料员":
						constructor.setZiliao(rs.getString("fDuty"));
						break;
					default:
						break;
					}

					list.add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询重复的技术工人数
	 */
	@Override
	public String querySkillworkerNum(String corpName) {
		// TODO Auto-generated method stub
		String sql1 = "select * from TBSkilledworker where corpName = '"
				+ corpName + "'";
		String idcard = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String s = "'" + rs.getString("IDENTITYCARD") + "'";
				idcard = idcard + s + ",";
			}
			if (idcard.length() > 0) {
				idcard = idcard.substring(0, idcard.length() - 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return idcard;
	}

	/**
	 * 查询重复的职称人员数目
	 */
	@Override
	public String queryTitleNum(String corpName) {
		// TODO Auto-generated method stub
		String sql1 = "select * from TBREGTITLEPERSON where corpName = '"
				+ corpName + "'";
		String idcard = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String s = "'" + rs.getString("IDCARD") + "'";
				idcard = idcard + s + ",";
			}
			if (idcard.length() > 0) {
				idcard = idcard.substring(0, idcard.length() - 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return idcard;
	}

	/**
	 * 查询重复的岗位人员数目
	 */
	@Override
	public String queryPosNum(String corpName) {
		// TODO Auto-generated method stub
		String sql = "select * from Position_Certificate where fentname ='"
				+ corpName + "' and fisdeleted = '0'";
		String idcard = "";
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String s = "'" + rs.getString("FCardId") + "'";
				idcard = idcard + s + ",";
			}
			if (idcard.length() > 0) {
				idcard = idcard.substring(0, idcard.length() - 1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return idcard;
	}

	/**
	 * 重复技术人员输出
	 */
	@Override
	public Page skillworkerNum(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Skilledworker skilledworder = new Skilledworker();
					skilledworder.setPersonId(rs.getString("personId")); // 主键
					skilledworder.setPersonName(rs.getString("personName")); // 人名
					skilledworder.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
					skilledworder.setIdentityCard(rs.getString("identityCard")); // 身份证（必须18位）
					skilledworder.setSkilledType(rs.getString("typeName")); // 技术人员种类（字典表：TBSKILLEDWORkERTYPE）
					skilledworder.setSkilledLevel(rs.getString("levelName")); // 技术人员级别（字典表：TBSKILLEDWORKERLEVEL）
					skilledworder.setMobile(rs.getString("mobile")); // 手机号
					page.getData().add(skilledworder);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 重复职称人员输出
	 */
	@Override
	public Page titleNum(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Title title = new Title();
					title.setPersonId(rs.getString("personid")); // 主键
					title.setPersonName(rs.getString("personName")); // 人名
					title.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
					title.setIdCardTypeName(rs.getString("idCardTypeName")); // 证件类型(字典表：TBIDCARDTYPEDIC)
					title.setIdCard(rs.getString("idCard")); // 身份证号(必须为18位)
					title.setMobile(rs.getString("mobile")); // 手机号码
					title.setTitleName(rs.getString("titleName")); // 职称
					title.setTitleMajor(rs.getString("titleMajor")); // 职称专业
					title.setTitleLevel(rs.getString("titleLevel")); // 职称等级
					title.setGraduatedSchool(rs.getString("graduatedSchool")); // 毕业学校
					title.setGraduatedDate(rs.getDate("graduatedDate")); // 毕业时间
					title.setStudyMajor(rs.getString("studyMajor")); // 所学专业
					page.getData().add(title);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * 重复岗位人员输出
	 */
	@Override
	public Page posNum(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.positionsPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Positions constructor = new Positions();
					constructor.setPersonId(rs.getString("fPersonID"));
					constructor.setName(rs.getString("fName"));// 姓名
					constructor.setCardId(rs.getString("fCardId"));// 身份证
					constructor.setSex(rs.getString("fSex"));// 性别
					constructor.setEntName(rs.getString("fEntName"));// 公司名称
					constructor.setDuty(rs.getString("fDuty"));// 岗位名称
					page.getData().add(constructor);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

}
