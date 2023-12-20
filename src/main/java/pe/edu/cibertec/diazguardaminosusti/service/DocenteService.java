package pe.edu.cibertec.diazguardaminosusti.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.diazguardaminosusti.model.Docente;
import pe.edu.cibertec.diazguardaminosusti.repository.DocenteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DocenteService {

    private DocenteRepository docenteRepository;

    public List<Docente> listarDocentes(){
        return docenteRepository.findAll();
    }
    public Docente guardar(Docente docente){
        return docenteRepository.save(docente);
    }
    public Optional<Docente> obtenerDocentePorId(Integer id){
        Optional<Docente> docente = docenteRepository.findById(id);
        if(docente.isEmpty()){
            return Optional.empty();
        }else
            return docente;
    }

    public void eliminarDocentePorId(Integer id) {
        Optional<Docente> productoOptional = docenteRepository.findById(id);
        if (productoOptional.isPresent()) {
            docenteRepository.deleteById(id);
        } else {
            throw new RuntimeException("El docente con ID " + id + " no existe.");
        }
    }
}
