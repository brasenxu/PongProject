
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	String soundClip;
	Clip myClip;
	
	Sound(String sound){
		soundClip = sound;		
	}
	
	public void soundFile() {
		try {
			File file = new File(soundClip);
			AudioInputStream Sound = AudioSystem.getAudioInputStream(file);
			myClip = AudioSystem.getClip();
			myClip.open(Sound);
		}
		catch(Exception e) {	
		}
	}
	
	public void playSound() {
		myClip.setFramePosition(0);
		myClip.start();
	}
	
	public void loop() {
		myClip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		myClip.stop();
		myClip.close();
	}
	
}
