package Playmedia;

import Clothes.Person;

public abstract class OSVersion {
	 /** 
     * ³éÏó·½·¨ 
     * @param person 
     */  
	protected VideoFile videoFile;
    public void setVideoFile(VideoFile videoFile){
    	this.videoFile=videoFile;
    };  
    public abstract void play(String fileName);

}
