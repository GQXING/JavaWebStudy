package Playmedia;

public class LinuxVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Linux²Ù×÷ÏµÍ³";
		this.videoFile.decode(osType, fileName);
	}

}
