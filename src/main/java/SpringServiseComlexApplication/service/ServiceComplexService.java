package SpringServiseComlexApplication.service;

import SpringServiseComlexApplication.repository.HistoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ServiceComplexService {

    private final HistoryRepository historyRepository;
    private final JwtService jwtService;
    private final ServiceBitrix serviceBitrix;

    public ServiceComplexService(HistoryRepository historyRepository, JwtService jwtService, ServiceBitrix serviceBitrix) {
        this.historyRepository = historyRepository;
        this.jwtService = jwtService;
        this.serviceBitrix = serviceBitrix;
    }

    public String addService(String complexName, String infoWorks, Integer period, String userName, String jwtToken) {

        String checkJwt = jwtService.checkJWT(jwtToken, "service");
        if (checkJwt.equals("error")) {
            return "invalid token";
        } else if (checkJwt.equals("no rights")) {
            return "no rights";
        }

        Date date = new Date();
        historyRepository.addService(complexName, infoWorks, period, date, userName);

        try {
            serviceBitrix.messageBitrix(complexName, infoWorks, userName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "ok";
    }

    public Map<Object, Object> infoService(String complexName, String jwtToken) {

        Map<Object, Object> result = new HashMap<>();

        String checkJwt = jwtService.checkJWT(jwtToken, "all");
        if (checkJwt.equals("error")) {
            result.put("error", "invalid token");
            return result;
        } else if (checkJwt.equals("no rights")) {
            result.put("error", "no rights");
            return result;
        }

        result.put("data", historyRepository.serviceInfo(complexName));

        return result;
    }

}
