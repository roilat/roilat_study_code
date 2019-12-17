package cn.roilat.framework.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AddressRelationTast {
	private Logger logger = LoggerFactory.getLogger(AddressRelationTast.class);
	@Scheduled(cron = "0 * * * * ?") // 每天执行
	private void run() {
		System.out.println("开始了");
		logger.info("-----获取数据治理监控数据任务开始----");
		logger.info("-----获取数据治理监控数据任务结束----");
	}
}
