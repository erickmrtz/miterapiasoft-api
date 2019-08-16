package pe.edu.pucp.miterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pucp.miterapia.model.TypeWorker;

public interface TypeWorkerRepository extends JpaRepository<TypeWorker, Integer> {
    @Query("SELECT t FROM TypeWorker t WHERE t.name= ?1")
    TypeWorker findByName(String name);
}
