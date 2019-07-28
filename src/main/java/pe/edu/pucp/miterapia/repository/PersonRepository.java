package pe.edu.pucp.miterapia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.pucp.miterapia.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    @Query("SELECT p FROM Person p WHERE p.dni= ?1")
    Person findByDni(String dni);
}
