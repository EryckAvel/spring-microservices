package com.eryckavel.alurafood.pagamento.service;

import com.eryckavel.alurafood.pagamento.dto.PagamentoDTO;
import com.eryckavel.alurafood.pagamento.model.Pagamento;
import com.eryckavel.alurafood.pagamento.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    public ResponseEntity<List<PagamentoDTO>> listar(){
        List<Pagamento> entidades = repository.findAll();
        List<PagamentoDTO> dtos = entidades
                .stream()
                .map(pagamento -> new PagamentoDTO(pagamento))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    public ResponseEntity<PagamentoDTO> buscar(Long idpagamento){
        Pagamento entidade = repository.findById(idpagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encontrado!"));
        PagamentoDTO dto = new PagamentoDTO(entidade);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @Transactional
    public ResponseEntity<Object> salvar(PagamentoDTO dto){
        Pagamento pagamento = new Pagamento();
        copiarDTOparaEntidade(pagamento, dto);
        pagamento = repository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PagamentoDTO(pagamento));
    }

    @Transactional
    public ResponseEntity<Object> atualizar(PagamentoDTO dto, Long idpagamento){
        Pagamento pagamento = repository.findById(idpagamento)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não encotrado!"));
        copiarDTOparaEntidadeUpdate(pagamento, dto, idpagamento);
        pagamento = repository.save(pagamento);
        return ResponseEntity.status(HttpStatus.OK).body(new PagamentoDTO(pagamento));
    }

    @Transactional
    public ResponseEntity<Object> deletar(Long idpagamento){
        Optional<Pagamento> entidade = repository.findById(idpagamento);
        if (entidade.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não encontrado");
        }else {
            repository.delete(entidade.get());
            return ResponseEntity.status(HttpStatus.OK).body("Pagamento deletado");
        }
    }

    public void copiarDTOparaEntidade(Pagamento entidade, PagamentoDTO dto){
        entidade.setValor(dto.getValor());
        entidade.setNome(dto.getNome());
        entidade.setNumero(dto.getNumero());
        entidade.setExpiracao(dto.getExpiracao());
        entidade.setCodigo(dto.getCodigo());
        entidade.setStatus(dto.getStatus());
        entidade.setIdpedido(dto.getIdpedido());
        entidade.setFormadepagamento(dto.getFormadepagamento());
    }

    public void copiarDTOparaEntidadeUpdate(Pagamento entidade, PagamentoDTO dto, Long identidade){
        Optional<Pagamento> optional = repository.findById(identidade);
        entidade.setId(optional.get().getId());
        if (dto.getValor() == null){
            entidade.setValor(optional.get().getValor());
        }else{
            entidade.setValor(dto.getValor());
        }
        if (dto.getNome() == null){
            entidade.setNome(optional.get().getNome());
        }else{
            entidade.setNome(dto.getNome());
        }
        if (dto.getNumero() == null){
            entidade.setNumero(optional.get().getNumero());
        }else{
            entidade.setNumero(dto.getNumero());
        }
        if (dto.getExpiracao() == null){
            entidade.setExpiracao(optional.get().getExpiracao());
        }else{
            entidade.setExpiracao(dto.getExpiracao());
        }
        if (dto.getCodigo() == null){
            entidade.setCodigo(optional.get().getCodigo());
        }else{
            entidade.setCodigo(dto.getCodigo());
        }
        if (dto.getStatus() == null){
            entidade.setStatus(optional.get().getStatus());
        }else{
            entidade.setStatus(dto.getStatus());
        }
        if (dto.getIdpedido() == null){
            entidade.setIdpedido(optional.get().getIdpedido());
        }else{
            entidade.setIdpedido(dto.getIdpedido());
        }
        if (dto.getFormadepagamento() == null){
            entidade.setFormadepagamento(optional.get().getFormadepagamento());
        }else{
            entidade.setFormadepagamento(dto.getFormadepagamento());
        }
    }

}
