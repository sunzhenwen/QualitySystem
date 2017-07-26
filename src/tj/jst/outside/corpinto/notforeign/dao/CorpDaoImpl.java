package com.tj.jst.outside.corpinto.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class CorpDaoImpl implements ICorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	// 组织机构代码证查询企业
	@Override
	public Corp queryCorpName(String corpCode) {

		Corp corp = new Corp();
		try {

			String qsql = "select * from TBCorpBasicinfo where corpCode=? and SPARE1 is not null";
			// 获取基础数据库链接，首先从基础数据库查询
			qconn = ConnectionFactory.getBasicConnection();
			qpstmt = qconn.prepareStatement(qsql);
			qpstmt.setString(1, corpCode);
			qrs = qpstmt.executeQuery();

			// 如果基础数据库存在，返回不允许企业再次注册
			if (qrs.next()) {
				corp.setCheckType(0);
				corp.setMessage("您所查询的企业已经注册并经过审核，请使用UKey登陆！");
			} else {
				// 如果基础数据库不存在，查询资质系统数据库
				String sql = "select * from TBCorpBasicinfo where corpCode=?";
				// 如果基础数据库系统不存在，从资质数据库中查询
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corpCode);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// 如果资质数据库存在，返回修改页面
					corp.setCorpId(rs.getString("corpId")); // 主键
					corp.setCorpName(rs.getString("corpName")); // 企业名称
					corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
					corp.setLicenseNum(rs.getString("licenseNum"));// 工商营业执照注册号
					corp.setProvinceNum(rs.getString("provinceNum"));// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					corp.setCityNum(rs.getString("cityNum")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
					corp.setCountyNum(rs.getString("countyNum")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
					corp.setAddress(rs.getString("address")); // 企业营业地址
					corp.setPostalCode(rs.getString("postalCode"));// 企业营业地址邮政编码
					corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
					corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
					corp.setLegalManIdCard(rs.getString("legalManIdCard"));// 法定代表人证件号码
					corp.setLegalManDuty(rs.getString("legalManDuty"));// 法定代表人职务
					corp.setLegaManProtitle(rs.getString("legaManProtitle"));// 法定代表人职称
					corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型(字典表：TBECONTYPEDIC)
					corp.setRegPrin(rs.getString("regPrin")); // 注册资本(万元)
					corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本(万元)
					corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
					corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// 成立日期
					corp.setOfficePhone(rs.getString("officePhone"));// 办公电话
					corp.setFax(rs.getString("fax")); // 传真号码
					corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
					corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
					corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
					corp.setEmail(rs.getString("email")); // 联系邮箱
					corp.setUrl(rs.getString("url")); // 企业网址
					corp.setDescription(rs.getString("description")); // 备注
					corp.setAssets(rs.getString("assets"));
					corp.setMachinery(rs.getString("machinery"));
					corp.setCheckType(1);
				} else {
					// 如果资质数据库不存在，返回添加注册页面
					corp.setCorpCode(corpCode);
					corp.setCheckType(2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	// 查询省
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
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

	// 查询市
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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

	// 证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
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

	// 企业登记注册类型
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		String sql = "select code,corpregtype from TBECONTYPEDIC where code not like '%00'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
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

	// 注册资本币种
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
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

	// 添加企业
	@Override
	public String addCorp(Corp corp) {
		String message = "";
		int check = 0;
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
				+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,CORPID,OLDORNEW,ASSETS,MACHINERY,DATASOURCE) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
			pstmt.setString(19, corp.getOfficePhone());// 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 添加时间
			pstmt.setString(28, corpId); // 主键
			pstmt.setString(29, "1"); // 新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, "01");
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "注册成功,请到受理大厅审核！";
			} else {
				message = "注册失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if (check > 0) {
			try {
				String sql2 = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
						+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
						+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
						+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CORPID,OLDORNEW,ASSETS,MACHINERY) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, corp.getCorpName()); // 企业名称
				pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
				pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
				pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // 企业营业地址
				pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
				pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
				pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
				pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
				pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
				pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
				pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
				pstmt.setString(19, corp.getOfficePhone());// 办公电话
				pstmt.setString(20, corp.getFax()); // 传真号码
				pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
				pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
				pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
				pstmt.setString(24, corp.getEmail()); // 联系邮箱
				pstmt.setString(25, corp.getUrl()); // 企业网址
				pstmt.setString(26, corp.getDescription()); // 备注
				// pstmt.setDate(27,new Date(new java.util.Date().getTime()));
				// //添加时间
				pstmt.setString(27, corpId); // 主键
				pstmt.setString(28, "1"); // 新老数据，0老数据，1新数据
				pstmt.setString(29, corp.getAssets());
				pstmt.setString(30, corp.getMachinery());
				int check1 = pstmt.executeUpdate();
				if (check1 == 1) {
					message = "注册成功,请到受理大厅审核！";
				} else {
					message = "注册失败！";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	// 修改企业
	@Override
	public String modifyCorp(Corp corp) {
		String message = "";
		int check = 0;
		String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=? where CORPID=? ";
		String sql2 = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=? where CORPID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
			pstmt.setString(19, corp.getOfficePhone());// 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 修改时间
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getCorpId()); // 主键
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "修改成功！";
			} else {
				message = "修改失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}

		if (check > 0) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName()); // 企业名称
				pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
				pstmt.setString(3, corp.getLicenseNum());// 工商营业执照注册号
				pstmt.setString(4, corp.getProvinceNum());// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // 企业营业地址
				pstmt.setString(8, corp.getPostalCode());// 企业营业地址邮政编码
				pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
				pstmt.setString(10, corp.getIdCardTypeNum());// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard());// 法定代表人证件号码
				pstmt.setString(12, corp.getLegalManDuty());// 法定代表人职务
				pstmt.setString(13, corp.getLegaManProtitle());// 法定代表人职称
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
				pstmt.setDouble(16,
						Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
				pstmt.setString(17, corp.getPrincipalUnitNum());// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate());// 成立日期
				pstmt.setString(19, corp.getOfficePhone());// 办公电话
				pstmt.setString(20, corp.getFax()); // 传真号码
				pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
				pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
				pstmt.setString(23, corp.getLinkPhone()); // 联系人手机号码
				pstmt.setString(24, corp.getEmail()); // 联系邮箱
				pstmt.setString(25, corp.getUrl()); // 企业网址
				pstmt.setString(26, corp.getDescription()); // 备注
				pstmt.setDate(27, new Date(new java.util.Date().getTime())); // 修改时间
				pstmt.setString(28, corp.getAssets());
				pstmt.setString(29, corp.getMachinery());
				pstmt.setString(30, corp.getCorpId()); // 主键
				check = pstmt.executeUpdate();
				if (check > 0) {
					message = "修改成功！";
				} else {
					message = "修改成功。";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}

		}
		
		return message;
	}

	// 查询区
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {

			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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

	//查询黑龙江所有市 
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		String sql = "select * from TBXZQDMDIC where code like '23%00' and code != '230000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
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

}
