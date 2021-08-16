package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends JpaRepository<Unit, Long> {
}
