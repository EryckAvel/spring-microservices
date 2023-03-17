package com.eryckavel.alurafood.pagamento.controller;

import com.eryckavel.alurafood.pagamento.dto.PagamentoDTO;
import com.eryckavel.alurafood.pagamento.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> listarPagamentos(){
        return service.listar();
    }

    @GetMapping("/{idpagamento}")
    public ResponseEntity<PagamentoDTO> buscarPagamento(@PathVariable("idpagamento") Long idpagamento){
        return service.buscar(idpagamento);
    }

    @PostMapping
    public ResponseEntity<Object> salvarPagamento(@RequestBody PagamentoDTO dto){
        return service.salvar(dto);
    }

    @PutMapping("/{idpagamento}")
    public ResponseEntity<Object> atualizarPagamento(@RequestBody PagamentoDTO dto,
                                                     @PathVariable Long idpagamento){
       return service.atualizar(dto, idpagamento);
    }

    @DeleteMapping("/{idpagamento}")
    public ResponseEntity<Object> deletarPagamento(@PathVariable("idpagamento") Long idpagamento){
        return service.deletar(idpagamento);
    }


}
