package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByPhone(@NonNull String phone);
}
