package com.tj.jst.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.login.model.Login;

public class LoginDaoImpl implements ILoginDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//查询企业ukey登陆
	@Override
	public Login query(String results) {
		String sql = "select t.*,"
				+ "(select a.name from TBXZQDMDIC a where a.code=t.provincenum) as provinceName,"
				+ "(select b.name from TBXZQDMDIC b where b.code=t.citynum) as cityName,"
				+ "(select c.name from TBXZQDMDIC c where c.code=t.countynum) as countyName "
				+ "from TBCORPBASICINFO t where t.LOCKNUMBER1='"+results+"' or t.LOCKNUMBER2='"+results+"' "
						+ "or t.LOCKNUMBER3='"+results+"'";
		Login login = new Login();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				login.setuKey(results);
				//主键
				login.setUserId(rs.getString("corpId"));
				//企业名称
				login.setUserName(rs.getString("corpName"));
				//组织机构代码
				login.setCorpCode(rs.getString("corpCode"));
				//工商营业执照号
				login.setLicenseNum(rs.getString("licenseNum"));
				//省编码
				login.setProvincenum(rs.getString("provincenum"));
				//省名称
				login.setProvinceName(rs.getString("provinceName"));
				//市编码
				login.setCitynum(rs.getString("citynum"));
				//市名称
				login.setCityName(rs.getString("cityName"));
				//区编码
				login.setCountynum(rs.getString("countynum"));
				//区名称
				login.setCountyName(rs.getString("countyName"));
				//企业营业地址
				login.setAddress(rs.getString("address"));
				//企业登记注册类型(字典表：TBECONTYPEDIC)
				login.setEconomicNum(rs.getInt("economicNum"));
				//法定代表人姓名
				login.setLegalMan(rs.getString("LEGALMAN"));
				//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				login.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				//法定代表人证件号码
				login.setLegalManIdCard(rs.getString("legalManIdCard"));
				//法定代表人职务
				login.setLegaLManDuty(rs.getString("legaLManDuty"));
				//法定代表人职称
				login.setLegaManProtitle(rs.getString("legaManProtitle"));
				//注册资本
				login.setRegPrin(rs.getString("REGPRIN"));
				//企业归属地编码
				String spare1=rs.getString("spare1");
				login.setSpare1(spare1);
				
				if(spare1.equals("230100"))
				{
					login.setSpareName("哈尔滨");
				}
				if(spare1.equals("230200"))
				{
					login.setSpareName("齐齐哈尔");
				}
				if(spare1.equals("231000"))
				{
					login.setSpareName("牡丹江");
				}
				if(spare1.equals("230600"))
				{
					login.setSpareName("大庆");
				}
				if(spare1.equals("230700"))
				{
					login.setSpareName("伊春");
				}
				if(spare1.equals("230400"))
				{
					login.setSpareName("鹤岗");
				}
				if(spare1.equals("230800"))
				{
					login.setSpareName("佳木斯");
				}
				if(spare1.equals("231100"))
				{
					login.setSpareName("黑河");
				}
				if(spare1.equals("232700"))
				{
					login.setSpareName("大兴安岭地区");
				}
				if(spare1.equals("400021"))
				{
					login.setSpareName("森工");
				}
				if(spare1.equals("400022"))
				{
					login.setSpareName("绥芬河");
				}
				if(spare1.equals("400023"))
				{
					login.setSpareName("抚远");
				}
				if(spare1.equals("230300"))
				{
					login.setSpareName("鸡西");
				}
				if(spare1.equals("400020"))
				{
					login.setSpareName("农垦");
				}
				if(spare1.equals("230900"))
				{
					login.setSpareName("七台河");
				}
				if(spare1.equals("230500"))
				{
					login.setSpareName("双鸭山");
				}
				if(spare1.equals("231200"))
				{
					login.setSpareName("绥化");
				}
				
				//新老数据
				login.setOldOrNew(rs.getString("oldOrNew"));
				//净资产
				login.setAssets(rs.getString("assets"));
				//机械设备
				login.setMachinery(rs.getString("machinery"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return login;
	}

	
	public List<String> getRole(String Ukey, String RoleSyetemID)
	{
		String sql = "select name,Loginuserid,roleID,departmentID,popedomid,department,personalID,rolename,department,popedomname,ROLESYSTMID,rolesystemname from VIEW_LOGINUSER_ROLE where Ukey=? and ROLESYSTMID=?";
		List<String> list = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, Ukey);
			pstmt.setString(2, RoleSyetemID);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				list.add(rs.getString("Loginuserid"));//用户Id
				list.add(rs.getString("name"));//用户名
				list.add(rs.getString("roleID"));//角色ID
				list.add(rs.getString("departmentID"));//部门ID
				list.add(rs.getString("popedomid"));//权限集合
				list.add(rs.getString("department"));//部门名称
				list.add(rs.getString("personalID"));//人员ID
				list.add(rs.getString("rolename"));//角色名称
				list.add(rs.getString("ROLESYSTMID"));//系统ID
				list.add(rs.getString("rolesystemname"));//系统名称
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


	/**
	 * 根据企业名称查询企业锁号
	 * @param corpName
	 * @return
	 */
	@Override
	public String queryDeptByName(String corpName) {
		// TODO Auto-generated method stub
		String results = null ;
		String sql = "select * from view_loginuser_role where name = ? " ;
		
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("UKEY");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		
		return results;
	}


	/**
	 * 根据名称查询部门
	 * @param corpName
	 * @return
	 */
	@Override
	public String queryCorpByName(String corpName) {
		// TODO Auto-generated method stub
		String results = null ;
		String sql = "select * from TBCORPBASICINFO where corpName = ? and lockNumber1 is not null" ;
		
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				results = rs.getString("lockNumber1");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		
		return results;
	}
}
