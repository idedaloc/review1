package com.review.review1.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Controller;

import com.review.review1.model.PetType;
import com.review.review1.services.PetTypeService;

@Controller
public class PetTypeFormatter implements Formatter<PetType>{
	
	private PetTypeService petTypeService;
	

	public PetTypeFormatter(com.review.review1.services.PetTypeService petTypeService) {
		super();
		this.petTypeService = petTypeService;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Collection<PetType> findPetTypes = petTypeService.findAll();
		for (PetType type : findPetTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}

}
