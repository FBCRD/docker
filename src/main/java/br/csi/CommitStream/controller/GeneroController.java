package br.csi.CommitStream.controller;

import br.csi.CommitStream.model.Genero.Genero;
import br.csi.CommitStream.model.Genero.GeneroRepository;
import br.csi.CommitStream.model.Usuario.UsuarioRepository;
import br.csi.CommitStream.service.GeneroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
@Tag(name="Generos", description = "Path relacionado a operações de Genero")
public class GeneroController {
    private final GeneroRepository generoRepository;
    private GeneroService service;
    private UsuarioRepository repository;

    public GeneroController(GeneroService service, GeneroRepository generoRepository){
        this.service=service;
        this.generoRepository = generoRepository;
    }
    @GetMapping("/listar")
    public List<Genero> listar(){
        return this.service.listar();
    }

    @GetMapping("/{id}")
    public Genero genero(@PathVariable Long id){
        return this.service.getGenero(id);
    }
    @PostMapping("/print-json")
    public void printjson1(@RequestBody String json){
        System.out.println(json);
    }

    @PostMapping()
    @Operation(summary = "Criar um novo Gênero", description = "Cria um genero e adiciona na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Genero criado com sucesso",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Genero.class))),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos", content = @Content)
    })
    public void salvar(@RequestBody @Valid Genero genero){
        this.service.salvar(genero);
    }
    @PutMapping
    public void atualizar(@RequestBody Genero genero){
        this.service.atualizar(genero);
    }

    @DeleteMapping("/{id}")
    public void  deletar(@PathVariable Long id){
        this.service.excluir(id);
    }

}
