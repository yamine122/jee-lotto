package com.lotto.web.serviceimpls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lotto.web.daoimpls.LottoDaoImpl;
import com.lotto.web.daos.LottoDao;
import com.lotto.web.domains.LottoBean;
import com.lotto.web.services.LottoService;

public class LottoServiceImpl implements LottoService{
		private LottoDao dao;
		
	public LottoServiceImpl() {
			dao = new LottoDaoImpl();
		}
	@Override
	public void createLotto(LottoBean param) {
		param.setBall(createBall());
		param.setLotteryNum(createLotteryNum());
		param.setLottoSeq(createSeq());
		
		dao.insertLotto(param);
		
		
	}
	@Override
	public String createBall() {
		/*Random r = new Random();
		String ball ="";
		for(int i = 0; i < 6; i++) {
			if(i == 5) {
				ball += r.nextInt(45)+1+" ";
				break;
			}else{
				ball += r.nextInt(45)+1+",";
			}
		}*/
		return new Random().nextInt(45)+1+"";
	}
	@Override
	public String createSeq() {
		Random r = new Random();
		String seq = "";
		for(int i = 0 ; i < 4; i++) {
			if(i == 0) {
				seq = "no."+r.nextInt(10);
			}else {
				seq += String.valueOf(r.nextInt(10));
			}
		}
			
		return seq;
	}
	@Override
	public String createLotteryNum() {
		String lotteryNum = "";
			for(int i = 0; i < 6; i++) {
				if(i == 5) {
					lotteryNum += createBall();
					break;
				}else{
					lotteryNum += createBall()+",";
				}
		}
		return lotteryNum;
	}
	@Override
	public boolean duplicatePrevention() {
		boolean flag = false;
		
		int[] arr = new int[6];
		for(int i = 0 ; i < arr.length; i++) {
			arr[i] = i+1;
		}
		int temp = 0;
		int j = 0;
		for(int i = 0 ; i < 6; i++) {
			j = (int)(Math.random()*45);
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			flag = true;
		}
		
		
		return flag;
	}

}
