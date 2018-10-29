package com.springframework.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.model.Owner;
import com.springframework.model.Pet;
import com.springframework.model.PetType;
import com.springframework.model.Vet;
import com.springframework.services.OwnerService;
import com.springframework.services.PetTypeService;
import com.springframework.services.VetService;

@Component
public class DataInitializer implements CommandLineRunner{

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		PetType dog = new PetType();
		dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);
        
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);	
        System.out.println("Pet Types Initialized");
        
		Owner owner1 = new Owner();
		owner1.setFirstName("Dan");
		owner1.setLastName("Brown");
		owner1.setAddress("221 Baker Street");
		owner1.setCity("London");
		owner1.setTelephone("2218979");
		
		Pet DansPet = new Pet();
		DansPet.setPetType(savedDogPetType);
		DansPet.setOwner(owner1);
		DansPet.setBirthDate(LocalDate.now());
		DansPet.setName("Tiger");
        owner1.getPets().add(DansPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Jonathan");
		owner2.setLastName("Nolan");
		owner2.setAddress("333 Elm Street");
		owner2.setCity("New York");
		owner2.setTelephone("33446677");
		
		Pet JonathansPet = new Pet();
		JonathansPet.setPetType(savedCatPetType);
		JonathansPet.setOwner(owner2);
		JonathansPet.setBirthDate(LocalDate.now());
		JonathansPet.setName("Katzz");
		owner2.getPets().add(JonathansPet);
		
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
