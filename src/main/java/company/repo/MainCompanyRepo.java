package company.repo;

import company.entity.MainCompany;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface MainCompanyRepo extends JpaRepository<MainCompany,Integer> {
}
