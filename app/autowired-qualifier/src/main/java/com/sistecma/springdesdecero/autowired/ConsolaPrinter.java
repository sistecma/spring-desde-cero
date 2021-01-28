package com.sistecma.springdesdecero.autowired;
import org.springframework.stereotype.Component;

@Component("miPrinter")
public class ConsolaPrinter implements Printer{
    public String print() {
        return "se-imprime-en-consola-1";
    }
}
