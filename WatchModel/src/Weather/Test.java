package Weather;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Weather weather=new Weather("����",24.5f);
		
		Department agricultureDepartment=new Department("ũҵ��");
		Department communicationDepartment=new Department("��ͨ��");
		Department tourismDepartment=new Department("���β�");
		
		weather.addObserver(tourismDepartment);
		weather.addObserver(communicationDepartment);
		weather.addObserver(agricultureDepartment);
		
		weather.setTempature(14.5f);
		
	}

}
