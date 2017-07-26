package com.tj.jst.outside.staffmanage.skilledworker.dao;

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
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

public class SkilledworkerDaoImpl extends BaseDao implements ISkilledworkerDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub(!!!!!!!����)
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Skilledworker skilledworder = new Skilledworker();
					skilledworder.setPersonId(rs.getString("personId")); // ����
					skilledworder.setPersonName(rs.getString("personName")); // ����
					skilledworder.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
					skilledworder.setIdentityCard(rs.getString("identityCard")); // ���֤������18λ��
					skilledworder.setSkilledType(rs.getString("typeName")); // ������Ա���ࣨ�ֵ��TBSKILLEDWORkERTYPE��
					skilledworder.setSkilledLevel(rs.getString("levelName")); // ������Ա�����ֵ��TBSKILLEDWORKERLEVEL��
					skilledworder.setMobile(rs.getString("mobile")); // �ֻ���
					page.getData().add(skilledworder);
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
	 * ������Ա�����ѯ
	 */
	@Override
	public List<DictionaryClass> skilledTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERTYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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
	 * ������Ա�����ѯ
	 */
	@Override
	public List<DictionaryClass> skilledLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSKILLEDWORKERLEVEL";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("id"));
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
	 * ���Ӽ�����Ա���������Ϣ
	 */
	@Override
	public String addPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String personId = UUID.randomUUID().toString();
		String message = "";
		String sql = "insert into TBSkilledworker(PERSONID,SEXNUM,IDENTITYCARD,SKILLEDTYPENUM,"
				+ "SKILLEDLEVELNUM,PERSONNAME,NATIONALITYNUM,DEGREENUM,MOBILE,CORPCODE,CORPID,"
				+ "EDULEVELNUM,IDCARDTYPENUM,BIRTHDAY,CORPNAME) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId); // ע����ԱId
			pstmt.setString(2, skilledworker.getSexNum()); // ע����Ա�Ա�
			pstmt.setString(3, skilledworker.getIdentityCard()); // ע����Ա֤������
			pstmt.setString(4, skilledworker.getSkilledType()); // ע����Ա��������
			pstmt.setString(5, skilledworker.getSkilledLevel()); // ע����Ա���ּ���
			pstmt.setString(6, skilledworker.getPersonName()); // ע����Ա����
			pstmt.setString(7, skilledworker.getNationAlityNum()); // ע����Ա����
			pstmt.setString(8, skilledworker.getDegreeNum()); // ע����Աѧ��
			pstmt.setString(9, skilledworker.getMobile()); // ע����Ա�ֻ�����
			pstmt.setString(10, skilledworker.getCorpCode()); // ע����Ա����ҵ����
			pstmt.setString(11, skilledworker.getUserId()); // ע����Ա����ҵ����ID
			pstmt.setString(12, skilledworker.getEduLevelNum()); // ע����Աѧλ
			pstmt.setString(13, skilledworker.getIdCardTypeNum()); // ע����Ա֤������
			pstmt.setDate(14, skilledworker.getBirthday()); // ע����Ա��������
			pstmt.setString(15, skilledworker.getCorpName()); // ��ҵ����
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�����Ա�ɹ���";
			} else {
				message = "�����Աʧ�ܣ�";
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
	 * �޸ļ�����Ա������Ϣ
	 */
	@Override
	public String modifyPersonInfo(Skilledworker skilledworker) {
		// TODO Auto-generated method stub
		String message = "";

		String sql = "update TBSkilledworker set SEXNUM=? , IDENTITYCARD = ? ,"
				+ " SKILLEDTYPENUM = ? , SKILLEDLEVELNUM = ? , PERSONNAME = ? ,"
				+ " NATIONALITYNUM = ? , DEGREENUM = ? , MOBILE = ? , "
				+ "EDULEVELNUM = ? , IDCARDTYPENUM = ? , BIRTHDAY = ? where PERSONID = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, skilledworker.getSexNum());
			pstmt.setString(2, skilledworker.getIdentityCard());
			pstmt.setString(3, skilledworker.getSkilledTypeNum());
			pstmt.setString(4, skilledworker.getSkilledLevelNum());
			pstmt.setString(5, skilledworker.getPersonName());
			pstmt.setString(6, skilledworker.getNationAlityNum());
			pstmt.setString(7, skilledworker.getDegreeNum());
			pstmt.setString(8, skilledworker.getMobile());
			pstmt.setString(9, skilledworker.getEduLevelNum());
			pstmt.setString(10, skilledworker.getIdCardTypeNum());
			pstmt.setDate(11, skilledworker.getBirthday());
			pstmt.setString(12, skilledworker.getPersonId());
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
	 * ɾ��������Ա����Ա��Ϣ
	 */
	@Override
	public String deletePersonInfo(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "delete from TBSkilledworker where personId=?";
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
	 * ��Ա�Ա��ѯ
	 */
	@Override
	public List<DictionaryClass> sexNums() {
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
	 * ��Ա�����ѯ
	 */
	@Override
	public List<DictionaryClass> nationalNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBNATIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("nation"));
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
	 * ��Աѧ����ѯ
	 */
	@Override
	public List<DictionaryClass> eduLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBEDULEVELDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("diploma"));
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
	 * ��Աѧλ��ѯ
	 */
	@Override
	public List<DictionaryClass> degreeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBDEGREEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("degree"));
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
	 * ��Ա֤�����Ͳ�ѯ
	 */
	@Override
	public List<DictionaryClass> idCardTypeNums() {
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
	 * ����PersonId��ֵ��Ѱ����Ҫ�޸ĵ���Ա��Ϣ
	 */
	@Override
	public Skilledworker queryById(String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where personId=?";
		Skilledworker skilledworker = new Skilledworker();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				skilledworker.setBirthday(rs.getDate("birthday"));
				skilledworker.setDegreeNum(rs.getString("degreenum"));
				skilledworker.setEduLevelNum(rs.getString("edulevelnum"));
				skilledworker.setIdCardTypeNum(rs.getString("idcardtypenum"));
				skilledworker.setIdentityCard(rs.getString("identitycard"));
				skilledworker.setMobile(rs.getString("mobile"));
				skilledworker.setNationAlityNum(rs.getString("nationalitynum"));
				skilledworker.setPersonName(rs.getString("personname"));
				skilledworker.setSexNum(rs.getString("sexnum"));
				skilledworker.setSkilledLevelNum(rs
						.getString("SKILLEDLEVELNUM").trim());
				skilledworker.setSkilledTypeNum(rs.getString("SKILLEDTYPENUM")
						.trim());
				skilledworker.setPersonId(personId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return skilledworker;
	}

	/**
	 * �����������identitycard�� personId��ֵ���жϸ��ĵ���Ϣ�е�IDCARDֵ�Ƿ�Ϊ�ظ����ݡ�
	 */
	@Override
	public String queryIdCardInfo(String identitycard, String personId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBSKILLEDWORKER where identitycard = ? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identitycard);
			rs = pstmt.executeQuery();
			if (personId == null || personId.equals("")) {
				if (rs.next()) {
					message = "��˾���ƣ� " + rs.getString("corpName") + "(������Ա)";
				} else {
					message = "�ɹ�";
				}
			} else {
				if (rs.next()) {
					if (personId.equals(rs.getString("personId"))) {
						message = "�ɹ�";
					} else {
						message = "��˾���ƣ� " + rs.getString("corpName")
								+ "(������Ա)";
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
	 * ��ְ����Ա�в����Ƿ�����ͬ�����֤����
	 */
	@Override
	public String queryFromTitle(String identitycard, String corpCode) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBREGTITLEPERSON where idCard = ? and corpCode!='"
				+ corpCode + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identitycard);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "��˾���ƣ� " + rs.getString("corpName") + "(ְ����Ա)";
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
	 * �ڸ�λ��Ա��Ѱ���Ƿ�����ͬ��֤������
	 */
	@Override
	public String queryFromPos(String identitycard, String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from Position_Certificate where FCardId = ? and FIsDeleted = 0  and FEntName != '"
				+ corpName + "' and fduty  in ('ʩ��Ա','����Ա','��ȫԱ','��׼Ա','����Ա','��еԱ','����Ա','����Ա') ";
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, identitycard);
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
