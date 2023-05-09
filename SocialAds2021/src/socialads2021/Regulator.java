package socialads2021;

import java.util.ArrayList;
import java.util.List;

public class Regulator implements Observer{
	private static Regulator INSTANCE;
	private List<String> FoulWords=new ArrayList<String>(); 
	private boolean ContainsFoulWord = false;
	private Regulator() {
	
	}
	
	public static Regulator getInstance() {
		if( INSTANCE==null) {
			INSTANCE=new Regulator();
		}
		return INSTANCE;
	}
	
	public boolean update(String adText){
		FoulWords.add("a1");
		FoulWords.add("a2");
		FoulWords.add("b1");
		FoulWords.add("b2");
		FoulWords.add("b4");
		FoulWords.add("c3");
		FoulWords.add("c5");
		FoulWords.add("c6");
		FoulWords.add("d1");
		FoulWords.add("d2");
		FoulWords.add("d2");
		FoulWords.add("d3");
		FoulWords.add("e5");
		FoulWords.add("e6");
		FoulWords.add("e7");
		FoulWords.add("f8");
		String[] separated =adText.split(" ");
		ContainsFoulWord=false;
		for(String str: separated){
			try {
				if (FoulWords.contains(str.toLowerCase())){
					ContainsFoulWord=true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.ContainsFoulWord;
		
		
	}


}
