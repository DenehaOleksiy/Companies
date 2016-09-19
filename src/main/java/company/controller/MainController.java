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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    //====== show ==========
    @RequestMapping(value = "/showMain", method = RequestMethod.GET)
    public String showAll(Model model){
        List<MainCompany>mainCompanies = mainCompanyService.findAll();
        model.addAttribute("showAll",mainCompanies);
        return "showMain";
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

//============ add ====================
    @RequestMapping(value = "/add/MainCompany")
    public String addForm(Model model){
        model.addAttribute("new", new MainCompany());
        return "addMain";
    }
    @RequestMapping(value = "/add/Main", method = RequestMethod.POST)
    public String addMain(@ModelAttribute MainCompany mainCompany){
    mainCompanyService.add(mainCompany);
        return "redirect:/showMain";
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

    //========= delete ============
    @RequestMapping(value = "/main/delete/{id}")
    public String delMain(@PathVariable String id){
        mainCompanyService.remove(Integer.parseInt(id));
        return "redirect:/showMain";
    }

    @RequestMapping(value = "/sub/delete/{id}")
    public String delSub(@PathVariable String id){
        subCompaniesService.remove(Integer.parseInt(id));
        return "redirect:/subAll";
    }

    @RequestMapping(value = "/subSub/delete/{id}")
    public String delSubSub(@PathVariable String id){
        subSubCompaniesService.remove(Integer.parseInt(id));
        return "redirect:/subSubAll";
    }

    //======== edit ============
    @RequestMapping(value = "/main/edit/{id}")
    public String edMain(@PathVariable String id,Model model){
    model.addAttribute("edit",mainCompanyService.findOneById(Integer.parseInt(id)));
        return "editMain";
    }
    @RequestMapping(value = "/edit/main",method = RequestMethod.POST)
    public String editMain(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer annual_earnings){
        mainCompanyService.edit(id,name,annual_earnings);
        return "redirect:/showMain";
    }

    @RequestMapping(value = "/sub/edit/{id}")
    public String edSub(@PathVariable String id,Model model){
        model.addAttribute("edit",subCompaniesService.findOneById(Integer.parseInt(id)));
        model.addAttribute("main", mainCompanyService.findAll());
        return "editSub";
    }

    @RequestMapping(value = "/edit/sub",method = RequestMethod.POST)
    public String editSub(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer annual_earnings,
                          @RequestParam("main") Integer mainId ){
        subCompaniesService.edit(id,name,annual_earnings,mainId);
        return "redirect:/subAll";
    }

    @RequestMapping(value = "/subSub/edit/{id}")
    public String edSubSub(@PathVariable String id,Model model){
        model.addAttribute("edit",subSubCompaniesService.findOneById(Integer.parseInt(id)));
        model.addAttribute("sub", subCompaniesService.findAll());
        return "editSubSub";
    }

    @RequestMapping(value = "/edit/subSub",method = RequestMethod.POST)
    public String editSubSub(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer annual_earnings,
                          @RequestParam("sub") Integer subId ){
        subSubCompaniesService.edit(id,name,annual_earnings,subId);
        return "redirect:/subSubAll";
    }

    //========== earnings ============
    @RequestMapping(value = "/subSub/earn/{id}")
    public String subSub(@PathVariable String id,Model model){
      SubSubCompanies subSubCompanies= subSubCompaniesService.findOneById(Integer.parseInt(id));
        model.addAttribute("earn",subSubCompanies);
        Integer i = subSubCompaniesService.earn(Integer.parseInt(id));
        model.addAttribute("intes",i);
        return "subSubEarn";
    }
    @RequestMapping(value = "/sub/earn/{id}")
    public String subEarn(@PathVariable String id, Model model){
        SubCompanies subCompanies = subCompaniesService.findOneById(Integer.parseInt(id));
        model.addAttribute("earn",subCompanies);
        Integer i = subCompaniesService.earn(Integer.parseInt(id));
        model.addAttribute("intes",i);
        return "subEarn";
    }
    @RequestMapping(value = "/main/earn/{id}")
    public String mainEarn(@PathVariable String id, Model model){
        MainCompany mainCompany = mainCompanyService.findOneById(Integer.parseInt(id));
        model.addAttribute("earn",mainCompany);
        Integer i = mainCompanyService.earn(Integer.parseInt(id));
        model.addAttribute("intes",i);
        return "mainEarn";
    }

    //======== total earnings ==========

    @RequestMapping(value = "/main/total/{id}")
    public String mainSub(@PathVariable String id, Model model){
        MainCompany mainCompany = mainCompanyService.findOneById(Integer.parseInt(id));
        model.addAttribute("earn", mainCompany);
        Integer integer = mainCompanyService.total(Integer.parseInt(id));
        integer += mainCompany.getAnnual_earnings();
        model.addAttribute("total", integer);
        return "totalMain";
    }

    @RequestMapping(value = "/sub/total/{id}")
    public String totalSub(@PathVariable String id, Model model){
        SubCompanies subCompanies = subCompaniesService.findOneById(Integer.parseInt(id));
        model.addAttribute("earn", subCompanies);
        Integer integer = subCompaniesService.total(Integer.parseInt(id));
        integer += subCompanies.getAnnual_earnings();
        model.addAttribute("total", integer);
        return "totalSub";
    }

    //============= tree =============

    @RequestMapping(value = "/tree")
    public String tree(Model model){
        List<MainCompany>mainCompanies = mainCompanyService.findAll();
        model.addAttribute("main", mainCompanies);
        List<SubCompanies>subCompanies = subCompaniesService.findAll();
        model.addAttribute("sub",subCompanies);
        List<SubSubCompanies>subSubCompanies = subSubCompaniesService.findAll();
        model.addAttribute("subSub",subSubCompanies);
        return "tree";
    }
}
