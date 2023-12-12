package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.dem01Entity.AccountEntity;

import jakarta.validation.Valid;
import repository.AccRepository;

@Service
@Validated
public class AccService {
	
	@Autowired
	private AccRepository accRepo;
	
	public AccountEntity create(@Valid AccountEntity acc) {
		
		return accRepo.save(acc);
		
	}
	
	public String delete(long id) throws Exception {
		Optional<AccountEntity> op =accRepo.findById(id);
		if(op.isPresent()) {
		accRepo.deleteById(id);
		return "User delete Successfully";
		}
		else {
			throw new Exception("Acc Not Found");
		}
	}

}
