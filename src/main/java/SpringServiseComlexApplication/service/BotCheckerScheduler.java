package SpringServiseComlexApplication.service;

import SpringServiseComlexApplication.repository.HistoryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class BotCheckerScheduler {

    private final HistoryRepository historyRepository;
    private final ServiceBitrix serviceBitrix;

    public BotCheckerScheduler(HistoryRepository historyRepository, ServiceBitrix serviceBitrix) {
        this.historyRepository = historyRepository;
        this.serviceBitrix = serviceBitrix;
    }

    @Scheduled(cron = "0 0 9 * * ?") // запуск в 9:00 каждый день
    public void botCheckerScheduler() throws IOException {
        List<Map<String, Object>> data = historyRepository.serviceInfoCurrentAll();
        long timeNow = System.currentTimeMillis();

        for (int i = 0; i < data.size(); i++) {
            String complexName = (String) data.get(i).get("complex_name");
            Timestamp time = (Timestamp) data.get(i).get("max_time");
            Integer periodService = (Integer) data.get(i).get("period_service");

            long timeStep = ((long) periodService) * 1000;
            long timeLast = time.getTime() + timeStep;

            if (timeNow > timeLast) {
                serviceBitrix.messageBitrixElapsedTime(complexName, new Timestamp(timeLast));
            }

        }

    }


}
