package com.uninter.tarefas.model; // Ajuste o pacote conforme o seu projeto

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate; // Importe LocalDate para a data de entrega

@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no BD
public class Tarefa {

    @Id // Marca o campo 'id' como a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de ID pelo BD
    private Long id;
    private String nome;
    private LocalDate dataEntrega; // Usamos LocalDate para representar a data sem hora
    private String responsavel;

    // Construtor padrão (necessário para JPA)
    public Tarefa() {
    }

    // Construtor com todos os campos (opcional, mas útil)
    public Tarefa(String nome, LocalDate dataEntrega, String responsavel) {
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }

    // Getters e Setters para todos os campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    // Opcional: toString() para facilitar a depuração
    @Override
    public String toString() {
        return "Tarefa{" +
               "id=" + id +
               ", nome='" + nome + '\'' +
               ", dataEntrega=" + dataEntrega +
               ", responsavel='" + responsavel + '\'' +
               '}';
    }
}