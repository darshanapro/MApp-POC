package com.acme.monitor.service;

import com.acme.monitor.controller.request.UserRequest;
import com.acme.monitor.controller.response.UsersResponse;

public interface UsersService {

  public UsersResponse getById(int userId);
  
  public UsersResponse save(UserRequest userRequest);
  
  public UsersResponse update(UserRequest userRequest);
  
  public UsersResponse getByUserName(String userName);
}
