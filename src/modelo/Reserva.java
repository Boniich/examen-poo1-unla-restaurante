package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {
	private int idReserva;
	private Cliente cliente;
	private LocalDate fechaReserva;
	private Mesa mesa;
	private int cantComensales;
	
	public Reserva(int idReserva, Cliente cliente, LocalDate fechaReserva, Mesa mesa, int cantComensales) throws Exception {
		this.idReserva = idReserva;
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.mesa = mesa;
		this.setCantComensales(cantComensales);
	}
	
	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getCantComensales() {
		return cantComensales;
	}

	public void setCantComensales(int cantComensales) throws Exception {
		if(validarComensales(cantComensales)) this.cantComensales = cantComensales;
	}
	
	public boolean validarComensales(int cantComensales) throws Exception{
		if(cantComensales > mesa.getCapacidad()) throw new Exception("Error: La cantidad "
				+ "de comensales supera la capacidad");
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return cantComensales == other.cantComensales && Objects.equals(cliente, other.cliente)
				&& Objects.equals(fechaReserva, other.fechaReserva) && idReserva == other.idReserva
				&& Objects.equals(mesa, other.mesa);
	}

	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva + ", mesa="
				+ mesa + ", cantComensales=" + cantComensales + "]\n";
	}
	
	
}
