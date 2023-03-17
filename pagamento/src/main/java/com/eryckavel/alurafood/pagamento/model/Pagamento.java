package com.eryckavel.alurafood.pagamento.model;

import com.eryckavel.alurafood.pagamento.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    @Column(name = "valor", nullable = false, precision = 9, scale = 2)
    private BigDecimal valor;
    @NotBlank
    @Size(max = 100)
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @NotBlank
    @Size(max = 19)
    @Column(name = "numero", nullable = false, length = 19)
    private String numero;
    @NotBlank
    @Size(max = 7)
    @Column(name = "expiracao", nullable = false, length = 7)
    private String expiracao;
    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "codigo", nullable = false, length = 3)
    private String codigo;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @NotNull
    @Column(name = "idpedido", nullable = false)
    private Long idpedido;
    @NotNull
    @Column(name = "idformapagamento", nullable = false)
    private Long formadepagamento;

    public Pagamento() {
    }

    public Pagamento(Long id, BigDecimal valor, String nome, String numero, String expiracao, String codigo, Status status, Long idpedido, Long formadepagamento) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.numero = numero;
        this.expiracao = expiracao;
        this.codigo = codigo;
        this.status = status;
        this.idpedido = idpedido;
        this.formadepagamento = formadepagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public Long getFormadepagamento() {
        return formadepagamento;
    }

    public void setFormadepagamento(Long formadepagamento) {
        this.formadepagamento = formadepagamento;
    }
}
