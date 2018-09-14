package br.com.stelo.maquina.inativar.controllers;

import br.com.stelo.maquina.inativar.models.ErrorMessage;
import br.com.stelo.maquina.inativar.models.Maquina;
import br.com.stelo.maquina.inativar.ports.GetMaquinaService;
import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MaquinaRestController {

    @Autowired
    private GetMaquinaService getMaquinaService;
    
    @Autowired
    private InativarMaquinaService inativarMaquinaService;

    @RequestMapping(value = "/maquina/{nuserie}", method = RequestMethod.GET)
    public ResponseEntity getMaquina(@PathVariable String nuserie) {
        Maquina maquina =  getMaquinaService.getMaquinaById(nuserie);
        if (maquina!=null) {
            return new ResponseEntity(maquina, HttpStatus.OK);
        }
        return new ResponseEntity(
                ErrorMessage.builder().message("Maquina with id " + nuserie + " was not found").build(),
                HttpStatus.NOT_FOUND
        );
    }

    @RequestMapping(value = "/maquina/{nuserie}/inativar", method = RequestMethod.PUT)
    public ResponseEntity inativarMaquina(@PathVariable String nuserie) {
    	boolean inativou = inativarMaquinaService.inativar(nuserie);
        if (inativou) {
            return new ResponseEntity("{\"id\": " + nuserie + "}", HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
