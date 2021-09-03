import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class EstudianteD {
	private ArrayList<EstudianteDTO> agenda;
	private String nombreArchivo="infoestudiantes.csv";

	@SuppressWarnings("unchecked")
	public int leerArchivo() {
		try {
			ObjectInputStream in =new ObjectInputStream(new FileInputStream(nombreArchivo));
			agenda = (ArrayList<EstudianteDTO>) in.readObject();
			in.close();
		}  catch (IOException | ClassNotFoundException e) {
						return -1;
		}
		return 0;
	}
	
	public void AgregarDirectorio(ArrayList<EstudianteDTO> agenda) {
		
		for(EstudianteDTO regDirectorio: agenda) {
			System.out.println("Nombres: "+regDirectorio.getNombres());
			System.out.println("Apellidos: "+regDirectorio.getApellidos());
			System.out.println("Fecha nacimiento: "+regDirectorio.getFecha());
			System.out.println("Correo institucional: "+regDirectorio.getCorreo());
			System.out.println("Correo personal: "+regDirectorio.getCorreop());
			System.out.println("Número de teléfono celular: "+regDirectorio.getCelular());
			System.out.println("Número de teléfono fijo: "+regDirectorio.getTelefono());
			System.out.println("Programa académico: "+regDirectorio.getPrograma());	
		}
	}

}
