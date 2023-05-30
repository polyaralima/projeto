package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Assinatura;
import br.com.fujideia.iesp.tecback.service.AssinaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assinaturas")
public class AssinaturaController {

    private final AssinaturaService assinaturaService;

    @Autowired
    public AssinaturaController(AssinaturaService assinaturaService) {
        this.assinaturaService = assinaturaService;
    }

    @PostMapping
    public ResponseEntity<Assinatura> criarAssinatura(@RequestBody Assinatura assinatura) {
        Assinatura novaAssinatura = assinaturaService.criarAssinatura(assinatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaAssinatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assinatura> atualizarAssinatura(@PathVariable Long id, @RequestBody Assinatura assinaturaAtualizada) {
        Assinatura assinatura = assinaturaService.atualizarAssinatura(id, assinaturaAtualizada);
        return ResponseEntity.ok(assinatura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAssinatura(@PathVariable Long id) {
        assinaturaService.deletarAssinatura(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Assinatura>> listarAssinaturas() {
        List<Assinatura> assinaturas = assinaturaService.listarAssinaturas();
        return ResponseEntity.ok(assinaturas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assinatura> buscarAssinaturaPorId(@PathVariable Long id) {
        Optional<Assinatura> optionalAssinatura = assinaturaService.buscarAssinaturaPorId(id);
        return optionalAssinatura.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}