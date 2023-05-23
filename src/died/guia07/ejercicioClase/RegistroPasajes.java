package died.guia07.ejercicioClase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class RegistroPasajes {
	private List<Pasaje> pasajes = new ArrayList<Pasaje>();
	
	public void agregarPasaje(Pasaje p) {
		if(!pasajes.contains(p)) pasajes.add(p);
	}
	
	public void listarViajesOrdenadosPorMonto() {
		Collections.sort(pasajes, (p1,p2) -> p2.getMonto().compareTo(p1.getMonto()));
		System.out.println(pasajes);
	}
	
	public List<Pasaje> buscarPasajesPorOrigenODestino(String origen, String destino){
		return pasajes.stream()
					  .filter(p -> p.getCiudadOrigen().equals(origen) || p.getCiudadDestino().equals(destino))
					  .collect(Collectors.toList());
	}
	
	public Optional<Pasaje> buscarPasajePorCodigoYPasajero(String codigo, Pasajero pasajero){
		Pasaje resultado = null;
		for(Pasaje p : pasajes) {
			if(p.getCodigo().equals(codigo) && p.getPasajero().equals(pasajero)) return Optional.of(p);
		}
		return Optional.ofNullable(resultado);
	}
	
	public OptionalDouble costoPromedioPasajes(Pasajero pasajero) {
		return pasajes.stream()
					  .filter(p -> p.getPasajero().equals(pasajero))
					  .mapToDouble(p -> p.getMonto())
					  .average();
	}
	
	public List<Pasaje> getPasajes(){
		return pasajes;
	}
}