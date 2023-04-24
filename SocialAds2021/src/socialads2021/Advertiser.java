/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialads2021;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author minut
 */
enum Subscription {Gold, Silver}; 
public class Advertiser {
    private String name; 
    private String HQaddress; 
    private String telephone;
    private String sector;
    private String VATnumber;
    private Subscription sub;
    private HashMap<String,Advertisement> uploadedAds;
    //private Administration admin;

    private String refNum;

    //create advertiser object 
    public Advertiser() {
        uploadedAds = new HashMap<String,Advertisement>();
    }
    
    public void signUp(){
        
        // sample details from representative and store in Advertiser
        
        System.out.println("*******************************************");
        System.out.println("Input Details for a silver Advertiser ");
        System.out.println("*******************************************");
        
        // stub- get details for an Advertiser 
        
        
        name = "Coats Ltd";
        telephone = "07384983844";
        sector= "Fashion";
        HQaddress= "B42 2SU";
        VATnumber="GB1234567";
        sub=Subscription.Silver;
        System.out.println("Sign up complete. Your unique reference number is"+ refNum);
         
    } 
    
    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }

    public String getRefNum() {
        return refNum;
    }
    
    public void changeDetails(){
        
        System.out.println("Display new details after update");
        // get change details from advertiser and store
        sub = Subscription.Gold;
        HQaddress="B40 2FG";
        
        display();
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        
        
    } 
    
    public void display(){
        System.out.println("Advertiser details: " +  refNum + "\n" + name +  "\n" + telephone + "\n" + HQaddress + "\n" + sector +"\n" + sub.toString()+"\n" + VATnumber + "*******************************************");
    }

    public void simulation() {
        //addAdverts
       addAdvertisement("Cashmere blue coats","Blue cashmere coats for sale");
       addAdvertisement("Cashmere red coats","Red cashmere coats for sale");
       addAdvertisement("Woollen blue coats ","Blue wool coats for sale");
       addAdvertisement("Woollen white coats ","White wool coats last pieces");
       addAdvertisement("Woollen red coats ","Red wool coats for sale");
       addAdvertisement("Last chance","Blue thick coats for sale");
       addAdvertisement("Last chance for scarves","Blue scarves for sale");
       addAdvertisement("Autumn coats available","Seasonal coats available on website");
       addAdvertisement("Winter coats available","Thick coats available on website");
       addAdvertisement("Last chance for skiing coats","Skiing coats available on website");
       
       //advert should not be uploaded; max limit reached
       addAdvertisement("Last chance for blue skiing coats now","Skiing coats available on website");
       
       //display all uploaded advertisements
       getUploadedAds();
        
       //change subscription type and HQAddress
       changeDetails(); 
       
       //Attempt adding an advert after the subscription type is changed
       addAdvertisement("Last chance for blue skiing coats","Skiing coats available on website");
       
       //Edit the text of an existing advert
       editAdvertisement("Winter coats available","Cozy coats available on website");
       
       //Delete an existing advertisement
        deleteAdvertisement("Autumn coats available"); 
       
       //Display advertisements after update/delete
       getUploadedAds();
       
   
       //unsubscribe from Social Ads
       //unsubscribe();
    }
 
   void unsubscribe() {
        System.out.println("Advertiser "+refNum+" removed"+"\n"+"*******************************************");
    }
    public void addAdvertisement (String title,String adText){
        if (sub==Subscription.Gold && uploadedAds.entrySet().size()>=20){
            System.out.println("Sorry you reached the max limit (20) of uploaded adverts this month given your Gold subscription.");
            //System.exit(1);
        }
        else if (sub==Subscription.Silver && uploadedAds.entrySet().size()>=10){
            System.out.println("Sorry you reached the max limit (10) of uploaded adverts this month given your Silver subscription.");
            //System.exit(1);
        }
        else{
            Advertisement newAd=new Advertisement(title, adText);
            uploadedAds.put(title,newAd);
            System.out.println("New advert titled "+title+" uploaded.");
        }
    }

    public void getUploadedAds() {
        Set set = uploadedAds.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            uploadedAds.get(me.getKey()).display();
        }
            
        System.out.println();
    }
    public void editAdvertisement(String title,String newText){
        Advertisement toEdit=uploadedAds.get(title);
        toEdit.setText(newText);
        System.out.println("Advert updated as follows: ");
        uploadedAds.get(title).display();
    }
    public void deleteAdvertisement(String title){
        uploadedAds.remove(title);
        System.out.println("Advert titled "+title+" removed from database");
    }
    
}

