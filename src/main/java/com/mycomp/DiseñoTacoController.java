package com.mycomp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycomp.Ingrediente.Tipo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/diseño")
public class DiseñoTacoController {

	@GetMapping
	public String showDiseñoForm(Model model) {

		List<Ingrediente> ingredientes = Arrays.asList(
				new Ingrediente("TOHA", "Tortilla de Harina", Tipo.MASA),
				new Ingrediente("TOMA", "Tortilla de Maíz", Tipo.MASA),
				new Ingrediente("CAPI", "Carne Picada", Tipo.PROTEINA),
				new Ingrediente("CARN", "Carnitas", Tipo.PROTEINA),
				new Ingrediente("TODA", "Tomates en Dados", Tipo.VEGETALES),
				new Ingrediente("LCHU", "Lechuga", Tipo.VEGETALES), 
				new Ingrediente("CHED", "Cheddar", Tipo.QUESO),
				new Ingrediente("JACK", "Monterrey Jack", Tipo.QUESO), 
				new Ingrediente("SLSA", "Salsa", Tipo.SALSA),
				new Ingrediente("CRAG", "Crema Agria", Tipo.SALSA));
		
		Tipo[] tipos = Ingrediente.Tipo.values();

		for (Tipo tipo : tipos) {
			
			model.addAttribute(tipo.toString().toLowerCase(), filterByType(ingredientes, tipo));
		}
		
		model.addAttribute("atrDesign", new Taco());
		
		return "diseño-taco";

	}

	 private List<Ingrediente> filterByType(List<Ingrediente> ingredientes, Tipo tipo) {
		    return ingredientes
		              .stream()
		              .filter(x -> x.getTipo().equals(tipo))
		              .collect(Collectors.toList());
		  }

}
