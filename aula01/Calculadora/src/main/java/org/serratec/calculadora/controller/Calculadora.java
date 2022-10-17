package org.serratec.calculadora.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class Calculadora {
	@RequestMapping("/soma")
	public Double soma (@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 + n2);
	}
	
	@RequestMapping("/sub/{n1}/{n2}")
	public Double subtracao (@PathVariable Double n1, @PathVariable Double n2) {
		return (n1 - n2);
	}
	
	@RequestMapping("/div")
	public Double divisao (@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 / n2);
	}
	
	@RequestMapping("/mult")
	public Double mutiplicacao (@RequestParam Double n1, @RequestParam Double n2) {
		return (n1 * n2);
	}
}
