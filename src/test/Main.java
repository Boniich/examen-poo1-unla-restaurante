package test;

import java.time.LocalDate;

import modelo.SistemaRestaurante;

//Parcial 2023
//Realizado 19-9-2025
//Tiempo utilizado: 1:30
//Dificultades: metodo validar comensales
//Nota estimada: 9-10

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SistemaRestaurante sistema = new SistemaRestaurante();
		
		try {
			System.out.println("Test 1");
			sistema.agregarCliente("Rodrigo", "Sanchez", 32694053, "+541179456274");
			sistema.agregarCliente("Adriana", "Diez", 31953256, "+541109462742");
			sistema.agregarCliente("Marcos", "Garcia", 34096528, "+541188345186");
			System.out.println(sistema.getListaCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 2");
			sistema.agregarMesa(1,2);
			sistema.agregarMesa(2,2);
			sistema.agregarMesa(3,4);
			sistema.agregarMesa(4,6);
			sistema.agregarMesa(5,4);
			sistema.agregarMesa(6,2);
			System.out.println(sistema.getListaMesas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 3");
			sistema.agregarReserva(
					sistema.traerCliente(32694053), 
					LocalDate.of(2023, 8, 15),
					sistema.traerMesa(1), 
					2);
			
			sistema.agregarReserva(
					sistema.traerCliente(31953256), 
					LocalDate.of(2023, 8, 15),
					sistema.traerMesa(4), 
					4);
			
			sistema.agregarReserva(
					sistema.traerCliente(34096528), 
					LocalDate.of(2023, 8, 25),
					sistema.traerMesa(5), 
					4);
			
			System.out.println(sistema.getListaReservas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("Test 4");
		System.out.println("Todas las reservas entre las fechas 2023-08-15 y 2023-08-20");
		System.out.println(sistema.traerReservasPorFechas(LocalDate.of(2023, 8, 15), 
				LocalDate.of(2023, 8, 20)));
		
		System.out.println("Test 5");
		System.out.println("Todas las mesas libres para la fecha 2023-08-15");
		System.out.println(sistema.traerMesaLibresPorFecha(LocalDate.of(2023, 8, 15)));
		
		try {
			System.out.println("Test 6");
			sistema.agregarCliente("Adriana", "Diez", 31953256, "+541109462742");
			System.out.println(sistema.getListaCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 7");
			sistema.agregarMesa(3,4);
			System.out.println(sistema.getListaMesas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 8");
			sistema.agregarReserva(
					sistema.traerCliente(32694053), 
					LocalDate.of(2023, 8, 25),
					sistema.traerMesa(5), 
					4);
			System.out.println(sistema.getListaReservas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Test 9");
			sistema.agregarReserva(
					sistema.traerCliente(31953256), 
					LocalDate.of(2023, 8, 17),
					sistema.traerMesa(6), 
					4);
			System.out.println(sistema.getListaReservas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
