package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaRestaurante {
	private List<Cliente> listaCliente;
	private List<Mesa> listaMesas;
	private List<Reserva> listaReservas;
	
	public SistemaRestaurante() {
		this.listaCliente = new ArrayList<Cliente>();
		this.listaMesas = new ArrayList<Mesa>();
		this.listaReservas = new ArrayList<Reserva>();
	}
	
	//Caso de uso 1: traer cliente(dni)
	public Cliente traerCliente(long dni) {
		Cliente clienteBuscado = null;
		int index = 0;
		boolean encontrado = false;
		
		while(index < listaCliente.size()&& !encontrado){
			if(listaCliente.get(index).getDni() == dni) {
				clienteBuscado = listaCliente.get(index);
				encontrado = true;
			}
			index++;
		}
		
		return clienteBuscado;
	}
	
	//Caso de uso 2: agregarCliente
	public boolean agregarCliente(String nombre, String apellido, long dni,
			String telefono) throws Exception {
		if(traerCliente(dni) != null) throw new Exception("Error: El cliente ya existe!");
		
		int ultimoId = 1;
		if(!listaCliente.isEmpty()) ultimoId = listaCliente.get(listaCliente.size()-1).
				getIdCliente()+1;
		return listaCliente.add(new Cliente(ultimoId,nombre,apellido,dni,telefono));
	}
	
	public Mesa traerMesa(int numeroMesa) {
		Mesa mesaBuscada = null;
		int index = 0;
		boolean encontrado = false;
		
		while(index < listaMesas.size()&& !encontrado){
			if(listaMesas.get(index).getNumeroMesa() == numeroMesa) {
				mesaBuscada = listaMesas.get(index);
				encontrado = true;
			}
			index++;
		}
		
		return mesaBuscada;
	}
	
	public boolean agregarMesa(int numeroMesa, int capacidad) throws Exception {
		if(traerMesa(numeroMesa) != null) throw new Exception("Error: La mesa ya existe!");
		
		int ultimoId = 1;
		if(!listaMesas.isEmpty()) ultimoId = listaMesas.get(listaMesas.size()-1).
				getIdMesa()+1;
		return listaMesas.add(new Mesa(ultimoId,numeroMesa,capacidad));
	}
	
	public Reserva traerReserva(int numeroMesa, LocalDate fechaReserva) {
		Reserva reservaBuscada = null;
		int index = 0;
		boolean encontrado = false;
		
		while(index < listaReservas.size()&& !encontrado){
			
			if(listaReservas.get(index).getMesa().getNumeroMesa() == numeroMesa && 
					listaReservas.get(index).getFechaReserva().equals(fechaReserva)) {
				reservaBuscada = listaReservas.get(index);
				encontrado = true;
			}
			
			index++;
		}
		
		return reservaBuscada;
	}
	public boolean agregarReserva(Cliente cliente, LocalDate fechaReserva
			, Mesa mesa, int cantComensales) throws Exception {
		
		if(traerReserva(mesa.getNumeroMesa(),fechaReserva) != null) 
			throw new Exception("Error: Ya existe una reserva para esa mesa ese dia!");
		
		int ultimoId = 1;
		if(!listaReservas.isEmpty()) ultimoId = listaReservas.get(listaReservas.size()-1).
				getIdReserva()+1;
		return listaReservas.add(new Reserva(ultimoId,cliente,fechaReserva,mesa,cantComensales));
	}
	
	public List<Reserva> traerReservasPorFechas(LocalDate fechaDesde, LocalDate fechaHasta){
		List<Reserva> reservasEntreFechas = new ArrayList<Reserva>();
		for(Reserva r : listaReservas) {
			if(r.getFechaReserva().equals(fechaDesde) || r.getFechaReserva().equals(fechaHasta) ||
			  (r.getFechaReserva().isAfter(fechaDesde) && r.getFechaReserva().isBefore(fechaHasta))){
				reservasEntreFechas.add(r);
			}
		}
		
		return reservasEntreFechas;
		
	}
	
	//Debo traer las mesas libres de una determinada fecha
	//Lo que tiene las fechas y la mesas ocupadas es listaReserva
	//Todas las mesas estan en la listamesas
	
	public List<Mesa> traerMesaLibresPorFecha(LocalDate fecha){
		List<Mesa> mesasLibres = new ArrayList<Mesa>();
		
		for(Mesa m : listaMesas) {
			if(traerReserva(m.getNumeroMesa(), fecha) == null) {
				mesasLibres.add(m);
			}
		}
		return mesasLibres;
	}
	
	

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public List<Mesa> getListaMesas() {
		return listaMesas;
	}

	public void setListaMesas(List<Mesa> listaMesas) {
		this.listaMesas = listaMesas;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}
	
	
}
