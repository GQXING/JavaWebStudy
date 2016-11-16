package Demo1;

import java.awt.List;
import java.util.ArrayList;

public class ConcreteWatched implements Watched
{
    // 存放观察者
    private ArrayList<Watcher> list = new ArrayList<Watcher>();

	@Override
	public void addWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		list.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		// TODO Auto-generated method stub
		 list.remove(watcher);
	}

	@Override
	public void notifyWatcher(String string) {
		// TODO Auto-generated method stub
		 // 自动调用实际上是主题进行调用的
        for (Watcher watcher : list)
        {
            watcher.update(string);
        }
	}

   
}