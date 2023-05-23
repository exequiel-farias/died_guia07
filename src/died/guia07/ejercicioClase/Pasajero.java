package died.guia07.ejercicioClase;

import java.util.Objects;

public class Pasajero {
	private String nombre;
	private String apellido;
	private String email;
	private String nroPasaporte;
	
	public Pasajero(String nombre, String apellido, String email, String nroPasaporte) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.nroPasaporte = nroPasaporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nroPasaporte);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		return Objects.equals(email, other.email) && Objects.equals(nroPasaporte, other.nroPasaporte);
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
}