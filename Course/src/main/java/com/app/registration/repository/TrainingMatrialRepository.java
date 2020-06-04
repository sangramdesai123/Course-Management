package com.app.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.TrainingMaterial;

public interface TrainingMatrialRepository extends JpaRepository<TrainingMaterial, String> {

	List<TrainingMaterial> findByCourse(String tempcourse);

}
