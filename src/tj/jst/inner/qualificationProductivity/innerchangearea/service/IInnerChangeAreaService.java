package com.tj.jst.inner.qualificationProductivity.innerchangearea.service;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.innerchangearea.model.InnerChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ���������޸���ҵ�����ط���ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IInnerChangeAreaService {

	/**
	 * ��ҳ����
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ��ѯ��ҵ��Ϣ
	 * 
	 * @param corpId
	 * @return
	 */
	public Corp queryCorp(String corpCode);

	/**
	 * ������ҵ������
	 * 
	 * @param corpCode
	 * @param cityNum
	 * @return
	 */
	public String changeArea(String corpCode, String cityNum);

	/**
	 * ��¼������Ϣ
	 * 
	 * @param info
	 * @return
	 */
	public String recordLog(InnerChangeArea info);

	/**
	 * ��־��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryInfoPage(Condition condition);

}
