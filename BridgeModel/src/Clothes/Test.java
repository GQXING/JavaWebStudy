package Clothes;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  //������  
        Person man = new Man();          
        Person lady = new Woman();  
        //�����·�����  
        Clothing jacket = new Jacket();          
        Clothing trouser = new Trouser() ;
  
        jacket.dressCloth(man);  
        trouser.dressCloth(man);  
        jacket.dressCloth(lady);  
        trouser.dressCloth(lady);  
	}

}
