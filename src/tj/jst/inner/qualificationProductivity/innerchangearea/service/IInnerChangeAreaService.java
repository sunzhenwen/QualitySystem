package com.tj.jst.inner.qualificationProductivity.innerchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * 内网主动修改企业归属地服务接口
 * 
 * @author DarkFlameMaster
 *
 */
public interface IInnerChangeAreaService {

	/**
	 * 分页方法
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * 查询企业信息
	 * 
	 * @param corpId
	 * @return
	 */
	public Corp queryCorp(String corpCode);

	/**
	 * 更改企业归属地
	 * 
	 * @param corpCode
	 * @param cityNum
	 * @return
	 */
	public String changeArea(String corpCode, String cityNum);

	/**
	 * 记录操作信息
	 * 
	 * @param info
	 * @return
	 */
	public String recordLog(InnerChangeArea info);

	/**
	 * 日志查询
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryInfoPage(Condition condition);

}
