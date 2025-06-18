package br.csi.CommitStream.service;

import br.csi.CommitStream.model.Filme.FilmeRepository;
import br.csi.CommitStream.model.Genero.Genero;
import br.csi.CommitStream.model.Genero.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    private final GeneroRepository repository;
    public GeneroService(GeneroRepository repository){
        this.repository=repository;
    }
    public void salvar(Genero genero){
        this.repository.save(genero);
    }
    public List<Genero> listar(){
        return this.repository.findAll();
    }
    public Genero getGenero(Long id){
        return this.repository.findById(id).get();
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }
    public void atualizar(Genero genero){
        Genero genero1 = this.repository.getReferenceById(genero.getIdGenero());
        genero1.setNomeGenero(genero.getNomeGenero());
        this.repository.save(genero1);
    }
}
