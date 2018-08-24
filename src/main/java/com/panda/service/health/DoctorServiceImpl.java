package com.panda.service.health;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.panda.entity.health.Doctor;
import com.panda.repository.health.DoctorDAO;

public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public List<Doctor> findByLocationAndSpeciality(String location, String speciality) {
        return doctorDAO.findByLocationAndSpeciality(location, speciality);
    }
}
