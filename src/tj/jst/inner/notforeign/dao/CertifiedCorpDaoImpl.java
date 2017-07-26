package com.tj.jst.inner.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;

public class CertifiedCorpDaoImpl implements ICertifiedCorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//证件类型
	@Override
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//修改企业
	@Override
	public String modifyCorp(CertifiedCorp corp) {
		String message = "";
		String sql = "update TBCorpBasicinfo set POSTALCODE=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,OFFICEPHONE=?,FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,"
				+ "EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS = ?,MACHINERY = ?,CORPBIRTHDATE = ? where CORPID=? ";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getPostalCode());	//企业营业地址邮政编码
			pstmt.setString(2,corp.getIdCardTypeNum());	//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(3,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(4,corp.getLegalManDuty());	//法定代表人职务
			pstmt.setString(5,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setString(6,corp.getOfficePhone());	//办公电话
			pstmt.setString(7,corp.getFax());			//传真号码
			pstmt.setString(8,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(9,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(10,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(11,corp.getEmail());		//联系邮箱
			pstmt.setString(12,corp.getUrl());			//企业网址
			pstmt.setString(13,corp.getDescription());	//备注
			pstmt.setDate(14,new Date(new java.util.Date().getTime()));	//修改时间
			pstmt.setString(15,corp.getAssets());	//系统来源
			pstmt.setString(16,corp.getMachinery());	//系统来源
			pstmt.setDate(17,corp.getCorpBirthDate());	//企业成立日期
			pstmt.setString(18,corp.getCorpId());	//主键
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(message.equals("修改成功！"))
		{
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,corp.getPostalCode());	//企业营业地址邮政编码
				pstmt.setString(2,corp.getIdCardTypeNum());	//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				pstmt.setString(3,corp.getLegalManIdCard());//法定代表人证件号码
				pstmt.setString(4,corp.getLegalManDuty());	//法定代表人职务
				pstmt.setString(5,corp.getLegaManProtitle());//法定代表人职称
				pstmt.setString(6,corp.getOfficePhone());	//办公电话
				pstmt.setString(7,corp.getFax());			//传真号码
				pstmt.setString(8,corp.getLinkMan()); 		//联系人姓名
				pstmt.setString(9,corp.getLinkTel());		//联系人办公电话
				pstmt.setString(10,corp.getLinkPhone());	//联系人手机号码
				pstmt.setString(11,corp.getEmail());		//联系邮箱
				pstmt.setString(12,corp.getUrl());			//企业网址
				pstmt.setString(13,corp.getDescription());	//备注
				pstmt.setDate(14,new Date(new java.util.Date().getTime()));	//修改时间
				pstmt.setString(15,corp.getAssets());	//系统来源
				pstmt.setString(16,corp.getMachinery());	//系统来源
				pstmt.setDate(17,corp.getCorpBirthDate());	//企业成立日期
				pstmt.setString(18,corp.getCorpId());	//主键
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "修改成功！";
				}else
				{
					message = "修改成功！01";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	//企业信息查询
	@Override
	public CertifiedCorp queryCorp(String corpId) {
		CertifiedCorp corp = new CertifiedCorp();
		String sql = "select c.*,(select p.name from TBXZQDMDIC p where c.provincenum=p.code) as provinceName,"
				+ "(select p.name from TBXZQDMDIC p where c.citynum=p.code) as cityName,"
				+ "(select p.name from TBXZQDMDIC p where c.countynum=p.code) as areaName,"
				+ "(select b.corpregtype from TBECONTYPEDIC b where c.economicNum=b.code) as economicName,"
				+ "(select h.currency from TBPRINCIPALUNITDIC h where c.principalunitnum=h.code) as principalUnitName "
				+ "from TBCORPBASICINFO c where c.corpId=?";
		
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				//如果资质数据库存在，返回修改页面
				corp.setCorpId(rs.getString("corpId"));		//主键	
				corp.setCorpName(rs.getString("corpName"));	//企业名称
				corp.setCorpCode(rs.getString("corpCode")); 	//组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));//工商营业执照注册号
				corp.setProvinceName(rs.getString("provinceName"));//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityName(rs.getString("cityName"));		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyName(rs.getString("areaName"));	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countynum"));
				corp.setAddress(rs.getString("address"));		//企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));//企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan"));	//法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));//法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));//法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));//法定代表人职称
				corp.setEconomicName(rs.getString("economicName"));	//企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setRegPrin(rs.getString("regPrin")); 		//注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin"));	//实收资本(万元)
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));//注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//成立日期
				corp.setOfficePhone(rs.getString("officePhone"));//办公电话
				corp.setFax(rs.getString("fax"));				//传真号码
				corp.setLinkMan(rs.getString("linkMan")); 		//联系人姓名
				corp.setLinkTel(rs.getString("linkTel"));		//联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone"));	//联系人手机号码
				corp.setEmail(rs.getString("email"));			//联系邮箱
				corp.setUrl(rs.getString("url"));				//企业网址
				corp.setDescription(rs.getString("description"));	//备注
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setSpare1(rs.getString("spare1"));
				corp.setAssets(rs.getString("ASSETS"));
				corp.setMachinery(rs.getString("MACHINERY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	/**
	 * 企业资质是否就位判断
	 */
	@Override
	public String perchCheck(String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBQUALIFICATIONAPPLY where corpCode = ? and ( QUALIFTYPE = '9' or QUALIFTYPE = '5' or QUALIFTYPE = '1' or QUALIFTYPE = 'a')";
		try{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				message = "已就位";
			}
			else{
				message = "未就位";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * 未就位企业信息修改
	 */
	@Override
	public String modifyCorpTwo(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCORPBASICINFO set CORPNAME = ? , "
				+ " LICENSENUM = ? , PROVINCENUM = ? , CITYNUM = ? , COUNTYNUM = ? , "
				+ "ADDRESS = ? , POSTALCODE = ? , LEGALMAN = ? , IDCARDTYPENUM = ? , "
				+ "LEGALMANIDCARD = ? , LEGALMANDUTY = ? , LEGAMANPROTITLE = ? , "
				+ "ECONOMICNUM = ? , REGPRIN = ? , FACTREGPRIN = ? , PRINCIPALUNITNUM = ? , "
				+ "CORPBIRTHDATE = ? , OFFICEPHONE= ? , FAX = ? , LINKMAN = ? , "
				+ "LINKTEL = ? , LINKPHONE = ? , EMAIL = ? , URL = ? , DESCRIPTION = ? , ASSETS = ? , MACHINERY = ? "
				+ "where corpId = ? ";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());						//企业名称
			pstmt.setString(2,corp.getLicenseNum());					//工商营业执照
			pstmt.setString(3,corp.getProvinceNum());					//注册所在省
			pstmt.setString(4,corp.getCityNum());						//注册所在地
			pstmt.setString(5,corp.getCountyNum());						//注册所在市
			pstmt.setString(6,corp.getAddress());						//企业营业地址
			pstmt.setString(7,corp.getPostalCode());					//邮政编码
			pstmt.setString(8,corp.getLegalMan());						//法定代表人姓名
			pstmt.setString(9,corp.getIdCardTypeNum());				//法定代表人证件类型
			pstmt.setString(10,corp.getLegalManIdCard());				//法定代表人证件号码
			pstmt.setString(11,corp.getLegalManDuty());					//法定代表人职务
			pstmt.setString(12,corp.getLegaManProtitle());				//法定代表人职称
			pstmt.setString(13,corp.getEconomicNum());					//企业登记注册类型
			pstmt.setString(14,corp.getRegPrin());						//注册资本（万元）
			pstmt.setString(15,corp.getFactRegPrin());					//实收资本（万元）
			pstmt.setString(16,corp.getPrincipalUnitNum());				//注册资本币种
			pstmt.setDate(17,corp.getCorpBirthDate());					//成立日期
			pstmt.setString(18,corp.getOfficePhone());					//办公电话
			pstmt.setString(19,corp.getFax());							//传真号码
			pstmt.setString(20,corp.getLinkMan());						//联系人姓名
			pstmt.setString(21,corp.getLinkTel());						//联系人办公电话
			pstmt.setString(22,corp.getLinkPhone());					//联系人手机
			pstmt.setString(23,corp.getEmail());						//联系邮箱
			pstmt.setString(24,corp.getUrl());							//企业网址
			pstmt.setString(25,corp.getDescription());					//备注
			pstmt.setString(26,corp.getAssets());						//净资产
			pstmt.setString(27,corp.getMachinery());					//机械设备
			pstmt.setString(28,corp.getCorpId());						//企业Id
			int check = pstmt.executeUpdate();			
			if(check == 1)
			{
				message = "修改成功！";
			}else
			{
				message = "修改失败！";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(message.equals("修改成功！")){
			try{
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,corp.getCorpName());						//企业名称
				pstmt.setString(2,corp.getLicenseNum());					//工商营业执照
				pstmt.setString(3,corp.getProvinceNum());					//注册所在省
				pstmt.setString(4,corp.getCityNum());						//注册所在地
				pstmt.setString(5,corp.getCountyNum());						//注册所在市
				pstmt.setString(6,corp.getAddress());						//企业营业地址
				pstmt.setString(7,corp.getPostalCode());					//邮政编码
				pstmt.setString(8,corp.getLegalMan());						//法定代表人姓名
				pstmt.setString(9,corp.getIdCardTypeNum());				//法定代表人证件类型
				pstmt.setString(10,corp.getLegalManIdCard());				//法定代表人证件号码
				pstmt.setString(11,corp.getLegalManDuty());					//法定代表人职务
				pstmt.setString(12,corp.getLegaManProtitle());				//法定代表人职称
				pstmt.setString(13,corp.getEconomicNum());					//企业登记注册类型
				pstmt.setString(14,corp.getRegPrin());						//注册资本（万元）
				pstmt.setString(15,corp.getFactRegPrin());					//实收资本（万元）
				pstmt.setString(16,corp.getPrincipalUnitNum());				//注册资本币种
				pstmt.setDate(17,corp.getCorpBirthDate());					//成立日期
				pstmt.setString(18,corp.getOfficePhone());					//办公电话
				pstmt.setString(19,corp.getFax());							//传真号码
				pstmt.setString(20,corp.getLinkMan());						//联系人姓名
				pstmt.setString(21,corp.getLinkTel());						//联系人办公电话
				pstmt.setString(22,corp.getLinkPhone());					//联系人手机
				pstmt.setString(23,corp.getEmail());						//联系邮箱
				pstmt.setString(24,corp.getUrl());							//企业网址
				pstmt.setString(25,corp.getDescription());					//备注
				pstmt.setString(26,corp.getAssets());						//净资产
				pstmt.setString(27,corp.getMachinery());					//机械设备
				pstmt.setString(28,corp.getCorpId());						//企业Id
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "修改成功！";
				}else
				{
					message = "修改成功!01";
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "修改失败，请确认您填写的信息是否符合要求！";
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	/**
	 * 不能有相同的组织机构代码证
	 */
	@Override
	public String queryCorpCode(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		try{
			String sql = "select * from TBCorpBasicinfo where corpCode=? and corpId != ?";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpCode());
			pstmt.setString(2, corp.getCorpId());
			rs = pstmt.executeQuery();
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				message = "您所添加的企业组织机构代码证已经被录入，请确认您填写的信息！";
			}else{
				message = "企业信息修改成功";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
}
