package main.java.fr.socle.web.crud.jpa.da;
 
import main.java.fr.socle.web.crud.jpa.model.User;

import org.springframework.data.repository.CrudRepository;
 

 
public interface UserDAO extends CrudRepository<User, Long>{
 
}