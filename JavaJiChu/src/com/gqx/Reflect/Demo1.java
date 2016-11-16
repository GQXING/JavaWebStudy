package com.gqx.Reflect;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<?> demo=null;
		try {
			demo=Class.forName("com.gqx.Reflect.Person");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Person per=null; 
        try { 
            per=(Person)demo.newInstance(); 
        } catch (InstantiationException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } catch (IllegalAccessException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
        per.setName("Rollen"); 
        per.setAge(20); 
        System.out.println(per); 
	}
}
