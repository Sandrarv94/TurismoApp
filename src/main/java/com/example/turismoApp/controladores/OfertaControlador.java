package com.example.turismoApp.controladores;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.servicios.EmpresaServicio;
import com.example.turismoApp.servicios.OfertaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ofertas")
public class OfertaControlador {
    @Autowired
    OfertaServicio ofertaServicio;

    @PostMapping
    public ResponseEntity<?> registrarOferta(@RequestBody Oferta datosOferta){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.ofertaServicio.registrarOferta(datosOferta));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @PutMapping("{idOferta}")
    public ResponseEntity<?> modificarOferta(@RequestBody Oferta datosNuevosOferta, @PathVariable Integer idOferta){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.ofertaServicio.modificarOferta(idOferta, datosNuevosOferta));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarOfertaPorId(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.ofertaServicio.buscarOfertaPorId(id));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasLasOfertas(){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.ofertaServicio.buscarTodasLasOfertas());
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> eliminarOferta(@PathVariable Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK)
                    .body(this.ofertaServicio.elminarOferta(id));
        } catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
