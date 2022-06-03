package com.daniel.stock.Repository;

import com.daniel.stock.model.Company;

import java.util.List;

public interface CompanyRepository {

    public boolean existbySymbol(String Symbol);

    public boolean existbyName(String name);

    public String findSymbol(String stick);
}
