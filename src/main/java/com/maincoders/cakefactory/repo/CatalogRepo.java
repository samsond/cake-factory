package com.maincoders.cakefactory.repo;

import com.maincoders.cakefactory.entity.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CatalogRepo extends JpaRepository<CatalogEntity, String> {

  public CatalogEntity findByTitle(String title);
  @Query(value = "SELECT * FROM catalog WHERE id = ?1", nativeQuery = true)
  public Optional<CatalogEntity> findById(String id);
  @Query(value = "SELECT * FROM catalog", nativeQuery = true)
  public List<CatalogEntity> findAll();



}
