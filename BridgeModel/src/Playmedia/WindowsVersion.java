package Playmedia;

public class WindowsVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Windows²Ù×÷ÏµÍ³";
		this.videoFile.decode(osType, fileName);
	}


}
