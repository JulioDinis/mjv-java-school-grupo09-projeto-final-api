package com.mjv.contrateme.resources;

import com.mjv.contrateme.models.Cidade;
import com.mjv.contrateme.services.CidadeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/contratame/cidade")
@Tag(name="Cidade")
public class CidadeResource {

    private final CidadeService cidadeService;

    public CidadeResource(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getOneCidade(@PathVariable(value="id") Integer id) {

        return ResponseEntity.status(HttpStatus.OK).body(this.cidadeService.findById(id));

    }

}