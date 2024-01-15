package com.example.project2.surveyapplication.daos;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project2.surveyapplication.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	

	User findByUsername(String username);

    // Additional query methods if needed
}
