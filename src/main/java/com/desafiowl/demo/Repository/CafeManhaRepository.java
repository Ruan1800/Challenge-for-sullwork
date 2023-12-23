package com.desafiowl.demo.Repository;

import com.desafiowl.demo.Model.CafeManha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CafeManhaRepository extends JpaRepository<CafeManha, Long> {


}
