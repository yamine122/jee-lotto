package com.lotto.web.serviceimpls;

import com.lotto.web.daoimpls.ConsumerDaoImpl;
import com.lotto.web.daos.ConsumerDao;
import com.lotto.web.domains.ConsumerBean;
import com.lotto.web.services.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService{
	private ConsumerDao dao;
	
	public ConsumerServiceImpl() {
		dao = new ConsumerDaoImpl();
	}
	
	
	@Override
	public void registerConsumer(ConsumerBean param) {
		dao.insertConsumer(param);
	}
}
