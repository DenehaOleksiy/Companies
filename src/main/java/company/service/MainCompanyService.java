package company.service;

import company.entity.MainCompany;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
public interface MainCompanyService {

    void add(MainCompany mainCompany);
    void edit(MainCompany mainCompany);
    void remove(int id);
    MainCompany findOneById(int id);
    List<MainCompany> findAll();
}