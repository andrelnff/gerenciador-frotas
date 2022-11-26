package com.tcc.gerenciadorfrotas.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tcc.gerenciadorfrotas.model.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
    
    @Query(value = "SELECT v.quilometragem FROM VEICULO V WHERE V.veiculo_id = ?1", nativeQuery = true)
    Long buscaQuilometragemVeiculo(Long id); 
    
   // @Query(value = "SELECT * FROM VEICULO V WHERE V.veiculo_id = ?1", nativeQuery = true)
   // Optional<Veiculo> buscarVeiculoPorId(Long id);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE VEICULO V SET V.quilometragem = ?1 WHERE V.veiculo_id = ?2", nativeQuery = true)
    void atualizaQuilometragemVeiculo(Long quilometragem, Long id);

}
