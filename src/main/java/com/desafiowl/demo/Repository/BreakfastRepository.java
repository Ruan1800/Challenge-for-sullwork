package com.desafiowl.demo.Repository;

import com.desafiowl.demo.Model.Breakfast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast, Long> {

    @Query(nativeQuery = true, value = "select * from breakfast where id = :id")
    Optional<Breakfast> findBreakfastById(@Param("id") Long id);

    @Query(nativeQuery = true, value = "select count(*) > 0 from breakfast where data = :data AND option_breakfast = :optionBreakfast")
    Boolean existsByDataAndOptionBreakfast(@Param("data") LocalDate data, @Param("optionBreakfast") String optionBreakfast);

    @Query(nativeQuery = true, value = "select count(*) > 0 from breakfast where cpf = :cpf AND data = :data")
    Boolean existsByCpfAndData(@Param("cpf") String cpf, @Param("data") LocalDate data);

    @Query(nativeQuery = true, value = "select * from breakfast where data = :data")
    List<Breakfast> findAllBreakFastByData(@Param("data") LocalDate data);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from breakfast where id = :id")
    void deleteBreakFastById(@Param("id") Long id);

}