package com.maincoders.cakefactory.repo;

import com.maincoders.cakefactory.entity.CatalogEntity;
import com.maincoders.cakefactory.repo.CatalogRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CatalogRepoIntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CatalogRepo catalogRepo;

    @Test
    public void whenGetTitle_thenReturnCatalog() {
        // given
        CatalogEntity catalog = new CatalogEntity("abcrrr","All Butter Croissant", 3.78);
        entityManager.persist(catalog);
        entityManager.flush();

        // when
        Optional<CatalogEntity> found = catalogRepo.findById(catalog.getId());

        // then
        Assertions.assertThat(found.isPresent()).isEqualTo(catalog.getTitle());
    }
}
