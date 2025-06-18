package br.csi.CommitStream.service;

import br.csi.CommitStream.model.Filme.Filme;
import br.csi.CommitStream.model.Filme.FilmeRepository;
import br.csi.CommitStream.model.Usuario.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    private final FilmeRepository repository;
    public FilmeService(FilmeRepository repository){
        this.repository=repository;
    }
    public void salvar(Filme filme){
        this.repository.save(filme);
    }
    public List<Filme> listar(){
        return this.repository.findAll();
    }
    public Filme getFilme(Long id){
        return this.repository.findById(id).get();
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }
    public void atualizar(Filme filme){
        Filme filme1 = this.repository.getReferenceById(filme.getIdfilme());
        filme1.setTitulo(filme.getTitulo());
        filme1.setDescricao(filme.getDescricao());
        filme1.setDuracao(filme.getDuracao());
        filme1.setDatalancamento(filme.getDatalancamento());
        this.repository.save(filme1);
    }

}
