package com.tj.jst.outside.staffmanage.constructor.dao;

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
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

public class ConstructorDaoImpl extends BaseDao implements IConstructorDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public Page pagedQuery(Condition condition) {

		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Constructor constructor = new Constructor();
					constructor.setPersonId(rs.getString("personid")); // ����
					constructor.setPersonName(rs.getString("personName")); // ����
					constructor.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
					constructor.setIdCardTypeName(rs
							.getString("idCardTypeName")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
					constructor.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
					constructor.setBirthday(rs.getDate("birthday")); // ����
					constructor.setNationAlityName(rs
							.getString("paperTypeName")); // ����(�ֵ��TBNATIONDIC)
					constructor.setEduLevelName(rs.getString("eduLevelName")); // ѧ��(�ֵ��TBEDULEVELDIC)
					constructor.setDegreeName(rs.getString("degreeName")); // ѧλ(�ֵ��TBDEGREEDIC)
					constructor.setMobile(rs.getString("mobile")); // �ֻ�����
					constructor.setSepecialtyTypName(rs
							.getString("specialtytypName"));
					constructor.setRegTradeTypeNum(rs
							.getString("regTradeTypeNum"));
					page.getData().add(constructor);
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

	// ѧ��
	@Override
	public List<DictionaryClass> eduLevelNums() {
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

	// ѧλ
	@Override
	public List<DictionaryClass> degreeNums() {
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

	// ��ѯ��ϸ
	@Override
	public Constructor queryDetailed(String idCard, String type) {
		String sql = "select t.*,"
				+ "(select a.papertype from TBIDCARDTYPEDIC a where a.code=t.idcardtypenum) as idCardTypeName,"
				+ "(select b.typelevel from TBSPECIALTYTYPEDIC b where b.code=t.specialtytypnum) as sepecialtyTypName,"
				+ "(select c.type from TBCALLINGTYPEDIC c where c.code=t.callingtypenum) as callingTypeName,"
				+ "(select d.discipline from TBREGTRADETYPEDIC d where d.code=t.regtradetypenum) as regTradeTypeName,"
				+ "(select e.status from TBQSTATEDIC e where e.code=t.qstate) as qStateName "
				+ "from TBREGPERSONREGINFO t where t.idCard18=? and t.regTradeTypeNum = ?";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			pstmt.setString(2, type);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard18"));
				constructor.setSepecialtyTypName(rs
						.getString("sepecialtyTypName"));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeName(rs.getString("callingTypeName"));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeName(rs
						.getString("regTradeTypeName"));
				constructor.setTradeTypeAwardDate(rs
						.getDate("tradeTypeAwardDate"));
				constructor.setTradeTypeEffectDate(rs
						.getDate("tradeTypeEffectDate"));
				constructor.setStateName(rs.getString("qStateName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return constructor;
	}
}
