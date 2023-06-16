package SpringServiseComlexApplication.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
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
    @Column(columnDefinition = "VARCHAR(500)")
    private String info_works;
    @Column(columnDefinition = "INT")
    private Integer period_service;

}
