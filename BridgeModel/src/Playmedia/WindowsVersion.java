package Playmedia;

public class WindowsVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Windows����ϵͳ";
		this.videoFile.decode(osType, fileName);
	}


}
