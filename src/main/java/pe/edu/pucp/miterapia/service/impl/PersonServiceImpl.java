package pe.edu.pucp.miterapia.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.pucp.miterapia.dto.PersonDTO;
import pe.edu.pucp.miterapia.model.Person;
import pe.edu.pucp.miterapia.repository.PersonRepository;
import pe.edu.pucp.miterapia.service.PersonService;
import pe.edu.pucp.miterapia.util.ApiResponse;
import pe.edu.pucp.miterapia.util.LoggerInfo;
import pe.edu.pucp.miterapia.util.MessageInfo;
import pe.edu.pucp.miterapia.util.PersonUtil;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public ResponseEntity<ApiResponse<?>> save(PersonDTO personDTO){
        if(personDTO == null){
            log.error(LoggerInfo.info(PersonServiceImpl.class,PersonDTO.class,LoggerInfo.IS_NULL));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST,MessageInfo.is_null(PersonDTO.class)));
        }

        Person person = new Person(
                personDTO.getDni(),
                personDTO.getFirst_name(),
                personDTO.getLast_name(),
                personDTO.getPhone_number(),
                personDTO.getEmail(),
                personDTO.getAddress(),
                personDTO.getPicture_addr(),
                PersonUtil.dtoToGender(personDTO.getGender()),
                PersonUtil.dtoToType(personDTO.getType()),
                1
        );

        personRepository.save(person);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK));
    }

    @Override
    public ResponseEntity<ApiResponse<?>> update(PersonDTO personDTO) {
        Person person = personRepository.findByDni(personDTO.getDni());
        if(person == null){
            log.error(LoggerInfo.info(PersonServiceImpl.class,PersonDTO.class,PersonUtil.ID_INCORRECT));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST,MessageInfo.is_null(PersonDTO.class)));
        }
        person.setFirst_name(personDTO.getFirst_name());
        person.setLast_name(personDTO.getLast_name());
        person.setPhone_number(personDTO.getPhone_number());
        person.setEmail(personDTO.getEmail());
        person.setAddress(personDTO.getAddress());
        person.setPicture_addr(personDTO.getPicture_addr());
        person.setGender(PersonUtil.dtoToGender(personDTO.getGender()));
        person.setPerson_type(PersonUtil.dtoToType(personDTO.getType()));

        personRepository.saveAndFlush(person);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK,person.toDTO()));
    }

    @Override
    public ResponseEntity<ApiResponse<List<PersonDTO>>> getAllPersons() {
        log.info(LoggerInfo.info(PersonServiceImpl.class,LoggerInfo.GET_METHOD));

        List<Person> persons = personRepository.findAll();
        List<PersonDTO> list = new ArrayList<>();

        for (Person person: persons) { list.add(person.toDTO()); }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK,list));
    }

    @Override
    public ResponseEntity<ApiResponse<PersonDTO>> getPerson(String dni) {
        Person person = personRepository.findByDni(dni);
        if(person == null){
            log.error(LoggerInfo.info(PersonServiceImpl.class,PersonUtil.ID_INCORRECT));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST,PersonUtil.ID_INCORRECT));
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK,person.toDTO()));
    }
}
