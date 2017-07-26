package com.tj.jst.outside.businessReport.perchQualification.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;

/**
 * 资质就位申请上报
 * 
 * @author DarkFlameMaster
 *
 */
public class PerchQualificationDaoImpl extends BaseDao implements
		IPerchQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	/**
	 * 就位资质服务事项查询页面
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CertifiedService> queryCertifiedService(String check,
			String corpId) {
		// TODO Auto-generated method stub
		List<CertifiedService> list = new ArrayList<CertifiedService>();

		try {
			// 先从基础数据库中获取公司的信息
			String sql1 = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type=? ";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, check); // 资质级别 1：国家 2：省 3：地市
			pstmt.setString(2, "0"); // 状态 ： 0：再用 1：已删除
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 查询成功，则输出相应信息。
				CertifiedService certifiedService = new CertifiedService();
				certifiedService.setCertId(rs.getString("certId")); // 服务事项主键
				certifiedService.setCertName(rs.getString("certName")); // 服务事项名称
				list.add(certifiedService);
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
	 * 根据传入的ids查询资质服务事项信息
	 * 
	 * @param certIds
	 * @return
	 */
	@Override
	public List<PerchQualification> queryCertifieds(String[] certIds) {
		String sql = "select * from V_SERVICECERTDETAIL where CERTID=?";
		List<PerchQualification> list = new ArrayList<PerchQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < certIds.length; i++) {
				pstmt.setString(1, certIds[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					PerchQualification certifiedService = new PerchQualification();
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
					list.add(certifiedService);
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
	 * 资质服务事项提交
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public String submitCertifiedService(List<PerchQualification> list) {
		// TODO Auto-generated method stub
		String sql = "insert into TBQUALIFICATIONAPPLY(CORPID,CORPNAME,CORPCODE,PROVINCENUM,PROVINCENAME,"
				+ "CITYNUM,CITYNAME,COUNTYNUM,COUNTYNAME,QUALIFTYPE,CERTID,CERTNAME,CRETTYPE,CRETLEVEL,CRETSEQUENCE,"
				+ "SPECIALTYTYPE,CRETGRADE,APPROVALDEPT,CREATDATE,NEWQUALID,ADDTYPENUM,TWOAPPROVALDEPT,APPROVALDEPTNAME,"
				+ "TWOAPPROVALDEPTNAME,SPARE1,EconomicNum,ADDRESS,LICENSENUM,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ "LEGALMANDUTY,LEGAMANPROTITLE,REGPRIN,ASSETS,MACHINERY) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String message = "";
		try {
			conn = ConnectionFactory.getQualityConnection();
			qconn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i = 0; i < list.size(); i++) { 
				// 查询是否有重复事项。
				String qsql = "select * from TBQUALIFICATIONAPPLY where corpName='"
						+ list.get(i).getCorpName()
						+ "' and certName='"
						+list.get(i).getCertName()+
						"' and (QUALIFTYPE='a' or QUALIFTYPE = '1' or QUALIFTYPE = '3' or QUALIFTYPE = '5' or QUALIFTYPE = '7' or QUALIFTYPE = '9') " +
						" and ADDTYPENUM in (" +
						" select code from tbaddtypedic ) ";
				System.out.println("测试重复申请qsql = "+qsql);
				qpstmt = qconn.prepareStatement(qsql);
				qrs = qpstmt.executeQuery();
				if (qrs.next()) {
					message = "申请失败！已有相同资质申请存在！" ;
					pstmt.executeBatch(); 
					conn.commit();
					return message ;
				} else {
					String NEWQUALID = UUID.randomUUID().toString();
					pstmt.setString(1, list.get(i).getCorpId());
					pstmt.setString(2, list.get(i).getCorpName());
					pstmt.setString(3, list.get(i).getCorpCode());
					pstmt.setString(4, list.get(i).getProvinceNum());
					pstmt.setString(5, list.get(i).getProvinceName());
					pstmt.setString(6, list.get(i).getCityNum());
					pstmt.setString(7, list.get(i).getCityName());
					pstmt.setString(8, list.get(i).getCountyNum());
					pstmt.setString(9, list.get(i).getCountyName());
					pstmt.setString(10, list.get(i).getQualifType());
					pstmt.setString(11, list.get(i).getCertId());
					pstmt.setString(12, list.get(i).getCertName());
					pstmt.setInt(13, list.get(i).getCretType());
					pstmt.setInt(14, list.get(i).getCretLevel());
					pstmt.setInt(15, list.get(i).getCretSequence());
					pstmt.setInt(16, list.get(i).getSpecialtyType());
					pstmt.setString(17, list.get(i).getCretGrade());
					pstmt.setString(18, list.get(i).getApprovalDept());
					pstmt.setDate(19, new Date(new java.util.Date().getTime()));
					pstmt.setString(20, NEWQUALID);
					pstmt.setString(21, list.get(i).getAddTypeNum());
					pstmt.setString(22, list.get(i).getTwoApprovalDept());
					pstmt.setString(23, list.get(i).getApprovalDeptName());
					pstmt.setString(24, list.get(i).getTwoApprovalDeptName());
					pstmt.setString(25, list.get(i).getSpare1());
					pstmt.setInt(26, list.get(i).getEconomicNum());// 企业登记注册类型
					pstmt.setString(27, list.get(i).getAddress());// 企业营业地址
					pstmt.setString(28, list.get(i).getLicenseNum());// 工商营业执照号
					pstmt.setString(29, list.get(i).getLegalMan());// 法定代表人姓名
					pstmt.setString(30, list.get(i).getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
					pstmt.setString(31, list.get(i).getLegalManIdCard());// 法定代表人证件号码
					pstmt.setString(32, list.get(i).getLegaLManDuty());// 法定代表人职务
					pstmt.setString(33, list.get(i).getLegaManProtitle());// 法定代表人职称
					// 注册资本
					pstmt.setString(34, list.get(i).getRegPrin());
					pstmt.setString(35, list.get(i).getAssets()); // 净资产
					pstmt.setString(36, list.get(i).getMachinery()); // 机械设备
					pstmt.addBatch();
				}
			}
			pstmt.executeBatch();
			conn.commit();
			int check = pstmt.SUCCESS_NO_INFO;
			// 如果执行成功
			if (check == -2) {
				message = "申请提交成功！可在审批查询中查询提交状态！";
			} else {
				message = "申请提交失败！";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
		}
		return message;
	}

	/**
	 * 将数据直接从基础表中取出并赋值
	 * @return 
	 */
	@Override
	public Boolean getBasicInfo(PerchQualification perchQualification,String corpId) {
		// TODO Auto-generated method stub
		
		Boolean isEmpty = false ; //判断企业基本信息是否有空的，false没有空的，true有空的
		String sql = " select * from tbcorpbasicinfo where corpId = '"+corpId+"' " ;
		System.out.println("sql = " + sql);
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				//corpId corpName corpCode licenseNum address legalman legalmanidcard economicnum regprin
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String corpbirthdate = sdf.format(rs.getDate("corpbirthdate"));
				if(
				   rs.getString("corpId") != null && !"-1".equals(rs.getString("corpId")) && !"".equals(rs.getString("corpId")) &&
				   rs.getString("corpName") != null && !"-1".equals(rs.getString("corpName")) && !"".equals(rs.getString("corpName")) &&
				   rs.getString("corpCode") != null && !"-1".equals(rs.getString("corpCode")) && !"".equals(rs.getString("corpCode")) &&
				   rs.getString("licenseNum") != null && !"-1".equals(rs.getString("licenseNum")) && !"".equals(rs.getString("licenseNum")) &&
				   rs.getString("address") != null && !"-1".equals(rs.getString("address")) && !"".equals(rs.getString("address")) &&
				   rs.getString("legalman") != null && !"-1".equals(rs.getString("legalman")) && !"".equals(rs.getString("legalman")) &&
				   rs.getString("legalmanidcard") != null && !"-1".equals(rs.getString("legalmanidcard")) && !"".equals(rs.getString("legalmanidcard")) &&
				   rs.getInt("economicnum") > 0 && rs.getInt("economicnum") != 0 &&
				   rs.getString("regprin") != null && !"-1".equals(rs.getString("regprin")) && !"".equals(rs.getString("regprin")) &&
				   rs.getString("assets") != null && !"".equals(rs.getString("assets")) &&
				   corpbirthdate != null && !"9999-12-31".equals(corpbirthdate) && !"".equals(corpbirthdate)){
					
					perchQualification.setCorpId(rs.getString("corpId"));
					perchQualification.setCorpCode(rs.getString("corpCode"));
					perchQualification.setCorpName(rs.getString("corpName"));
					perchQualification.setLicenseNum(rs.getString("licenseNum"));
					perchQualification.setAddress(rs.getString("address")); 
					perchQualification.setLegalMan(rs.getString("legalMan"));               //法人
					perchQualification.setLegalManIdCard(rs.getString("legalManIdCard"));   //证件号（身份证等）
					perchQualification.setEconomicNum(rs.getInt("economicNum"));            //经济类型
					perchQualification.setRegPrin(rs.getString("regPrin"));                 //注册资本金 
					perchQualification.setAssets(rs.getString("assets"));                   //总资产
					perchQualification.setLegaManProtitle(rs.getString("legamanprotitle"));               //法人代表职称
					isEmpty = false ;
				}else {
					isEmpty = true ;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return isEmpty ;
				
		
	}

}
