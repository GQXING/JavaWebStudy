package Demo1;
//抽象主题角色，watched：被观察者
public interface Watched {
	public void addWatcher(Watcher watcher);
	
	public void removeWatcher(Watcher watcher);
	
	public void notifyWatcher(String string);
}
