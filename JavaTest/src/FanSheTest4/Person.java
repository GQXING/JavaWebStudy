	package FanSheTest4;
	
	interface Info{
		public static final String AUTHOR="MLDN";
		public String getInFo();
		public String say(String name,String content);
		public void sayHello();
	}
	public class Person implements Info {
		private String name;
		private int age;
		public Person(){
			
		}
		public Person(String name){
			this.setName(name);
		}
		public Person(String name,int age){
			this(name);
			this.setAge(age);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String toString(){
			return "���֣�"+this.name+"�����䣺"+this.age;
		}
		@Override
		public String getInFo() {
			// TODO Auto-generated method stub
			return "Hello World";
		}
		@Override
		public String say(String name, String content) {
			// TODO Auto-generated method stub
			return name+"˵��"+content;
		}
		@Override
		public void sayHello() {
			// TODO Auto-generated method stub
			System.out.println("hello-->"+AUTHOR);
		}
	}
