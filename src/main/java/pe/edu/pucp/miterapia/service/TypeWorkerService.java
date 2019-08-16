package pe.edu.pucp.miterapia.service;

import org.springframework.http.ResponseEntity;
import pe.edu.pucp.miterapia.dto.TypeWorkerDTO;
import pe.edu.pucp.miterapia.util.ApiResponse;

import java.util.List;

public interface TypeWorkerService {
    ResponseEntity<ApiResponse<?>> save(TypeWorkerDTO typeWorkerDTO);
    ResponseEntity<ApiResponse<?>> update(TypeWorkerDTO typeWorkerDTO);
    ResponseEntity<ApiResponse<List<TypeWorkerDTO>>> getAll();
    ResponseEntity<ApiResponse<?>> delete(String name);
}
