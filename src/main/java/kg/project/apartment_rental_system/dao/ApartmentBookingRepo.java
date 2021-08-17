package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.ReserveHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentBookingRepo extends JpaRepository<ReserveHistory, Long> {
}
