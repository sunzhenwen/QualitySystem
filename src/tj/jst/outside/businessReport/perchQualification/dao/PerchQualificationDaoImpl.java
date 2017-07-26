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
 * ���ʾ�λ�����ϱ�
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
	 * ��λ���ʷ��������ѯҳ��
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
			// �ȴӻ������ݿ��л�ȡ��˾����Ϣ
			String sql1 = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type=? ";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, check); // ���ʼ��� 1������ 2��ʡ 3������
			pstmt.setString(2, "0"); // ״̬ �� 0������ 1����ɾ��
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// ��ѯ�ɹ����������Ӧ��Ϣ��
				CertifiedService certifiedService = new CertifiedService();
				certifiedService.setCertId(rs.getString("certId")); // ������������
				certifiedService.setCertName(rs.getString("certName")); // ������������
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
	 * ���ݴ����ids��ѯ���ʷ���������Ϣ
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

	/**
	 * ���ʷ��������ύ
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
				// ��ѯ�Ƿ����ظ����
				String qsql = "select * from TBQUALIFICATIONAPPLY where corpName='"
						+ list.get(i).getCorpName()
						+ "' and certName='"
						+list.get(i).getCertName()+
						"' and (QUALIFTYPE='a' or QUALIFTYPE = '1' or QUALIFTYPE = '3' or QUALIFTYPE = '5' or QUALIFTYPE = '7' or QUALIFTYPE = '9') " +
						" and ADDTYPENUM in (" +
						" select code from tbaddtypedic ) ";
				System.out.println("�����ظ�����qsql = "+qsql);
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
					pstmt.setString(30, list.get(i).getIdCardTypeNum());// ����������֤������(�ֵ����TBIDCARDTYPEDIC)
					pstmt.setString(31, list.get(i).getLegalManIdCard());// ����������֤������
					pstmt.setString(32, list.get(i).getLegaLManDuty());// ����������ְ��
					pstmt.setString(33, list.get(i).getLegaManProtitle());// ����������ְ��
					// ע���ʱ�
					pstmt.setString(34, list.get(i).getRegPrin());
					pstmt.setString(35, list.get(i).getAssets()); // ���ʲ�
					pstmt.setString(36, list.get(i).getMachinery()); // ��е�豸
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

	/**
	 * ������ֱ�Ӵӻ�������ȡ������ֵ
	 * @return 
	 */
	@Override
	public Boolean getBasicInfo(PerchQualification perchQualification,String corpId) {
		// TODO Auto-generated method stub
		
		Boolean isEmpty = false ; //�ж���ҵ������Ϣ�Ƿ��пյģ�falseû�пյģ�true�пյ�
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
					perchQualification.setLegalMan(rs.getString("legalMan"));               //����
					perchQualification.setLegalManIdCard(rs.getString("legalManIdCard"));   //֤���ţ�����֤�ȣ�
					perchQualification.setEconomicNum(rs.getInt("economicNum"));            //��������
					perchQualification.setRegPrin(rs.getString("regPrin"));                 //ע���ʱ��� 
					perchQualification.setAssets(rs.getString("assets"));                   //���ʲ�
					perchQualification.setLegaManProtitle(rs.getString("legamanprotitle"));               //���˴���ְ��
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