package application;

import java.net.URL;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import BuildH2O.BuildingH2O;
import BuildH2O.Hydrogen;
import BuildH2O.Oxygen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class MainController implements Initializable {
	
	
	final int randomA[]= {1,0,1,0,1,1};
	
	@FXML
	Button Start, Pause, Resume;

	@FXML
	private  Text H, O, H2O, countH, countO;

	Thread MainThread = new Thread() {
		public  void run() {

			BuildingH2O buildingH2O = new BuildingH2O();
			
			for (int i = 0; i < 200; i++) {
				
				if (RanDom() == 1) {
					
					Hydrogen hydrogen = new Hydrogen(buildingH2O);
					Thread thread = new Thread(hydrogen);
					thread.start();	
					countH.setText(Integer.toString(Hydrogen.count));					

					H.setText(Integer.toString(buildingH2O.hydrogen));				
					O.setText(Integer.toString(buildingH2O.oxygen));
					countH.setText(Integer.toString(Oxygen.count));
					
				} else {
					
					Oxygen myOxygen = new Oxygen(buildingH2O);
					Thread thread = new Thread(myOxygen);
					thread.start();
					countO.setText(Integer.toString(Oxygen.count));		
					O.setText(Integer.toString(buildingH2O.oxygen));					
					H.setText(Integer.toString(buildingH2O.hydrogen));	

				}	
				
				 H2O.setText(Integer.toString(BuildingH2O.count));
				try {
						TimeUnit.MILLISECONDS.sleep(1100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	};
	

	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	int RanDom() {
		Random rd = new Random();
		int number = rd.nextInt(6); // 0-5
		return randomA[number];
	}

	
	@FXML
	public  void begin() {
		MainThread.start();
	}
	    

	@SuppressWarnings("removal")
	@FXML
	public void pause() {
		MainThread.suspend();
	}
	
	@SuppressWarnings("removal")
	@FXML
	public void resume() {
		MainThread.resume();
	}
	
	    

}
	


