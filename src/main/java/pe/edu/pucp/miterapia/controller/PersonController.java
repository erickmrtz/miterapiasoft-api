package pe.edu.pucp.miterapia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.pucp.miterapia.dto.PersonDTO;
import pe.edu.pucp.miterapia.service.PersonService;
import pe.edu.pucp.miterapia.util.ApiResponse;
import pe.edu.pucp.miterapia.util.LoggerInfo;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> save(@RequestBody PersonDTO personDTO){
        log.info(LoggerInfo.info(PersonController.class,LoggerInfo.POST_METHOD));
        return personService.save(personDTO);
    }

    @GetMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<List<PersonDTO>>> getAll(){
        log.info(LoggerInfo.info(PersonController.class,LoggerInfo.GET_METHOD));
        return personService.getAll();
    }

    @PutMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> update(@RequestBody PersonDTO personDTO){
        log.info(LoggerInfo.info(PersonController.class,LoggerInfo.PUT_METHOD));
        return personService.update(personDTO);
    }

    @GetMapping(name = "/{dni}", produces = "application/json")
    public ResponseEntity<ApiResponse<PersonDTO>> getById(@PathVariable(name = "dni") String dni){
        log.info(LoggerInfo.info(PersonController.class,LoggerInfo.GET_METHOD + "(" + dni +")"));
        return personService.getOne(dni);
    }
}
