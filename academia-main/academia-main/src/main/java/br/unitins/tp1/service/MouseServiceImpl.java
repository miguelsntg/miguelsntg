package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Mouse;
import br.unitins.tp1.repository.MouseRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MouseServiceImpl implements MouseService {

    @Inject
    MouseRepository repository;

    @Override
    @Transactional
    public Mouse create(Mouse mouse) {
        repository.persist(mouse);
        return mouse;
    }

    @Override
    @Transactional
    public void update(Long id, Mouse mouse) {
        Mouse estadoBanco = repository.findById(id);
        if (estadoBanco == null) {
            throw new RuntimeException("Mouse não encontrado");
        }
        estadoBanco.setMarca(mouse.getMarca());
        estadoBanco.setModelo(mouse.getModelo());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Mouse findById(Long id) {
       return repository.findById(id);
    }

    @Override
    public List<Mouse> findByMarca(String marca) {
        return repository.findByMarca(marca);
    }

    @Override
    public List<Mouse> findByModelo(String modelo) {
        return repository.findByModelo(modelo);
    }

    @Override
    public List<Mouse> findAll() {
        return repository.listAll();
    }
    
}
