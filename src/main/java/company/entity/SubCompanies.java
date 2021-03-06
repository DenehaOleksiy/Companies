package company.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
    @Column
    private Integer mainId;

    @ManyToOne(fetch = FetchType.LAZY)
    private MainCompany mainCompany;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCompanies" ,fetch = FetchType.EAGER)
    private List<SubSubCompanies>subSubCompanies;


//orphanRemoval=true,

    public SubCompanies() {

    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
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
