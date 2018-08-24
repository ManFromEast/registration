package com.panda.repository.health;

import java.util.List;

import com.panda.entity.health.Doctor;

public interface DoctorDAO {

    List<Doctor> findByLocationAndSpeciality(String location, String speciality);
}
