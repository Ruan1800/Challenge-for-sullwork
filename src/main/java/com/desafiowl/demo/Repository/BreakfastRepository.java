package com.desafiowl.demo.Repository;

import com.desafiowl.demo.Model.Breakfast;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM CAFE_MANHA WHERE cpf = ?1 AND data = ?2")
    Breakfast findByCpfAndData(String cpf, Breakfast data);


    @Query(value = "SELECT * FROM breakfast", nativeQuery = true)
    List<Breakfast> findAllByid();

    @Query(value = "SELECT * FROM ITEMS i WHERE i.ID = ?", nativeQuery = true)
    Optional<Breakfast> findOneById(Long id);


    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM CAFE_MANHA WHERE data = :data AND option_breakfast = :optionBreakfast")
    boolean existsByDataAndOptionBreakfast(@Param("data") LocalDate data, @Param("optionBreakfast") String optionBreakfast);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) > 0 FROM CAFE_MANHA WHERE cpf = :cpf")
    boolean existsByCpf(@Param("cpf") String cpf);

}