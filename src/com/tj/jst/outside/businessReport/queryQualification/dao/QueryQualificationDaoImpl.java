package com.tj.jst.outside.businessReport.queryQualification.dao;

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
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * ��ҵӵ�����ʲ�ѯ
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationDaoImpl extends BaseDao implements
		IQueryQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ���ʷ��������ѯ
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Qualification queryQualification = new Qualification();
					queryQualification.setCorpId(rs.getString("CORPID")); // ��ҵ����֤ID
					queryQualification.setCorpCode(rs.getString("CorpCode")); // ��ҵ����֤
					queryQualification.setCorpName(rs.getString("CorpName")); // ��ҵ����
					queryQualification.setCertDetailId(rs
							.getString("CertDetailId")); // ����
					queryQualification.setCertTypeName(rs
							.getString("CertTypeName")); // ��������
					queryQualification.setTitleLevelName(rs
							.getString("TitleLevel")); // ���ʵȼ�
					queryQualification.setAddTypeName(rs
							.getString("AddTypeName")); // ����ȡ�÷�ʽ
					queryQualification.setTradeBoundName(rs
							.getString("TradeBoundName")); // רҵ���
					queryQualification.setCertId(rs.getString("CertId")); // ֤����
					queryQualification.setCertTradeStatusName(rs.getString("CertTradeStatusName"));
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
	public List<DictionaryClass> CertTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC ";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE"));
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
	 * �����ʸ�ȼ���ѯ
	 */
	@Override
	public List<DictionaryClass> TitleLevelNums() {
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
	 * �����ʸ��ȡ��ʽ��ѯ
	 */
	@Override
	public List<DictionaryClass> AddTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBADDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("GETMETHODNAME"));
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
	 * רҵ����ѯ
	 */
	@Override
	public List<DictionaryClass> TradeBoundNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEBOUNDDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("SPECIALTYTYPE"));
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
	 * ͨ��Id��ѡ����ҵ����ϸ��Ϣ
	 */
	@Override
	public Qualification queryById(String CertDetailId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select t.*,(select s.QUALIFICATIONSTYPE from TBAPTITUDEKINDDIC s where t.CERTTYPENUM=s.code) as certTypeName,"
				+ "(select d.CODENAME from TBTRADETYPEDIC d where t.TRADETYPENUM=d.code) as tradeTypeName,"
				+ "(select n.SPECIALTYTYPE from TBTRADETYPEBOUNDDIC n where t.TRADEBOUNDNUM=n.code) as TRADEBOUNDNAME,"
				+ "(select l.RATING from TBCERTTITLELEVELDIC l where t.TITLELEVELNUM=l.code and rownum=1) as TITLELEVEl,"
				+ "(select b.GETMETHODNAME from TBADDTYPEDIC b where t.ADDTYPENUM=b.code) as ADDTYPENAME,"
				+ "(select e.QUALIFSTATUS from TBCERTTRADESTATUSDIC e where t.CertTradeStatusNum=e.code) as CertTradeStatusName"
				+ " from TBCorpCertdetailinfo t where t.CertDetailId=?";
		Qualification qualification = new Qualification();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CertDetailId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qualification.setCertDetailId(rs.getString("CertDetailId")); // ����
				qualification.setCorpName(rs.getString("CorpName")); // ��ҵ����
				qualification.setCertTypeName(rs.getString("CertTypeName")); // �����ʸ�����
				qualification.setCertTypeNum(rs.getString("CertTypeNum")); // �����ʸ�����
				qualification.setCertId(rs.getString("CertId")); // ֤����
				qualification.setTradeTypeName(rs.getString("TradeTypeName")); // �����ʸ�����
				qualification.setTradeTypeNum(rs.getString("TradeTypeNum")); // �����ʸ�����
				qualification.setTradeBoundName(rs.getString("TradeBoundName")); // רҵ���
				qualification.setTradeBoundNum(rs.getString("TradeBoundNum")); // רҵ���
				qualification.setTitleLevelLevel(rs.getString("TitleLevel")); // �����ʸ�ȼ�
				qualification.setTitleLevelNum(rs.getString("TitleLevelNum")); // �����ʸ�ȼ�
				qualification.setNoteNumber(rs.getString("NoteNumber")); // �״���׼�����ʸ��ĺ�
				qualification.setNoteDate(rs.getDate("NoteDate")); // �״���׼�����ʸ�����
				qualification.setAddTypeName(rs.getString("AddTypeName")); // �����ʸ�ȡ�÷�ʽ
				qualification.setAddTypeNum(rs.getString("AddTypeNum")); // �����ʸ�ȡ�÷�ʽ
				qualification.setCertTradeStatusName(rs
						.getString("CertTradeStatusName")); // �����ʸ�״̬
				qualification.setCertTradeStatusNum(rs
						.getString("CertTradeStatusNum")); // �����ʸ�״̬
				qualification.setCorpCode(rs.getString("CorpCode")); // ��ҵ��֯��������֤
				qualification.setCorpId(rs.getString("CorpId")); // ��ҵ��֯��������֤ID

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return qualification;
	}

}
