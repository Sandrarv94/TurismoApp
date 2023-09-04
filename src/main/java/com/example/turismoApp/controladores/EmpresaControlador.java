package com.example.turismoApp.controladores;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.servicios.EmpresaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
public class EmpresaControlador {
    @Autowired
    EmpresaServicio empresaServicio;

    @PostMapping
    public ResponseEntity<?> registrarEmpresa(@RequestBody Empresa datosEmpresa){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.empresaServicio.registrarEmpresa(datosEmpresa));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("{idEmpresa}")
    public ResponseEntity<?> modificarEmpresa(@RequestBody Empresa datosNuevosEmpresa, @PathVariable Integer idEmpresa){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.empresaServicio.modificarEmpresa(idEmpresa, datosNuevosEmpresa));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarEmpresaPorId(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.empresaServicio.buscarEmpresaPorId(id));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasLasEmpresas(){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.empresaServicio.buscarTodasLasEmpresas());
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarEmpresa(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.empresaServicio.eliminarEmpresa(id));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

}
