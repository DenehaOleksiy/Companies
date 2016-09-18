package company.service;

import company.entity.SubSubCompanies;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubSubCompaniesService {
   // void add(SubSubCompanies subSubCompanies);
   // void edit(SubSubCompanies subSubCompanies);
    void remove(int id);
    SubSubCompanies findOneById(int id);
    List<SubSubCompanies> findAll();
    void add(Integer subId, String name,Integer annual_earnings);
    void edit(Integer id,String name,Integer annual_earnings,Integer subId);
    Integer earn(Integer id);
}
