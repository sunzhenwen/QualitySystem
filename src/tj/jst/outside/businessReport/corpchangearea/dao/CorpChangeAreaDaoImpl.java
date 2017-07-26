package com.tj.jst.outside.businessReport.corpchangearea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

public class CorpChangeAreaDaoImpl extends BaseDao implements
		ICorpChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 查询企业信息
	 */
	@Override
	public CertifiedCorp queryPage(String corpName) {
		// TODO Auto-generated method stub
		CertifiedCorp corp = new CertifiedCorp();
		String sql = "select c.*,(select p.name from TBXZQDMDIC p where c.provincenum=p.code) as provinceName,"
				+ "(select p.name from TBXZQDMDIC p where c.citynum=p.code) as cityName,"
				+ "(select p.name from TBXZQDMDIC p where c.countynum=p.code) as areaName,"
				+ "(select b.corpregtype from TBECONTYPEDIC b where c.economicNum=b.code) as economicName,"
				+ "(select h.currency from TBPRINCIPALUNITDIC h where c.principalunitnum=h.code) as principalUnitName "
				+ "from TBCORPBASICINFO c where c.corpName=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 如果资质数据库存在，返回修改页面
				corp.setCorpId(rs.getString("corpId")); // 主键
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));// 工商营业执照注册号
				corp.setProvinceName(rs.getString("provinceName"));// 注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityName(rs.getString("cityName")); // 注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyName(rs.getString("areaName")); // 注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countynum"));
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));// 企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// 法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// 法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));// 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// 法定代表人职称
				corp.setEconomicName(rs.getString("economicName")); // 企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本(万元)
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));// 注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// 成立日期
				corp.setOfficePhone(rs.getString("officePhone"));// 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setSpare1(rs.getString("spare1"));// 企业归属地
				corp.setAssets(rs.getString("ASSETS"));
				corp.setMachinery(rs.getString("MACHINERY"));
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
	 * 提交变更申请
	 */
	@Override
	public String approvalUpdate(ChangeArea change , int mark) {
		// TODO Auto-generated method stub
		String sql = "insert into TB_CHANGEAREA(CHANGEID,CORPNAME,BEFOREAREA,AFTERPROVINCEAREA,AFTERCITYAREA,STATUS,PROCESS,MARK) values (?,?,?,?,?,?,?,?)";
		int check = 0;
		String message = "";
		String changeId = UUID.randomUUID().toString();
		String cityNum = "";
		if (change.getStatus().equals("2")) {
			cityNum = change.getAfterProvinceCityArea();
		}
		if (change.getStatus().equals("1")) {
			cityNum = change.getAfterCityArea();
			change.setAfterProvinceArea("");
		}
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changeId); // 主键
			pstmt.setString(2, change.getCorpName());// 企业名称
			pstmt.setString(3, change.getBeforeArea());// 原归属地
			pstmt.setString(4, change.getAfterProvinceArea());// 想要变更的归属地所在省
			pstmt.setString(5, cityNum);// 想要变更的归属地所在市
			pstmt.setString(6, change.getStatus());// 获取归属地是否为本省
			pstmt.setString(7, "1");// 设置审批陵城为企业提交.
			pstmt.setString(8, Integer.toString(mark));// 设置是否需要省厅审批.
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "提交成功,请到受理大厅审核！";
			} else {
				message = "提交失败！";
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
	 * 查询省
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000' and code !='230000'";
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
	 * 查询是否需要厅局审批
	 */
	@Override
	public String queryMark(String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		int count = 0;
		String sql = "select * from TBCORPCERTDETAILINFO where corpName = '"
				+ corpName + "' ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				if (rs.getString("APPROVALDEPT").length() == 2) {
					message = "省厅审批";
				}
			}
			if (count != 0) {
				if (message.equals("省厅审批")) {
					message = "省厅";
				}
			}else if(count == 0){
				message = "无资质";
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
