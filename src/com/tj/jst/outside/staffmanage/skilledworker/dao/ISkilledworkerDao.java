package com.tj.jst.outside.staffmanage.skilledworker.dao;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

public interface ISkilledworkerDao {
	
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	//������Ա����ѯ
	public List<DictionaryClass> skilledTypeNums();
	//������Ա�����ѯ
	public List<DictionaryClass> skilledLevelNums();
	//������Ա��Ϣ
	public String addPersonInfo(Skilledworker skilledworker);
	//�޸���Ա��Ϣ
	public String modifyPersonInfo(Skilledworker skilledworker);
	//����idCard��personId��ֵ���ж��Ƿ����ظ������Ϣ
	public String queryIdCardInfo(String identitycard,String personId);
	//ͨ��personId���ж����޸Ļ�ɾ������Ա
	public Skilledworker queryById(String personId);
	//ɾ����Ա��Ϣ
	public String deletePersonInfo(String personId);
	//�Ա���Ϣ
	public List<DictionaryClass> sexNums();
	//������Ϣ
	public List<DictionaryClass> nationalNums();
	//ѧ��
	public List<DictionaryClass> eduLevelNums();
	//ѧλ
	public List<DictionaryClass> degreeNums();
	//֤������
	public List<DictionaryClass> idCardTypeNums();
	
	//��ְ����Ա��Ѱ���Ƿ�����ͬ��֤������
	public String queryFromTitle(String identitycard,String corpCode);
	
	//�ڸ�λ��Ա��Ѱ���Ƿ�����ͬ��֤������
	public String queryFromPos(String identitycard,String corpName);
	
}
