//import needed package
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Sound class
public class Sound {
	
	//create variables needed in class
	String soundClip; //file location string
	Clip myClip; 
	
	/* constructor
	 * pre: none
	 * post: creates a Sound object with soundClip equal to sound string
	 */
	Sound(String sound){
		soundClip = sound;		
	}
	
	/* set the sound file
	 * pre: none
	 * post: the sound file is set, and the clip has been opened
	 */
	public void soundFile() {
		try {
			File file = new File(soundClip); //create new file with soundClip
			AudioInputStream Sound = AudioSystem.getAudioInputStream(file);
			myClip = AudioSystem.getClip(); //open clip
			myClip.open(Sound);
		}
		catch(Exception e) {	
		}
	}
	
	/* play the clip sound
	 * pre: none
	 * post: the sound has been played
	 */
	public void playSound() {
		myClip.setFramePosition(0);
		myClip.start();
	}
	
	/* loop the clip sound
	 * pre: none
	 * post: the sound is now looping continuously 
	 */
	public void loop() {
		myClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	/* stop playing sound (stops it from looping)
	 * pre: none
	 * post: the sound has stopped playing (myClip has closed)
	 */
	public void stop() {
		myClip.stop();
		myClip.close();
	}
	
}
