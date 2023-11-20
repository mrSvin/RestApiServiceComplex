package SpringServiseComlexApplication.service;

import SpringServiseComlexApplication.repository.HistoryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BotCheckerScheduler {

    private final HistoryRepository historyRepository;

    public BotCheckerScheduler(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Scheduled(cron = "0 39 16 * * ?") // запуск в 12:00 каждый день
    public void botCheckerScheduler() {
        List<Map<String, Object>> data = historyRepository.serviceCheck();
        System.out.println(data.get(0).get("complex_name"));
        System.out.println(data.get(0).get("max_time"));
    }


}
