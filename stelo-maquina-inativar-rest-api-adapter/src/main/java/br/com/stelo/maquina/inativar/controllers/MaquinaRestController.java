package br.com.stelo.maquina.inativar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.stelo.maquina.inativar.config.UsuarioLogado;
import br.com.stelo.maquina.inativar.ports.InativarMaquinaService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("maquina-inativar")
@CrossOrigin
public class MaquinaRestController {
	
    @Autowired
    private InativarMaquinaService inativarMaquinaService;

    @Autowired
    private UsuarioLogado usuarioLogado;
    
    @CrossOrigin
    @PutMapping("maquina/{nuserie}/inativar")
    public ResponseEntity inativarMaquina(@PathVariable String nuserie) {
    	
    	String userName = usuarioLogado.getUserName();
    	log.info("usuarioLogado.getUserName(): " + userName);

    	boolean inativou = inativarMaquinaService.inativar(nuserie, userName);
    	
        if (inativou) {
            return new ResponseEntity("{\"id\": " + nuserie + "}", HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    
}
