package com.uninter.tarefas.controller;

import com.uninter.tarefas.model.Tarefa; // Importe a classe Tarefa
import com.uninter.tarefas.repository.TarefaRepository; // Importe a interface TarefaRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController // Indica que esta classe é um controlador REST
@RequestMapping("/tarefas") // Define o caminho base para todos os endpoints neste controller
public class TarefaController {

    @Autowired // Injete a dependência de TarefaRepository
    private TarefaRepository tarefaRepository;

    // Endpoint para criar uma nova tarefa (Teste 1)
    @PostMapping
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaRepository.save(tarefa);
        return new ResponseEntity<>(novaTarefa, HttpStatus.CREATED); // Retorna 201 Created
    }

    // Endpoint para consultar todas as tarefas (Teste 2)
    @GetMapping
    public ResponseEntity<List<Tarefa>> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return new ResponseEntity<>(tarefas, HttpStatus.OK); // Retorna 200 OK
    }

    // Endpoint para consultar uma tarefa específica pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarTarefaPorId(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND)); // Retorna 404 Not Found se não encontrar
    }

    // Endpoint para atualizar uma tarefa existente (Teste 3)
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetalhes) {
        Optional<Tarefa> tarefaExistente = tarefaRepository.findById(id);

        if (tarefaExistente.isPresent()) {
            Tarefa tarefa = tarefaExistente.get();
            tarefa.setNome(tarefaDetalhes.getNome());
            tarefa.setDataEntrega(tarefaDetalhes.getDataEntrega());
            tarefa.setResponsavel(tarefaDetalhes.getResponsavel());
            Tarefa tarefaAtualizada = tarefaRepository.save(tarefa);
            return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK); // Retorna 200 OK
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna 404 Not Found
        }
    }

    // Endpoint para remover uma tarefa (Teste 4)
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarTarefa(@PathVariable Long id) {
        try {
            tarefaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna 204 No Content para deleção bem-sucedida
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna 500 Internal Server Error em caso de falha
        }
    }
}