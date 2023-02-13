package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

import modelo.*;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener{

	Vista Vista = new Vista();
	private int votosTotales;
	private int progreso;
	private int avanza;
	private int votos1 = 0;
	private int votos2 = 0;
	private int votos3 = 0;
	private int votos4 = 0;
	private int votos5 = 0;
	private int votos6 = 0;
	private int votos7 = 0;
	private int votos8 = 0;
	private int votos9 = 0;
	private int votos10 = 0;


	public Controlador(Vista Vista) {
		this.Vista = Vista;
		this.Vista.botonInicio.addActionListener(this);
		this.Vista.comboBox.addActionListener(this);
		this.Vista.comboComunidades.addActionListener(this);
		this.votos1 = votos1;
		this.votos2 = votos2;
		this.votos3 = votos3;
		this.votos4 = votos4;
		this.votos5 = votos5;
		this.votos6 = votos6;
		this.votos7 = votos7;
		this.votos8 = votos8;
		this.votos9 = votos9;
		this.votos10 = votos10;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int numVotos = 0;
		Controlador helper = new Controlador(Vista);
		Connection connection = null;
		
		ArrayList<Cantante> cantantes = new ArrayList();
		inicializarArrayList(cantantes);

		try {
			if(e.getSource() == this.Vista.botonInicio) {
				connection = helper.createConnection();
				Vista.botonInicio.setVisible(false);
				Vista.cargando.setVisible(false);
				Vista.imagen.setVisible(false);
				procesarComunidadVoto(connection);
				mostrarGanadores();
				Vista.lblGanadores.setVisible(true);

				
//				votacionAndalucia(connection, "");
				
			}
			if(e.getSource() == Vista.comboBox) {
				for(int i =0; i < cantantes.size(); i ++) {
					cantantes.remove(i);
				}
				
				inicializarArrayList(cantantes);
				int max = 0;
				Boolean acabar = false;
				String filtro = (String)Vista.comboBox.getSelectedItem();
				String comunidad = (String)Vista.comboComunidades.getSelectedItem();
				if(filtro.equals("-- Seleccione filtro --")) {
					Vista.comboComunidades.setVisible(false);
				}
				if(filtro.equals("Comunidad")) {
					Vista.comboComunidades.setVisible(true);
					
						cantantes = calcularGanadorProvincia(connection, comunidad, cantantes);
						Collections.sort(cantantes, new Comparator<Cantante>() {
						    @Override
						    public int compare(Cantante c1, Cantante c2) {
						        return Long.compare(c2.getVotos(), c1.getVotos());
						    }
						});
						
						mostrarGanadores(cantantes);
						
				}else if(filtro.equals("Nacional")) {
					Vista.comboComunidades.setVisible(false);
					
					inicializarArrayList(cantantes);
					cantantes.get(0).setVotos(this.votos1);
					cantantes.get(1).setVotos(this.votos2);
					cantantes.get(2).setVotos(this.votos3);
					cantantes.get(3).setVotos(this.votos4);
					cantantes.get(4).setVotos(this.votos5);
					cantantes.get(5).setVotos(this.votos6);
					cantantes.get(6).setVotos(this.votos7);
					cantantes.get(7).setVotos(this.votos8);
					cantantes.get(8).setVotos(this.votos9);
					cantantes.get(9).setVotos(this.votos10);
					
					Collections.sort(cantantes, new Comparator<Cantante>() {
					    @Override
					    public int compare(Cantante c1, Cantante c2) {
					        return Long.compare(c2.getVotos(), c1.getVotos());
					    }
					});
					
					mostrarGanadores(cantantes);
					
				}else if(filtro.equals("Edad")) {
					Vista.comboComunidades.setVisible(false);
				}else {
					
				}
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private void mostrarGanadores(ArrayList<Cantante> cantantes) {
		Vista.lblNombreTop1.setText(cantantes.get(0).getNombre());
		Vista.lblImagenTop1.setIcon(new ImageIcon(cantantes.get(0).getImagen()));
		Vista.lblPuntosTop1.setText(Integer.toString(cantantes.get(0).getVotos()));
		
		Vista.lblNombreTop2.setText(cantantes.get(1).getNombre());
		Vista.lblImagenTop2.setIcon(new ImageIcon(cantantes.get(1).getImagen()));
		Vista.lblPuntosTop2.setText(Integer.toString(cantantes.get(1).getVotos()));
		
		Vista.lblNombreTop3.setText(cantantes.get(2).getNombre());
		Vista.lblImagenTop3.setIcon(new ImageIcon(cantantes.get(2).getImagen()));
		Vista.lblPuntosTop3.setText(Integer.toString(cantantes.get(2).getVotos()));
		
	}

	private void inicializarArrayList(ArrayList<Cantante> cantantes) {
		Cantante cantante1 = new Cantante("15987458H","Joel", "src/Imagenes/abdurozik.png", 0 );
		Cantante cantante2 = new Cantante("43217895I","Victoria", "src/Imagenes/motomami.jpg", 0 );
		Cantante cantante3 = new Cantante("78912374F","Thiago", "src/Imagenes/hasbulla.png", 0 );
		Cantante cantante4 = new Cantante("74185296C","Sarah", "src/Imagenes/melendi.png", 0 );
		Cantante cantante5 = new Cantante("12345678A","Elton", "src/Imagenes/elton.png", 0 );
		Cantante cantante6 = new Cantante("95175386E","Amie", "src/Imagenes/elnano.png", 0 );
		Cantante cantante7 = new Cantante("85296321J","Nahid", "src/Imagenes/johncena.png", 0 );
		Cantante cantante8 = new Cantante("84267418G","Marc", "src/Imagenes/sandrorey.png", 0 );
		Cantante cantante9 = new Cantante("98765432B","Alba", "src/Imagenes/jorge.png", 0 );
		Cantante cantante10 = new Cantante("78951425D","Julio", "src/Imagenes/rajoy.png", 0 );
		
		cantantes.add(cantante1);
		cantantes.add(cantante2);
		cantantes.add(cantante3);
		cantantes.add(cantante4);
		cantantes.add(cantante5);
		cantantes.add(cantante6);
		cantantes.add(cantante7);
		cantantes.add(cantante8);
		cantantes.add(cantante9);
		cantantes.add(cantante10);
	}


	private void mostrarGanadores() {
		Vista.seleccionFiltro.setVisible(true);
		Vista.comboBox.setVisible(true);
		Vista.panelTop1.setVisible(true);
		Vista.panelPosicionTop1.setVisible(true);
		Vista.panelTop2.setVisible(true);
		Vista.panelPosicionTop2.setVisible(true);
		Vista.panelTop3.setVisible(true);
		Vista.panelPosicionTop3.setVisible(true);
		
	}
	
	
	
	public void procesarComunidadVoto(Connection connection) {
		ArrayList<String> comunidades = new ArrayList<String>();
		ArrayList<String> rangos = new ArrayList<String>();
		
		String comunidad;
		String rango;
		
		try {
			
			comunidades = sacarComunidad(connection, comunidades);
			rangos = sacarRango(connection, rangos);
			
			for(int i = 0; i<comunidades.size(); i++) {
				for(int j = 0; j<rangos.size(); j++) {
					comunidad = comunidades.get(i);
					rango = rangos.get(j);
					
					String consulta = "SELECT " + rango + " FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD = ?";
					
					votacionComunidades(connection, consulta, rango, comunidad);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> sacarComunidad(Connection connection, ArrayList<String> comunidades) throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT NOMBRE_COMUNIDAD FROM PORCENTAJES_RANGOEDAD");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				comunidades.add(resultSet.getString("NOMBRE_COMUNIDAD"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
			}
		}
		
		return comunidades;
	}
	
	public ArrayList<String> sacarRango(Connection connection, ArrayList<String> rangos) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT RANGO FROM PORCENTAJE_VOTACION_RANGO WHERE ES_MAYOREDAD = '1'");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				rangos.add(resultSet.getString("RANGO"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
				}
			}
		}
		
		return rangos;
	}
	
	public void votacionComunidades(Connection connection, String consulta, String rango, String comunidad) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int porcentajeVoto, numVotosFinal, totalHabitantes;
		double porcentajeRango;
		
		try {
			
			preparedStatement = connection.prepareStatement(consulta);
			preparedStatement.setString(1, comunidad);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				porcentajeVoto = resultSet.getInt(rango);

				porcentajeRango = votacionRango(connection, rango);
				
				totalHabitantes = habitantesComunidad(connection, comunidad);
			
				numVotosFinal = generarNumVotos(porcentajeVoto, porcentajeRango, totalHabitantes);
			
				votacion(connection, numVotosFinal, rango, comunidad);
			}		
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}finally {
			if (null != preparedStatement) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				
					}
				}
		}
	}

	public int generarNumVotos(int porcentajeVoto, double porcentajeRango, int totalHabitantes) {
		int numVotosFinal;
		porcentajeVoto = (totalHabitantes * porcentajeVoto)/100;
		
		numVotosFinal = (int) ((porcentajeVoto * porcentajeRango)/100);
		
		return numVotosFinal;
	}
	
	public int habitantesComunidad(Connection connection, String comunidad) throws SQLException {
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		int totalHabitantes = 0;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT TOTAL_HABITANTES FROM PORCENTAJES_RANGOEDAD WHERE NOMBRE_COMUNIDAD = ?");
			preparedStatement.setString(1, comunidad);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			totalHabitantes = resultSet.getInt("TOTAL_HABITANTES");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return totalHabitantes;
	}
	
	public double votacionRango(Connection connection, String rango) throws SQLException{
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		double porcentajeVoto = 0;
		
		try {
			
			preparedStatement = connection.prepareStatement("SELECT PORCENTAJE FROM PORCENTAJE_VOTACION_RANGO WHERE RANGO = ?");
			preparedStatement.setString(1, rango);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			porcentajeVoto = resultSet.getDouble("PORCENTAJE");
			
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return porcentajeVoto;
	}

	public void votacion(Connection connection, int numVotos, String rango, String comunidad) throws SQLException {
		//Repetimos el for segun el numero de votos por porcentaje de rango
		int voto = 0;
		if(numVotos < 5) {
			numVotos = 5;
		}
		
		for(int i = 0; i< numVotos; i++) {
			//Creacion del hilo de prueba
			Votacion hilo = new Votacion(rango);
			
			hilo.start();
			try {
				//hilo.sleep(500);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//Recuperamos el voto que ha salido del numero random que calcula el hilo
			voto = hilo.getVoto();
			
			updateVoto(connection, voto, comunidad, rango);
			}
		}

	
	
	public void updateVoto(Connection connection, int voto, String comunidad, String rango) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int sumaVoto = 0;
		
		String dni = "";
		
		if(voto == 1) {
			this.votos1 = this.votos1 + 1;
			dni = "12345678A";
		}else if(voto == 2) {
			dni = "98765432B";
			this.votos2 = this.votos2 + 1;
		}else if(voto == 3) {
			dni = "74185296C";
			this.votos3 = this.votos3 + 1;
		}else if(voto == 4) {
			dni = "78951425D";
			this.votos4 = this.votos4 + 1;
		}else if(voto == 5) {
			dni = "95175386E";
			this.votos5 = this.votos5 + 1;
		}else if(voto == 6) {
			dni = "78912374F";
			this.votos6 = this.votos6 + 1;
		}else if(voto == 7) {
			dni = "84267418G";
			this.votos7 = this.votos7 + 1;
		}else if(voto == 8) {
			dni = "15987458H";
			this.votos8 = this.votos8 + 1;
		}else if(voto == 9) {
			dni = "43217895I";
			this.votos9 = this.votos9 + 1;
		}else if(voto == 10) {
			dni = "85296321J";
			this.votos10 = this.votos10 + 1;
		}
		if(comunidad.equals("Cataluña")) {
			comunidad = "CATALUNIA";
		}
		if(comunidad.equals("Islas Canarias")) {
			comunidad = "CANARIAS";
		}
		if(comunidad.equals("Islas Baleares")) {
			comunidad = "BALEARES";
		}
		if(comunidad.equals("Castilla La Mancha")) {
			comunidad = "CASTILLA_LA_MANCHA";
		}if(comunidad.equals("Castilla y Leon")) {
			comunidad = "CASTILLA_LEON";
		}
		if(comunidad.equals("Comunidad Valenciana")) {
			comunidad = "COMUNIDAD_VALENCIANA";
		}
		
		if(comunidad.equals("La Rioja")) {
			comunidad = "LA_RIOJA";
		}
		
		if(comunidad.equals("Pais Vasco")){
			comunidad = "PAIS_VASCO";
		}
		
		try {
			System.out.println(comunidad);
			if(rango.equals("RANGO_18_25")) {
				preparedStatement = connection.prepareStatement("SELECT VOTOS_18_25 FROM " + comunidad + " WHERE DNI_CANTANTE = ? " );
				preparedStatement.setString(1, dni);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					sumaVoto = resultSet.getInt("VOTOS_18_25") + 1;
					}
				
				preparedStatement = connection.prepareStatement("UPDATE " + comunidad + " SET VOTOS_18_25 = " +sumaVoto+ " WHERE DNI_CANTANTE = ? ");
				preparedStatement.setString(1, dni);
				preparedStatement.executeUpdate();
				connection.commit();
			}else if(rango.equals("RANGO_26_40")) {
				preparedStatement = connection.prepareStatement("SELECT VOTOS_26_40 FROM " + comunidad + " WHERE DNI_CANTANTE = ? " );
				preparedStatement.setString(1, dni);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					sumaVoto = resultSet.getInt("VOTOS_26_40") + 1;
					}
				
				preparedStatement = connection.prepareStatement("UPDATE " + comunidad + " SET VOTOS_26_40 = " +sumaVoto+ " WHERE DNI_CANTANTE = ? ");
				preparedStatement.setString(1, dni);
				preparedStatement.executeUpdate();
				connection.commit();
			}else if(rango.equals("RANGO_41_65")) {
				preparedStatement = connection.prepareStatement("SELECT VOTOS_41_65 FROM " + comunidad + " WHERE DNI_CANTANTE = ? " );
				preparedStatement.setString(1, dni);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					sumaVoto = resultSet.getInt("VOTOS_41_65") + 1;
					}
				
				preparedStatement = connection.prepareStatement("UPDATE " + comunidad + " SET VOTOS_41_65 = " +sumaVoto+ " WHERE DNI_CANTANTE = ? ");
				preparedStatement.setString(1, dni);
				preparedStatement.executeUpdate();
				connection.commit();
			}else if(rango.equals("RANGO_MAS_66")) {
				preparedStatement = connection.prepareStatement("SELECT VOTOS_66 FROM " + comunidad + " WHERE DNI_CANTANTE = ? " );
				preparedStatement.setString(1, dni);
				
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()){
					sumaVoto = resultSet.getInt("VOTOS_66") + 1;
					}
				
				preparedStatement = connection.prepareStatement("UPDATE " + comunidad + " SET VOTOS_66 = " +sumaVoto+ " WHERE DNI_CANTANTE = ? ");
				preparedStatement.setString(1, dni);
				preparedStatement.executeUpdate();
				connection.commit();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public ArrayList<Cantante> calcularGanadorProvincia(Connection connection, String comunidad, ArrayList<Cantante> cantantes) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String dni = null;
		int votos = 0;
		if(comunidad.equals("Cataluña")) {
			comunidad = "CATALUNIA";
		}
		if(comunidad.equals("Islas Canarias")) {
			comunidad = "CANARIAS";
		}
		if(comunidad.equals("Islas Baleares")) {
			comunidad = "BALEARES";
		}
		if(comunidad.equals("Castilla La Mancha")) {
			comunidad = "CASTILLA_LA_MANCHA";
		}
		if(comunidad.equals("Castilla Leon")) {
			comunidad = "CASTILLA_LEON";
		}
		if(comunidad.equals("Comunidad Valenciana")) {
			comunidad = "COMUNIDAD_VALENCIANA";
		}
		
		if(comunidad.equals("La Rioja")) {
			comunidad = "LA_RIOJA";
		}
		
		if(comunidad.equals("Pais Vasco")){
			comunidad = "PAIS_VASCO";
		}
		try {
			try {
				connection = createConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			preparedStatement = connection.prepareStatement("SELECT DNI_CANTANTE, (VOTOS_18_25 + VOTOS_26_40 + VOTOS_41_65 + VOTOS_66) AS SUMA_VOTOS FROM " + comunidad +" ORDER BY SUMA_VOTOS DESC " );
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				dni = resultSet.getString("DNI_CANTANTE");
				votos = resultSet.getInt("SUMA_VOTOS");
				for(int i = 0; i < cantantes.size(); i++) {
					if(cantantes.get(i).getDni().equals(dni)) {
						cantantes.get(i).setVotos(votos + cantantes.get(i).getVotos());
					}
				}
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cantantes;
	}

	public static Connection createConnection() throws ClassNotFoundException, SQLException, IOException {

		Connection censoHabitantes = null;

		try {
			//Accedemos al fichero de propiedades para recuperar los datos para conectarnos a base de datos
			Properties propiedades = new Properties();
			propiedades.load(new FileReader("src/recursos/database.properties"));
			String driver = propiedades.getProperty("database.driver");
			String url = propiedades.getProperty("database.url");
			String user = propiedades.getProperty("database.user");
			String password = propiedades.getProperty("database.password");

			//Relizamos el registro del driver y obtenemos la conexion
			Class.forName(driver);
			censoHabitantes = DriverManager.getConnection(url, user, password);

			// Nos aseguramos setAutoCommit a false
			censoHabitantes.setAutoCommit(false);
			
			System.out.println("Conexion creada con exito");
						
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			throw e;
		}

		return censoHabitantes;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
