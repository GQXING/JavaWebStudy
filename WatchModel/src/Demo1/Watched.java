package Demo1;
//���������ɫ��watched�����۲���
public interface Watched {
	public void addWatcher(Watcher watcher);
	
	public void removeWatcher(Watcher watcher);
	
	public void notifyWatcher(String string);
}
