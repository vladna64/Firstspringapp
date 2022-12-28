package com.example.person;
import com.example.person.PersonDAO;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class PersonController {
    private final PersonDAO personDAO;
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/")
    public List<PersonForm> showAllPerson() {
        return personDAO.index();
    }

    @GetMapping("/one")
    public PersonForm showOnePerson(@RequestParam(name = "id") int id,PersonForm personForm) {
        return personDAO.show(id);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestParam(name = "id") int id, @Valid @RequestBody PersonForm personForm)  {

        personDAO.update(id, personForm);
        return ResponseEntity.ok("valid");
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") int id) {
        personDAO.delete(id);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> AddPerson(@Valid @RequestBody PersonForm personForm) {

        personDAO.save(personForm);
        return ResponseEntity.ok("valid");
    }
}