package com.tj.jst.outside.staffmanage.skilledworker.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;

public interface ISkilledworkerService {
	
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
	//������Ա����
	public List<DictionaryClass> skilledTypeNums();
	//������Ա����
	public List<DictionaryClass> skilledLevelNums();
	//������Ա��Ϣ
	public String addPersonInfo(Skilledworker skilledworker);
	//�޸���Ա��Ϣ
	public String modifyPersonInfo(Skilledworker skilledworker);
	public Skilledworker queryById(String personId);
	public String queryIdCardInfo(String identitycard, String personId);
	//ɾ����Ա
	public String delete(String personId);
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
