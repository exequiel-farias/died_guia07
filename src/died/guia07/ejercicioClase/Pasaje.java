package died.guia07.ejercicioClase;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Pasaje implements Comparable<Pasaje> {
	private String codigo;
	private int numVuelo;
	private String ciudadOrigen;
	private String ciudadDestino;
	private Instant fechaHoraPartida;
	private Instant fechaHoraArribo;
	private Instant fechaCancelacion;
	private int asiento;
	private Pasajero pasajero;
	private TipoServicio tipoServicio;
	private double monto;
	private String aerolinea;
	
	@Override
	public int hashCode() {
		return Objects.hash(ciudadDestino, ciudadOrigen, codigo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasaje other = (Pasaje) obj;
		return Objects.equals(ciudadDestino, other.ciudadDestino) && Objects.equals(ciudadOrigen, other.ciudadOrigen)
				&& Objects.equals(codigo, other.codigo);
	}
	
	public long duracion() {
		return ChronoUnit.MINUTES.between(fechaHoraPartida, fechaHoraArribo);
	}

	@Override
	public int compareTo(Pasaje o) {
		return fechaHoraPartida.compareTo(o.fechaHoraPartida);
	}

	@Override
	public String toString() {
		return "Pasaje [codigo=" + codigo + ", ciudadOrigen=" + ciudadOrigen + ", ciudadDestino=" + ciudadDestino
				+ ", monto=" + monto + "]";
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}
	
	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public String getCiudadDestino() {
		return ciudadDestino;
	}
	
	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}
	
	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Instant getFechaHoraPartida() {
		return fechaHoraPartida;
	}

	public void setFechaHoraPartida(Instant fechaHoraPartida) {
		this.fechaHoraPartida = fechaHoraPartida;
	}

	public Instant getFechaHoraArribo() {
		return fechaHoraArribo;
	}

	public void setFechaHoraArribo(Instant fechaHoraArribo) {
		this.fechaHoraArribo = fechaHoraArribo;
	}
}