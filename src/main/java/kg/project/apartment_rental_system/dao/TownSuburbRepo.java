package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.TownSuburb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownSuburbRepo extends JpaRepository<TownSuburb, Long> {
}
