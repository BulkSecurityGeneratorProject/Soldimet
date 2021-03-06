package soldimet.repository;

import soldimet.domain.FormaDePago;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the FormaDePago entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FormaDePagoRepository extends JpaRepository<FormaDePago, Long> {

}
