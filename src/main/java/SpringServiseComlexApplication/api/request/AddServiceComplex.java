package SpringServiseComlexApplication.api.request;

public class AddServiceComplex {
    private String complexName;
    private String userName;
    private String infoWorks;
    private Integer periodSrvice;

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfoWorks() {
        return infoWorks;
    }

    public void setInfoWorks(String infoWorks) {
        this.infoWorks = infoWorks;
    }

    public Integer getPeriodSrvice() {
        return periodSrvice;
    }

    public void setPeriodSrvice(Integer periodSrvice) {
        this.periodSrvice = periodSrvice;
    }
}
