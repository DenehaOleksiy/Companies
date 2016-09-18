package company.service.implementation;

import company.entity.MainCompany;
import company.repo.MainCompanyRepo;
import company.service.MainCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Service
public class MainCompanyServiceImpl implements MainCompanyService {

   @Autowired
   private MainCompanyRepo mainCompanyRepo;

    @Override
    public void add(MainCompany mainCompany) {
        mainCompanyRepo.save(mainCompany);
    }

//

    @Override
    public void edit(Integer id, String name, Integer annual_earnings) {
        MainCompany mainCompany = new MainCompany();
        mainCompany.setId(id);
        mainCompany.setName(name);
        mainCompany.setAnnual_earnings(annual_earnings);
        mainCompanyRepo.save(mainCompany);
    }

    @Override
    public void remove(int id) {
    mainCompanyRepo.delete(id);
    }

    @Override
    public MainCompany findOneById(int id) {
        return mainCompanyRepo.findOne(id);
    }

    @Override
    public List<MainCompany> findAll() {
        return mainCompanyRepo.findAll();
    }

    @Override
    public Integer earn(Integer id) {
        Integer integer = mainCompanyRepo.earn(id);
        return integer;
    }

    @Override
    public Integer total() {
       Integer integer = mainCompanyRepo.totalSum();
        return integer;
    }
}
