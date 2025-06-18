package br.csi.CommitStream.service;

import br.csi.CommitStream.model.Listas.ListaRepository;
import br.csi.CommitStream.model.Listas.Listafavoritos;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {
    private final ListaRepository repository;
    public ListaService(ListaRepository repository){
        this.repository = repository;
    }
    public void salvar(Listafavoritos listafavoritos){
        this.repository.save(listafavoritos);
    }
    public List<Listafavoritos> listar(){
        return this.repository.findAll();
    }
    public Listafavoritos getListaFavoritos(Long id){
        return this.repository.findById(id).get();
    }
    public void excluir(Long id){
        this.repository.deleteById(id);
    }
    public void atualizar(Listafavoritos listafavoritos){
        Listafavoritos lista = this.repository.getReferenceById(listafavoritos.getIdlistafav());
        lista.setNomelista(listafavoritos.getNomelista());
        lista.setFilme(listafavoritos.getFilme());
        lista.setUsuario(listafavoritos.getUsuario());
        this.repository.save(lista);
    }


}
