package com.tj.jst.outside.staffmanage.positions.dao;

import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;

public interface IPositionsDao {
	//��ҳ��ѯ
	public Page pagedQuery(Condition condition);
}
