package com.panda;

import org.springframework.beans.factory.annotation.Autowired;

import com.panda.repository.Belly;
import com.panda.repository.NoteRepository;

import cucumber.api.java.en.Given;

public class Stepdefs {
	
	@Autowired
	NoteRepository noteRepository;
	
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
}
