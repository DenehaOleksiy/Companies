package company.repo;

import company.entity.SubCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubCompaniesRepo extends JpaRepository<SubCompanies,Integer> {

    @Query("select a.annual_earnings from SubCompanies a where a.id=:param")
    Integer earn(@Param("param") Integer id);

//    @Query("select a.totalSum from SubCompanies a")
//    Integer totalSum();

    @Query("select subCompany from SubCompanies subCompany where subCompany.id=:id")
    List<SubCompanies> byMainCompany(@Param("id") Integer id);

}
