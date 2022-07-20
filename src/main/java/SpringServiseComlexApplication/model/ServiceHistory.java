package SpringServiseComlexApplication.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(45)")
    private String complex_name;
    @Column(columnDefinition = "DATETIME")
    private Date time_service;
    @Column(columnDefinition = "VARCHAR(45)")
    private String user_name;
    @Column(columnDefinition = "VARCHAR(255)")
    private String info_works;
    @Column(columnDefinition = "INT")
    private Integer period_service;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getComplex_name() {
        return complex_name;
    }

    public void setComplex_name(String complex_name) {
        this.complex_name = complex_name;
    }

    public Date getTime_service() {
        return time_service;
    }

    public void setTime_service(Date time_service) {
        this.time_service = time_service;
    }

    public String getInfo_works() {
        return info_works;
    }

    public void setInfo_works(String info_works) {
        this.info_works = info_works;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getPeriod_service() {
        return period_service;
    }

    public void setPeriod_service(Integer period_service) {
        this.period_service = period_service;
    }
}
