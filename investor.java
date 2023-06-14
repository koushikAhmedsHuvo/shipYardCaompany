/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypkg;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class investor implements Serializable {
    String name;
    int amount;
    float per;

    public investor(String name, int amount, float per) {
        this.name = name;
        this.amount = amount;
        this.per = per;
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

    public float getPer() {
        return per;
    }

    public void setPer(float per) {
        this.per = per;
    }
    
      public void display(){
        System.out.println("Name="+name+", Amount="+amount+", Percentage="+per);
    }
    @Override
    public String toString(){
        //return id+","+name+","+cgpa+"\n";
        //return "Id="+id+"; Name="+name+"; Cgpa="+cgpa;
        return "The "+name+" is Invest "+amount+" Tk and took "+per+" percentage of this company";
    }  
    
}
