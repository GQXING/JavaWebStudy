package Clothes;

public class Man extends Person {

	 public Man()  
	    {  
	        setType("ÄÐÈË");  
	    } 
	@Override
	public void dress() {
		// TODO Auto-generated method stub
		getClothing().dressCloth(this); 
	}

}
