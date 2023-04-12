package com.mycomp;

import lombok.*;

@Data
@RequiredArgsConstructor
public class Ingrediente {

	private final String id;
	private final String nombre;
	private final Tipo tipo;

	public static enum Tipo {
		MASA, PROTEINA, VEGETALES, QUESO, SALSA
	}

}
