package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dem01Entity.AccountEntity;

@Repository
public interface AccRepository extends JpaRepository<AccountEntity,Long> {

}
