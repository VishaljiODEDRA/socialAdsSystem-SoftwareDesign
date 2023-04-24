/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialads2021;

/**
 *
 * @author minut
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.util.Random;
public class Administration {

 // stub class for Administration
    
    private HashMap<String,Advertiser> advertisers;
    
    
    public  Administration(){
        
        advertisers = new HashMap<String,Advertiser>() ;
      
    }
    
 
    public void signUp(){
        Advertiser advertiser; 
        //create Advertiser object using constructor
       
        advertiser = new Advertiser();
        
        //set reference number
        advertiser.setRefNum(createRef()); 
        
        // get details and store in advertiser object
        advertiser.signUp();
        
        
       advertisers.put(advertiser.getRefNum(),advertiser);

        //Simulate Advertiser activity
        advertiser.simulation();
        
    
        
        
        
        
    } 
    public String createRef() {
        
        Random ran  = new Random();
        int i = ran.nextInt(100000);
        String id= i +"";
        return id;
        
    }
    public void display(){
        System.out.println("Display Advertisers");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        Set set = advertisers.entrySet();
        Iterator i = set.iterator();
        
        while (i.hasNext())
        {
            Map.Entry me = (Map.Entry)i.next();
            advertisers.get(me.getKey()).display();
        }
            
        System.out.println();
    
    } 
    public void changeDetails(String refNum){
        System.out.println("Advertisers");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        
        advertisers.get(refNum).changeDetails();//find advertiser and change
        
        
    }
    public void unsubscribe(String refNum){
        System.out.println("Advertisers");
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        advertisers.get(refNum).unsubscribe();
        advertisers.remove(refNum);      
    }
    public static void main(String[] args){
            
            Administration  admin = new Administration();
            
            admin.signUp();
            admin.display();    
    }
}

