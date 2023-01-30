package com.example.dao;

import com.example.dto.PersonDTO;
import jakarta.validation.Valid;
import com.example.mapper.PersonMapper;
import com.example.model.PersonForm;
import com.example.ValidatingforminputApplication;
import com.example.repository.PersonRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);
    private final PersonRepository personRepository;

    private final PersonMapper personMapper = new PersonMapper();
    @PersistenceContext
    private EntityManager entityManager;


    public PersonDAO (PersonRepository personRepository) {
        this.personRepository = personRepository;    }

    public List<PersonDTO> showAllPerson() {
        log.debug("Вывод всех пользователей");
        return personRepository.findAllPerson().stream().map(personMapper::MapToPersonDTO).collect(Collectors.toList());
    }

    public PersonForm showOnePersonById(long id) {
        log.info("Вывод определенного пользователя по id= {}", id);
        return entityManager.find(PersonForm.class, id);
   }

    public void saveNewPerson(@Valid PersonDTO personDTO) {
        personRepository.save(personMapper.MapToPersonForm(personDTO));
        log.info("Сохранен новый пользователь");
    }

    public void updatePersonById(int id, @Valid PersonDTO personDTO) {
        personRepository.save(personMapper.MapToPersonForm(personDTO));
        log.info("Обновлена информация пользователя с id=" + id);
    }

    public void deletePersonById(long id) {
        personRepository.deleteById(id);
        log.info("Удален пользователь с id ={}", id);
    }

}