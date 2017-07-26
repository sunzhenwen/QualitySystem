package com.tj.jst.outside.staffmanage.title.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.title.dao.ITitleDao;
import com.tj.jst.outside.staffmanage.title.dao.TitleDaoImpl;
import com.tj.jst.outside.staffmanage.title.model.Title;

public class TitleServiceImpl implements ITitleService {

	// ��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.pagedQuery(condition);
	}

	/**
	 * ����ְ����Ա������Ϣ
	 */
	@Override
	public String add(Title title) {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		String message = "";
		// ��ѯ��λ��Ա���Ƿ����ظ�����
		message = titleDao.queryIdCardInfo(title.getIdCard(),
				title.getPersonId());
		if (!message.equals("�ɹ�")) {
			return message;
		} else {
			message = titleDao.queryFormPos(title.getIdCard(),
					title.getCorpName());
			if (!message.equals("�ɹ�")) {
				return message;
			} else {
				message = titleDao.queryFormSkill(title.getIdCard(),
						title.getCorpCode());
				if (!message.equals("�ɹ�")) {
					return message;
				} else {
					return titleDao.add(title);
				}
			}
		}
	}

	/**
	 * �޸�ְ����Ա��Ϣ
	 */
	@Override
	public String modify(Title title) {
		ITitleDao titleDao = new TitleDaoImpl();
		String message = "";
		message = titleDao.queryIdCardInfo(title.getIdCard(),
				title.getPersonId());
		if (!message.equals("�ɹ�")) {
			return message;
		} else {
			message = titleDao.queryFormSkill(title.getIdCard(),
					title.getCorpCode());
			if (!message.equals("�ɹ�")) {
				return message;
			} else {
				message = titleDao.queryFormPos(title.getIdCard(),
						title.getCorpName());
				if (!message.equals("�ɹ�")) {
					return message;
				} else {
					return titleDao.modify(title);
				}
			}
		}
	}

	/**
	 * ͨ��PersonId���жϽ���ɾ��������ְ����Ա��Ϣ
	 */
	@Override
	public String delete(String personId) {
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.delete(personId);
	}

	/**
	 * �ֵ䣺�Ա���
	 */
	@Override
	public List<DictionaryClass> querySexNums() {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.querySexNums();
	}

	/**
	 * �ֵ䣺֤��������
	 */
	@Override
	public List<DictionaryClass> queryIdCardTypeNums() {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.queryIdCardTypeNums();
	}

	/**
	 * ����personId��Ѱ�ҽ���ɾ�������޸Ĳ�������Ա��Ϣ
	 */
	@Override
	public Title queryById(String personId) {
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.queryById(personId);
	}

	/**
	 * ͨ��idCard��personId���ж�֤�������Ƿ��ظ�
	 */
	@Override
	public String queryIdCardInfo(String idCard, String personId) {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.queryIdCardInfo(idCard, personId);
	}

	/**
	 * ��ѯ������Ա���ж��Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormSkill(String idCard, String corpCode) {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.queryFormSkill(idCard, corpCode);
	}

	/**
	 * ��ѯ��λ��Ա�Ƿ����ظ�֤������
	 */
	@Override
	public String queryFormPos(String idCard, String corpName) {
		// TODO Auto-generated method stub
		ITitleDao titleDao = new TitleDaoImpl();
		return titleDao.queryFormPos(idCard, corpName);
	}

}
