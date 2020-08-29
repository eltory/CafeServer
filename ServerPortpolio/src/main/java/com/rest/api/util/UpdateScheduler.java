package com.rest.api.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import kr.go.localdata.client.DatasReceive;
import kr.go.localdata.client.ReceiveLocalDatas;

@Component
public class UpdateScheduler {

	
	@Scheduled(cron = "${spring.interval}")
	public void getNewData() {
		ReceiveLocalDatas receiveLocalDatas = new ReceiveLocalDatas();
	}
}
