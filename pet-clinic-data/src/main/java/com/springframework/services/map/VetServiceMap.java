package com.springframework.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.model.Speciality;
import com.springframework.model.Vet;
import com.springframework.services.SpecialitiesService;
import com.springframework.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService{

	private final SpecialitiesService specilitiesService;
	
	
	public VetServiceMap(SpecialitiesService specilitiesService) {
	this.specilitiesService = specilitiesService;
}
	
@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if(object.getSpecialities().size() >0) {
			object.getSpecialities().forEach(speciality ->{
				if(speciality.getId() == null) {
					Speciality savedSpeciality = specilitiesService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
}
