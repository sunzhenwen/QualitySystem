package com.tj.jst.inner.notforeigninfo.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;

/**
 * 企业信息操作
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpInfoDaoImpl extends BaseDao implements ICorpInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询企业组织机构代码证，不可以有重复的企业名称
	 */
	@Override
	public String queryCorpName(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			String sql = "select * from TBCorpBasicinfo where corpCode=?";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpCode());
			rs = pstmt.executeQuery();
			// 如果基础数据库存在，返回不允许企业再次注册
			if (rs.next()) {
				corp.setCheckType(0);
				corp.setMessage("您所添加的企业组织机构代码证已经被录入，请确认您填写的信息！");
				message = "您所添加的企业组织机构代码证已经被录入，请确认您填写的信息！";
			} else {
				message = "成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
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

	/**
	 * 查询市
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
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

	/**
	 * 查询区
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
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

	/**
	 * 字典：证件类
	 */
	@Override
	public List<DictionaryClass> queryIdCardType() {
		// TODO Auto-generated method stub
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

	/**
	 * 字典：登记注册类型
	 */
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
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

	/**
	 * 字典：注册币种
	 */
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
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

	/**
	 * 增加企业信息
	 */
	@Override
	public String addCorp(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
				+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,UPDATETIME,CORPID,OLDORNEW,ASSETS,MACHINERY) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
			pstmt.setString(3, corp.getLicenseNum()); // 工商营业执照注册号
			pstmt.setString(4, corp.getProvinceNum()); // 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode()); // 企业营业地址邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum()); // 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard()); // 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty()); // 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle()); // 法定代表人职称
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
			pstmt.setString(17, corp.getPrincipalUnitNum()); // 注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate()); // 成立日期
			pstmt.setString(19, corp.getOfficePhone()); // 办公电话
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
			pstmt.setString(30, corp.getAssets()); // 净资产
			pstmt.setString(31, corp.getMachinery()); // 机械设备
			int check = pstmt.executeUpdate();
			if (check == 1) {
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

		if (message.equals("注册成功,请到受理大厅审核！")) {
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName()); // 企业名称
				pstmt.setString(2, corp.getCorpCode()); // 组织机构代码
				pstmt.setString(3, corp.getLicenseNum()); // 工商营业执照注册号
				pstmt.setString(4, corp.getProvinceNum()); // 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // 企业营业地址
				pstmt.setString(8, corp.getPostalCode()); // 企业营业地址邮政编码
				pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
				pstmt.setString(10, corp.getIdCardTypeNum()); // 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard()); // 法定代表人证件号码
				pstmt.setString(12, corp.getLegalManDuty()); // 法定代表人职务
				pstmt.setString(13, corp.getLegaManProtitle()); // 法定代表人职称
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // 注册资本(万元)
				pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // 实收资本(万元)
				pstmt.setString(17, corp.getPrincipalUnitNum()); // 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate()); // 成立日期
				pstmt.setString(19, corp.getOfficePhone()); // 办公电话
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
				pstmt.setString(30, corp.getAssets()); // 净资产
				pstmt.setString(31, corp.getMachinery()); // 机械设备
				int check = pstmt.executeUpdate();
				if (check == 1) {
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

	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					CorpInfo corp = new CorpInfo();
					corp.setCorpId(rs.getString("corpId")); // 企业Id
					corp.setCorpName(rs.getString("corpName")); // 企业名称
					corp.setCorpCode(rs.getString("corpCode")); // 企业组织机构代码证
					corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
					corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
					page.getData().add(corp);
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
	 * 通过corpId来查询想要修改的企业
	 */
	@Override
	public CorpInfo queryById(String corpId) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select * from TBCORPBASICINFO where corpId = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpId(rs.getString("corpId")); // 企业Id
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码证
				corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum")); // 注册所在省
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在市
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode")); // 邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // 法定代表人证件类型
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // 发行代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty")); // 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // 法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本（万元）
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本（万元）
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // 注册资本币种
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // 成立日期
				corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("Url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery")); // 机械设备
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	/**
	 * 修改企业信息
	 */
	@Override
	public String modify(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCORPBASICINFO set CORPNAME = ? , CORPCODE = ? ,"
				+ " LICENSENUM = ? , PROVINCENUM = ? , CITYNUM = ? , COUNTYNUM = ? , "
				+ "ADDRESS = ? , POSTALCODE = ? , LEGALMAN = ? , IDCARDTYPENUM = ? , "
				+ "LEGALMANIDCARD = ? , LEGALMANDUTY = ? , LEGAMANPROTITLE = ? , "
				+ "ECONOMICNUM = ? , REGPRIN = ? , FACTREGPRIN = ? , PRINCIPALUNITNUM = ? , "
				+ "CORPBIRTHDATE = ? , OFFICEPHONE= ? , FAX = ? , LINKMAN = ? , "
				+ "LINKTEL = ? , LINKPHONE = ? , EMAIL = ? , URL = ? , DESCRIPTION = ? , ASSETS = ? ,"
				+ "MACHINERY= ?  where corpId = ? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // 企业名称
			pstmt.setString(2, corp.getCorpCode()); // 组织机构代码证
			pstmt.setString(3, corp.getLicenseNum()); // 工商营业执照
			pstmt.setString(4, corp.getProvinceNum()); // 注册所在省
			pstmt.setString(5, corp.getCityNum()); // 注册所在地
			pstmt.setString(6, corp.getCountyNum()); // 注册所在市
			pstmt.setString(7, corp.getAddress()); // 企业营业地址
			pstmt.setString(8, corp.getPostalCode()); // 邮政编码
			pstmt.setString(9, corp.getLegalMan()); // 法定代表人姓名
			pstmt.setString(10, corp.getIdCardTypeNum()); // 法定代表人证件类型
			pstmt.setString(11, corp.getLegalManIdCard()); // 法定代表人证件号码
			pstmt.setString(12, corp.getLegalManDuty()); // 法定代表人职务
			pstmt.setString(13, corp.getLegaManProtitle()); // 法定代表人职称
			pstmt.setString(14, corp.getEconomicNum()); // 企业登记注册类型
			pstmt.setString(15, corp.getRegPrin()); // 注册资本（万元）
			pstmt.setString(16, corp.getFactRegPrin()); // 实收资本（万元）
			pstmt.setString(17, corp.getPrincipalUnitNum()); // 注册资本币种
			pstmt.setDate(18, corp.getCorpBirthDate()); // 成立日期
			pstmt.setString(19, corp.getOfficePhone()); // 办公电话
			pstmt.setString(20, corp.getFax()); // 传真号码
			pstmt.setString(21, corp.getLinkMan()); // 联系人姓名
			pstmt.setString(22, corp.getLinkTel()); // 联系人办公电话
			pstmt.setString(23, corp.getLinkPhone()); // 联系人手机
			pstmt.setString(24, corp.getEmail()); // 联系邮箱
			pstmt.setString(25, corp.getUrl()); // 企业网址
			pstmt.setString(26, corp.getDescription()); // 备注
			pstmt.setString(27, corp.getAssets()); // 净资产
			pstmt.setString(28, corp.getMachinery()); // 机械设备
			pstmt.setString(29, corp.getCorpId()); // 企业Id
			int check = pstmt.executeUpdate();
			if (check == 1) {
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
		if (message.equals("修改成功！")) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName());
				pstmt.setString(2, corp.getCorpCode());
				pstmt.setString(3, corp.getLicenseNum());
				pstmt.setString(4, corp.getProvinceNum());
				pstmt.setString(5, corp.getCityNum());
				pstmt.setString(6, corp.getCountyNum());
				pstmt.setString(7, corp.getAddress());
				pstmt.setString(8, corp.getPostalCode());
				pstmt.setString(9, corp.getLegalMan());
				pstmt.setString(10, corp.getIdCardTypeNum());
				pstmt.setString(11, corp.getLegalManIdCard());
				pstmt.setString(12, corp.getLegalManDuty());
				pstmt.setString(13, corp.getLegaManProtitle());
				pstmt.setString(14, corp.getEconomicNum());
				pstmt.setString(15, corp.getRegPrin());
				pstmt.setString(16, corp.getFactRegPrin());
				pstmt.setString(17, corp.getPrincipalUnitNum());
				pstmt.setDate(18, corp.getCorpBirthDate());
				pstmt.setString(19, corp.getOfficePhone());
				pstmt.setString(20, corp.getFax());
				pstmt.setString(21, corp.getLinkMan());
				pstmt.setString(22, corp.getLinkTel());
				pstmt.setString(23, corp.getLinkPhone());
				pstmt.setString(24, corp.getEmail());
				pstmt.setString(25, corp.getUrl());
				pstmt.setString(26, corp.getDescription());
				pstmt.setString(27, corp.getAssets()); // 净资产
				pstmt.setString(28, corp.getMachinery()); // 机械设备
				pstmt.setString(29, corp.getCorpId()); // 企业Id
				int check = pstmt.executeUpdate();
				if (check == 1) {
					message = "修改成功！";
				} else {
					message = "修改失败！";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "修改失败，请确认您填写的信息是否符合要求！";
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	/**
	 * 通过corpId 和 corpName 判断所修改的企业名称是否重复
	 */
	@Override
	public String queryCorpInfoUsed(String corpId, String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBCORPBASICINFO where corpName = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (corpId.equals(rs.getString("corpId"))) {
					message = "成功";
				} else {
					message = "失败";
				}
			} else {
				message = "成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	@Override
	public CorpInfo queryByCode(String corpCode) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select * from TBCORPBASICINFO where corpCode = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpId(rs.getString("corpId"));
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码证
				corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum")); // 注册所在省
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在市
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode")); // 邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // 法定代表人证件类型
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // 发行代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty")); // 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // 法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本（万元）
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本（万元）
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // 注册资本币种
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // 成立日期
				corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("Url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery")); // 机械设备
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
