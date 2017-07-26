package com.tj.jst.inner.qualificationProductivity.twoApproval.dao;

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
import com.tj.jst.base.util.judgedate.JudgeDateAction;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ʡ����������
 * 
 * @author Administrator
 *
 */
public class TwoApprovalDaoImpl extends BaseDao implements ITwoApprovalDao {

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
					// ��������ʱ��
					certifiedService.setPushTwoDate(rs.getDate("pushTwoDate"));
					// �����ֹʱ��
					certifiedService.setDeadDate(JudgeDateAction.getDeadDate(rs
							.getDate("pushTwoDate")));
					// �ж��Ƿ��ǳ���
					if (rs.getDate("floorDate") != null) {
						// ��ֹ����
						certifiedService.setDeadDate(JudgeDateAction
								.getDeadDate(rs.getDate("floorDate")));
						// �ж��Ƿ���
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
	 * ��ת����ҳ���ѯ
	 */
	public NewQualification queryapproval(String newQualId) {
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"
					+ newQualId + "'";
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
				// ��������
				certifiedService.setApprovalDept(rs.getString("approvalDept"));
				// ������������
				certifiedService.setApprovalDeptName(rs
						.getString("approvalDeptName"));
				// ��������������
				certifiedService.setTwoApprovalDept(rs
						.getString("twoApprovalDept"));
				// ������������������
				certifiedService.setTwoApprovalDeptName(rs
						.getString("twoApprovalDeptName"));
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
	 * 
	 * @return
	 */
	public void applythrough(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ONEULTIMATEOPINION=?,"
							+ "ONEAPPDATE=?,TWOAPPROVALSTAFF=?,TWOAPPROVALSTAFFID=?,ONERESULTS=? where NEWQUALID=?");

			// ����״̬
			pstmt.setString(1, "3");
			// �����������
			pstmt.setString(2, newQualification.getOneUltimateOpinion());
			// ��������ʱ��
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			// ����������Ա
			pstmt.setString(4, newQualification.getTwoApprovalStaff());
			// ����������ԱId
			pstmt.setString(5, newQualification.getTwoApprovalStaffId());
			// �����������
			pstmt.setString(6, "3");
			pstmt.setString(7, newQualification.getNewQualId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * �����˻�
	 * 
	 * @return
	 */
	public void applyBack(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ONEULTIMATEOPINION=?,"
							+ "ONEAPPDATE=?,TWOAPPROVALSTAFF=?,TWOAPPROVALSTAFFID=?,ONERESULTS=? where NEWQUALID=?");
			// ����״̬
			pstmt.setString(1, "4");
			// �����������
			pstmt.setString(2, newQualification.getOneUltimateOpinion());
			// ��������ʱ��
			pstmt.setDate(3, new Date(new java.util.Date().getTime()));
			// ����������Ա
			pstmt.setString(4, newQualification.getTwoApprovalStaff());
			// ����������ԱId
			pstmt.setString(5, newQualification.getTwoApprovalStaffId());
			// �����������
			pstmt.setString(6, "4");
			pstmt.setString(7, newQualification.getNewQualId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ��������
	 * 
	 * @return
	 */
	public void pushApply(NewQualification newQualification) {
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn
					.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? where NEWQUALID=?");
			pstmt.setString(1, "2");
			pstmt.setString(2, newQualification.getNewQualId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	// ��ѯְ����Ա
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

	// ��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId) {
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

	// ��ѯ������������
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

	// ��������(�ֵ��TBAPTITUDEKINDDIC)
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

	// ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
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

	// ��������(�ֵ��TBTRADETYPEDIC)
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

	// ����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
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

	// ���ʼ���(�ֵ��TBCRETGRADEDIC)
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

	// ��������(�ֵ��TBADDTYPEDIC)
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

	// ��ѯ��λ��Ա
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

	// ��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification) {
		// TODO Auto-generated method stub
		// String sql =
		// "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
		// +
		// "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
		// +
		// "where qualifType=? and corpId=? and cretLevel=? and cretGrade=? and specialtyType=? ";
		String sql = "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
				+ "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
				+ "where qualifType=? and corpId=? and cretLevel=? and specialtyType=? ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "5");
			pstmt.setString(2, newQualification.getCorpId());
			if (newQualification.getCretLevel() == 76) {
				pstmt.setInt(3, 75);
			}
			if (newQualification.getCretLevel() == 77) {
				pstmt.setInt(3, 76);
			}
			if (newQualification.getCretLevel() == 78) {
				pstmt.setInt(3, 77);
			}
			pstmt.setInt(4, newQualification.getSpecialtyType());
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

	// ����ids�������ύ�����ʷ�������
	public List<NewQualification> queryQualification(String[] ids) {
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
}
