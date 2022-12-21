package com.example.validatingforminput.dao;

import com.example.validatingforminput.PersonForm;
import com.example.validatingforminput.ValidatingforminputApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
@Component
public class PersonDAO {
    private static final Logger log = LoggerFactory.getLogger(ValidatingforminputApplication.class);
    private final JdbcTemplate jdbcTemplate;


    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PersonForm> index() {
        log.info("Вывод всех пользователей");
        return jdbcTemplate.query("SELECT * FROM customers", new PersonMapper());
    }

    public PersonForm show(int id) {
        log.info("Вывод определенного пользователя по id");
        return jdbcTemplate.query("Select * from customers where id=?", new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);
    }

    public void save(PersonForm personForm) {
        log.info("Сохранение пользователя");
        jdbcTemplate.update("INSERT INTO customers (firstname, lastname, age, start, procent, des_score) VALUES(?,?,?,?,?,?)", personForm.getFirstname(), personForm.getLastname(), personForm.getAge(), personForm.getStart(), personForm.getProcent(), personForm.getDes_score());
    }

    public void update(int id, PersonForm personForm) {
        log.info("Обновление информации пользователя");
        jdbcTemplate.update("UPDATE customers SET firstname=?, lastname=?, age=?, start=?, procent=?, des_score=? WHERE id=?",personForm.getFirstname(), personForm.getLastname(), personForm.getAge(), personForm.getStart(), personForm.getDes_score(), id);
    }

    public void delete(int id) {
        log.info("Удаления пользователя");
        jdbcTemplate.update("DELETE FROM customers where id=?", id);
    }

}