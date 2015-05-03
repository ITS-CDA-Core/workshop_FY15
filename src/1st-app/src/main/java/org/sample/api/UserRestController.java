package org.sample.api;

import java.util.List;

import org.sample.domain.User;
import org.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/* For Example
curl http://localhost:8080/api/user -v -X POST -H 'Content-Type:application/json' -d '{"userName":"imaizm", "password":"password", "createdAt":"2015-01-01T09:00+09"}'
curl http://localhost:8080/api/user -v -X GET
curl http://localhost:8080/api/user/imaizm -v -X DELETE
curl http://localhost:8080/api/user -v -X GET
 */

@RestController
@RequestMapping("api/user")
public class UserRestController {

	@Autowired
	UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	List<User> getChatRooms() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	User postChatRooms(@Validated @RequestBody User user) {
		return service.save(user);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{userName}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteChatRoom(@PathVariable("userName") String userName) {
		service.delete(userName);
	}
}
