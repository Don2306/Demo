package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dem01Entity.AccountEntity;

import jakarta.validation.Valid;
import service.AccService;

@RestController
@Validated
@RequestMapping(path="/acc")
public class AccController {
	
	@Autowired
	private AccService accSer;
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody AccountEntity acc){
		AccountEntity accEnt = accSer.create(acc);
		return new ResponseEntity<Object>(accEnt , HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<Object> delete(Long id) throws Exception{
		
		accSer.delete(id);
		return new ResponseEntity<Object>("User Deleted Successfully" , HttpStatus.OK);
	}

}
