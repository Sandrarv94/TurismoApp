package com.example.turismoApp.servicios;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.repositorios.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfertaServicio {

    @Autowired
    OfertaRepositorio ofertaRepositorio;

    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception{
        try{
            return (this.ofertaRepositorio.save(datosARegistrar));
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Oferta modificarOferta(Integer id,Oferta datosAmodificar) throws Exception{
        try{
            Optional<Oferta> ofertaEncontrada = this.ofertaRepositorio.findById(id);
            if(ofertaEncontrada.isEmpty()){
                throw new Exception("Oferta no encontrada");
            }
            Oferta ofertaQueExiste = ofertaEncontrada.get();

            ofertaQueExiste.setTitulo(datosAmodificar.getTitulo());
            ofertaQueExiste.setDescripcion(datosAmodificar.getDescripcion());

            return(this.ofertaRepositorio.save(ofertaQueExiste));
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }


    }

    public Oferta buscarOfertaPorId(Integer id) throws Exception{
        try {
            Optional<Oferta> ofertaOpcional = this.ofertaRepositorio.findById(id);
            if(ofertaOpcional.isEmpty()){
                throw new Exception("Oferta no encontrada");
            }
            return ofertaOpcional.get();
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Oferta> buscarTodasLasOfertas() throws Exception{
        try{
            List<Oferta> listaOferta = this.ofertaRepositorio.findAll();
            return listaOferta;
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Boolean elminarOferta(Integer id) throws Exception{
        try{
            Optional<Oferta> ofertaOpcional = this.ofertaRepositorio.findById(id);
            if(ofertaOpcional.isPresent()){
                this.ofertaRepositorio.deleteById(id);
                return true;
            } else{
                throw new Exception("Oferta no encontrada");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
