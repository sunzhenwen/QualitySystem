package com.tj.jst.inner.qualificationProductivity.changearea.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 内网审批归属地变更Dao接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IChangeAreaDao {

	/**
	 * 审批分页
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 审批通过
	 * 
	 * @param change
	 * @return
	 */
	public String approvalSuccess(ChangeArea change);

	/**
	 * 审批不通过
	 * 
	 * @param change
	 * @return
	 */
	public String approvalFailed(ChangeArea change);

	/**
	 * 查询跨省所在地名称
	 * 
	 * @param cityNum
	 * @return
	 */
	public String queryCityName(String cityNum);

	/**
	 * 审批通过时，更改证书编号。
	 * 
	 * @param change
	 * @return
	 */
	public String changeCertificateCode(ChangeArea change);

	/**
	 * 跳转审批页面
	 * 
	 * @param changeId
	 * @return
	 */
	public ChangeArea queryById(String changeId);

	/**
	 * 查询企业
	 * 
	 * @param corpName
	 * @return
	 */
	public Corp queryCorp(String corpName);

	/**
	 * 更改企业归属地
	 * 
	 * @param corp
	 * @return
	 */
	public String changeCorpArea(Corp corp , String cityNum);

}
