package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * �����������ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class FloorApprovalDaoImpl extends BaseDao implements IFloorApprovalDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ����
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// ����
					certifiedService.setNewQualId(rs.getString("newQualId"));
					// ��ҵ����
					certifiedService.setCorpId(rs.getString("corpId"));
					// ��ҵ����
					certifiedService.setCorpName(rs.getString("corpName"));
					// ��ҵסַ��������֤
					certifiedService.setCorpCode(rs.getString("corpCode"));
					// ��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					certifiedService
							.setProvinceNum(rs.getString("provinceNum"));
					// ��ҵ����ʡ����
					certifiedService.setProvinceName(rs
							.getString("provinceName"));
					// ��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					// ��ҵ����������
					certifiedService.setCityName(rs.getString("cityName"));
					// ��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					// ��ҵ����������
					certifiedService.setCountyName(rs.getString("countyName"));
					// ����״̬(1��������)
					certifiedService.setQualifType(rs.getString("qualifType"));
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
					// ��������
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// ����ȡ�÷�ʽ��ʽ
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					// ����ȡ�÷�ʽ����
					certifiedService
							.setAddTypeName(rs.getString("addTypeName"));
					certifiedService.setAssets(rs.getString("assets"));
					certifiedService.setMachinery(rs.getString("machinery"));
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
	 * ������ϸ
	 */
	@Override
	public NewQualification queryInfo(String id) {
		// TODO Auto-generated method stub
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ id + "'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// ����
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				// ��ҵ����
				certifiedService.setCorpId(rs.getString("corpId").trim());
				// ��ҵ����
				certifiedService.setCorpName(rs.getString("corpName").trim());
				// ��ҵסַ��������֤
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				// ��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum")
						.trim());
				// ��ҵ����ʡ����
				certifiedService.setProvinceName(rs.getString("provinceName")
						.trim());
				// ��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				// ��ҵ����������
				certifiedService.setCityName(rs.getString("cityName").trim());
				// ��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// ��ҵ����������
				certifiedService.setCountyName(rs.getString("countyName")
						.trim());
				// ����״̬(1��������)
				certifiedService.setQualifType(rs.getString("qualifType")
						.trim());
				// ������������
				certifiedService.setCertId(rs.getString("certId").trim());
				// ������������
				certifiedService.setCertName(rs.getString("certName").trim());
				// ���ʼ���
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				// ���ʼ�������
				certifiedService.setCretGradeName(rs.getString("cretGradeName")
						.trim());
				// ���ʵȼ�
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				// ���ʵȼ�����
				certifiedService.setCretLevelName(rs.getString("cretLevelName")
						.trim());
				// ��������
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				// ������������
				certifiedService.setCretSequenceName(rs.getString(
						"cretSequenceName").trim());
				// ��������
				certifiedService.setCretType(rs.getInt("cretType"));
				// ������������
				certifiedService.setCretTypeName(rs.getString("cretTypeName")
						.trim());
				// ����רҵ���
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				// ����רҵ�������
				certifiedService.setSpecialtyTypeName(rs.getString(
						"specialtyTypeName").trim());
				// ��������
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				// �����ʸ�ȡ�÷�ʽ
				certifiedService.setAddTypeNum(rs.getString("addTypeNum")
						.trim());
				// �����ʸ�ȡ�÷�ʽ����
				certifiedService.setAddTypeName(rs.getString("addTypeName")
						.trim());
				// ��������Id
				certifiedService.setApprovalDept(rs.getString("approvalDept")
						.trim());
				// ������������
				certifiedService.setApprovalDeptName(rs.getString(
						"approvalDeptName").trim());
				// ��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// ������������
				certifiedService.setTwoApprovalDept(rs.getString(
						"twoApprovalDept").trim());
				// ����������������
				certifiedService.setTwoApprovalDeptName(rs.getString(
						"twoApprovalDeptName").trim());
				// ������Ա
				certifiedService.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff"));
				// ������ԱId
				certifiedService.setTwoApprovalStaffId(rs
						.getString("twoApprovalStaffId"));
				// ����ʱ��
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				// ����״̬
				certifiedService.setOneResults(rs.getString("oneResults"));
				// ������
				certifiedService.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion"));
				// ��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// ����Ӫҵִ��ע���
				certifiedService.setLicenseNum(rs.getString("licenseNum"));
				// ��������������
				certifiedService.setLegalMan(rs.getString("legalMan"));
				// ����������֤������
				certifiedService
						.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				// ����������֤������
				certifiedService.setLegalManIdCard(rs
						.getString("legalManIdCard"));
				// ����������ְ��
				certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
				// ����������ְ��
				certifiedService.setLegaManProtitle(rs
						.getString("legaManProtitle"));
				// ��ҵӪҵ��ַ
				certifiedService.setAddress(rs.getString("address"));
				// ע���ʱ�
				certifiedService.setRegPrin(rs.getString("REGPRIN"));
				certifiedService.setAssets(rs.getString("assets"));
				certifiedService.setMachinery(rs.getString("machinery"));
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
	 * �����ɹ�
	 */
	@Override
	public String approvalSuccess(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TB_FLOORAPPROVAL(NEWQUALID,CORPCODE,CORPNAME,APPPER,APPDATE,APPDEPT,APPOP,CTN,MESS1,MESS2,MESS3,MESS4,MESS5,MESS6,MESS7,MESS8,MESS9,MESS10,MESS11,MESS12,MESS13,MESS14,CERTMESS,CERTNAME) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, floor.getNewQualId());
			pstmt.setString(2, floor.getCorpCode());
			pstmt.setString(3, floor.getCorpName());
			pstmt.setString(4, floor.getApprovalPerson());
			pstmt.setDate(5, floor.getApprovalDate());
			pstmt.setString(6, floor.getAppDept());
			pstmt.setString(7, floor.getApprovalOpinion());
			pstmt.setString(8, "0");
			pstmt.setString(9, floor.getMes1());
			pstmt.setString(10, floor.getMes2());
			pstmt.setString(11, floor.getMes3());
			pstmt.setString(12, floor.getMes4());
			pstmt.setString(13, floor.getMes5());
			pstmt.setString(14, floor.getMes6());
			pstmt.setString(15, floor.getMes7());
			pstmt.setString(16, floor.getMes8());
			pstmt.setString(17, floor.getMes9());
			pstmt.setString(18, floor.getMes10());
			pstmt.setString(19, floor.getMes11());
			pstmt.setString(20, floor.getMes12());
			pstmt.setString(21, floor.getMes13());
			pstmt.setString(22, floor.getMes14());
			pstmt.setString(23, floor.getCertMess());
			pstmt.setString(24, floor.getCertName());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "��ӳɹ� ��";
			} else {
				message = "���ʧ��!";
			}
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
		return message;
	}

	/**
	 * ����ʧ��
	 */
	@Override
	public String approvalFailed(FloorApproval floor, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TB_FLOORAPPROVAL(NEWQUALID,CORPCODE,CORPNAME,APPPER,APPDATE,APPDEPT,APPOP,CTN,MESS1,MESS2,MESS3,MESS4,MESS5,MESS6,MESS7,MESS8,MESS9,MESS10,MESS11,MESS12,CERTMESS,MESS13) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, floor.getNewQualId());
			pstmt.setString(2, floor.getCorpCode());
			pstmt.setString(3, floor.getCorpName());
			pstmt.setString(4, floor.getApprovalPerson());
			pstmt.setDate(5, floor.getApprovalDate());
			pstmt.setString(6, floor.getAppDept());
			pstmt.setString(7, floor.getApprovalOpinion());
			pstmt.setString(8, "1");
			pstmt.setString(9, floor.getMes1());
			pstmt.setString(10, floor.getMes2());
			pstmt.setString(11, floor.getMes3());
			pstmt.setString(12, floor.getMes4());
			pstmt.setString(13, floor.getMes5());
			pstmt.setString(14, floor.getMes6());
			pstmt.setString(15, floor.getMes7());
			pstmt.setString(16, floor.getMes8());
			pstmt.setString(17, floor.getMes9());
			pstmt.setString(18, floor.getMes10());
			pstmt.setString(19, floor.getMes11());
			pstmt.setString(20, floor.getMes12());
			pstmt.setString(21, floor.getCertMess());
			pstmt.setString(22, floor.getMes13());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "��ӳɹ� ��";
			} else {
				message = "���ʧ��!";
			}
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
		return message;
	}

	/**
	 * ��ɺ����״̬
	 */
	@Override
	public String changeType(String approvalId, String type, String name, String approvalOpinion) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set QUALIFTYPE='" + type
				+ "' , FLOORDATE=? , FLOORPERSON=? , FLOOROP='" + approvalOpinion + "' WHERE NEWQUALID = '"
				+ approvalId + "'";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, name);
			int check = pstmt.executeUpdate();
			if (check == 0) {
				message = "��ӳɹ� ��";
			} else {
				message = "���ʧ��!";
			}
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
		return message;
	}

	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC where QUALIFICATIONSTYPE='����ҵ'";
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

	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='����ҵ'";
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

	@Override
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

	@Override
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

	@Override
	public int queryCountTitle(String userId) {
		// TODO Auto-generated method stub
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

	@Override
	public int queryCountConstructor(String userId) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from V_CONSTRUCTOR where corpName='"
					+ userId + "'";
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

	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
		int countConstructor = 0;
		try {
			String sql = "select count(*) from Position_Certificate where FIsDeleted = 0 and FEntName='"
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

	@Override
	public int queryCountSkilledworker(String userId) {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ���ʾ�λ��Ϣ
	 */
	@Override
	public NewQualification queryPerchInfo(String id) {
		// TODO Auto-generated method stub
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ id + "'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// ����
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				// ��ҵ����
				certifiedService.setCorpId(rs.getString("corpId").trim());
				// ��ҵ����
				certifiedService.setCorpName(rs.getString("corpName").trim());
				// ��ҵסַ��������֤
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				// ��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum")
						.trim());
				// ��ҵ����ʡ����
				certifiedService.setProvinceName(rs.getString("provinceName")
						.trim());
				// ��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				// ��ҵ����������
				certifiedService.setCityName(rs.getString("cityName").trim());
				// ��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// ��ҵ����������
				certifiedService.setCountyName(rs.getString("countyName")
						.trim());
				// ����״̬(1��������)
				certifiedService.setQualifType(rs.getString("qualifType")
						.trim());
				// ������������
				certifiedService.setCertId(rs.getString("certId").trim());
				// ������������
				certifiedService.setCertName(rs.getString("certName").trim());
				// ���ʼ���
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				// ���ʼ�������
				certifiedService.setCretGradeName(rs.getString("cretGradeName")
						.trim());
				// ���ʵȼ�
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				// ���ʵȼ�����
				certifiedService.setCretLevelName(rs.getString("cretLevelName")
						.trim());
				// ��������
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				// ������������
				certifiedService.setCretSequenceName(rs.getString(
						"cretSequenceName").trim());
				// ��������
				certifiedService.setCretType(rs.getInt("cretType"));
				// ������������
				certifiedService.setCretTypeName(rs.getString("cretTypeName")
						.trim());
				// ����רҵ���
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				// ����רҵ�������
				certifiedService.setSpecialtyTypeName(rs.getString(
						"specialtyTypeName").trim());
				// ��������
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				// �����ʸ�ȡ�÷�ʽ
				certifiedService.setAddTypeNum(rs.getString("addTypeNum")
						.trim());
				// �����ʸ�ȡ�÷�ʽ����
				certifiedService.setAddTypeName(rs.getString("addTypeName")
						.trim());
				// ��������Id
				certifiedService.setApprovalDept(rs.getString("approvalDept")
						.trim());
				// ������������
				certifiedService.setApprovalDeptName(rs.getString(
						"approvalDeptName").trim());
				// ��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// ������������
				certifiedService.setTwoApprovalDept(rs.getString(
						"twoApprovalDept").trim());
				// ����������������
				certifiedService.setTwoApprovalDeptName(rs.getString(
						"twoApprovalDeptName").trim());
				// ������Ա
				certifiedService.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff"));
				// ������ԱId
				certifiedService.setTwoApprovalStaffId(rs
						.getString("twoApprovalStaffId"));
				// ����ʱ��
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				// ����״̬
				certifiedService.setOneResults(rs.getString("oneResults"));
				// ������
				certifiedService.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion"));
				// ��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				// ����Ӫҵִ��ע���
				certifiedService.setLicenseNum(rs.getString("licenseNum"));
				// ��������������
				certifiedService.setLegalMan(rs.getString("legalMan"));
				// ����������֤������
				certifiedService
						.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				// ����������֤������
				certifiedService.setLegalManIdCard(rs
						.getString("legalManIdCard"));
				// ����������ְ��
				certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
				// ����������ְ��
				certifiedService.setLegaManProtitle(rs
						.getString("legaManProtitle"));
				// ��ҵӪҵ��ַ
				certifiedService.setAddress(rs.getString("address"));
				// ע���ʱ�
				certifiedService.setRegPrin(rs.getString("REGPRIN"));
				certifiedService.setAssets(rs.getString("assets"));
				certifiedService.setMachinery(rs.getString("machinery"));
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
	 * ���ʾ�λ����ͨ��
	 */
	@Override
	public String perchApprovalSuccess(String id, String op, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON=? where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, op);
			pstmt.setString(3, name);
			pstmt.setString(4, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				message = "�ɹ�";
			} else {
				message = "ʧ��";
			}
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
		return message;
	}

	/**
	 * ���ʾ�λ������ͨ��
	 */
	@Override
	public String perchApprovalFailed(String id, String op, String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='b' where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, new Date(new java.util.Date().getTime()));
			pstmt.setString(2, op);
			pstmt.setString(3, id);
			int i = pstmt.executeUpdate();
			if (i == 1) {
				message = "�ɹ�";
			} else {
				message = "ʧ��";
			}
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
		return message;
	}

	@Override
	public List<NewQualification> queryQualification(String[] ids) {
		// TODO Auto-generated method stub
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId=?";
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < ids.length; i++) {
				pstmt.setString(1, ids[i]);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// ����
					certifiedService.setNewQualId(rs.getString("newQualId")
							.trim());
					// ��ҵ����
					certifiedService.setCorpId(rs.getString("corpId").trim());
					// ��ҵ����
					certifiedService.setCorpName(rs.getString("corpName")
							.trim());
					// ��ҵסַ��������֤
					certifiedService.setCorpCode(rs.getString("corpCode")
							.trim());
					// ��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum")
							.trim());
					// ��ҵ����ʡ����
					certifiedService.setProvinceName(rs.getString(
							"provinceName").trim());
					// ��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum").trim());
					// ��ҵ����������
					certifiedService.setCityName(rs.getString("cityName")
							.trim());
					// ��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum")
							.trim());
					// ��ҵ����������
					certifiedService.setCountyName(rs.getString("countyName")
							.trim());
					// ����״̬(1��������)
					certifiedService.setQualifType(rs.getString("qualifType")
							.trim());
					// ������������
					certifiedService.setCertId(rs.getString("certId").trim());
					// ������������
					certifiedService.setCertName(rs.getString("certName")
							.trim());
					// ���ʼ���
					certifiedService.setCretGrade(rs.getString("cretGrade")
							.trim());
					// ���ʼ�������
					certifiedService.setCretGradeName(rs.getString(
							"cretGradeName").trim());
					// ���ʵȼ�
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// ���ʵȼ�����
					certifiedService.setCretLevelName(rs.getString(
							"cretLevelName").trim());
					// ��������
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// ������������
					certifiedService.setCretSequenceName(rs.getString(
							"cretSequenceName").trim());
					// ��������
					certifiedService.setCretType(rs.getInt("cretType"));
					// ������������
					certifiedService.setCretTypeName(rs.getString(
							"cretTypeName").trim());
					// ����רҵ���
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// ����רҵ�������
					certifiedService.setSpecialtyTypeName(rs.getString(
							"specialtyTypeName").trim());
					// ��������
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// �����ʸ�ȡ�÷�ʽ
					certifiedService.setAddTypeNum(rs.getString("addTypeNum")
							.trim());
					// �����ʸ�ȡ�÷�ʽ����
					certifiedService.setAddTypeName(rs.getString("addTypeName")
							.trim());
					// ��������Id
					certifiedService.setApprovalDept(rs.getString(
							"approvalDept").trim());
					// ������������
					certifiedService.setApprovalDeptName(rs.getString(
							"approvalDeptName").trim());
					// ��ҵ�Ǽ�ע������
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// ������������
					certifiedService.setTwoApprovalDept(rs.getString(
							"twoApprovalDept").trim());
					// ����������������
					certifiedService.setTwoApprovalDeptName(rs.getString(
							"twoApprovalDeptName").trim());
					// ������Ա
					certifiedService.setTwoApprovalStaff(rs
							.getString("twoApprovalStaff"));
					// ������ԱId
					certifiedService.setTwoApprovalStaffId(rs
							.getString("twoApprovalStaffId"));
					// ����ʱ��
					certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
					// ����״̬
					certifiedService.setOneResults(rs.getString("oneResults"));
					// ������
					certifiedService.setOneUltimateOpinion(rs
							.getString("oneUltimateOpinion"));
					// ��ҵ�Ǽ�ע������
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					// ����Ӫҵִ��ע���
					certifiedService.setLicenseNum(rs.getString("licenseNum"));
					// ��������������
					certifiedService.setLegalMan(rs.getString("legalMan"));
					// ����������֤������
					certifiedService.setIdCardTypeNum(rs
							.getString("idCardTypeNum"));
					// ����������֤������
					certifiedService.setLegalManIdCard(rs
							.getString("legalManIdCard"));
					// ����������ְ��
					certifiedService.setLegaLManDuty(rs
							.getString("legaLManDuty"));
					// ����������ְ��
					certifiedService.setLegaManProtitle(rs
							.getString("legaManProtitle"));
					// ��ҵӪҵ��ַ
					certifiedService.setAddress(rs.getString("address"));
					// ע���ʱ�
					certifiedService.setRegPrin(rs.getString("REGPRIN"));
					list.add(certifiedService);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		String corpCodeTest = list.get(0).getCorpCode() ; //��ȡlist�е�һ���������ҵ��֯���������
		for( int i=0; i<list.size(); i++ ){
			if(!corpCodeTest.equals(list.get(i).getCorpCode())){  //�ж�list�е�������ҵ�Ƿ���ͬһ����ҵ
				System.out.println("������������ͬһ����ҵ");
				return null ;
			}
		}
		
		return list;
	}

}
