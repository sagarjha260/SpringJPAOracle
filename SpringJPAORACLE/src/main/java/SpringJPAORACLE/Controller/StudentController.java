package SpringJPAORACLE.Controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import SpringJPAORACLE.Model.Employee;

@RestController
public class StudentController 
{
	@RequestMapping(method = RequestMethod.POST, value = "/employee") 
	public ResponseEntity<Employee> addTopic(@RequestBody Employee employee) 
	{ 
		System.out.println(employee.getName());
		System.out.println(employee.getCompany());
		System.out.println(employee.getCountry());
		
	    if (employee == null) 
	    {
	    	System.out.println(ResponseEntity.notFound().build());
	        return ResponseEntity.notFound().build();
	    }
	    else
	    {
	    	return ResponseEntity.ok(employee);
	    }
		/*
		 * else { URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		 * .path("/{id}") .buildAndExpand(employee.getName()) .toUri();
		 * 
		 * return ResponseEntity.created(uri) .body(employee); }
		 */
	}

}
