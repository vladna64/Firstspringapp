package com.example.mapper;

import com.example.dto.PersonDTO;
import com.example.model.PersonForm;

public class PersonMapper {
    public PersonDTO MapToPersonDTO(PersonForm entity) {
        PersonDTO personDto = new PersonDTO();
        personDto.setId(entity.getId());
        personDto.setFirstname(entity.getFirstname());
        personDto.setLastname(entity.getLastname());
        personDto.setAge(entity.getAge());
        personDto.setStart(entity.getStart());
        personDto.setProcent(entity.getProcent());
        personDto.setDes_score(entity.getDes_score());
        return personDto;
    }
    public PersonForm MapToPersonForm(PersonDTO dto) {
        PersonForm personForm= new PersonForm();
        personForm.setId(dto.getId());
        personForm.setFirstname(dto.getFirstname());
        personForm.setLastname(dto.getLastname());
        personForm.setAge(dto.getAge());
        personForm.setStart(dto.getStart());
        personForm.setProcent(dto.getProcent());
        personForm.setDes_score(dto.getDes_score());
        return personForm;
    }

}
