import java.util.ArrayList;

public class Controlador {
	private static Modelo m;
	private static Vista v;
	private static EstudianteD e;
	
	

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu(){
		m=new Modelo();
		v= new Vista();
		e=new EstudianteD();
		e.leerArchivo();
		m.createTableEstudiantes();
	
		boolean salir=false;
		
		while(!salir) {
			int opcion=v.menuGrafico();
			
			//int opcion = v.imprimirMenu();
			
			switch(opcion) {
			case 1:
				m.agregarEstudiantegrafico();
				break;
			case 2:
				m.selectEstudiantes();
				v.buscarEstudiantexIDGrafico(m.getAgenda());
				break;
			case 3:
				modificarEstudianteGrafico();
				break;
			case 4:
				borrarEstudianteGrafico();
				break;
			case 5:
				m.selectEstudiantes();
				v.mostrarAgendaGrafico(m.getAgenda());
				break;
			case 6:
				v.imprimirMensaje("Hasta pronto");
				//System.out.println("Hasta pronto");
				System.exit(0);
				break;
			}
		
		}
	}
	
	public static void agregarEstudiante() {
		String apellidos="",fecha="",nombres="",correo="",correop="", programa="";
		long celular=0,telefono=0;
		
		nombres=v.pedirString("Ingresar estudiante\nIngresar nombres:\n");
		apellidos=v.pedirString("Ingresar apellidos:\n");
		fecha=v.pedirString("Ingresar fecha de nacimiento (YYYY-MM-DD):\n");
		correo=v.pedirString("Ingresar correo institucional:\n");
		correop=v.pedirString("Ingresar correo personal:\n");
		celular=v.pedirLong("Ingresar número de celular:\n");
		telefono=v.pedirLong("Ingresar número fijo:\n");
		programa=v.pedirString("Ingresar programa:\n");
		
		
		m.insertEstudiante(nombres,apellidos,fecha,correo,correop,celular,telefono,programa);
	}
	
	public static void modificarEstudiante() {
		String correo= "";
		m.selectEstudiantes();	
		correo=existe(m.getAgenda());
		
		if(!correo.equals("12n0existe@")) {
			String correop = v.pedirString("Ingresar correo personal:\n");
			long celular = v.pedirLong("Ingresar número de celular:\r\n");
			long telefono = v.pedirLong("Ingresar número fijo:\n");
			String programa = v.pedirString("Ingresar programa:\n");

			m.updateEstudiante(correo,correop,celular,telefono,programa);
		}
		else {
			System.out.println("El estudiante no existe");
		}
	}
	public static void modificarEstudianteGrafico() {
		String correo= "";
		m.selectEstudiantes();	
		correo=existeGrafico(m.getAgenda());
		
		if(!correo.equals("12n0existe@")) {
			String correop = v.pedirStringGrafico("Ingresar correo personal:\n");
			long celular = v.pedirLongGrafico("Ingresar número de celular:\r\n");
			long telefono = v.pedirLongGrafico("Ingresar número fijo:\n");
			String programa = v.pedirStringGrafico("Ingresar programa:\n");

			m.updateEstudiante(correo,correop,celular,telefono,programa);
		}
		else {
			v.mostrarMensaje(correo);
		}
	}
	
	public static String existeGrafico(ArrayList<EstudianteDTO> agenda) {
		int i=0;
		String correo =v.pedirStringGrafico("\nModificar estudiante\nIngresar correo institucional:\n");

		for (EstudianteDTO registro : agenda) {	
			if(correo.equals(registro.getCorreo())) {
			i=1;	
			}
		}
		if(i==0) {
			
			correo="12n0existe@";
			}
		
		return correo;
		}
	
	public static String existe(ArrayList<EstudianteDTO> agenda) {
		int i=0;
		String correo =v.pedirString("\nModificar estudiante\nIngresar correo institucional:\n");

		for (EstudianteDTO registro : agenda) {	
			if(correo.equals(registro.getCorreo())) {
			i=1;	
			}
		}
		if(i==0) {
			
			correo="12n0existe@";
			}
		
		return correo;
		}
	
	public static void borrarEstudiante() {
		String correo= "";
		m.selectEstudiantes();	
		correo=existe(m.getAgenda());
		
		if(!correo.equals("12n0existe@")) {
			m.deleteEstudiante(correo);
		}
		else {
			v.mostrarMensaje("El estudiante no existe");
		}
	}
	public static void borrarEstudianteGrafico() {
		String correo= "";
		m.selectEstudiantes();	
		correo=existeGrafico(m.getAgenda());
		
		if(!correo.equals("12n0existe@")) {
			m.deleteEstudiante(correo);
		}
		else {
			v.imprimirMensaje("El estudiante no existe");
		}
	}	
		

}
