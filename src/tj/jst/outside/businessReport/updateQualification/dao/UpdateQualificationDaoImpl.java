package com.tj.jst.outside.businessReport.updateQualification.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ���������ϱ�
 * 
 * @author DarkFlameMaster
 *
 */
public class UpdateQualificationDaoImpl implements IUpdateQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	Connection sconn = null;
	PreparedStatement spstmt = null;
	ResultSet srs = null;

	/**
	 * ���ʷ��������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CertifiedService> queryCertifiedService(String check,
			String corpId) {
		// TODO Auto-generated method stub
		// ����ж�ȡ�����ʵ�����ѡ��
		List<CertifiedService> list = new ArrayList<CertifiedService>();
		try {
			// �ӻ������ݿ��в�����Ӧ��˾����Ϣ
			String sql1 = "select * from TBCORPCERTDETAILINFO where corpId =? and OLDORNEW = 1 and CERTTRADESTATUSNUM = 001 and (QUALIFTYPE = 5 or QUALIFTYPE = 9)";
			qconn = ConnectionFactory.getQualityConnection();
			qpstmt = qconn.prepareStatement(sql1);
			qpstmt.setString(1, corpId);
			qrs = qpstmt.executeQuery();
			// ��ѯ�ɹ����ٴ��������ݿ���Ѱ�Ҳ��ҵ��Ĺ�˾��ӵ�е�������Ϣ
			while (qrs.next()) {
				String sql = "select * from V_SERVICECERTDETAIL where type=? and specialtytype = ? and cretLevel = ? and CRETGRADE = ?"; // isUpgrade:�ܷ�����
																																			// 1����
																																			// 2����
				int tradeBoundNum = qrs.getInt("TRADEBOUNDNUM");
				int qlevel = qrs.getInt("TITLELEVELNUM");
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "0"); // ״̬ �� 0������ 1����ɾ��
				pstmt.setInt(2, tradeBoundNum); // ���ݹ�˾��ӵ�е�������ѡ���������������
				pstmt.setInt(3, qlevel); // ��ѯ��˾��ӵ�еĸ����ʵĵȼ���������Ϣ
				pstmt.setString(4, check);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					CertifiedService certifiedService = new CertifiedService();
					certifiedService.setApprovalCondition(rs
							.getString("certName"));
					// ��ǰ������һ�����ʲ�ѯ
					String sql2 = "select * from V_SERVICECERTDETAIL where CRETLEVEL = ? and specialtytype = ?";
					sconn = ConnectionFactory.getQualityConnection();
					spstmt = sconn.prepareStatement(sql2);
					spstmt.setInt(1, qlevel + 1);
					spstmt.setInt(2, tradeBoundNum);
					srs = spstmt.executeQuery();
					if (srs.next()) {
						certifiedService.setCertId(srs.getString("certId")); // ������������
						certifiedService.setCertName(srs.getString("certName")); // ������������
					}
					list.add(certifiedService);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(sconn, spstmt, srs);

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
	public List<NewQualification> queryCertifieds(String[] certIds) {
		// TODO Auto-generated method stub
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
	@Override
	public String submitCertifiedService(List<NewQualification> list) {
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
