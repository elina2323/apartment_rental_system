package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.User;
import kg.project.apartment_rental_system.model.enums.CodeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface CodeRepo extends JpaRepository<Code, Long> {

    Code findByUserAndCodeStatus(User user, CodeStatus codeStatus);
    Code findByUserAndCodeStatusAndStartDateAfter(User user, CodeStatus codeStatus, LocalDate startDate);
}
