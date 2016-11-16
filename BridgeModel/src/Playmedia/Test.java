package Playmedia;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-genera ted method stub
		OSVersion windows=new WindowsVersion();
		VideoFile avifileFile=new AVIFile();
		windows.setVideoFile(avifileFile);
		windows.play("movie");
	}

}
