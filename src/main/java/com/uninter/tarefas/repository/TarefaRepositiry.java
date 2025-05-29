package com.uninter.tarefas.repository; // Ajuste o pacote conforme o seu projeto

import com.uninter.tarefas.model.Tarefa; // Importe a classe Tarefa que você acabou de criar
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indica que esta interface é um componente de repositório Spring
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Spring Data JPA magic!
    // Você não precisa escrever implementações para os métodos CRUD básicos.
    // JpaRepository já oferece: save(), findById(), findAll(), deleteById(), etc.

    // Se precisar de métodos de consulta personalizados, você pode declará-los aqui,
    // e o Spring Data JPA os implementará automaticamente com base no nome do método.
    // Exemplo:
    // List<Tarefa> findByResponsavel(String responsavel);
}