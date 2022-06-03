package com.daniel.stock.service;

import com.daniel.stock.Repository.JdbcCompanyRepository;
import com.daniel.stock.model.Company;
import org.springframework.stereotype.Service;

@Service
public class SearchCompany {

    private final JdbcCompanyRepository jdbc;


    public SearchCompany(JdbcCompanyRepository jdbc) {
        this.jdbc = jdbc;
    }

    public boolean existCompany(String symbol){
        return jdbc.existbySymbol(symbol)||jdbc.existbyName(symbol);
    }

    public String findSymbol(String stick){
        return jdbc.findSymbol(stick);

    }
}
