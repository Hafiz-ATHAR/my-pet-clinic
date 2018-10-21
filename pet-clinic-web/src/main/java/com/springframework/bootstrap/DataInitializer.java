package com.springframework.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.model.Owner;
import com.springframework.model.Vet;
import com.springframework.services.OwnerService;
import com.springframework.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	
	public DataInitializer(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Dan");
		owner1.setLastName("Brown");
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Jonathan");
		owner2.setLastName("Nolan");
		
		ownerService.save(owner2);
		
		System.out.println("Owners Initialized");

		Vet vet1 = new Vet();
		vet1.setFirstName("Anthony");
		vet1.setLastName("Hopkins");
		
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("Johnny");
		vet2.setLastName("Cash");
		
		vetService.save(vet2);
		
		System.out.println("Vets Initialized");
	}
}
