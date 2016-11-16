package Demo1;

import java.awt.List;
import java.util.ArrayList;

public class ConcreteWatched implements Watched
{
    // ��Ź۲���
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
		 // �Զ�����ʵ������������е��õ�
        for (Watcher watcher : list)
        {
            watcher.update(string);
        }
	}

   
}