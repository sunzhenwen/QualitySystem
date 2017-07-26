package com.tj.jst.inner.qualificationProductivity.changearea.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * �������������ر��Dao�ӿ�
 * 
 * @author DarkFlameMaster
 *
 */
public interface IChangeAreaDao {

	/**
	 * ������ҳ
	 * 
	 * @param condition
	 * @return
	 */
	public Page queryPage(Condition condition);

	/**
	 * ����ͨ��
	 * 
	 * @param change
	 * @return
	 */
	public String approvalSuccess(ChangeArea change);

	/**
	 * ������ͨ��
	 * 
	 * @param change
	 * @return
	 */
	public String approvalFailed(ChangeArea change);

	/**
	 * ��ѯ��ʡ���ڵ�����
	 * 
	 * @param cityNum
	 * @return
	 */
	public String queryCityName(String cityNum);

	/**
	 * ����ͨ��ʱ������֤���š�
	 * 
	 * @param change
	 * @return
	 */
	public String changeCertificateCode(ChangeArea change);

	/**
	 * ��ת����ҳ��
	 * 
	 * @param changeId
	 * @return
	 */
	public ChangeArea queryById(String changeId);

	/**
	 * ��ѯ��ҵ
	 * 
	 * @param corpName
	 * @return
	 */
	public Corp queryCorp(String corpName);

	/**
	 * ������ҵ������
	 * 
	 * @param corp
	 * @return
	 */
	public String changeCorpArea(Corp corp , String cityNum);

}
