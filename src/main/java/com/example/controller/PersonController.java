package com.example.controller;
import com.example.ValidatingforminputApplication;
import com.example.dao.PersonDAO;
import com.example.dto.PersonDTO;
import com.example.model.PersonForm;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {
    private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);
    private final PersonDAO personDAO;
    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> PersonNullException() {
        log.error("Пользователь ввел несуществующий ID");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Нет такого человека в бд");
    }
    @GetMapping("/")
    public List<PersonDTO> showAllPerson() {
        return personDAO.showAllPerson();
    }

    @GetMapping("/one")
    public ResponseEntity showOnePerson(@RequestParam(name = "id") long id) {
        PersonForm personForm= personDAO.showOnePersonById(id);
        if (personDAO.showOnePersonById(id)== null) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.status(HttpStatus.OK).body(personForm);
    }
    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestParam(name = "id") int id, @Valid @RequestBody PersonDTO personDTO)  {
        if (personDAO.showOnePersonById(id)== null) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        personDAO.updatePersonById(id, personDTO);
        return ResponseEntity.ok("valid");
    }

    @DeleteMapping("/delete")
    public void deletePerson(@RequestParam(name = "id") int id) {
        if (personDAO.showOnePersonById(id) == null) {
            ResponseEntity.status(HttpStatus.NOT_FOUND);
            return;
        }
        personDAO.deletePersonById(id);
        ResponseEntity.status(HttpStatus.OK);
    }
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> AddPerson(@Valid @RequestBody PersonDTO personDTO) {

        personDAO.saveNewPerson(personDTO);
        return ResponseEntity.ok("valid");
    }

    @GetMapping("/user")
    public String user() {
        return "User";
    }
    @GetMapping("/admin")
    public String admin() {
        return "Admin";
    }
}