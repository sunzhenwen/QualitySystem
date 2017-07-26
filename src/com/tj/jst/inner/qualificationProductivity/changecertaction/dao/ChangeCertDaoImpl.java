package com.tj.jst.inner.qualificationProductivity.changecertaction.dao;

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
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ��������֤���ݿ���
 * 
 * @author Administrator
 *
 */
public class ChangeCertDaoImpl extends BaseDao implements IChangeCertDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
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
	 * ����ҳ��
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
				certifiedService.setCityName(rs.getString("cityName"));
				// ��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				// ��ҵ����������
				certifiedService.setCountyName(rs.getString("countyName"));
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
				certifiedService.setCreatDate(rs.getDate("creatDate"));
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
	 * ����ͨ��
	 */
	@Override
	public String perchApprovalSuccess(String id, String op , String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON='"+name+"' where NEWQUALID=?";
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

	/**
	 * ������ͨ��
	 */
	@Override
	public String perchApprovalFailed(String id, String op , String name) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='b',FLOORPERSON='"+name+"' where NEWQUALID=?";
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

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void batchApplythrough(List<NewQualification> list,String name)
	{
		// TODO Auto-generated method stub
		String sql = "update TBQUALIFICATIONAPPLY set FLOORDATE=?,FLOOROP=?,QUALIFTYPE='1',FLOORPERSON=? where NEWQUALID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<list.size();i++)
			{
				pstmt.setDate(1, new Date(new java.util.Date().getTime()));
				pstmt.setString(2, list.get(i).getFloorOp());
				pstmt.setString(3, name);
				pstmt.setString(4, list.get(i).getNewQualId());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
            // ���û�д������ʾ��������ִ�� �ֹ��ύ
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
	 * ��ѯ��λ��Ա
	 */
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

	/**
	 * ��ѯ����ʦS
	 */
	@Override
	public int queryCountConstructor(String userName) {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��λ��Ա
	 */
	@Override
	public int queryCountPositions(String corpName) {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��������
	 */
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
	public List<NewQualification> queryQualification(String[] ids) {
		// TODO Auto-generated method stub
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			for (int i = 0; i < ids.length; i++) {
				String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
						+ ids[i] + "'";
				
				pstmt = conn.prepareStatement(sql);
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
		return list;
	}

	@Override
	public CorpInfo queryCorpInfo(String corpCode) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select  t.* , "
				+ "	(select e.corpregtype from TBECONTYPEDIC e where t.economicnum = e.code) as economicName"
				+ " from TBCORPBASICINFO t where t.corpCode = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������֤
				corp.setLicenseNum(rs.getString("licenseNum")); // ����Ӫҵִ��ע���
				corp.setProvinceNum(rs.getString("provinceNum")); // ע������ʡ
				corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�
				corp.setCountyNum(rs.getString("countyNum")); // ע��������
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode")); // ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // ����������֤������
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // ���д�����֤������
				corp.setLegalManDuty(rs.getString("legalManDuty")); // ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // ����������ְ��
				corp.setEconomicNum(rs.getString("economicName")); // ��ҵ�Ǽ�ע������
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�����Ԫ��
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�����Ԫ��
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // ע���ʱ�����
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // ��������
				corp.setOfficePhone(rs.getString("officePhone")); // �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("Url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setAssets(rs.getString("assets")); // ���ʲ�
				corp.setMachinery(rs.getString("machinery")); // ��е�豸
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

}
