package SpringServiseComlexApplication.repository;

import SpringServiseComlexApplication.model.ServiceHistory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface HistoryRepository extends CrudRepository<ServiceHistory, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO `stanki_service`.`service_history` (`complex_name`, `info_works`, `period_service`, `time_service`, `user_name`) " +
            "VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addService(@Param("complex_name") String complex_name, @Param("info_works") String info_works, @Param("period_service") int period_service,
                    @Param("time_service") Date time_service, @Param("user_name") String user_name);

    @Query(value = "SELECT * FROM stanki_service.service_history where complex_name=?1 order by time_service desc", nativeQuery = true)
    List<ServiceHistory> serviceInfo(String complexName);

    @Query(value = "SELECT complex_name, time_service as max_time, period_service FROM stanki_service.service_history " +
            "where id in (select max(id) " +
            "FROM stanki_service.service_history " +
            "GROUP BY complex_name)", nativeQuery = true)
    List<Map<String, Object>> serviceInfoCurrentAll();

}
