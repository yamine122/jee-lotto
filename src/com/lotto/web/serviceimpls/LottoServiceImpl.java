package com.lotto.web.serviceimpls;

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
		param.setBall(createBall()+"");
		param.setLotteryNum(createLotteryNum());
		param.setLottoSeq(createSeq());
		
		dao.insertLotto(param);
		
		
	}
	@Override
	public int createBall() {
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
		return (int)(Math.random() * 45)+1;
	}
	@Override
	public String createSeq() {
		Random r = new Random();
		  String result = "No.";
		  for (int i = 0; i < 4; i++) {
		   result += r.nextInt(9) + "";

		  }
		return result;
	}
	@Override
	public String createLotteryNum() {
		String lotteryNum = "";
		int[] arr = new int[6];
			for(int i = 0; i < arr.length; i++) {
				int a = createBall();
				if(!exist(arr , a)) {
					arr[i] = a;
				}else {
					i--;
				}
			}
			
			arr = bubbleSort(arr , true);
			
			
			for(int i = 0; i < arr.length; i++) {
				
				lotteryNum += arr[i]+",";
		}
		return lotteryNum;
	}
	@Override
	public boolean exist(int[] arr , int a) {
		boolean flag = false;
		for(int i : arr) {
			if(a == i) {
				flag = true;
			}
		}
		
		
		return flag;
	}
	@Override
	public int[] bubbleSort(int[] arr , boolean flag) {
		int t = 0;
		for(int i = 0 ; i < arr.length; i++) {
			for(i = 0 ; i < arr.length-1; i++) {
				if(arr[i] >arr[i+1]) {
					t = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = t;
				}else {
					if(arr[i] < arr[i+1]) {
						t = arr[i];
						arr[i] = arr[i+1];
						arr[i+1] = t;
					}
				}
			}
		}
	
		return arr;
	}

}
