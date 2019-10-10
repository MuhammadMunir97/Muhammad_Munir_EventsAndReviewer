package com.muhammad.events.repositories;

import org.springframework.data.repository.CrudRepository;

import com.muhammad.events.modells.Comment;

public interface CommentsRepository extends CrudRepository<Comment, Long> {

}
