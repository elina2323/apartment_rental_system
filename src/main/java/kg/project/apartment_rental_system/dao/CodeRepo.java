package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Code;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Repository
public interface CodeRepo extends JpaRepository<Code, Long> {

    Code findByIdAndStartDateAndEndDate(Long id, LocalDate startDate, LocalDate endDate);

    boolean findExpireTime(LocalDateTime localDateTime);
}
