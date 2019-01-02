package com.review.review1.controllers;

import com.review.review1.model.Vet;
import com.review.review1.services.VetService;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping({"vets","/vets","vets/index","vets/index.html","vets.html"})
    public String listVets(Model model) {
        model.addAttribute("vets",vetService.findAll());
        return "vets/index";
    }
    
    @GetMapping("/api/vets")
    public @ResponseBody Set<Vet> getVetsJson() {
    	
    	return vetService.findAll();
    	
    }
}
