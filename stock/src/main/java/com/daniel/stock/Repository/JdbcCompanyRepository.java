package com.daniel.stock.Repository;

import com.daniel.stock.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcCompanyRepository implements CompanyRepository{
    private final JdbcTemplate jdbc;

    @Autowired
    public JdbcCompanyRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public boolean existbySymbol(String Symbol) {
        String sql = "select * from company where symbol=?";
        List<Company> result = jdbc.query(sql, new CompanyMapper(), Symbol);
        return result.size() != 0;
    }

    @Override
    public boolean existbyName(String stick) {
        String sql= "SELECT * FROM COMPANY WHERE NAME LIKE ?";
        List<Company> result = jdbc.query(sql, new CompanyMapper(), "%"+stick+"%");
        if(result.size()==0)
            return false;
        else return result.size() <= 1;
    }

    @Override
    public String findSymbol(String stick) {
        if(existbySymbol(stick)) return stick;
        String sql= "select * from company where NAME LIKE ?";
        Company result = jdbc.queryForObject(sql, new CompanyMapper(),"%"+stick+"%");
        return result.getSymbol();
    }
}
