package com.tj.jst.inner.system.qualificationRevocation.condition;

import java.sql.Date;

import com.tj.jst.base.page.Condition;

/**
 * 企业已获资质打回
 * @author Administrator
 *
 */
public class QualificationRevocationCondition extends Condition {
	
	private String corpCode ;
	private String corpName ;
	// 部门Id
	private String deptId;
	// 人员Id
	private String personalID;
	
	public QualificationRevocationCondition() {
		// TODO Auto-generated constructor stub
	}
	
	public QualificationRevocationCondition(String deptId){
		this.deptId = deptId ;
	}
	
	public QualificationRevocationCondition(String deptId,String personalID){
		this.deptId = deptId ;
		this.personalID = personalID ;
	}
	
	
	@Override
	public String getInitialSql() {
		//设置排序
		this.setOrderByItem("corpName desc");
		//查询当前可用单位；
		StringBuffer sb = null;
		if (deptId.equals("230100")) {
			// 用人员id判断登陆用户进行过滤
			/*if (personalID.equals("400322")) {
				// 哈尔滨市企业管理站
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and QUALIFTYPE='1' and "
								+ "CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc') and cretGrade=3");
			}*/
			if (personalID.equals("400004")) {
				// 哈尔滨市企业管理站
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and "
								+ "CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc','bfdca30b-967a-4104-8b4b-91615dff947e'," 
								+"'cf7fa175-7b73-4f89-ae18-882519a2d0e0','dc53db6d-7b9c-4ef5-8593-7bce1965d98d'," 
								+"'ead0cb20-5a76-4120-bdff-bba66e81b4ba','841a088c-8687-435f-b3bd-ba262d04a176',"
								+"'80e8e0a6-d48e-47e5-bbf8-da44843e8185','d25fb2d1-abf5-4d98-b12e-a5d63ff63e6b',"
								+"'a7300268-1cab-4cce-850e-dfdbd0beebad','1959dbef-443f-4cd7-92e7-ee0ccafa330c',"
								+"'4587c1a1-3c26-4505-89af-baef1990510f','61ed166d-cc34-4ed4-946e-1d8cb2e815e0') and cretGrade=3 ");
			}
			if (personalID.equals("400018")) {
				// 哈尔滨市市城建处
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and CERTID in ('96b9f693-a572-45e5-80ff-7b06e75fc284','a13c1f06-12b7-49b2-b11f-542bc2401463') and cretGrade=3 ");
			}
//			if (personalID.equals("400362")) {
//				// 哈尔滨市市城建处2
//				sb = new StringBuffer(
//						" where rtrim(SPARE1)='"
//								+ deptId
//								+ "' and QUALIFTYPE='1' and CERTID in ('96b9f693-a572-45e5-80ff-7b06e75fc284','a13c1f06-12b7-49b2-b11f-542bc2401463') and cretGrade=3");
//			}
			if (personalID.equals("400019")) {
				// 哈尔滨市预拌商品混凝土办公事
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and CERTID in ('6fe81921-ee8f-4e2c-8c4f-c29b65c198ae') and cretGrade=3 ");
			}

		}
		else if(deptId.equals("20")) {
			sb = new StringBuffer(" where 1=1 ") ;
		}
		else {
			// 其它地市
			sb = new StringBuffer(" where rtrim(SPARE1)='" + deptId  + "' and cretGrade=3 ") ;
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		sb.append(" and corpcode is not null ");
		String sql = "select * from V_QUALICATIONREVOCATION "+sb.toString();
		System.out.println("打回sql = "+sql);
		return sql;
	}

	//查询数量
	@Override
	public String getCountSql() {
		//设置排序
		this.setOrderByItem("corpName desc");
		//查询当前可用单位；
		StringBuffer sb = null;
		if (deptId.equals("230100")) {
			// 用人员id判断登陆用户进行过滤
			/*if (personalID.equals("400322")) {
				// 哈尔滨市企业管理站
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and QUALIFTYPE='1' and "
								+ "CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc') and cretGrade=3");
			}*/
			if (personalID.equals("400004")) {
				// 哈尔滨市企业管理站
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and "
								+ "CERTID in ('ef506994-65b6-405d-9716-28b20cdb137a','b0092ed5-51bc-48f5-b772-935e1b2991bf',"
								+ "'e064abc9-0e57-4f40-920d-6adb48a85354','e6e88d31-9c1e-4308-afcd-3e7af37e74f0',"
								+ "'25103281-926c-450e-b060-9476debfd511','827329d9-8b40-4460-91a9-fafa96f74dfb',"
								+ "'cedca74f-ae14-4a07-b26b-8ab476aaa640','1f546ca1-ec64-484b-b167-21d93d0c05c3',"
								+ "'61b3467f-7af4-422b-8396-d6361e70ed67','0045a495-4757-4317-9279-4504e2744f59',"
								+ "'85e54ffd-99d6-488b-9384-fe7592e1ff7e','c9353f46-68f1-44b3-8d82-4bfc4dcad69e',"
								+ "'1f92a65d-3b66-46e9-9f2e-ac351b4514f2','38ccbd5c-e90e-4ea1-81ec-364dff56c0a7',"
								+ "'f755318a-6ce8-490a-a038-185fdc34d85d','5a15a746-46fb-4688-8e00-de324b08f341',"
								+ "'621ab385-8831-4321-a207-411b5bd84ebc','bfdca30b-967a-4104-8b4b-91615dff947e'," 
								+"'cf7fa175-7b73-4f89-ae18-882519a2d0e0','dc53db6d-7b9c-4ef5-8593-7bce1965d98d'," 
								+"'ead0cb20-5a76-4120-bdff-bba66e81b4ba','841a088c-8687-435f-b3bd-ba262d04a176',"
								+"'80e8e0a6-d48e-47e5-bbf8-da44843e8185','d25fb2d1-abf5-4d98-b12e-a5d63ff63e6b',"
								+"'a7300268-1cab-4cce-850e-dfdbd0beebad','1959dbef-443f-4cd7-92e7-ee0ccafa330c',"
								+"'4587c1a1-3c26-4505-89af-baef1990510f','61ed166d-cc34-4ed4-946e-1d8cb2e815e0') and cretGrade=3 ");
			}
			if (personalID.equals("400018")) {
				// 哈尔滨市市城建处
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and CERTID in ('96b9f693-a572-45e5-80ff-7b06e75fc284','a13c1f06-12b7-49b2-b11f-542bc2401463') and cretGrade=3 ");
			}
//			if (personalID.equals("400362")) {
//				// 哈尔滨市市城建处2
//				sb = new StringBuffer(
//						" where rtrim(SPARE1)='"
//								+ deptId
//								+ "' and QUALIFTYPE='1' and CERTID in ('96b9f693-a572-45e5-80ff-7b06e75fc284','a13c1f06-12b7-49b2-b11f-542bc2401463') and cretGrade=3");
//			}
			if (personalID.equals("400019")) {
				// 哈尔滨市预拌商品混凝土办公事
				sb = new StringBuffer(
						" where rtrim(SPARE1)='"
								+ deptId
								+ "' and CERTID in ('6fe81921-ee8f-4e2c-8c4f-c29b65c198ae') and cretGrade=3 ");
			}

		} else if(deptId.equals("20")) {
			sb = new StringBuffer(" where 1=1 ") ;
		} 
		else {
			// 其它地市
			sb = new StringBuffer(" where rtrim(SPARE1)='" + deptId + "' and cretGrade=3 " );
		}
		if(corpCode!= null && !"".equals(corpCode)){
			sb.append(" and corpCode like '%"+corpCode.trim()+"%'"); 
		}
		if(corpName != null && !"".equals(corpName)){
			sb.append(" and corpName like '%"+corpName.trim()+"%'");
		}
		sb.append(" and corpcode is not null ");
		String sqlCount="select count(*) from V_QUALICATIONREVOCATION "+sb.toString();
		System.out.println("打回sqlCount = "+sqlCount);
		return sqlCount;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}


}
