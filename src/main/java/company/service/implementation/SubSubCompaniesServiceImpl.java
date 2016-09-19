package company.service.implementation;

import company.entity.SubCompanies;
import company.entity.SubSubCompanies;
import company.repo.SubCompaniesRepo;
import company.repo.SubSubCompaniesRepo;
import company.service.SubSubCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Service
public class SubSubCompaniesServiceImpl implements SubSubCompaniesService {
    @Autowired
    private SubSubCompaniesRepo subSubCompaniesRepo;
    @Autowired
    private SubCompaniesRepo subCompaniesRepo;

    @Override
    public void remove(int id) {
        subSubCompaniesRepo.delete(id);
    }

    @Override
    public SubSubCompanies findOneById(int id) {
        return subSubCompaniesRepo.findOne(id);
    }

    @Override
    public List<SubSubCompanies> findAll() {
        return subSubCompaniesRepo.findAll();
    }

    @Override
    public void add(Integer subId, String name, Integer annual_earnings) {
        SubSubCompanies subSubCompanies = new SubSubCompanies();
        subSubCompanies.setAnnual_earnings(annual_earnings);
        subSubCompanies.setName(name);
        SubCompanies subCompanies = subCompaniesRepo.findOne(subId);
        subSubCompanies.setSubCompanies(subCompanies);
        subSubCompanies.setSubId(subId);
        subSubCompaniesRepo.save(subSubCompanies);
    }

    @Override
    public void edit(Integer id, String name, Integer annual_earnings, Integer subId) {
        SubSubCompanies subSubCompanies = new SubSubCompanies();
        subSubCompanies.setId(id);
        subSubCompanies.setName(name);
        subSubCompanies.setAnnual_earnings(annual_earnings);
        SubCompanies subCompanies = subCompaniesRepo.findOne(subId);
        subSubCompanies.setSubCompanies(subCompanies);
        subSubCompaniesRepo.save(subSubCompanies);
    }

    @Override
    public Integer earn(Integer id) {
        Integer integer = subSubCompaniesRepo.earn(id);
        return integer;
    }


}
