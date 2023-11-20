package SpringServiseComlexApplication.restController;

import SpringServiseComlexApplication.api.request.AddServiceComplex;
import SpringServiseComlexApplication.service.ServiceBitrix;
import SpringServiseComlexApplication.service.ServiceComplexService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
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

    @GetMapping("/serviceInfo/{complexName}")
    private Map<Object, Object> serviceInfo(@PathVariable String complexName, @RequestHeader("Authorization") String jwtBearer) {
        return serviceComplexService.infoService(complexName, jwtBearer);
    }

}
