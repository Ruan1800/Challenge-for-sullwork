package com.desafiowl.demo.Repository;

import com.desafiowl.demo.Model.Colaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColaboratorRepository extends JpaRepository<Colaborator, Long> {
}
