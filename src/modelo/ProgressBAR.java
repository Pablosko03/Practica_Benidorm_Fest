package modelo;
import vista.Vista;

public class ProgressBAR extends Thread {

	Vista vista = new Vista();
	private int progreso = 0;
	
	
public ProgressBAR() {
		super();
		this.vista = vista;
	}

@Override
public void run() {
	for(int i = 0; i < 100; i++) {
		vista.progressBar.setValue(i);
		try {
			this.sleep(10000);
		}catch(Exception e) {
			
		}
		
	}
}
}