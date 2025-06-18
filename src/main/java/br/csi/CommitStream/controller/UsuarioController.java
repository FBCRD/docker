package br.csi.CommitStream.controller;

import br.csi.CommitStream.model.Usuario.Usuario;
import br.csi.CommitStream.model.Usuario.UsuarioRepository;
import br.csi.CommitStream.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@Tag(name =  "Usuarios", description = "Path relacionado a operações de Usuario")
public class UsuarioController {
    private UsuarioService service;
    private UsuarioRepository repository;

    public UsuarioController(UsuarioService service){this.service = service;}

    /*http://localhost:8080/commitStream/usuario/listar*/
    @GetMapping("/listar")
    public List<Usuario> listar(){
        return this.service.listar();
    }

    /*http://localhost:8080/commitStream/usuario/1*/
    @GetMapping("/{id}")
    public Usuario usuario(@PathVariable Long id){return this.service.getUsuario(id);}

    /*http://localhost:8080/commitStream/usuario/print-json*/
    @PostMapping("/print-json")
    public void printjson(@RequestBody String json){
        System.out.println(json);
    }
    /*http://localhost:8080/commitStream/usuario*/
    @PostMapping()
    @Operation(summary = "Criar um novo usuario", description = "Cria um novo usuario e o adiciona na lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso",
                content = @Content(mediaType = "application/json",
                schema = @Schema(implementation = Usuario.class))),
            @ApiResponse(responseCode = "400", description = "Dados invalidos fornecidos", content = @Content)
    })
    public ResponseEntity salvar(@RequestBody @Valid Usuario usuario, UriComponentsBuilder uriComponentsBuilder){
        this.service.salvar(usuario);
        //monta a RI da aplicação dinamicamente
        URI uri = uriComponentsBuilder.path("/usuario/{uuid}").buildAndExpand(usuario.getUuid()).toUri();
        return ResponseEntity.created(uri).body(usuario);
    }



    /*http://localhost:8080/commitStream/usuario*/
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody Usuario usuario){
        this.service.atualizar(usuario);
        return ResponseEntity.ok(usuario);
    }
    /*http://localhost:8080/commitStream/usuario/1*/


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        this.service.excluir(id);
    }
    /*http://localhost:8080/commitStream/usuario/uuid/e3df46c8-bb36-406f-ad83-53b60131eebe*/


    @GetMapping("/uuid/{uuid}")
    public Usuario usuario(@PathVariable String uuid){
        return this.service.getUsuarioUUID(uuid);
    }
    /*http://localhost:8080/commitStream/usuario/uuid/e3df46c8-bb36-406f-ad83-53b60131eebe*/
    @PutMapping("/uuid")
    public void atualizarUUID(@RequestBody Usuario usuario){
        this.service.atualizarUUID(usuario);
    }

}
