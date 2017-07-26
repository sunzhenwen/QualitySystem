package com.tj.jst.outside.businessReport.newQualification.dao;

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

/**
 * ���������ϱ�
 * 
 * @author Administrator
 *
 */
public class NewQualificationDaoImpl extends BaseDao implements
		INewQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	/**
	 * ���������ʷ��������ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check,
			String corpCode) {
		// check:1����;2ʡ��;3����;
		String sql = "";
		if (check.equals("1")) {
			sql = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type=? and LOWESTTYPE=1 "
					+ "and SPECIALTYTYPE in ("
					+ querycertNumber(corpCode, "2")
					+ " 10402030,10402033,10402034,10402032)";

		} else if (check.equals("2")) {
			sql = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type=? and LOWESTTYPE=1 "
					+ "and SPECIALTYTYPE in ("
					+ querycertNumber(corpCode, "3")
					+ "10402060,10402056,10402050,10402044,10402043,10402042,10402040,10402038,10402037,10402035,10402031,10402029,10402028,10402081,10402027,10402026,10402004,10402003,10402013,10402011,10402023,10401011,10401005,10401004,10401002)";
		} else if (check.equals("3")) {
			sql = "select * from V_SERVICECERTDETAIL where CRETGRADE=? and type=? and LOWESTTYPE=1 ";
		}
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, check);
			pstmt.setString(2, "0");
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
	 * �����������ʷ��������ѯҳ��
	 * 
	 * @author �ɽ
	 * @return
	 * @throws Exception
	 */
	public List<CertifiedService> queryCertifiedService(String check,
			String corpid, String addTypeNum) {
		// check:1����;2ʡ��;3����;
		String sql = " select * "
				+ " from V_SERVICECERTDETAIL "
				+ " where CRETGRADE=? and type=? "
				//+ " and CRETSEQUENCE in (select tradetypenum from tbcorpcertdetailinfo where corpid=?) "
				+ " and SPECIALTYTYPE not in (select tradeboundnum from tbcorpcertdetailinfo where corpid=? and certid is not null ) ";
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, check);
			pstmt.setString(2, "0");
			//pstmt.setString(3, corpid);
			pstmt.setString(3, corpid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
	public List<NewQualification> queryCertifieds(String[] certIds) {
		String sql = "select * from V_SERVICECERTDETAIL where CERTID=?";
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < certIds.length; i++) {
				pstmt.setString(1, certIds[i]);
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

	/**
	 * ���ʷ��������ύ
	 * 
	 * @return
	 * @throws Exception
	 */
	public String submitCertifiedService(List<NewQualification> list) {
		String sql = "insert into TBQUALIFICATIONAPPLY(CORPID,CORPNAME,CORPCODE,PROVINCENUM,PROVINCENAME,"
				+ "CITYNUM,CITYNAME,COUNTYNUM,COUNTYNAME,QUALIFTYPE,CERTID,CERTNAME,CRETTYPE,CRETLEVEL,CRETSEQUENCE,"
				+ "SPECIALTYTYPE,CRETGRADE,APPROVALDEPT,CREATDATE,NEWQUALID,ADDTYPENUM,TWOAPPROVALDEPT,APPROVALDEPTNAME,"
				+ "TWOAPPROVALDEPTNAME,SPARE1,EconomicNum,ADDRESS,LICENSENUM,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,"
				+ "LEGALMANDUTY,LEGAMANPROTITLE,REGPRIN,ASSETS,MACHINERY) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		String message = "";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i = 0; i < list.size(); i++) {
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
	 * ��ѯ��ҵ�������������list
	 * 
	 * @param corpCode
	 * @return
	 */
	public String querycertNumber(String corpCode, String cretGrade) {
		String list = "";
		String sql = "select tradeboundnum,titlelevelNum from tbcorpcertdetailinfo where corpCode='"
				+ corpCode + "' and certId is not null";
		String qsql = "select ismax,specialtytype from tbCertifiedService where specialtytype=? and cretlevel=? and cretgrade='"
				+ cretGrade + "'";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qconn = ConnectionFactory.getQualityConnection();
				qpstmt = qconn.prepareStatement(qsql);
				qpstmt.setString(1, rs.getString("tradeboundnum"));
				qpstmt.setString(2, rs.getString("titlelevelNum"));
				qrs = qpstmt.executeQuery();
				while (qrs.next()) {
					if (qrs.getString("ismax").equals("1")) {
						list += qrs.getString("specialtytype") + ",";
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
		}
		return list;
	}

	@Override
	public Boolean getBasicInfo(NewQualification newQualification, String corpId) {
		Boolean isEmpty = false ;
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
				   rs.getString("assets") != null && rs.getDouble("assets")>0 && !"".equals(rs.getString("assets")) &&
				   corpbirthdate != null && !"9999-12-31".equals(corpbirthdate) && !"".equals(corpbirthdate)){
					
					newQualification.setCorpId(rs.getString("corpId"));
					newQualification.setCorpCode(rs.getString("corpCode"));
					newQualification.setCorpName(rs.getString("corpName"));
					newQualification.setLicenseNum(rs.getString("licenseNum"));
					newQualification.setAddress(rs.getString("address")); 
					newQualification.setLegalMan(rs.getString("legalMan"));               //����
					newQualification.setLegalManIdCard(rs.getString("legalManIdCard"));   //֤���ţ����֤�ȣ�
					newQualification.setEconomicNum(rs.getInt("economicNum"));            //��������
					newQualification.setRegPrin(rs.getString("regPrin"));                 //ע���ʱ��� 
					newQualification.setAssets(rs.getString("assets"));                   //���ʲ�
					newQualification.setLegaManProtitle(rs.getString("legaManProtitle"));               //���˴���ְ��
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
