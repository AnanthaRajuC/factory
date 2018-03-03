package pl.com.bottega.factory.demand.forecasting.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface DemandDao extends JpaRepository<DemandEntity, Long> {
    List<DemandEntity> findByRefNoAndDateGreaterThanEqual(String refNo, LocalDate now);
}
