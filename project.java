/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class project {
    String name;
    int amount;
    LocalDate oder_date,delivery_date;

    public project(String name, int amount, LocalDate oder_date, LocalDate delivery_date) {
        this.name = name;
        this.amount = amount;
        this.oder_date = oder_date;
        this.delivery_date = delivery_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getOder_date() {
        return oder_date;
    }

    public void setOder_date(LocalDate oder_date) {
        this.oder_date = oder_date;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }
    
    
            
    
}
