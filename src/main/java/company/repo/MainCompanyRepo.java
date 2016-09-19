package company.repo;

import company.entity.MainCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface MainCompanyRepo extends JpaRepository<MainCompany,Integer> {

    @Query("select  a.annual_earnings from MainCompany a where a.id =:param")
    Integer earn(@Param("param") Integer id);

    @Query("select a.totalSum from MainCompany a")
    Integer totalSum();


}
