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
 * ���ʾ�λ�����ϱ�
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
				separateQualification.setRelationId(rs.getString("relationId")); // ������������
				separateQualification.setCertName(rs.getString("certName")); // ������������
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
	 * ��ѯ��������ҵ��������Ϣ
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
					// ������������
					certifiedService.setCertId(rs.getString("certId"));
					// ������������
					certifiedService.setCertName(rs.getString("certName"));
					// ���ʼ���
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					// ���ʼ�������
					certifiedService.setCretGradeName(rs
							.getString("cretGradeName"));
					// ���ʵȼ�
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// ���ʵȼ�����
					certifiedService.setCretLevelName(rs
							.getString("cretLevelName"));
					// ��������
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// ������������
					certifiedService.setCretSequenceName(rs
							.getString("cretSequenceName"));
					// ��������
					certifiedService.setCretType(rs.getInt("cretType"));
					// ������������
					certifiedService.setCretTypeName(rs
							.getString("cretTypeName"));
					// ����רҵ���
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// ����רҵ�������
					certifiedService.setSpecialtyTypeName(rs
							.getString("specialtyTypeName"));
					// ��������
					certifiedService.setApprovalDept(rs
							.getString("approvalDept"));
					// ������������
					certifiedService.setApprovalDeptName(rs
							.getString("approvalDeptName"));
					// ��������������
					certifiedService.setTwoApprovalDept(rs
							.getString("twoApprovalDept"));
					// ������������������
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
				// ��ѯ�Ƿ����ظ����
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
					message = "����ʧ�ܣ�������ͬ����������ڣ�" ;
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
					pstmt.setInt(26, list.get(i).getEconomicNum());// ��ҵ�Ǽ�ע������
					pstmt.setString(27, list.get(i).getAddress());// ��ҵӪҵ��ַ
					pstmt.setString(28, list.get(i).getLicenseNum());// ����Ӫҵִ�պ�
					pstmt.setString(29, list.get(i).getLegalMan());// ��������������
					pstmt.setString(30, list.get(i).getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
					pstmt.setString(31, list.get(i).getLegalManIdCard());// ����������֤������
					pstmt.setString(32, list.get(i).getLegaLManDuty());// ����������ְ��
					pstmt.setString(33, list.get(i).getLegaManProtitle());// ����������ְ��
					// ע���ʱ�
					pstmt.setString(34, list.get(i).getRegPrin());
					pstmt.setString(35, list.get(i).getAssets()); // ���ʲ�
					pstmt.setString(36, list.get(i).getMachinery()); // ��е�豸
					pstmt.setString(37, separateQualification.get(i).getPreCorpCode()); // ��������˾����֯��������֤��
					pstmt.setString(38, separateQualification.get(i).getPreCorpName()); // ��������˾������
					pstmt.setDate(39, separateQualification.get(i).getEndDate()); // ��������˾���ʵ���Ч��
					
					pstmt.addBatch();
				}
			}
			pstmt.executeBatch();
			conn.commit();
			int check = pstmt.SUCCESS_NO_INFO;
			// ���ִ�гɹ�
			if (check == -2) {
				message = "�����ύ�ɹ�������������ѯ�в�ѯ�ύ״̬��";
			} else {
				message = "�����ύʧ�ܣ�";
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
