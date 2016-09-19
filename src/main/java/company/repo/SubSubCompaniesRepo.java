package company.repo;

import company.entity.SubSubCompanies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubSubCompaniesRepo extends JpaRepository<SubSubCompanies,Integer> {

    @Query("select a.annual_earnings from SubSubCompanies a where a.id =:param")
    Integer earn(@Param("param") Integer id);

    @Query("select subSub from SubSubCompanies subSub where subSub.id=:id")
    List<SubSubCompanies> bySubCompany(@Param("id") int id);

}
