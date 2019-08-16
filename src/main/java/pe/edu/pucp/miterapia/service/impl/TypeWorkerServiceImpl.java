package pe.edu.pucp.miterapia.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.edu.pucp.miterapia.dto.TypeWorkerDTO;
import pe.edu.pucp.miterapia.model.TypeWorker;
import pe.edu.pucp.miterapia.repository.TypeWorkerRepository;
import pe.edu.pucp.miterapia.service.TypeWorkerService;
import pe.edu.pucp.miterapia.util.ApiResponse;
import pe.edu.pucp.miterapia.util.LoggerInfo;
import pe.edu.pucp.miterapia.util.MessageInfo;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TypeWorkerServiceImpl implements TypeWorkerService {
    @Autowired
    private TypeWorkerRepository typeWorkerRepository;

    @Override
    public ResponseEntity<ApiResponse<?>> save(TypeWorkerDTO typeWorkerDTO) {
        if(typeWorkerDTO == null){
            log.error(LoggerInfo.info(TypeWorkerServiceImpl.class, TypeWorkerDTO.class,LoggerInfo.IS_NULL));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST, MessageInfo.is_null(TypeWorkerDTO.class)));
        }

        TypeWorker typeWorker = new TypeWorker(
                typeWorkerDTO.getName(),
                typeWorkerDTO.getCharge(),
                typeWorkerDTO.getDescription(),
                1
        );

        typeWorkerRepository.save(typeWorker);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK));
    }

    @Override
    public ResponseEntity<ApiResponse<?>> update(TypeWorkerDTO typeWorkerDTO) {
        if(typeWorkerDTO == null){
            log.error(LoggerInfo.info(TypeWorkerServiceImpl.class, TypeWorkerDTO.class,LoggerInfo.IS_NULL));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST, MessageInfo.is_null(TypeWorkerDTO.class)));
        }

        TypeWorker typeWorker = typeWorkerRepository.findByName(typeWorkerDTO.getName());
        if(typeWorker == null){
            log.error(LoggerInfo.info(TypeWorkerServiceImpl.class,TypeWorker.class,"bad searching"));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST, MessageInfo.is_null(TypeWorker.class)));
        }

        typeWorker.setDescription(typeWorkerDTO.getDescription());
        typeWorker.setCharge(typeWorkerDTO.getCharge());
        typeWorker.setName(typeWorkerDTO.getName());

        typeWorkerRepository.saveAndFlush(typeWorker);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, "update completed"));
    }

    @Override
    public ResponseEntity<ApiResponse<List<TypeWorkerDTO>>> getAll() {
        log.info(LoggerInfo.info(TypeWorkerServiceImpl.class,LoggerInfo.GET_METHOD));

        List<TypeWorker> typeWorkers = typeWorkerRepository.findAll();
        List<TypeWorkerDTO> list = new ArrayList<>();

        for(TypeWorker typeWorker: typeWorkers){
            list.add(typeWorker.toDTO());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK,MessageInfo.IS_OK,list));
    }

    @Override
    public ResponseEntity<ApiResponse<?>> delete(String name) {
        TypeWorker typeWorker = typeWorkerRepository.findByName(name);
        if(typeWorker == null){
            log.error(LoggerInfo.info(TypeWorkerServiceImpl.class,TypeWorker.class,"bad searching"));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST, MessageInfo.is_null(TypeWorker.class)));
        }

        typeWorker.setActive(0);

        typeWorkerRepository.saveAndFlush(typeWorker);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(HttpStatus.OK, "update completed"));
    }

}
