package com.tj.jst.outside.staffmanage.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.title.model.Title;

public interface ITitleService {

	// ��ҳ��ѯ
	public Page pagedQuery(Condition condition);

	/**
	 * ���
	 * 
	 * @return
	 */
	public String add(Title title);

	/**
	 * �޸�
	 * 
	 * @return
	 */
	public Title queryById(String personId);

	/**
	 * ͨ����ѯIDcardֵ��personID��ֵ���ж��������֤����Ϣ�Ƿ��ظ���
	 * 
	 * @param idCard
	 * @param personId
	 * @return
	 */
	public String queryIdCardInfo(String idCard, String personId);

	/**
	 * �޸�
	 * 
	 * @return
	 */
	public String modify(Title title);

	/**
	 * ɾ��
	 * 
	 * @return
	 */
	public String delete(String personId);

	/**
	 * ��ѯ�Ա�
	 * 
	 * @return
	 */
	public List<DictionaryClass> querySexNums();

	/**
	 * ��ѯ֤������
	 * 
	 * @return
	 */
	public List<DictionaryClass> queryIdCardTypeNums();

	/**
	 * ��ѯ������Ա���ݿ����Ƿ����ظ�����
	 * 
	 * @param idCard
	 * @return
	 */
	public String queryFormSkill(String idCard, String corpCode);

	/**
	 * ��ѯ��λ��Ա���Ƿ����ظ�֤������
	 * 
	 * @param idCard
	 * @return
	 */
	public String queryFormPos(String idCard, String corpName);
}
