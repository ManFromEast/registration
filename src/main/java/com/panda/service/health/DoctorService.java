package com.panda.service.health;

import java.util.List;

import com.panda.entity.health.Doctor;

public interface DoctorService {

    public List<Doctor> findByLocationAndSpeciality(String location, String speciality);
}
