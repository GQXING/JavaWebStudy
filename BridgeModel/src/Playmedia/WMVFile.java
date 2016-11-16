package Playmedia;

public class WMVFile implements VideoFile {

	@Override
	public void decode(String osType, String fileName) {
		// TODO Auto-generated method stub
		System.out.println(osType+"播放WMV格式的"+fileName);
	}

}
