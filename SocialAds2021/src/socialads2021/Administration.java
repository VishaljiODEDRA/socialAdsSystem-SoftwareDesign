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
import java.io.*;
public class Administration {

 // stub class for Administration
    
    private HashMap<String,Advertiser> advertisers;
    BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
    
    
    public  Administration(){
        
        advertisers = new HashMap<String,Advertiser>() ;
      
    }
    
 
    public void signUp() throws IOException{
        Advertiser advertiser;
        Observer regulator;
        //create Advertiser object using constructor
        System.out.println("Identify the Advertiser:\n(a) Food Advertiser \n(b) Attraction Advertiser");
        String catagory= c.readLine();

        if (catagory.equals("a")){
        	advertiser = new FoodAdvertiser();
        	regulator= Regulator.getInstance();
        	//set reference number
            advertiser.setRefNum(createRef());
            
            // get details and store in advertiser object
            advertiser.signUp();
            advertiser.attach(regulator);
            
            
            advertisers.put(advertiser.getRefNum(),advertiser);
            advertiser.display();
            
        }else if(catagory.equals("b")){
            advertiser= new AttractionAdvertiser();
            regulator= Regulator.getInstance();
           //set reference number
            advertiser.setRefNum(createRef()); 
            
            // get details and store in advertiser object
            advertiser.signUp();
            advertiser.attach(regulator);
            
            advertisers.put(advertiser.getRefNum(),advertiser);
            advertiser.display();
        }else {
            System.out.println("Enter the Valid Option (a) or (b)");
            signUp();
        } 
    
        //Simulate Advertiser activity
       
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
        
        while (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            advertisers.get(me.getKey()).display();
           
        }   
        System.out.println();
    
    } 
    public void changeDetails(String refNum) throws IOException{
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
    public static void main(String[] args) throws IOException{
            
    		//To enter details manually uncomment below 3 lines of code and comment next 2 lines of code or else run directly for simulation
    	
            //Administration  admin = new Administration();     
            //admin.signUp();
            //admin.display();   
    	
            Advertiser advertiser = new FoodAdvertiser();
            advertiser.simulation();
    }
}

