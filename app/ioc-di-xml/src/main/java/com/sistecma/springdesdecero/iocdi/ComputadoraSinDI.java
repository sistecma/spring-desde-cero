package com.sistecma.springdesdecero.iocdi;

//Dependencias de objetos al modo tradicional

/* 
La clase Computadora sostiene el contrato o interface Monitor
Al instanciar Monitor via el constructor de Computadora instancia
la implementación de Monitor via MonitorImpl
*/

public class ComputadoraSinDI implements Equipo{
 private String ip;
 private String hostname;
 
 private Monitor monitor; // contrato

 public ComputadoraSinDI() {
     monitor = new MonitorImpl();  // implementación de Monitor  
 }

 public void boot() {
 	System.out.println("equipo " + hostname + " esta " + monitor.mostrar("booteando..."));
 }
 
 public void shutdown() {
 	System.out.println("apagando equipo " + hostname);
 }
	
	@Override
	public String ping() {
		return ip;
	}

	@Override
	public String hostname() {
		
		return hostname;
	}
}