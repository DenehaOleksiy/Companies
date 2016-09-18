package company.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Entity
public class SubCompanies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int annual_earnings;


    private Integer totalSum =0;

    @ManyToOne(fetch = FetchType.EAGER)
    private MainCompany mainCompany;

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "subCompanies")
    private List<SubSubCompanies>subSubCompanies;
//orphanRemoval=true,

    public SubCompanies() {

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

    public MainCompany getMainCompany() {
        return mainCompany;
    }

    public void setMainCompany(MainCompany mainCompany) {
        this.mainCompany = mainCompany;
    }

    public List<SubSubCompanies> getSubSubCompanies() {
        return subSubCompanies;
    }

    public void setSubSubCompanies(List<SubSubCompanies> subSubCompanies) {
        this.subSubCompanies = subSubCompanies;
    }
}
