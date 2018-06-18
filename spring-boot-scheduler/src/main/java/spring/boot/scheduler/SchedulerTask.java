package spring.boot.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
	
    //@Scheduled(cron='*/6 * * * * ?') 常用的cron：*/6 * * * * ?
    //@Scheduled(fixedRate = 6000)   两种都表示每隔六秒打印一下内容
    //@Scheduled(fixedRate = 6000) ：上一次开始执行时间点之后6秒再执行
    //@Scheduled(fixedDelay = 6000) ：上一次执行完毕时间点之后6秒再执行
    //@Scheduled(initialDelay=1000, fixedRate=6000) ：第一次延迟1秒后执行，之后按fixedRate的规则每6秒执行一次
	
	private int i = 0;
	
	@Scheduled(cron="*/6 * * * * ?")
	public void scheduledTask() {
		System.out.println("This is scheduler task running "+ (i++));
	}
	
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
    }

}
