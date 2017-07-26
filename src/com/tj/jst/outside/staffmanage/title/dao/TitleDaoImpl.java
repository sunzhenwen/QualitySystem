package com.tj.jst.outside.staffmanage.title.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.title.model.Title;

public class TitleDaoImpl extends BaseDao implements ITitleDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	public Page pagedQuery(Condition condition) {

		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Title title = new Title();
					title.setPersonId(rs.getString("personid")); // ����
					title.setPersonName(rs.getString("personName")); // ����
					title.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
					title.setIdCardTypeName(rs.getString("idCardTypeName")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
					title.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
					title.setMobile(rs.getString("mobile")); // �ֻ�����
					title.setTitleName(rs.getString("titleName")); // ְ��
					title.setTitleMajor(rs.getString("titleMajor")); // ְ��רҵ
					title.setTitleLevel(rs.getString("titleLevel")); // ְ�Ƶȼ�
					title.setGraduatedSchool(rs.getString("graduatedSchool")); // ��ҵѧУ
					title.setGraduatedDate(rs.getDate("graduatedDate")); // ��ҵʱ��
					title.setStudyMajor(rs.getString("studyMajor")); // ��ѧרҵ
					page.getData().add(title);
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
	 * ����ְ����Ա��Ϣ
	 */
	@Override
	public String add(Title title) {
		String message = "";
		String sql = "insert into TBREGTITLEPERSON(personName,sexNum,idCardTypeNum,idCard,mobile,"
				+ "titleName,titleMajor,titleLevel,graduatedSchool,studyMajor,graduatedDate,personId,corpId,corpCode,corpName) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String personId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title.getPersonName());
			pstmt.setString(2, title.getSexNum());
			pstmt.setString(3, title.getIdCardTypeNum());
			pstmt.setString(4, title.getIdCard());
			pstmt.setString(5, title.getMobile());
			pstmt.setString(6, title.getTitleName());
			pstmt.setString(7, title.getTitleMajor());
			pstmt.setString(8, title.getTitleLevel());
			pstmt.setString(9, title.getGraduatedSchool());
			pstmt.setString(10, title.getStudyMajor());
			pstmt.setDate(11, title.getGraduatedDate());
			pstmt.setString(12, personId);
			pstmt.setString(13, title.getCorpId());
			pstmt.setString(14, title.getCorpCode());
			pstmt.setString(15, title.getCorpName());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "��ӳɹ���";
			} else {
				message = "���ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ְ����Ա��Ϣ�޸�
	 */
	@Override
	public String modify(Title title) {
		String message = "";
		String sql = "update TBREGTITLEPERSON set personName=?,sexNum=?,idCardTypeNum=?,idCard=?,mobile=?,"
				+ "titleName=?,titleMajor=?,titleLevel=?,graduatedSchool=?,studyMajor=?,graduatedDate=? "
				+ "where personId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title.getPersonName());
			pstmt.setString(2, title.getSexNum());
			pstmt.setString(3, title.getIdCardTypeNum());
			pstmt.setString(4, title.getIdCard());
			pstmt.setString(5, title.getMobile());
			pstmt.setString(6, title.getTitleName());
			pstmt.setString(7, title.getTitleMajor());
			pstmt.setString(8, title.getTitleLevel());
			pstmt.setString(9, title.getGraduatedSchool());
			pstmt.setString(10, title.getStudyMajor());
			pstmt.setDate(11, title.getGraduatedDate());
			pstmt.setString(12, title.getPersonId());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�޸ĳɹ���";
			} else {
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ����personId��ֵ��Ѱ�ұ�ɾ������Ա��Ϣ������ɾ��
	 */
	@Override
	public String delete(String personId) {
		String message = "";
		String sql = "delete from TBREGTITLEPERSON where personId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
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

	/**
	 * �ֵ��ࣺ�Ա�
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSEXDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("sex"));
				dictionaryClass.setCode(rs.getString("code"));
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
	 * �ֵ䣺֤������
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("papertype"));
				dictionaryClass.setCode(rs.getString("code"));
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
	 * ͨ��perosnId��Ѱ��Ҫ����ɾ�������޸Ĳ�������Ա
	 */
	@Override
	public Title queryById(String personId) {
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where personId=?";
		Title title = new Title();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				title.setPersonId(rs.getString("personId"));
				title.setPersonName(rs.getString("personName"));
				title.setSexNum(rs.getString("sexNum")); // �Ա�(�ֵ��TBSEXDIC)
				title.setIdCardTypeNum(rs.getString("idCardTypeNum")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
				title.setMobile(rs.getString("mobile")); // �ֻ�����
				// ְ��
				title.setTitleName(rs.getString("titleName"));
				// ְ��רҵ
				title.setTitleMajor(rs.getString("titleMajor"));
				// ְ�Ƽ���
				title.setTitleLevel(rs.getString("titleLevel"));
				// ��ҵѧУ
				title.setGraduatedSchool(rs.getString("graduatedSchool"));
				// ��ѧרҵ
				title.setStudyMajor(rs.getString("studyMajor"));
				// ��ҵʱ��
				title.setGraduatedDate(rs.getDate("graduatedDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return title;
	}

	/**
	 * ͨ����ѯIDcardֵ��personID��ֵ���ж��������֤����Ϣ�Ƿ��ظ���
	 */
	@Override
	public String queryIdCardInfo(String idCard, String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where idCard=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			if (personId == null || personId.equals("")) {
				if (rs.next()) {
					message = "��˾���ƣ� " + rs.getString("corpName") + "(ְ����Ա)";
				} else {
					message = "�ɹ�";
				}
			} else {
				if (rs.next()) {
					if (personId.equals(rs.getString("personId"))) {
						message = "�ɹ�";
					} else {
						message = "��˾���ƣ� " + rs.getString("corpName")
								+ "(ְ����Ա)";
					}
				} else {
					message = "�ɹ�";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * ��ѯ������Ա���ж��Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormSkill(String idCard, String corpCode) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where identitycard = ? and corpCode != '"
				+ corpCode + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "��˾���ƣ� " + rs.getString("corpName") + "��������Ա��";
			} else {
				message = "�ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * ��ѯ��λ��Ա�Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormPos(String idCard, String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from  Position_Certificate where FCardId = ? and FIsDeleted = 0  and FEntName !='"
				+ corpName + "' and  fduty  in ('ʩ��Ա','����Ա','��ȫԱ','��׼Ա','����Ա','��еԱ','����Ա','����Ա')   ";
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "��˾���ƣ� " + rs.getString("FEntName") + "(��λ��Ա)";
			} else {
				message = "�ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}
