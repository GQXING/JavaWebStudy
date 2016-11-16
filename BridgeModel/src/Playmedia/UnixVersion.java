package Playmedia;

public class UnixVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Unix²Ù×÷ÏµÍ³";
		this.videoFile.decode(osType, fileName);
	}

}
