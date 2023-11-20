package SpringServiseComlexApplication.service;

import SpringServiseComlexApplication.repository.HistoryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BotCheckerScheduler {

    private final HistoryRepository historyRepository;

    public BotCheckerScheduler(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Scheduled(cron = "0 8 17 * * ?") // запуск в 12:00 каждый день
    public void botCheckerScheduler() {
        List<Map<String, Object>> data = historyRepository.serviceCheck();
        long timeNow = System.currentTimeMillis();

        for (int i=0; i<data.size()-1; i++) {
            Object complexName = data.get(i).get("complex_name");
            Timestamp time = (Timestamp) data.get(i).get("max_time");

            if (timeNow>time.getTime()) {

            }

        }

    }


}
