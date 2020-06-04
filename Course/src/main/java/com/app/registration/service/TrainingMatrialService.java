package com.app.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.TrainingMaterial;
import com.app.registration.repository.TrainingMatrialRepository;

@Service
public class TrainingMatrialService {
	@Autowired
	private TrainingMatrialRepository trepo;
	
	public TrainingMaterial saveTrainingMaterial(TrainingMaterial matrial) {
		//this will save course to database
		return trepo.save(matrial);
	}
	
	public List<TrainingMaterial> findAllTrainingMaterial(){
		return trepo.findAll();
	}
	
//	public Optional<TrainingMaterial> findTrainingMaterial(String course) {
//        return trepo.findById(course);
//    }
	
	public void deleteTrainingMaterial(String course) {
        trepo.deleteById(course);
    }

	public List<TrainingMaterial> fetchMatrialByCourse(String tempcourse) {
		// TODO Auto-generated method stub
		return trepo.findByCourse(tempcourse);
	}
	
}
