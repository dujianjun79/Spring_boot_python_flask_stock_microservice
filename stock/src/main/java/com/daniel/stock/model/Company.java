package com.daniel.stock.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Company {
    private String symbol;
    private String name;
    private String sector;

    public Company() {
    }

    public Company(String symbol, String name, String sector) {
        this.symbol = symbol;
        this.name = name;
        this.sector = sector;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Company{" +
                "symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                '}';
    }
}
