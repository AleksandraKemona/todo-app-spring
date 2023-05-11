package io.akem.controler;

import io.akem.model.Task;
import io.akem.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

// Spring annotation, that adds controller and response body

@RestController

class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(final TaskRepository repository) {
        this.repository = repository;
    }
    @GetMapping( path = "/tasks", params = {"!sort","!page", "!size"})
    ResponseEntity<List<Task>>readAllTasks(){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping( path = "/tasks")
    ResponseEntity<List<Task>>readAllTasks(Pageable page){
        logger.info("Custom pageable");
        return ResponseEntity.ok(repository.findAll(page).getContent());
    }
    @GetMapping( path = "/tasks/{id}")
    ResponseEntity<Task> readTask(@PathVariable int id){
        if (!repository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }

        return repository.findById(id).
                map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?>updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate){
        if (!repository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/task")
    ResponseEntity<Task> createTask (@RequestBody @Valid Task toCreate){
        Task result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }
}
