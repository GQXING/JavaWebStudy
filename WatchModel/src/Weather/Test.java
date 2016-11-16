package Weather;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather weather=new Weather("明天",24.5f);
		
		Department agricultureDepartment=new Department("农业部");
		Department communicationDepartment=new Department("交通部");
		Department tourismDepartment=new Department("旅游部");
		
		weather.addObserver(tourismDepartment);
		weather.addObserver(communicationDepartment);
		weather.addObserver(agricultureDepartment);
		
		weather.setTempature(14.5f);
		
	}

}
