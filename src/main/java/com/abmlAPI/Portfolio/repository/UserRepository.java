package com.abmlAPI.Portfolio.repository;
 
import com.abmlAPI.Portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, String>{

    public User findByUserId(String userId);

    public Object findById(Long id);
    
}
