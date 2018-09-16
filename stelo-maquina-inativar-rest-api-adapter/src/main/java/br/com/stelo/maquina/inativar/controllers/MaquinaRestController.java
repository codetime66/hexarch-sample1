package br.com.stelo.maquina.inativar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;

@RestController
public class MaquinaRestController {

    @Autowired
    private InativarMaquinaService inativarMaquinaService;

    @RequestMapping(value = "/maquina/{nuserie}/inativar", method = RequestMethod.PUT)
    public ResponseEntity inativarMaquina(@PathVariable String nuserie) {
    	boolean inativou = inativarMaquinaService.inativar(nuserie);
    	
        if (inativou) {
            return new ResponseEntity("{\"id\": " + nuserie + "}", HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
