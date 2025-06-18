package br.csi.CommitStream.service;

import br.csi.CommitStream.model.Avaliacao.Avaliacao;
import br.csi.CommitStream.model.Avaliacao.AvaliacaoRepository;
import br.csi.CommitStream.model.Filme.Filme;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {
    private final AvaliacaoRepository repository;
    public AvaliacaoService(AvaliacaoRepository repository){
        this.repository=repository;
    }
    public void salvar(Avaliacao avaliacao){
        this.repository.save(avaliacao);
    }
    public List<Avaliacao> listar(){
        return this.repository.findAll();
    }
    public Avaliacao getAvaliacao(Long id){
        return this.repository.findById(id).get();
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }
    public void atualizar(Avaliacao avaliacao){
        Avaliacao avaliacao1 = this.repository.getReferenceById(avaliacao.getIdAvaliacao());
        avaliacao1.setComentario(avaliacao.getComentario());
        avaliacao1.setData(avaliacao.getData());
        avaliacao1.setNota(avaliacao.getNota());
        this.repository.save(avaliacao1);
    }
}
