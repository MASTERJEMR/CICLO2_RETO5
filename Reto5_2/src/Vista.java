import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
public class Vista {
	String mensaje="";
	Scanner entrada = new Scanner(System.in);

	public int menuGrafico() {
		this.mensaje="INSTITUTO LA FLORESTA\n"
				+ "Seleccione tarea a realizar:\r\n"
				+ "1. Ingresar estudiante\r\n"
				+ "2. Buscar estudiante\r\n"
				+ "3. Modificar estudiante\r\n"
				+ "4. Eliminar Estudiante\r\n"
				+ "5. Ver directorio de estudiantes\r\n"
				+ "6. Salir\n"
				+ "Opción:\n";
		int option=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return option;
	}
	public void imprimirMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public int imprimirMenu() {

		System.out.println("INSTITUTO LA FLORESTA\r\n"
				+ "Seleccione tarea a realizar:\r\n"
				+ "1. Ingresar estudiante\r\n"
				+ "2. Buscar estudiante\r\n"
				+ "3. Modificar estudiante\r\n"
				+ "4. Eliminar Estudiante\r\n"
				+ "5. Ver directorio de estudiantes\r\n"
				+ "6. Salir\r\n"
				+ "Opción:\n");
		String op=entrada.nextLine();
		int opcion = Integer.parseInt(op);
		return opcion;

	}
	public void mostrarAgenda(ArrayList<EstudianteDTO> agenda) {
		
		System.out.println("mostrar agenda");
		for (EstudianteDTO registro : agenda) {
			
			System.out.println("Nombres: "+registro.getNombres());
			System.out.println("Apellidos: "+registro.getApellidos());
			System.out.println("Fecha nacimiento: "+registro.getFecha());
			System.out.println("Correo institucional: "+registro.getCorreo());
			System.out.println("Correo personal: "+registro.getCorreop());
			System.out.println("Número de teléfono celular: "+registro.getCelular());
			System.out.println("Número de teléfono fijo: "+registro.getTelefono());
			System.out.println("Programa académico: "+registro.getPrograma());	
			
		}
	}
public void mostrarAgendaGrafico(ArrayList<EstudianteDTO> agenda) {
		this.mensaje="";
		for (EstudianteDTO registro : agenda) {
			this.mensaje=this.mensaje+"\n"+"Nombres: "+registro.getNombres()
						+"\n"+"Apellidos: "+registro.getApellidos()
						+"\n"+"Fecha nacimiento: "+registro.getFecha()
						+"\n"+"Correo institucional: "+registro.getCorreo()
						+"\n"+"Correo personal: "+registro.getCorreop()
						+"\n"+"Número de teléfono celular: "+registro.getCelular()
						+"\n"+"Número de teléfono fijo: "+registro.getTelefono()
						+"\n"+"Programa académico: "+registro.getPrograma();
					}
		this.mensaje="mostrar agenda"+this.mensaje;
		JOptionPane.showMessageDialog(null, mensaje);
	}
	public void buscarEstudiantexID(ArrayList<EstudianteDTO> agenda) {
		
		String correo=pedirString("\nBuscar estudiante\nIngresar correo institucional:\n");
		for (EstudianteDTO registro : agenda) {	
			if(correo.equals(registro.getCorreo())) {
			
			System.out.println("Nombres: "+registro.getNombres());
			System.out.println("Apellidos: "+registro.getApellidos());
			System.out.println("Fecha nacimiento: "+registro.getFecha());
			System.out.println("Correo institucional: "+registro.getCorreo());
			System.out.println("Correo personal: "+registro.getCorreop());
			System.out.println("Número de teléfono celular: "+registro.getCelular());
			System.out.println("Número de teléfono fijo: "+registro.getTelefono());
			System.out.println("Programa académico: "+registro.getPrograma());	
			}
		}
	}
public void buscarEstudiantexIDGrafico(ArrayList<EstudianteDTO> agenda) {
		
		String correo=pedirStringGrafico("\nBuscar estudiante\nIngresar correo institucional:\n");
		for (EstudianteDTO registro : agenda) {	
			if(correo.equals(registro.getCorreo())) {
			this.mensaje="Nombres: "+registro.getNombres()
						+"\n"+"Apellidos: "+registro.getApellidos()
						+"\n"+"Fecha nacimiento: "+registro.getFecha()
						+"\n"+"Correo institucional: "+registro.getCorreo()
						+"\n"+"Correo personal: "+registro.getCorreop()
						+"\n"+"Número de teléfono celular: "+registro.getCelular()
						+"\n"+"Número de teléfono fijo: "+registro.getTelefono()
						+"\n"+"Programa académico: "+registro.getPrograma();	
			imprimirMensaje(mensaje);
			}
		}
	}

	public String pedirString(String mensaje) {
		String texto = "";
		System.out.print(mensaje);
		texto = entrada.nextLine();
		return texto;
	}
	public String pedirStringGrafico(String mensaje) {
		String texto = "";
		texto=JOptionPane.showInputDialog(mensaje);
		return texto;
	}
	public int pedirIntGrafico(String mensaje) {
		int texto = 0;
		texto=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return texto;
	}
	public long pedirLongGrafico(String mensaje) {
		long texto = 0;
		texto=Long.parseLong(JOptionPane.showInputDialog(mensaje));
		return texto;
	}
	

	public int pedirInt(String mensaje) {
		int numero = 0;
		System.out.print(mensaje);
		numero = entrada.nextInt();
		entrada.nextLine();
		return numero;
	}
	public long pedirLong(String mensaje) {
		long numero = 0;
		System.out.print(mensaje);
		numero = entrada.nextLong();
		entrada.nextLine();
		return numero;
	}

	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
	
}
