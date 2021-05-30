package com.devglan.userportal;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    User create(User user);

    User delete(int id);

    List<User> findAll();

    User findById(int id);

    User update(User user);
}
