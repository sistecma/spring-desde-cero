package com.sistecma.springdesdecero.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrintService {  

	@Autowired
	@Qualifier("miPrinter2")
    private Printer printer;
	
	public String imprimeConPrinter() {
		return printer.print();
	}
}

