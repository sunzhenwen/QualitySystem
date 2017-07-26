package com.tj.jst.outside.staffmanage.constructor.service;

import java.util.List;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.staffmanage.constructor.dao.ConstructorDaoImpl;
import com.tj.jst.outside.staffmanage.constructor.dao.IConstructorDao;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

public class ConstructorServiceImpl implements IConstructorService {

	//��ҳ��ѯ
	@Override
	public Page pagedQuery(Condition condition) {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.pagedQuery(condition);
	}

	//ѧ��
	@Override
	public List<DictionaryClass> eduLevelNums() {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.eduLevelNums();
	}

	//ѧλ
	@Override
	public List<DictionaryClass> degreeNums() {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.degreeNums();
	}

	//��ѯ��ϸ
	@Override
	public Constructor queryDetailed(String personId,String type) {
		IConstructorDao constructorDao = new ConstructorDaoImpl();
		return constructorDao.queryDetailed(personId,type);
	}
}
