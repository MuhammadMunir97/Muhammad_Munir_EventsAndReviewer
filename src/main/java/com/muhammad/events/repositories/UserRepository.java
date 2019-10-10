package com.muhammad.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muhammad.events.modells.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
