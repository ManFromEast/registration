package com.panda.controller.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.panda.entity.health.DoctorList;
import com.panda.service.health.DoctorService;

@RestController
public class DoctorSearchController {

    @Autowired
    DoctorService docService;

    @RequestMapping(value = "/doctors", method = RequestMethod.GET, produces = "application/json")
    public DoctorList searchDoctor(
            @RequestParam(value = "location", required = false) String location,
            @RequestParam(value = "speciality", required = false) String speciality) {
        DoctorList docList = (DoctorList) docService.findByLocationAndSpeciality(location, speciality);
        return docList;
    }
}
