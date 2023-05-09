package socialads2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AttractionAdvertiser extends Advertiser {
	private String Country;
	public AttractionAdvertiser() {
	}
	public String getCountry(){
		return Country;
	}
	public void setCountry(String c){
		this.Country=c;
	}
	@Override
	public void signUp() throws IOException{
    	BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
    	
        System.out.println("Name: ");
        super.setName(c.readLine());

        System.out.println("Telephone: ");
        super.setTelephone(c.readLine());

        System.out.println("Sector ");
        super.setSector(c.readLine());

        System.out.println("HQaddress: ");
        super.setHQaddress(c.readLine());

        System.out.println("VAT number: ");
        super.setVATnumber(c.readLine());
		
		System.out.println("Country: ");
        setCountry(c.readLine()); 

        System.out.println("Select Subscription:\n(a)Silver \n(b)Gold");
        String sub= c.readLine().toLowerCase();

        if (sub.equals("a")){
           super.setSub(Subscription.Silver);
        }else if(sub.equals("b")){
            super.setSub(Subscription.Gold);
        }else {
            System.out.println("Enter the Valid Option (a) or (b)");
            signUp();
        } 
        System.out.println("Sign up complete. Your unique reference number is "+ super.getRefNum());     
    } 
	@Override 
	public void display(){
        System.out.println("Advertiser details: " + super.getRefNum() + "\n" +super.getName() +  "\n" + super.getTelephone() + "\n" + super.getHQaddress() + "\n" + super.getSector() +"\n" + super.getSub().toString()+"\n" + super.getVATnumber() + "\n" +Country + "\n*******************************************");
    }

	
	
}
