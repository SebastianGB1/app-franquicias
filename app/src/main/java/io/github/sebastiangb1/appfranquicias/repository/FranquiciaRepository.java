package io.github.sebastiangb1.appfranquicias.repository;

import io.github.sebastiangb1.appfranquicias.models.Franquicia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranquiciaRepository extends JpaRepository<Franquicia, Long> {

}
