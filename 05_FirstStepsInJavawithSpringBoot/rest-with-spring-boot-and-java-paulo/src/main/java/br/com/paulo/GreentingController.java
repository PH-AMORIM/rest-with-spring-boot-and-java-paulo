package br.com.paulo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica que essa class é um controlador de requisições HTTP e que o resultado das requisições serão escritas no body do HTTP
public class GreentingController {
	
	private static final String template = "Hello, %s!"; //static esse campo não vai depender das instacias, mas sim da propria class
	//%s, formato de string
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting") //anotação que mapea as request dos metodos, ("/greeting") é o nome do caminho 
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {// vai retorna algo do tipo Greeting q é uma class
		//@RequestParam -> serve para extarir nesse caso o value, o valor dele 
		return new Greeting(counter.getAndIncrement(), String.format(template, name));//getAndIncrement()-> gera sempre um valor maior 
		
	}
	
}
