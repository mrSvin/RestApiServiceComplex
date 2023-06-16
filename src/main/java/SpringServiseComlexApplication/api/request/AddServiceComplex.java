package SpringServiseComlexApplication.api.request;

import lombok.Data;

@Data
public class AddServiceComplex {
    private String complexName;
    private String userName;
    private String infoWorks;
    private Integer periodSrvice;

}
