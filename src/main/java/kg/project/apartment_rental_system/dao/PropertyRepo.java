package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Property;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

    List<Property> findByDistrictName(@NonNull String districtName);
    List<Property> findByTownSuburbName(@NonNull String townSuburbName);
    List<Property> findByRegionName(@NonNull String regionName);
    List<Property> findByTypeId(Long typeId);
    List<Property> findByFurnitureIs(@NonNull boolean furniture);
    List<Property> findByInternetIs(@NonNull boolean internet);
    List<Property> findByRoomAmount(@NonNull int roomAmount);
    List<Property> findByFloor(@NonNull int floor);



}
