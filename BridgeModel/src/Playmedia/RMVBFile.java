package Playmedia;

public class RMVBFile implements VideoFile {

	@Override
	public void decode(String osType, String fileName) {
		// TODO Auto-generated method stub
		System.out.println(osType+"播放RMVB格式的"+fileName);
	}

}
