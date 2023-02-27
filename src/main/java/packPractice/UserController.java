package packPractice;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



public class UserController
{
	@Autowired
	private UserService service;

	// GET /users
	// retrieveAllUsers
	@GetMapping("/users")
	public List<UserBean> retrieveAllUsers() {
		return service.findAll();
	}

	// GET /users/{username}
	@GetMapping("/users/{username}")
	public UserBean retrieveUser(@PathVariable String username) throws UserNotFoundException {

		UserBean user = service.findOne(username);
		if (user == null)
			throw new UserNotFoundException("username :" + username);

		return user;
	}

//	@GetMapping("/users/hateoas/{id}")
//	public EntityModel<UserBean> retrieveUser_hateoas(@PathVariable int id) {
//		UserBean user = service.findOne(id);
//
//		if (user == null)
//			throw new UserNotFoundException("id-" + id);
//
//		// "all-users", SERVER_PATH + "/users"
//		// retrieveAllUsers
//		EntityModel<UserBean> resource = EntityModel.of(user);
//
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//		resource.add(linkTo.withRel("all-users"));
//
//		// HATEOAS
//
//		return resource;
//	}

	// input - details of user
	// output - Created & Return the Created URI

	@PostMapping("/users")
	public UserBean createUser(@RequestBody UserBean user) {

		return service.save(user);
//
//		// CREATED
//		// /user/{id} savedUser.getId()
//
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId())
//				.toUri();
//
//		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/users/{username}")
	public void deleteUser(@PathVariable String username) {
		service.deleteByUsername(username);

//		if (user == null)
//			throw new UserNotFoundException("Username :" + username);
	}

	
}
