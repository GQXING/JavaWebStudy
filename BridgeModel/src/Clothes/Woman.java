package Clothes;

public class Woman extends Person {

	 public Woman()  
	    {  
	        setType("Ů��");  
	    } 
	@Override
	public void dress() {
		// TODO Auto-generated method stub
		getClothing().dressCloth(this); 
	}

}
