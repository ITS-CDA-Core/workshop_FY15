package org.sample.api;

import java.util.List;

import org.sample.domain.ChatRoom;
import org.sample.service.ChatRoomService;
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
curl http://localhost:8080/api/chat_rooms -v -X POST -H 'Content-Type:application/json' -d '{"title":"Chat Room 1", "createdBy":"0", "createdAt":"2015-01-01T09:00:00.000Z"}'
curl http://localhost:8080/api/chat_rooms -v -X POST -H 'Content-Type:application/json' -d '{"title":"Chat Room 2", "createdBy":"1", "createdAt":"2015-01-02T23:59:59.999Z"}'
curl http://localhost:8080/api/chat_rooms -v -X GET
curl http://localhost:8080/api/chat_rooms/1 -v -X DELETE
curl http://localhost:8080/api/chat_rooms -v -X GET
 */

@RestController
@RequestMapping("api/chat_rooms")
public class ChatRoomRestController {
	@Autowired
	ChatRoomService service;
	
	@RequestMapping(method = RequestMethod.GET)
	List<ChatRoom> getChatRooms() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	ChatRoom postChatRooms(@Validated @RequestBody ChatRoom chatRoom) {
		return service.save(chatRoom);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteChatRoom(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
