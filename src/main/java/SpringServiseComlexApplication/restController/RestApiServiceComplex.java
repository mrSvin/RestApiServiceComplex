package SpringServiseComlexApplication.restController;

import SpringServiseComlexApplication.api.request.AddServiceComplex;
import SpringServiseComlexApplication.service.ServiceBitrix;
import SpringServiseComlexApplication.service.ServiceComplexService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://iot.sespel.com", "http://frontend.sespel.com", "http://192.168.3.96:3000", "http://192.168.2.78:3000"})
public class RestApiServiceComplex {

    private final ServiceComplexService serviceComplexService;


    public RestApiServiceComplex(ServiceComplexService serviceComplexService) {
        this.serviceComplexService = serviceComplexService;
    }

    @PostMapping("/addService")
    private String addService(@RequestBody AddServiceComplex addServiceComplex, @RequestHeader("Authorization") String jwtBearer) {

        return serviceComplexService.addService(addServiceComplex.getComplexName(), addServiceComplex.getInfoWorks(), addServiceComplex.getPeriodSrvice(),
                addServiceComplex.getUserName(), jwtBearer);
    }

    @PostMapping("/serviceInfo/{complexName}")
    private Map<Object, Object> serviceInfo(@PathVariable String complexName, @RequestHeader("Authorization") String jwtBearer) {
        return serviceComplexService.infoService(complexName, jwtBearer);
    }

    @PostMapping("/serviceInfoCurrentAll")
    private List<Map<String, Object>> serviceInfoCurrentAll(@RequestHeader("Authorization") String jwtBearer) {
        return serviceComplexService.serviceInfoCurrentAll(jwtBearer);
    }

}
