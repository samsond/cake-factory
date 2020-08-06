package com.maincoders.cakefactory.repo;

import com.maincoders.cakefactory.entity.CatalogEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CatalogRepo extends CrudRepository<CatalogEntity, String> {

  public CatalogEntity getByTitle(String title);
  public CatalogEntity getById(String id);
  @Query(value = "SELECT * FROM catalog", nativeQuery = true)
  public List<CatalogEntity> findAll();


}
