package pe.edu.cibertec.diazguardaminosusti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.diazguardaminosusti.model.Docente;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {

    Optional<Docente> findByNombre(String nombre);
    List<Docente> findByNombreContainingIgnoreCase(String filtro);

}
