package com.tj.jst.outside.businessReport.queryQualificationInfo.dao;

import java.sql.Connection;
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
import com.tj.jst.outside.businessReport.queryQualificationInfo.model.QualificationInfo;

/**
 * ��ҵ�����������Ϣ״̬��ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationInfoDaoImpl extends BaseDao implements
		IQueryQualificationInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ���ʲ�ѯ
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					QualificationInfo queryQualification = new QualificationInfo();
					queryQualification.setNewQualId(rs.getString("NEWQUALID")); // ��ҵ������ϢID
					queryQualification.setCorpId(rs.getString("CORPID")); // ��ҵ����֤ID
					queryQualification.setCorpName(rs.getString("CorpName")); // ��ҵ����
					String num = rs.getString("qualifType").trim();
					switch (num) {
					case "1":
						queryQualification.setQualifType("������������"); // �������
						break;
					case "2":
						queryQualification.setQualifType("����רҵ���ֳ���"); // �������
						break;
					case "3":
						queryQualification
								.setQualifType("רҵ���ֳ������(ͨ��)�����������������š�"); // �������
						break;
					case "4":
						queryQualification
								.setQualifType("רҵ���ֳ������(δͨ��)�����������������š�"); // �������
						break;
					case "5":
						queryQualification.setQualifType("����ͨ����"); // �������
						break;
					case "6":
						queryQualification.setQualifType("����δͨ����"); // �������
						break;
					case "7":
						queryQualification.setQualifType("רҵ���ֳ���ͨ����"); // �������
						break;
					case "8":
						queryQualification.setQualifType("רҵ���ֳ���δͨ����"); // �������
						break;
					case "9":
						queryQualification.setQualifType("��������ͨ����"); // �������
						break;
					case "10":
						queryQualification.setQualifType("��������δͨ����"); // �������
						break;
					case "a":
						queryQualification.setQualifType("��ҵ���ύ����������������"); // �������
						break;
					case "b":
						queryQualification.setQualifType("��������δͨ����"); // �������
						break;
					default:
						queryQualification.setQualifType("�������ݡ�");
						break;
					}
					queryQualification.setCretLevelName(rs
							.getString("cretLevelName")); // ���ʵȼ�����
					queryQualification.setCretTypeName(rs
							.getString("cretTypeName")); // �����ʸ�����
					queryQualification.setCreatDate(rs.getDate("creatDate")); // ��������
					queryQualification.setOneAppDate(rs.getDate("oneAppDate")); // ��������ʱ��
					queryQualification.setCretLevelName(rs
							.getString("CretLevelName")); // ������������
					queryQualification.setAddTypeName(rs
							.getString("addTypeName")); // ������������
					queryQualification.setSpecialtyTypeName(rs
							.getString("SpecialtyTypeName")); // ������������
					queryQualification.setFloorDate(rs.getDate("floorDate"));
					queryQualification.setOneAppDate(rs.getDate("oneAppDate"));
					queryQualification.setUltimateDate(rs
							.getDate("ultimateDate"));
					queryQualification.setCertName(rs.getString("certName"));
					page.getData().add(queryQualification);
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
	 * �����ʸ����Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> CretLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='����ҵ'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * ͨ��ID��Ѱ����ҵ������ϸ��Ϣ
	 */
	@Override
	public QualificationInfo queryById(String NewQualId) {
		// TODO Auto-generated method stub
		String message = "";

		String sql = "select t.*,"
				+ "(select b.qualificationstype from TBAPTITUDEKINDDIC b where b.code=t.crettype) as cretTypeName,"
				+ "(select c.codename from TBTRADETYPEDIC c where c.code=t.CRETSEQUENCE) as cretSequenceName,"
				+ "(select d.rating from TBCERTTITLELEVELDIC d where d.code=t.CRETLEVEL and d.qualificationstype='����ҵ') as cretLevelName,"
				+ "(select e.name from TBCRETGRADEDIC e where e.code=t.cretgrade) as cretGradeName,"
				+ "(select f.specialtytype from TBTRADETYPEBOUNDDIC f where f.code=t.specialtytype) as specialtyTypeName,"
				+ "(select g.getmethodname from TBADDTYPEDIC g where g.code=t.addtypenum) as addtypeName"
				+ " from TBQUALIFICATIONAPPLY t where t.NEWQUALID=?";
		QualificationInfo qualification = new QualificationInfo();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NewQualId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// д��Ϣ
				qualification.setNewQualId(rs.getString("newQualId")); // ����
				qualification.setCorpId(rs.getString("corpId")); // ��ҵID
				qualification.setCorpName(rs.getString("corpName")); // ��ҵ����
				if (rs.getString("qualifType").trim().equals("1")) {
					qualification.setQualifType("������������"); // �������
				} else if (rs.getString("qualifType").trim().equals("2")) {
					qualification.setQualifType("רҵ���ֲ���������"); // �������
				} else if (rs.getString("qualifType").trim().equals("3")) {
					qualification.setQualifType("רҵ���ֲ����������(ͨ��)�����������������š�"); // �������
				} else if (rs.getString("qualifType").trim().equals("4")) {
					qualification.setQualifType("רҵ���ֲ����������(δͨ��)�����������������š�"); // �������
				} else if (rs.getString("qualifType").trim().equals("5")) {
					qualification.setQualifType("��������ͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("6")) {
					qualification.setQualifType("��������δͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("7")) {
					qualification.setQualifType("רҵ���ֳ���ͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("8")) {
					qualification.setQualifType("רҵ���ֳ���δͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("9")) {
					qualification.setQualifType("��������ͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("10")) {
					qualification.setQualifType("��������δͨ����"); // �������
				} else if (rs.getString("qualifType").trim().equals("a")) {
					qualification.setQualifType("��ҵ���ύ������������������"); // �������
				} else if (rs.getString("qualifType").trim().equals("b")) {
					qualification.setQualifType("��������δͨ��"); // �������
				}
				qualification.setCretLevelName(rs.getString("cretLevelName")); // ���ʵȼ�
				qualification.setCretName(rs.getString("certName")); // ������������
				qualification.setCretTypeName(rs.getString("cretTypeName")); // ��������
				qualification.setCretSequenceName(rs
						.getString("cretSequenceName")); // ������������
				qualification.setSpecialtyTypeName(rs
						.getString("specialtyTypeName")); // ����רҵ�������
				qualification.setCretGradeName(rs.getString("cretGradeName")); // ���ʼ�������
				qualification.setApprovalDeptName(rs
						.getString("approvalDeptName")); // ������������
				qualification.setCreatDate(rs.getDate("creatDate")); // ��������
				qualification.setTwoApprovalDeptName(rs
						.getString("twoApprovalDeptName")); // ����������������
				qualification.setOneUltimateOpinion(rs
						.getString("oneUltimateOpinion")); // �����������
				qualification.setOneAppDate(rs.getDate("oneAppDate")); // ��������ʱ��
				qualification.setTwoApprovalStaff(rs
						.getString("twoApprovalStaff")); // ����������Ա
				qualification.setUltimateOpinion(rs
						.getString("ultimateOpinion")); // �����������
				qualification.setApprovalStaff(rs.getString("approvalStaff")); // ����������Ա
				qualification.setFloorDate(rs.getDate("floorDate"));// ��������ʱ��
				qualification.setFloorOp(rs.getString("floorOp"));// �����������
				;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return qualification;
	}

	/**
	 * ͨ��Id ���ж���ѡ��ɾ����Ϣ
	 */
	@Override
	public String deleteById(String NewQualId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from TBQUALIFICATIONAPPLY where NEWQUALID = ? and (QUALIFTYPE = '1' or QUALIFTYPE = 'a' )";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NewQualId);
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "ɾ���ɹ���";
			} else {
				message = "ɾ��ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

}
