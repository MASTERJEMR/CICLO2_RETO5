
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modelo {
	private static Vista v;
	private ArrayList<EstudianteDTO> agenda;
	private static CxDBData cx;
	
	

	public Modelo() {
		agenda = new ArrayList<EstudianteDTO>();
		cx = new CxDBData();
		v= new Vista();
	}
	
	
	
	public  Connection conectarBD() {
		Connection conn = null;
		int opcion = 2;
		switch(opcion) {
		case 1:
			conn = cx.conectarBDMySQL();
			break;
		case 2:
			conn = cx.conectarBDSQLite();
			break;
		}
		return conn;
	}


	
	public void createTableEstudiantes() {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS bd_estudiantes ("
					+"nombres TEXT(200) NOT NULL,"
					+"apellidos TEXT(200) NOT NULL,"
				    +"fecha TEXT(100) NOT NULL,"
				    +"correoins varchar(100) NOT NULL,"
				    +"correoper varchar(100) NOT NULL,"
				    +"cel DOUBLE(10) NOT NULL,"
				    +"fijo DOUBLE(10) NOT NULL,"
				    +"programa TEXT(100) NOT NULL"
					+ ");";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertEstudiante(String nombres,String apellidos,
			String fecha,String correo,String correop,long celular,long telefono,String programa) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO bd_estudiantes VALUES ('" + nombres + "',\'" 
					+ apellidos + "\'" + ",\'" + fecha+ "\'" + ",\'"+correo+ "\'" + ",\'"
					+correop+ "\'" + ",\'"+celular+ "\'" + ",\'"+telefono+ "\'" + ",\'"
					+programa
					+ "\');";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void updateEstudiante(String correo, String correop, long celular,long fijo,String programa) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "UPDATE bd_estudiantes SET correoper=\'" 
						+ correop + "\', cel=\'" + celular+ "\', fijo=\'" +fijo
						+ "\', programa=\'" +programa
						+ "\' WHERE correoins='"+correo+"';";
			//System.out.println(sql);
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteEstudiante(String correo) {
		try {
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM bd_estudiantes WHERE correoins='"+correo+"';";
			//System.out.println(sql);
			//System.out.println("Se eliminó el estudiante\n");
			v.imprimirMensaje("Se eliminó el estudiante\n");
			stmt.executeUpdate(sql);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void selectEstudiantes() {
		agenda = new ArrayList<EstudianteDTO>();
		try {
			EstudianteDTO Estudiante; 
			String sql = "SELECT nombres, apellidos, fecha,correoins,correoper,cel,fijo,programa FROM bd_estudiantes;";
			Connection conn = conectarBD();
			Statement stmt = conn.createStatement();
			//System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Estudiante = new EstudianteDTO();
								
				Estudiante.setNombres(rs.getString("nombres"));
				Estudiante.setApellidos(rs.getString("apellidos"));
				Estudiante.setFecha(rs.getString("fecha"));
				Estudiante.setCorreo(rs.getString("correoins"));
				Estudiante.setCorreop(rs.getString("correoper"));
				Estudiante.setCelular(rs.getLong("cel"));
				Estudiante.setTelefono(rs.getLong("fijo"));
				Estudiante.setPrograma(rs.getString("programa"));
				
				
				agenda.add(Estudiante);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<EstudianteDTO> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<EstudianteDTO> agenda) {
		this.agenda = agenda;
	}
	///////////////
	public  void agregarEstudiantegrafico() {
		String apellidos="",fecha="",nombres="",correo="",correop="", programa="";
		long celular=0,telefono=0;
		
		nombres=v.pedirStringGrafico("Ingresar estudiante\nIngresar nombres:\n");
		apellidos=v.pedirStringGrafico("Ingresar apellidos:\n");
		fecha=v.pedirStringGrafico("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
		correo=v.pedirStringGrafico("Ingresar correo institucional:\n");
		correop=v.pedirStringGrafico("Ingresar correo personal:\n");
		celular=v.pedirLongGrafico("Ingresar número de celular:\n");
		telefono=v.pedirLongGrafico("Ingresar número fijo:\n");
		programa=v.pedirStringGrafico("Ingresar programa:\n");
		insertEstudiante(nombres,apellidos,fecha,correo,correop,celular,telefono,programa);
	}
	////////////////////
	
}
