package com.acme.monitor.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.acme.monitor.model.Users;

@Repository
public interface UsersDao extends JpaRepository<Users, Integer> {

  @Query("From Users u WHERE u.users_id = :userId")
  public Users findByUserId(@Param("userId") int userId);
  
  public Users findByUserNameIgnoreCase(String userName);
}
