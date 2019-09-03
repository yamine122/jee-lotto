package com.lotto.web.services;

import com.lotto.web.domains.LottoBean;

public interface LottoService {
	public void createLotto(LottoBean param);
	public int createBall();
	public String createSeq();
	public String createLotteryNum();
	public boolean exist(int[] arr ,int a);
	public int[] bubbleSort(int[] arr , boolean flag);
}
