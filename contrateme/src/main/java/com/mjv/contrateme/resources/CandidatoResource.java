package com.mjv.contrateme.resources;

import com.mjv.contrateme.models.CadastroCandidato;
import com.mjv.contrateme.services.CandidatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/contratame/candidato")
@Tag(name="Candidato")
public class CandidatoResource {

    private final CandidatoService candidatoService;

    public CandidatoResource(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CadastroCandidato> getOneCandidato(@PathVariable(value="id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.candidatoService.findById(id));

    }

}