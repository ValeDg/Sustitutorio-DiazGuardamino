package pe.edu.cibertec.diazguardaminosusti.controller;

import lombok.AllArgsConstructor;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.diazguardaminosusti.model.Docente;
import pe.edu.cibertec.diazguardaminosusti.service.DocenteService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/docente")
public class DocenteController {

    private DocenteService docenteService;


    @GetMapping("")
    public ResponseEntity<List<Docente>> listarDocentes(){
        List<Docente> docenteList = new ArrayList<>();
        docenteService.listarDocentes()
                .forEach(docenteList::add);
        if(docenteList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(docenteList, HttpStatus.OK);
    }


    /*
    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerDocentes(
            @PathVariable("id") Integer id){
        Docente docente = docenteService
                .obtenerDocentePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El docente con el Id Nro. "+
                        id + " no existe."));

        return new ResponseEntity<>(docente, HttpStatus.OK);
    }

*/

    @PostMapping("")
    public ResponseEntity<Docente> registrarDocente(
            @RequestBody Docente docente
    ){
        return new ResponseEntity<>(
                docenteService.guardar(docente), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Docente> actualizarDocente(
            @PathVariable("id") Integer id,
            @RequestBody Docente docente
    ){
        Docente oldDocente = docenteService
                .obtenerDocentePorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("El docente con el Id Nro. "+
                        id + " no existe."));
        oldDocente.setNombre(docente.getNombre());
        oldDocente.setDni(docente.getDni());
        oldDocente.setFechanacimiento(docente.getFechanacimiento());
        oldDocente.setSueldo(docente.getSueldo());
        oldDocente.setEmail(docente.getEmail());
        oldDocente.setSexo(docente.getSexo());
        oldDocente.setCategoria(docente.getCategoria());
        return new ResponseEntity<>(
                docenteService.guardar(oldDocente), HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDocente(
            @PathVariable("id") Integer id) {
        try {
            docenteService.eliminarDocentePorId(id);
            return new ResponseEntity<>("Docente eliminado con ID: " + id, HttpStatus.OK);
        } catch (ResourceNotFoundException exception) {
            return new ResponseEntity<>("Docente no encontrado con ID: " + id, HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<>("Error al eliminar el docente con ID: " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}