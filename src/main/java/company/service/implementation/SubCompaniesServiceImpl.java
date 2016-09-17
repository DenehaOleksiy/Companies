package company.service.implementation;

import company.entity.MainCompany;
import company.entity.SubCompanies;
import company.repo.MainCompanyRepo;
import company.repo.SubCompaniesRepo;
import company.service.SubCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Service
public class SubCompaniesServiceImpl implements SubCompaniesService {

    @Autowired
    private SubCompaniesRepo subCompaniesRepo;

    @Autowired
    private MainCompanyRepo mainCompanyRepo;

//    @Override
//    public void add(SubCompanies subCompanies) {
//        subCompaniesRepo.save(subCompanies);
//    }

//    @Override
//    public void edit(SubCompanies subCompanies) {
//    subCompaniesRepo.save(subCompanies);
//    }

    @Override
    public void remove(int id) {
    subCompaniesRepo.delete(id);
    }

    @Override
    public SubCompanies findOneById(int id) {
        return subCompaniesRepo.findOne(id);
    }

    @Override
    public List<SubCompanies> findAll() {
        return subCompaniesRepo.findAll();
    }

    @Override
    public void add(Integer mainId, String name, Integer annual_earnings) {
        SubCompanies subCompanies = new SubCompanies();
        subCompanies.setAnnual_earnings(annual_earnings);
        subCompanies.setName(name);
        MainCompany mainCompany = mainCompanyRepo.findOne(mainId);
        subCompanies.setMainCompany(mainCompany);
        subCompaniesRepo.save(subCompanies);
    }

    @Override
    public void edit(Integer id, String name, Integer annual_earnings, Integer mainId) {
        SubCompanies subCompanies = new SubCompanies();
        subCompanies.setId(id);
        subCompanies.setName(name);
        subCompanies.setAnnual_earnings(annual_earnings);
        MainCompany mainCompany = mainCompanyRepo.findOne(mainId);
        subCompanies.setMainCompany(mainCompany);
        subCompaniesRepo.save(subCompanies);
    }
}
