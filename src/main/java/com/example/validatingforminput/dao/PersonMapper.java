package com.example.validatingforminput.dao;

import com.example.validatingforminput.PersonForm;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonForm> {
    @Override
    public PersonForm mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonForm personForm = new PersonForm();

        personForm.setId(rs.getInt("id"));
        personForm.setFirstname(rs.getString("firstname"));
        personForm.setLastname(rs.getString("lastname"));
        personForm.setAge(rs.getInt("age"));
        personForm.setStart(rs.getBoolean("start"));
        personForm.setProcent(rs.getDouble("procent"));
        personForm.setDes_score(rs.getString("des_score").charAt(0));
        return personForm;
    }
}
