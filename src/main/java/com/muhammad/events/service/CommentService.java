package com.muhammad.events.service;

import org.springframework.stereotype.Service;

import com.muhammad.events.modells.Comment;
import com.muhammad.events.repositories.CommentsRepository;

@Service
public class CommentService {
	
	private final CommentsRepository commentsRepo;

	public CommentService(CommentsRepository commentsRepo) {
		this.commentsRepo = commentsRepo;
	}
	
	public void saveComment(Comment comment) {
		commentsRepo.save(comment);
	}
	
}
