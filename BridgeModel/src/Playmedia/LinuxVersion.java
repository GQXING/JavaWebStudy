package Playmedia;

public class LinuxVersion extends OSVersion {

	@Override
	public void play(String fileName) {
		// TODO Auto-generated method stub
		String osType="Linux����ϵͳ";
		this.videoFile.decode(osType, fileName);
	}

}
