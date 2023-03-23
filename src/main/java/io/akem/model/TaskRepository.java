package io.akem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

// RepositoryRestResource Służy do tego, żeby nadpisywać mapowania, które już istnieją
// w rest data repository. Spring data rest dobre jest na start, ale w rozbudowanych aplikacjach
// Powinna istnieć warstwa nap. servisu, wieć Repository nie potrzebuje udostępniać swoich metod bezposrednio.
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @RestResource(path = "done", rel = "done")
    List<Task> findByDone(@Param("state") boolean done);
}
