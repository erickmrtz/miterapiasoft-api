package pe.edu.pucp.miterapia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.pucp.miterapia.dto.TypeWorkerDTO;
import pe.edu.pucp.miterapia.model.TypeWorker;
import pe.edu.pucp.miterapia.service.TypeWorkerService;
import pe.edu.pucp.miterapia.util.ApiResponse;
import pe.edu.pucp.miterapia.util.LoggerInfo;

import java.util.List;

@RestController
@RequestMapping("/api/typeworkers")
@Slf4j
public class TypeWorkerController {
    @Autowired
    private TypeWorkerService typeWorkerService;

    @PostMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> save(@RequestBody TypeWorkerDTO typeWorkerDTO){
        log.info(LoggerInfo.info(TypeWorkerController.class,LoggerInfo.POST_METHOD));
        return typeWorkerService.save(typeWorkerDTO);
    }

    @GetMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<List<TypeWorkerDTO>>> getAll(){
        log.info(LoggerInfo.info(TypeWorkerController.class,LoggerInfo.GET_METHOD));
        return typeWorkerService.getAll();
    }

    @PutMapping(name = "/", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> update(TypeWorkerDTO typeWorkerDTO){
        log.info(LoggerInfo.info(TypeWorkerController.class,LoggerInfo.PUT_METHOD));
        return typeWorkerService.update(typeWorkerDTO);
    }

    @DeleteMapping(name = "/{name}", produces = "application/json")
    public ResponseEntity<ApiResponse<?>> delete(@PathVariable(name = "name") String name){
        log.info(LoggerInfo.info(TypeWorkerController.class,LoggerInfo.DEL_METHOD));
        return typeWorkerService.delete(name);
    }
}
