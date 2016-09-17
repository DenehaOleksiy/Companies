package company.controller;

import company.entity.MainCompany;
import company.entity.SubCompanies;
import company.entity.SubSubCompanies;
import company.service.MainCompanyService;
import company.service.SubCompaniesService;
import company.service.SubSubCompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Администратор on 15.09.2016.
 */
@Controller
public class MainController {

    @Autowired
    private MainCompanyService mainCompanyService;
    @Autowired
    private SubCompaniesService subCompaniesService;
    @Autowired
    private SubSubCompaniesService subSubCompaniesService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/showsAll", method = RequestMethod.GET)
    public String showAll(Model model){
        List<MainCompany>mainCompanies = mainCompanyService.findAll();
        model.addAttribute("showAll",mainCompanies);
        return "showAll";
    }
    @RequestMapping(value = "/subAll", method = RequestMethod.GET)
    public String subAll(Model model){
        List<SubCompanies>subCompanies = subCompaniesService.findAll();
        model.addAttribute("subAll",subCompanies);
        return "subAll";
    }
    @RequestMapping(value = "/subSubAll", method = RequestMethod.GET)
    public String subSubAll(Model model){
        List<SubSubCompanies>subSubCompanies = subSubCompaniesService.findAll();
        model.addAttribute("subSubAll",subSubCompanies);
        return "subSubAll";
    }


    @RequestMapping(value = "/add/MainCompany")
    public String addForm(Model model){
        model.addAttribute("new", new MainCompany());
        return "addMain";
    }
    @RequestMapping(value = "/add/Main", method = RequestMethod.POST)
    public String addMain(@ModelAttribute MainCompany mainCompany){
    mainCompanyService.add(mainCompany);
        return "redirect:/showsAll";
    }


    @RequestMapping(value = "/add/subCompany")
    public String addSub(Model model){
        model.addAttribute("main",mainCompanyService.findAll());
        return "addSub";
    }
    @RequestMapping(value = "/add/sub", method = RequestMethod.POST)
    public String addSubComp(@RequestParam("name") String name, @RequestParam("annual_earnings") Integer annual_earnings,
                             @RequestParam("mainCompany") Integer id){
    subCompaniesService.add(id,name,annual_earnings);
        return "redirect:/subAll";
    }

    @RequestMapping(value = "/add/subSubCompany")
    public String addSubSub(Model model){
        model.addAttribute("sub",subCompaniesService.findAll());
        return "addSubSub";
    }
    @RequestMapping(value = "/add/subSub", method = RequestMethod.POST)
    public String addSubSubComp(@RequestParam("name") String name, @RequestParam("annual_earnings") Integer annual_earnings,
                             @RequestParam("subCompanies") Integer id){
        subSubCompaniesService.add(id,name,annual_earnings);
        return "redirect:/subSubAll";
    }



}
