package modelo;

public class Votacion extends Thread{
	
	private String rango;
	private int voto;
	
	public Votacion(String rango) {
		super();
		this.rango = rango;
	}

	@Override
	public void run() {
		int random;
		random = (int)(0+ Math.random()*99);
		
		if(rango.equals("RANGO_18_25")) {
			if(random >= 0 && random <= 7) {
				voto = 1;
			}else if(random >= 8 && random <= 10) {
				voto = 2;
			}else if(random >= 11 && random <= 23) {
				voto = 3;
			}else if(random >= 24 && random <= 30) {
				voto = 4;
			}else if(random >= 31 && random <= 37) {
				voto = 5;
			}else if(random >= 38 && random <= 51) {
				voto = 6;
			}else if(random >= 52 && random <= 61) {
				voto = 7;
			}else if(random >= 62 && random <= 88) {
				voto = 8;
			}else if(random >= 89 && random <= 95) {
				voto = 9;
			}else if(random >= 96 && random <= 100) {
				voto = 10;
			}
		}else if(rango.equals("RANGO_26_40")) {
			if(random >= 0 && random <= 14) {
				voto = 1;
			}else if(random >= 15 && random <= 20) {
				voto = 2;
			}else if(random >= 21 && random <= 33) {
				voto = 3;
			}else if(random >= 34 && random <= 40) {
				voto = 4;
			}else if(random >= 41 && random <= 46) {
				voto = 5;
			}else if(random >= 47 && random <= 58) {
				voto = 6;
			}else if(random >= 59 && random <= 65) {
				voto = 7;
			}else if(random >= 66 && random <= 81) {
				voto = 8;
			}else if(random >= 82 && random <= 90) {
				voto = 9;
			}else if(random >= 91 && random <= 100) {
				voto = 10;
			}
		}else if(rango.equals("RANGO_41_65")) {
			if(random >= 0 && random <= 5) {
				voto = 1;
			}else if(random >= 6 && random <= 15) {
				voto = 2;
			}else if(random >= 16 && random <= 27) {
				voto = 3;
			}else if(random >= 28 && random <= 33) {
				voto = 4;
			}else if(random >= 34 && random <= 40) {
				voto = 5;
			}else if(random >= 41 && random <= 54) {
				voto = 6;
			}else if(random >= 55 && random <= 61) {
				voto = 7;
			}else if(random >= 62 && random <= 71) {
				voto = 8;
			}else if(random >= 72 && random <= 88) {
				voto = 9;
			}else if(random >= 89 && random <= 100) {
				voto = 10;
			}
		}else if(rango.equals("RANGO_MAS_66")) {
			if(random >= 0 && random <= 3) {
				voto = 1;
			}else if(random >= 4 && random <= 20) {
				voto = 2;
			}else if(random >= 21 && random <= 25) {
				voto = 3;
			}else if(random >= 26 && random <= 37) {
				voto = 4;
			}else if(random >= 38 && random <= 49) {
				voto = 5;
			}else if(random >= 50 && random <= 58) {
				voto = 6;
			}else if(random >= 59 && random <= 65) {
				voto = 7;
			}else if(random >= 66 && random <= 76) {
				voto = 8;
			}else if(random >= 77 && random <= 91) {
				voto = 9;
			}else if(random >= 92 && random <= 100) {
				voto = 10;
			}
		}
		
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}
	
}
