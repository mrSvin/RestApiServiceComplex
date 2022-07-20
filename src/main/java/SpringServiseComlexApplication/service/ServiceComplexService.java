package SpringServiseComlexApplication.service;

import SpringServiseComlexApplication.model.ServiceHistory;
import SpringServiseComlexApplication.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceComplexService {

    private final HistoryRepository historyRepository;


    public ServiceComplexService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public String addService(String complexName, String infoWorks, Integer period, String userName) {
        Date date = new Date();
        historyRepository.addService(complexName, infoWorks, period, date, userName);
        return "ok";
    }

    public List<ServiceHistory> infoService(String complexName) {
        return historyRepository.serviceInfo(complexName);
    }

}
