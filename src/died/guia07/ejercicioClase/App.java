package died.guia07.ejercicioClase;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class App {

	public static void main(String[] args) {
		RegistroPasajes registro = new RegistroPasajes();

		Pasajero p1 = new Pasajero("Farias","Exequiel","efarias@outlook.com","A999");
		Pasajero p2 = new Pasajero("Farias","Exequiel","efarias@outlook.com","A999");
		Pasajero p3 = new Pasajero("Fernandez","Martin","mfernandez@outlook.com","B999");
		
		Pasaje pj1 = new Pasaje();
		Pasaje pj2 = new Pasaje();
		Pasaje pj3 = new Pasaje();
		Pasaje pj4 = new Pasaje();
		Pasaje pj5 = new Pasaje();
		Pasaje pj6 = new Pasaje();
		Pasaje pj7 = new Pasaje();
		
		pj1.setCodigo("AAA1");
		pj1.setCiudadOrigen("Barcelona");
		pj1.setCiudadDestino("Madrid");
		pj1.setMonto(150.0);
		pj1.setPasajero(p1);
		pj2.setCodigo("AAA1");
		pj2.setCiudadOrigen("Barcelona");
		pj2.setCiudadDestino("Madrid");
		pj2.setMonto(150.0);
		pj2.setPasajero(p3);
		pj3.setCodigo("AAA2");
		pj3.setCiudadOrigen("Paris");
		pj3.setCiudadDestino("Londres");
		pj3.setMonto(300.7);
		pj3.setPasajero(p1);
		pj4.setCodigo("ABC2");
		pj4.setMonto(125.3);
		pj4.setCiudadOrigen("Chicago");
		pj4.setCiudadDestino("Londres");
		pj4.setPasajero(p1);
		pj1.setFechaHoraPartida(Instant.now());
		pj1.setFechaHoraArribo(pj1.getFechaHoraPartida().plus(3, ChronoUnit.HOURS));
		pj5.setCodigo("ABC1");
		pj5.setMonto(100.8);
		pj5.setCiudadOrigen("New York");
		pj5.setCiudadDestino("Barcelona");
		pj5.setPasajero(p3);
		pj6.setCodigo("ABC3");
		pj6.setMonto(97.3);
		pj6.setCiudadOrigen("Barcelona");
		pj6.setCiudadDestino("Londres");
		pj6.setPasajero(p3);
		pj7.setCodigo("ABC4");
		pj7.setMonto(89.1);
		pj7.setCiudadOrigen("Chicago");
		pj7.setCiudadDestino("Madrid");
		pj7.setPasajero(p3);
		
		registro.agregarPasaje(pj1);
		registro.agregarPasaje(pj2);
		registro.agregarPasaje(pj3);
		registro.agregarPasaje(pj4);
		registro.agregarPasaje(pj5);
		registro.agregarPasaje(pj6);
		registro.agregarPasaje(pj7);
		
		System.out.println("Pasajero p1 y p2 son iguales?: "+p1.equals(p2));
		System.out.println("Pasajero p1 y p3 son iguales?: "+p1.equals(p3));
		System.out.println("Pasaje pj1 y pj2 son iguales?: "+pj1.equals(pj2));
		System.out.println("Pasaje pj1 y pj3 son iguales?: "+pj1.equals(pj3));
		System.out.println("La duracion estimado del viaje pj1 es "+pj1.duracion()+" horas");
		System.out.println("El registro esta ordenado de la siguiente manera: ");
		for(Pasaje p : registro.getPasajes()) {
			System.out.println(p);
		}
		System.out.println("El registro si se lo ordena por monto queda de la siguiente manera: ");
		registro.listarViajesOrdenadosPorMonto();
		
		List<Pasaje> listaPasajes = new ArrayList<Pasaje>();
		listaPasajes = registro.buscarPasajesPorOrigenODestino("Barcelona", "Madrid");
		System.out.println("Los pasajes que tienen como ciudad origen Barcelona o ciudad destino Madrid son:");
		for(Pasaje p : listaPasajes) {
			System.out.println(p);
		}

		Optional<Pasaje> p11 = registro.buscarPasajePorCodigoYPasajero("AAA1", p1);
		if(p11.isPresent()) {
			System.out.println("Existe un pasaje que corresponda con el codigo AAA1 y el pasajero "+
					p1.getApellido()+" "+p1.getNombre());
		}else System.out.println("No existe un pasaje que corresponda con el codigo AAA1 y el pasajero "+
					p1.getApellido()+" "+p1.getNombre());

		OptionalDouble promedio = registro.costoPromedioPasajes(p1);
		if(promedio.isPresent()) {
			System.out.println("El promedio de los costos de los pasajes asignados a Farias Exequiel es: "+promedio.getAsDouble());
		}
	}

}