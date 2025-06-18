package br.csi.CommitStream.controller;

import br.csi.CommitStream.model.Filme.Filme;
import br.csi.CommitStream.model.Filme.FilmeRepository;
import br.csi.CommitStream.model.Usuario.Usuario;
import br.csi.CommitStream.service.FilmeService;
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
@RequestMapping("/filme")
@Tag(name="Filmes", description = "Path relacionado a operações de filmes")
public class FilmeController {
    private FilmeService service;
    private FilmeRepository repository;

    public FilmeController(FilmeService service){
        this.service = service;
    }

    /*http://localhost:8080/commitStream/filme/listar*/
    @GetMapping("/listar")
    public List<Filme> listar(){
        return this.service.listar();
    }
    /*http://localhost:8080/commitStream/filme/1*/
    @GetMapping("/{id}")
    public Filme filme (@PathVariable Long id){return this.service.getFilme(id);}

    /*http://localhost:8080/commitStream/filme/print-json*/
    @PostMapping("/print-json")
    public void printjson3(@RequestBody String json){
        System.out.println(json);
    }



    /*http://localhost:8080/commitStream/filme*/
    @PostMapping()
    @Operation(summary = "Cria um novo filme", description = "Cria um novo vilme e o adiciona na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos", content = @Content)
    })
    public void salvar(@RequestBody @Valid Filme filme){
        this.service.salvar(filme);
    }

    /*http://localhost:8080/commitStream/filme*/
    @PutMapping
    public void atualizar(@RequestBody Filme filme){
        this.service.atualizar(filme);
    }
    /*http://localhost:8080/commitStream/filme/1*/
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.service.excluir(id);
    }


}
