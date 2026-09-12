package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Mouse;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MouseRepository implements PanacheRepository<Mouse> {
    public List<Mouse> findByMarca(String marca) {
        // return find("SELECT e FROM Mouse e WHERE e.marca LIKE ?", marca).list();
        return find("upper(marca) LIKE upper(?1)", "%" + marca + "%").list();
    }

    public List<Mouse> findByModelo(String modelo) {
        // return find("SELECT e FROM Mouse e WHERE e.modelo LIKE ?", modelo).list();
        return find("upper(modelo) LIKE upper(?1)", "%" + modelo + "%").list();
    }
}
