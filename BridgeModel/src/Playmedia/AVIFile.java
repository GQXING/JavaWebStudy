package Playmedia;

public class AVIFile implements VideoFile {

	@Override
	public void decode(String osType, String fileName) {
		// TODO Auto-generated method stub
		System.out.println(osType+"����AVI��ʽ��"+fileName);
	}

}
