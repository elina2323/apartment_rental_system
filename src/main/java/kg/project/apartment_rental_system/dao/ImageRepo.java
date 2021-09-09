package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

}
