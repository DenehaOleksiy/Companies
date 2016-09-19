package company.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Entity
public class MainCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int annual_earnings;


    private Integer totalSum =0;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainCompany",fetch = FetchType.EAGER)
    private List<SubCompanies> subCompaniesList;



    public MainCompany() {
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAnnual_earnings() {
        return annual_earnings;
    }

    public void setAnnual_earnings(int annual_earnings) {
        this.annual_earnings = annual_earnings;
    }

    public List<SubCompanies> getSubCompaniesList() {
        return subCompaniesList;
    }

    public void setSubCompaniesList(List<SubCompanies> subCompaniesList) {
        this.subCompaniesList = subCompaniesList;
    }


}
