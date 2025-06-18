package br.csi.CommitStream.controller;

import br.csi.CommitStream.model.Listas.ListaRepository;
import br.csi.CommitStream.model.Listas.Listafavoritos;
import br.csi.CommitStream.service.ListaService;
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
@RequestMapping("/listafavoritos")
@Tag(name="listafavoritos", description = "Path relacionado a operações de Lista de favoritos")
public class ListaFavController {
    private ListaService service;
    private ListaRepository repository;

    public ListaFavController(ListaService service){
        this.service=service;
    }
    @GetMapping("/listar")
    public List<Listafavoritos> listar(){
        return this.service.listar();
    }

    @GetMapping("/{id}")
    public Listafavoritos listafavoritos(@PathVariable Long id){
        return this.service.getListaFavoritos(id);
    }
    @PostMapping("/print-json")
    public void printjson(@RequestBody String json){
        System.out.println(json);
    }
    @PostMapping()
    @Operation(summary = "Criar uma nova lista", description = "Cria uma lista de filmes e adiciona na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Genero criado com sucesso",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Listafavoritos.class))),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos", content = @Content)
    })
    public  void salvar(@RequestBody @Valid Listafavoritos listafavoritos){
           this.service.salvar(listafavoritos);
    }
    @PutMapping
    public void atualizar(@RequestBody Listafavoritos listafavoritos){
        this.service.atualizar(listafavoritos);
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.service.excluir(id);
    }
}
