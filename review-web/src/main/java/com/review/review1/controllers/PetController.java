package com.review.review1.controllers;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.review.review1.exceptions.NotFoundException;
import com.review.review1.model.Owner;
import com.review.review1.model.Pet;
import com.review.review1.model.PetType;
import com.review.review1.services.OwnerService;
import com.review.review1.services.PetService;
import com.review.review1.services.PetTypeService;

import javax.validation.Valid;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/owners/{ownerId}")
class PetController {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	private final PetService petService;
	private final OwnerService ownerService;
	private final PetTypeService petTypeService; 

	public PetController(PetService petService, OwnerService ownerService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.ownerService = ownerService;
		this.petTypeService = petTypeService;
	}

	@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return petTypeService.findAll();
	}

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return ownerService.findById(ownerId).orElseThrow(NotFoundException::new);
	}

	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		dataBinder.setDisallowedFields("id");
		
		//dataBinder.registerCustomEditor(LocalDate.class, new CustomDateEditor(dateFormat, true));

//		dataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
//			@Override
//			public void setAsText(String text) throws IllegalArgumentException{
//				setValue(LocalDate.parse(text));
//			}
//			@Override
//			public String getAsText() throws IllegalArgumentException{
//				String toR = (String)((LocalDate) getValue()).format(DateTimeFormatter.ofPattern("yyy-mm-dd"));
//				return toR;
//			}
//
//		});

	}

	@GetMapping("/pets/new")
	public String initCreationForm(Owner owner, Model model) {
		Pet pet = new Pet();
		owner.getPetSet().add(pet);
		pet.setOwner(owner);
		model.addAttribute("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/pets/new")
	public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, Model model) {
		if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null){
			result.rejectValue("name", "duplicate", "already exists");
		}
		owner.getPetSet().add(pet);
		if (result.hasErrors()) {
			model.addAttribute("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		} else {
			petService.save(pet);
			return "redirect:/owners/{ownerId}";
		}
	}


	@GetMapping("/pets/{petId}/edit")
	public String initUpdateForm(@PathVariable("petId") Long petId, Model model) {
		Pet pet = petService.findById(petId).orElseThrow(NotFoundException::new);
		model.addAttribute("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/pets/{petId}/edit")
	public String processUpdateForm(@Valid Pet pet, BindingResult result, Owner owner, Model model) {
		if (result.hasErrors()) {
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		} else {
			Pet savedPet = petService.findById(pet.getId()).orElseThrow(NotFoundException::new);
			savedPet.setName(pet.getName());
			savedPet.setBirhtDate(pet.getBirhtDate());
			//savedPet.setOwner(owner);
			savedPet.setPetType(pet.getPetType());
			petService.save(savedPet);
			return "redirect:/owners/{ownerId}";
		}
	}



}
