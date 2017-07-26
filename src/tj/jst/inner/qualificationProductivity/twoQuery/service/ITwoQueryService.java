package com.tj.jst.inner.qualificationProductivity.twoQuery.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ����������ʷ��¼��ѯ
 * @author DarkFlameMaster
 *
 */
public interface ITwoQueryService {
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ת����ҳ��
	 * @return
	 */
	public NewQualification queryapproval(String newQualId);
	
	/**
	 * ���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	 */
	public List<DictionaryClass> queryCretLevels();
	
	/**
	 * ��������(�ֵ��TBADDTYPEDIC)
	 */
	public List<DictionaryClass> queryAddTypeNums();

}
