package com.devglan.userportal;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public interface UserService {

    User create(User user);

    User delete(int id);

    List<User> findAll() throws IOException, InterruptedException;

    User findById(int id);

    User update(User user);
}
