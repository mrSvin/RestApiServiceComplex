package SpringServiseComlexApplication.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BotCheckerScheduler {

    @Scheduled(cron = "0 51 15 * * ?") // запуск в 12:00 каждый день
    public void botCheckerScheduler() {
        System.out.println("ok");
    }


}
