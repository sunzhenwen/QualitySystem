package com.tj.jst.inner.qualificationProductivity.querySeparateQualification.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������Ϣ��ѯ
 * @author DarkFlameMaster
 *
 */
public interface IQuerySeparateQualificationDao {

	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition);
	
	/**
	 * ��ת������ѯҳ��
	 * @return
	 */
	public NewQualification queryapproval(String newQualId);
	
	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	public List<DictionaryClass> queryCretLevels();
			
	//��������(�ֵ��TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums();
	
	//��ѯԭ������Ϣ
	public NewQualification queryOldInfo(String corpId , int cretType , int cretLevel);
	
	//��תҳ���ж�
	public String queryUpdate(String newQualId);
}
