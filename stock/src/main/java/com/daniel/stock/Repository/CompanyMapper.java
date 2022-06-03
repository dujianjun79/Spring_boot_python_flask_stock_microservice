package com.daniel.stock.Repository;

import com.daniel.stock.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setSymbol(rs.getString("symbol"));
        company.setName(rs.getString("name"));
        company.setSector(rs.getString("sector"));
        return company;
    }
}
