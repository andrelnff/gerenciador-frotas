package com.tcc.gerenciadorfrotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcc.gerenciadorfrotas.model.entity.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>{

}
