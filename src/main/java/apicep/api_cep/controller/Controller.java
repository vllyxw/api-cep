package apicep.api_cep.controller;

import apicep.api_cep.client.Client;
import apicep.api_cep.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    private final Client client;

    @Autowired
    public Controller(Client client) {
        this.client = client;
    }

    @PostMapping("/buscar")
    public ResponseEntity<Endereco> buscarCep(@RequestParam String cep) {
        try {
            Endereco endereco = client.buscarCep(cep);
            return ResponseEntity.ok(endereco);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
