package com.eryckavel.alurafood.pagamento.repository;

import com.eryckavel.alurafood.pagamento.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}