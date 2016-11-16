package Playmedia;

public class MPEGFile implements VideoFile {

	@Override
	public void decode(String osType, String fileName) {
		// TODO Auto-generated method stub
		System.out.println(osType+"播放MPEG格式的"+fileName);
	}

}
