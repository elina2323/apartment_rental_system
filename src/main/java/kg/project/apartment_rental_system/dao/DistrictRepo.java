package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepo extends JpaRepository<District, Long> {


}
