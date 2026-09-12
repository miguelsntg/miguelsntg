package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Mouse;

public interface MouseService {
    Mouse create(Mouse mouse);
    void update(Long id, Mouse mouse);
    void delete(Long id);
    Mouse findById(Long id);
    List<Mouse> findByMarca(String marca);
    List<Mouse> findByModelo(String modelo);
    List<Mouse> findAll();
}
