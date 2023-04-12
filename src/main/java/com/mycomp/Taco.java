package com.mycomp;

import java.util.List;

import lombok.Data;

@Data
public class Taco {
	
	private String nombre;
	private List<String> ingredientes;

}
