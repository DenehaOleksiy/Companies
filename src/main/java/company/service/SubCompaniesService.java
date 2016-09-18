package company.service;

import company.entity.SubCompanies;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface SubCompaniesService {

    // void add(SubCompanies subCompanies);
    //void edit(SubCompanies subCompanies);
    void remove(int id);
    SubCompanies findOneById(int id);
    List<SubCompanies> findAll();

   void add(Integer mainId, String name,Integer annual_earnings);
   void edit(Integer id,String name,Integer annual_earnings,Integer mainId);
   Integer earn(Integer id);

    Integer total();
}
