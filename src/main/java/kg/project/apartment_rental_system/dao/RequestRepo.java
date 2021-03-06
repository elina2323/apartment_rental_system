package kg.project.apartment_rental_system.dao;

import kg.project.apartment_rental_system.model.entity.Code;
import kg.project.apartment_rental_system.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepo extends JpaRepository<Request, Long> {

    int countRequestsByCodeAndSuccessIs(Code code, boolean isSuccess);
}
