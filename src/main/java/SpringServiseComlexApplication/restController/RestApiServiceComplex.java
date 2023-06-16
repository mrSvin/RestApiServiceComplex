package SpringServiseComlexApplication.restController;

import SpringServiseComlexApplication.api.request.AddServiceComplex;
import SpringServiseComlexApplication.model.ServiceHistory;
import SpringServiseComlexApplication.service.ServiceBitrix;
import SpringServiseComlexApplication.service.ServiceComplexService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 3600)
@RestController
@RequestMapping("/api")
public class RestApiServiceComplex {

    private final ServiceComplexService serviceComplexService;
    private final ServiceBitrix serviceBitrix;

    public RestApiServiceComplex(ServiceComplexService serviceComplexService, ServiceBitrix serviceBitrix) {
        this.serviceComplexService = serviceComplexService;
        this.serviceBitrix = serviceBitrix;
    }

    @PostMapping("/addService")
    private String addService(@RequestBody AddServiceComplex addServiceComplex) {

        try {
            serviceBitrix.messageBitrix(addServiceComplex.getComplexName(), addServiceComplex.getInfoWorks(), addServiceComplex.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return serviceComplexService.addService(addServiceComplex.getComplexName(), addServiceComplex.getInfoWorks(), addServiceComplex.getPeriodSrvice(),
                addServiceComplex.getUserName());
    }

    @GetMapping("/serviceInfo/{complexName}")
    private List<ServiceHistory> serviceInfo(@PathVariable String complexName) {
        return serviceComplexService.infoService(complexName);
    }

}
