package Playmedia;

public class UnixVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Unix����ϵͳ";
		this.videoFile.decode(osType, fileName);
	}

}
