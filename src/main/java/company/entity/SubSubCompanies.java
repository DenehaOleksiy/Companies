package company.entity;

import javax.persistence.*;

/**
 * Created by Администратор on 15.09.2016.
 */
@Entity
public class SubSubCompanies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int annual_earnings;
    @Column
    private Integer subId;

    @ManyToOne(fetch = FetchType.LAZY)
    private SubCompanies subCompanies;

    public SubSubCompanies() {
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
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

    public SubCompanies getSubCompanies() {
        return subCompanies;
    }

    public void setSubCompanies(SubCompanies subCompanies) {
        this.subCompanies = subCompanies;
    }
}
