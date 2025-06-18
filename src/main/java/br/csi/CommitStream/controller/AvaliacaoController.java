package br.csi.CommitStream.controller;

import br.csi.CommitStream.model.Avaliacao.Avaliacao;
import br.csi.CommitStream.model.Avaliacao.AvaliacaoRepository;
import br.csi.CommitStream.model.Usuario.Usuario;
import br.csi.CommitStream.service.AvaliacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacao")
@Tag(name= "Avaliacao", description = "Path relacionado a operações de avaliações")
public class AvaliacaoController {
    private AvaliacaoService service;
    private AvaliacaoRepository repository;

    public AvaliacaoController(AvaliacaoService service){
        this.service=service;
    }

    /*http://localhost:8080/commitStream/avalicao/listar*/
    @GetMapping("/listar")
    public List<Avaliacao> listar(){
        return this.service.listar();
    }
    /*http://localhost:8080/commitStream/avaliacao/1*/
    @GetMapping("/{id}")
    public Avaliacao avaliacao(@PathVariable Long id){
        return this.service.getAvaliacao(id);
    }
    /*http://localhost:8080/commitStream/avaliacao*/
    @PostMapping("/print-json")
    public void printjson4(@RequestBody String json){
        System.out.println(json);
    }
    /*http://localhost:8080/commitStream/avaliacao*/
    @PostMapping()
    @Operation(summary = "Criar uma nova avaliacao", description = "Cria uma nova avalição e o adiciona na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Avaliacao criada com sucesso",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = Avaliacao.class))),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos", content= @Content)

    })
    public void salvar(@RequestBody @Valid Avaliacao avaliacao){
        this.service.salvar(avaliacao);
    }
    /*http://localhost:8080/commitStream/avaliacao*/
    @PutMapping
    public void atualizar(@RequestBody Avaliacao avaliacao){
        this.service.atualizar(avaliacao);
    }
    /*http://localhost:8080/commitStream/avaliacao*/
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.service.excluir(id);
    }

}
