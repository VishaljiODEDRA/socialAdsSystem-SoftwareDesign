/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialads2021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author minut
 */
public class Advertisement {

    private String title;
    private String adText;

    public Advertisement(String title, String adText) {

        this.title = title;
        this.adText = adText;
    }


    public String getTitle() {
        return this.title;
    }

    public void display(){
        System.out.println(title +  "\n" + adText +"\n"); //Find out more at: "+businessPostCode +"\nFor just: " + "£"+ productPrice + "\n" + "*******************************************");
    }

    void setText(String newText) {
        this.adText=newText;
    }
    
}