package company.service.implementation;

import company.entity.MainCompany;
import company.entity.SubCompanies;
import company.entity.SubSubCompanies;
import company.repo.MainCompanyRepo;
import company.repo.SubCompaniesRepo;
import company.repo.SubSubCompaniesRepo;
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


    //ці два наступних репо потрібні, щоб можна було доступитись до будь яких полів цих ентіті(нам треба тільки до суми заробітку)

    @Autowired
    private SubCompaniesRepo subCompaniesRepo;

    @Autowired
    private SubSubCompaniesRepo subSubCompaniesRepo;





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
    public Integer total(int id) {
        int subEarn = 0;
        List<SubCompanies>subCompanies = subCompaniesRepo.findAll();
        for (SubCompanies sc:subCompanies) {
            if(sc.getMainId()==id) {
                subEarn += sc.getAnnual_earnings();
            }
        }
//         int subSubEarn = 0;
//        List<SubSubCompanies> subSubCompanies = subSubCompaniesRepo.findAll();
//        for (SubSubCompanies ssc:subSubCompanies) {
//            subSubEarn+=ssc.getAnnual_earnings();
//        }
//        int sum = subEarn + subSubEarn;
        return subEarn;
    }


}
