package com.sistecma.springdesdecero.iocdi;

public class Servidor implements Equipo{

	private String ip;
    private String hostname;
    
	@Override
	public String ping() {
		return getIp();
	}

	@Override
	public String hostname() {
		// TODO Auto-generated method stub
		return hostname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
}
