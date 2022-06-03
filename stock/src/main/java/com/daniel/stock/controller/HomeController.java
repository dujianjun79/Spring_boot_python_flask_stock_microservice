package com.daniel.stock.controller;


import com.daniel.stock.model.Company;
import com.daniel.stock.model.Student;
import com.daniel.stock.service.SearchCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@Controller
public class HomeController {
    private final SearchCompany searchCompany;

    @Autowired
    private RestTemplate restTemplate;

    public HomeController(SearchCompany searchCompany, RestTemplate restTemplate) {
        this.searchCompany = searchCompany;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/recordPage")
    public String recordPage(Student student) {

        return "record";
    }

    @GetMapping("/search")
    public String search_page() {
        //model.addAttribute("stick","hello world");
        return "search";
    }

    @PostMapping("/search")
    public String postStock(@RequestParam("stick") String stick, Model model){
        boolean exist = searchCompany.existCompany(stick);
        if(exist){
            String symbol=searchCompany.findSymbol(stick);
            String price = restTemplate.getForObject("http://localhost:8050/fetch/{symbol}", String.class, symbol);
            model.addAttribute("company",symbol);
            model.addAttribute("price",price);
        }
        else {
            model.addAttribute("exist", "The company name or stick is not right or ambiguous.");
        }

        return "search";
    }

    @GetMapping("/stock")
    public @ResponseBody
    String getStock(){
        String forNow = restTemplate.getForObject("http://localhost:8050/fetch", String.class);
        return forNow;
    }
}
