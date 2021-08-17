package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentRepo extends JpaRepository<Property, Long> {
}
