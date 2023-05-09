/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialads2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author minut
 */
enum Subscription {Gold, Silver}; 
public class Advertiser implements Subject{
    private String name; 
    private String HQaddress; 
    private String telephone;
    private String sector;
    private String VATnumber;
    private Subscription sub;
    private HashMap<String,Advertisement> uploadedAds;
    private List<Observer> observers=new ArrayList<Observer>();
    private boolean isFoulWord;
   
    //private Administration admin;
    private String refNum;

    //create advertiser object 
    public Advertiser() {
        uploadedAds = new HashMap<String,Advertisement>();

    }
    
    public void signUp() throws IOException{
    	BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
    	
        System.out.println("Name: ");
        setName(c.readLine());

        System.out.println("Telephone: ");
        setTelephone(c.readLine());

        System.out.println("Sector ");
        setSector(c.readLine());

        System.out.println("HQaddress: ");
        setHQaddress(c.readLine());

        System.out.println("VAT number: ");
        setVATnumber(c.readLine());  

        System.out.println("Select Subscription:\n(a)Silver \n(b)Gold");
        String sub= c.readLine().toLowerCase();

        if (sub.equals("a")){
           setSub(Subscription.Silver);
        }else if(sub.equals("b")){
            setSub(Subscription.Gold);
        }else {
            System.out.println("Enter the Valid Option (a) or (b)");
            signUp();
        } 
        System.out.println("Sign up complete. Your unique reference number is "+ refNum);     
    } 
    
    public void setName(String name){
        this.name=name;
    }
    public void setTelephone(String tel){
        this.telephone=tel;

    }
    public void setSector(String sector){
        this.sector=sector;
    }
    public void setHQaddress(String HQadd){
        this.HQaddress=HQadd;
    }
    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }
    public void setVATnumber(String VAT){
        this.VATnumber=VAT;
    }
    public void setSub(Subscription sub){
        this.sub=sub;
    }

    public String getRefNum() {
        return refNum;
    }
    public String getName() {
        return name;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getSector() {
        return sector;
    }
    public String getHQaddress() {
        return HQaddress;
    }
    public String getVATnumber() {
        return VATnumber;
    }
    public Subscription getSub() {
        return sub;
    }
    
    public void changeDetails() throws IOException{
    	BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
    	String choice;
    	
        System.out.println("Would you like to change NAME: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("Name: ");
	        setName(c.readLine());
        }
        
        System.out.println("Would you like to change TELEPHONE NUMBER: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("Telephone: ");
	        setTelephone(c.readLine());
        }
        
        System.out.println("Would you like to change SECTOR: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("Sector ");
	        setSector(c.readLine());
        }
        
        System.out.println("Would you like to change HQ ADDRESS: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("HQaddress: ");
	        setHQaddress(c.readLine());
        }
        
        System.out.println("Would you like to change VAT NUMBER: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("VAT number: ");
	        setVATnumber(c.readLine());  
        }
        
        System.out.println("Would you like to change SUBSCRIPTION: Y/N");
        choice=c.readLine();
        if(choice.equals("Y")) {
	        System.out.println("Select Subscription:\n(a)Silver \n(b)Gold");
	        String sub= c.readLine().toLowerCase();
	        
	        if (sub.equals("a")){
	           setSub(Subscription.Silver);
	        }else if(sub.equals("b")){
	            setSub(Subscription.Gold);
	        }else {
	            System.out.println("Enter the Valid Option (a) or (b)");
	            signUp();
	        }
        }
        System.out.println("Display new details after update");
        // get change details from advertiser and store
        display();
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        
        
    } 
    
    public void display(){
        System.out.println("Advertiser details: " +  refNum + "\n" + name +  "\n" + telephone + "\n" + HQaddress + "\n" + sector +"\n" + sub.toString()+"\n" + VATnumber + "\n*******************************************");
    }

    public void simulation() {
    	
       	//creating FoodAdvertiser with silver subscription
    	System.out.println("********************* Simulation 1 **********************");
    	Administration a1 = new Administration();
    	FoodAdvertiser f1 = new FoodAdvertiser();
    	Regulator r1 = Regulator.getInstance();
    	f1.setRefNum(a1.createRef());
    	f1.setName("McDonald Ltd."); 
    	f1.setHQaddress("Los Angeles"); 
    	f1.setTelephone("01453798099");
    	f1.setSector("Fast Food Chain");
    	f1.setVATnumber("AB897456XCYZ");
    	f1.setSub(Subscription.Silver);
    	f1.setCuisines("American Cuisines");
    	f1.attach(r1);
    	f1.display();
    	
    	//The food advertiser attempts to upload 9 advertisements that do not have any foul terms.
    	System.out.println("\n********************* Simulation 2 **********************");
    	f1.addAdvertisement("Beyond Meat Burger", "Introducing the latest addition to our menu - the Beyond Meat Burger!");
    	f1.addAdvertisement("Limited Time Offer", "The McRib Sandwich is back for a limited time only!");
    	f1.addAdvertisement("Breakfast All Day", "Why limit breakfast to just the morning? At McDonald's, you can enjoy your breakfast favorites all day long.");
    	f1.addAdvertisement("Happy Meal Toys", "Looking for a fun way to keep the kids entertained? Our Happy Meal toys are sure to delight!");
    	f1.addAdvertisement("McCafé Coffee", "Get your caffeine fixed at McDonald's with our delicious McCafé coffee.");
    	f1.addAdvertisement("Late Night Menu", "Our late night menu features all your favorites, like Big Macs, McNuggets, and fries, available until 3 AM.");
    	f1.addAdvertisement("Mobile Ordering", "Skip the line and order ahead with our convenient mobile app!");
    	f1.addAdvertisement("Dollar Menu", "Need a budget-friendly meal? Check out our Dollar Menu, featuring classic favorites like the McChicken, McDouble, and small fries.");
    	f1.addAdvertisement("Delivery", "Can't make it to McDonald's? No problem! With our delivery service, you can enjoy your favorites from the comfort of your own home.");
    	
    	
    	//The food advertiser attempts to upload 1 advertisement which has a foul term from the list in the Regulator class.
    	//Here the word "A1" is taken as Foul Word and carried out the simulation
    	System.out.println("\n********************* Simulation 3 **********************");
    	f1.addAdvertisement("The A1 Steakhouse Burger", "Get ready for a burger experience unlike any other with our A1 Steakhouse Burger!");
    	
    	
    	//The food advertiser attempts to upload 2 advertisements which do not have foul terms.
    	System.out.println("\n********************* Simulation 4 **********************");
    	f1.addAdvertisement("New Menu Item", "Ready to spice up your meal routine? Check out our new Spicy McChicken Deluxe sandwich!");
    	f1.addAdvertisement("Drive-Thru Convenience", "Don't have time to sit down for a meal? No problem! With McDonald's drive-thru, you can enjoy your favorites on the go.");
    	
    	//The food advertiser changes from a silver to a gold subscription.
    	System.out.println("\n********************* Simulation 5 **********************");
    	System.out.println("Your current Subscription is " + f1.getSub());
    	f1.setSub(Subscription.Gold);
    	System.out.println("You changed your Subscription to "+f1.getSub());
    	
    	//The food advertiser attempts to upload 2 advertisements which do not have foul terms.
    	System.out.println("\n********************* Simulation 6 **********************");
    	f1.addAdvertisement("McCafé Bakery", "Need a sweet treat to go with your coffee? Look no further than McDonald's McCafé Bakery!");
    	f1.addAdvertisement("All-Day Breakfast", "Who says breakfast is just for the morning? At McDonald's, you can enjoy your breakfast favorites all day long!");
    
    	//The food advertiser displays are the uploaded advertisements.
    	System.out.println("\n********************* Simulation 7 **********************");
    	System.out.println("Getting all uploaded advertisement on " + f1.getName() + "\n");
    	f1.getUploadedAds();
    	
    	//The food advertiser edits the text for one of the uploaded advertisements. 
    	System.out.println("\n********************* Simulation 8 **********************");
    	f1.editAdvertisement("McCafé Coffee", "From classic drip coffee to indulgent mochas and lattes, we've got everything you need to fuel your day");
    	
    	//The food advertiser deletes one of the uploaded advertisements.
    	System.out.println("\n********************* Simulation 9 **********************");
    	f1.deleteAdvertisement("All-Day Breakfast");
    	
    	//The food advertiser unsubscribes from SocialAds
    	System.out.println("\n********************* Simulation 10 *********************");
    	System.out.println("We are sorry to see you leaving " + f1.getName());
    	f1.unsubscribe(); 	
    }

    public void unsubscribe() {
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
            notifyObservers(adText);
            for (Observer observer: observers){ 
                if(!isFoulWord){
                    Advertisement newAd=new Advertisement(title, adText);
                    uploadedAds.put(title,newAd);
                    System.out.println("New advert titled "+title+" uploaded.");
                    
                }else{
                    System.out.println("Sorry your Advertisement Contains Foul Word");
                }
                
            }
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
    public void notifyObservers(String adText){
        for (Observer observer: observers){
        	if (observer.equals(Regulator.getInstance())) {
        		isFoulWord=observer.update(adText);
        	}
        	observer.update(adText);
        }
    }
	public void attach(Observer o){
        observers.add(o);
    }
	public void detach(Observer o){
        Iterator itr =observers.iterator();
        while (itr.hasNext()){
            if (itr.next()==o){
                itr.remove();
            }
        }
    }
    
}

