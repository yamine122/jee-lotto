package com.lotto.web.daoimpls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.lotto.web.daos.ConsumerDao;
import com.lotto.web.domains.ConsumerBean;

public class ConsumerDaoImpl implements ConsumerDao{
	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-lotto%sWebContent%sresources%stxt%s" , 
			 File.separator,
			 File.separator,
			 File.separator,
			 File.separator,
			 File.separator,
			 File.separator,
			 File.separator,
			 File.separator);
	@Override
	public void insertConsumer(ConsumerBean param) {
		try {
			File file = new File(FILE_PATH+"consumers.txt");
			@SuppressWarnings("resource")
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(String.format("%s,%s", param.getCid(), param.getPass()));
			writer.newLine();
			writer.flush();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
