package company.repo;

import company.entity.SubCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubCompaniesRepo extends JpaRepository<SubCompanies,Integer> {

    @Query("select a.annual_earnings from SubCompanies a where a.id=:param")
    Integer earn(@Param("param") Integer id);

    @Query("select  c.annual_earnings from  SubCompanies c where c.id=:param ")
    Integer total(@Param("param") Integer id);
}
