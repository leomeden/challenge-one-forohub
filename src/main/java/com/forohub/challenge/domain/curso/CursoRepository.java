package com.forohub.challenge.domain.curso;

import com.forohub.challenge.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
