import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javazoom.jl.decoder.Decoder;
import javazoom.jl.decoder.Header;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Main extends JFrame implements ChangeListener{
	
	public static GraphicsPanel gp;
	public static double wabbleAmmount = 0;
	public static double wabbleIntensity = 0;

	public static void main(String[] args) {
		new Main();
	

	}
	
	public static void preDraw() {
		gp.currentPath = new RotationalPath(new RotationalFunctionPair() {
			
			@Override
			public double function(double theta) {
				return Math.sin(theta) + Math.cos(theta * wabbleAmmount) * (wabbleIntensity);
			}
			
			@Override
			public double coFunction(double theta) {
				return Math.cos(theta) + Math.sin(theta * wabbleAmmount) * (wabbleIntensity);
			}
		});
		gp.repaint();
	}
	
	public Main() {
		this.setSize(800, 600);
		this.setTitle("RotationVisualizer");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gp = new GraphicsPanel();
		JSlider wabbles = new JSlider(JSlider.HORIZONTAL, 0, 200, 0);
		wabbles.setName("wabbles");
		wabbles.addChangeListener(this);
		JSlider wabbleIntensiy = new JSlider(JSlider.HORIZONTAL, 0, 600, 0);
		wabbleIntensiy.setName("wabbleIntensity");
		wabbleIntensiy.addChangeListener(this);
		gp.add(wabbles);
		gp.add(wabbleIntensiy);
		preDraw();
		this.add(gp);
		gp.repaint();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		JSlider slider = (JSlider)(e.getSource());
		if(slider.getName().equals("wabbles")) {
		wabbleAmmount = slider.getValue() / 10.0;
		}else if (slider.getName().equals("wabbleIntensity")) {
		wabbleIntensity = slider.getValue() / 100.0;
		}
		preDraw();
	}
}
