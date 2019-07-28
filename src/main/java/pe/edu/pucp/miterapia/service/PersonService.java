package pe.edu.pucp.miterapia.service;

import org.springframework.http.ResponseEntity;
import pe.edu.pucp.miterapia.dto.PersonDTO;
import pe.edu.pucp.miterapia.util.ApiResponse;

import java.util.List;

public interface PersonService {
    ResponseEntity<ApiResponse<?>> save(PersonDTO personDTO);
    ResponseEntity<ApiResponse<?>> update(PersonDTO personDTO);
    ResponseEntity<ApiResponse<List<PersonDTO>>> getAllPersons();
    ResponseEntity<ApiResponse<PersonDTO>> getPerson(String dni);
}
