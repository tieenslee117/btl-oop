/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author PC
 */
public class Stock {
    String stockName, companyName, manName;
    int quantityRelease, quantitySold, tran, san;

    public Stock(String stockName, String companyName, String manName, int quantityRelease, int quantitySold, int tran, int san) {
        this.stockName = stockName;
        this.companyName = companyName;
        this.manName = manName;
        this.quantityRelease = quantityRelease;
        this.quantitySold = quantitySold;
        this.tran = tran;
        this.san = san;
    }

    public String getStockName() {
        return stockName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getManName() {
        return manName;
    }

    public int getQuantityRelease() {
        return quantityRelease;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public int getTran() {
        return tran;
    }

    public int getSan() {
        return san;
    }
    
}
