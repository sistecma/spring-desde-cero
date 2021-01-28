package com.sistecma.springdesdecero.autowired;

import org.springframework.stereotype.Component;

@Component("miPrinter2")
public class ConsolaPrinter2 implements Printer {

	@Override
	public String print() {
		return "se-imprime-en-consola-2";
	}

}
