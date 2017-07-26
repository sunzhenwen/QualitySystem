package com.tj.jst.outside.businessReport.separateQualification.dao;

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
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.businessReport.perchQualification.model.PerchQualification;
import com.tj.jst.outside.businessReport.separateQualification.model.SeparateQualification;

/**
 * 资质就位申请上报
 * 
 * @author DarkFlameMaster
 *
 */
public class SeparateQualificationDaoImpl extends BaseDao implements ISeparateQualificationDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;
	
	@Override
	public List<SeparateQualification> queryCorpQualification(String queryCorp) {
		// TODO Auto-generated method stub
		List<SeparateQualification> list = new ArrayList<SeparateQualification>();
		String sql = "select * from TBCORPCERTINFO where ( corpname = ? or corpcode = ? ) " ;
		try {
			
			conn  = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, queryCorp);
			pstmt.setString(2, queryCorp);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SeparateQualification separateQualification = new SeparateQualification();
				separateQualification.setRelationId(rs.getString("relationId")); // 服务事项主键
				separateQualification.setCertName(rs.getString("certName")); // 服务事项名称
				separateQualification.setCorpName(rs.getString("corpName"));
				list.add(separateQualification);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cuole ");
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * 查询被分立企业的资质信息
	 */
	@Override
	public List<SeparateQualification> queryEXCorpQualification(
			String[] relationIds) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCORPCERTINFO where relationId = ? " ;
		List<SeparateQualification> list = new ArrayList<SeparateQualification>();
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < relationIds.length; i++) {
				pstmt.setString(1, relationIds[i]);
				rs = pstmt.executeQuery();
				if(rs.next()){
					SeparateQualification separateQualification = new SeparateQualification() ;
					separateQualification.setPreCorpName(rs.getString("corpName"));
					separateQualification.setPreCorpCode(rs.getString("corpCode"));
					separateQualification.setCertName(rs.getString("certName"));
					separateQualification.setCretGrade(rs.getString("cretGrade"));
					separateQualification.setEndDate(rs.getDate("endDate"));
					list.add(separateQualification);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<NewQualification> queryCertifieds(
			List<SeparateQualification> separateQualification) {
		// TODO Auto-generated method stub
		String sql = "select * from V_SERVICECERTDETAIL where certName=?";
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < separateQualification.size(); i++) {
				pstmt.setString(1, separateQualification.get(i).getCertName());
				rs = pstmt.executeQuery();
				if (rs.next()) {
					NewQualification certifiedService = new NewQualification();
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

	@Override
	public String submitCertified(List<NewQualification> list,List<SeparateQualification> separateQualification) {
		// TODO Auto-generated method stub
		String sql = "insert into TBQUALIFICATIONAPPLY(CORPID,CORPNAME,CORPCODE,PROVINCENUM,PROVINCENAME,"
				+ "CITYNUM,CITYNAME,COUNTYNUM,COUNTYNAME,QUALIFTYPE,CERTID,CERTNAME,CRETTYPE,CRETLEVEL,CRETSEQUENCE,"
				+ "SPECIALTYTYPE,CRETGRADE,APPROVALDEPT,CREATDATE,NEWQUALID,ADDTYPENUM,TWOAPPROVALDEPT,APPROVALDEPTNAME,"
				+ "TWOAPPROVALDEPTNAME,SPARE1,EconomicNum,ADDRESS,LICENSENUM,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ "LEGALMANDUTY,LEGAMANPROTITLE,REGPRIN,ASSETS,MACHINERY,preCorpCode,preCorpName,endDate) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String message = "";
		try {
			conn = ConnectionFactory.getQualityConnection();
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
				qconn = ConnectionFactory.getQualityConnection();
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
					pstmt.setString(37, separateQualification.get(i).getPreCorpCode()); // 被分立公司的组织机构代码证号
					pstmt.setString(38, separateQualification.get(i).getPreCorpName()); // 被分立公司的名称
					pstmt.setDate(39, separateQualification.get(i).getEndDate()); // 被分立公司资质的有效期
					
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
	
}
