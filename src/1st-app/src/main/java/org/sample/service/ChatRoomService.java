package org.sample.service;

import java.util.List;

import org.sample.domain.ChatRoom;
import org.sample.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ChatRoomService {
	@Autowired
	ChatRoomRepository repository;
	
	public List<ChatRoom> findAll() {
		return repository.findAll(new Sort(Sort.Direction.ASC, "id"));
	}
	
	public ChatRoom save(ChatRoom chatRoom) {
		return repository.save(chatRoom);
	}
	
	public void delete(Long id) {
		repository.delete(id);
	}
}
