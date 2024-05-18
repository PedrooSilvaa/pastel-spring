package br.edu.senaisp.Pastel.repository;

import br.edu.senaisp.Pastel.model.Pastel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPastelRepository extends JpaRepository<Pastel, Integer> {
}
