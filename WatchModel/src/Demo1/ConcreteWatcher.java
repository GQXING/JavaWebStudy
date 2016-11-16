package Demo1;
//定义具体的观察者
public class ConcreteWatcher implements Watcher {

	@Override
	public void update(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

}
