package cloudcomputing;

import cloudcomputing.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByFirstName(String firstName);
	
	public User findByLastName(String lastName);

}
