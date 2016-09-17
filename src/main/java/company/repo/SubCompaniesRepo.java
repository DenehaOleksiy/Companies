package company.repo;

import company.entity.SubCompanies;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubCompaniesRepo extends JpaRepository<SubCompanies,Integer> {
}
