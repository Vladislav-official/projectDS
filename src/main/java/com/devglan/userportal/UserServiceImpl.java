package com.devglan.userportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.save(user);

    }

    @Override
    public User delete(int id) {
        User user = findById(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return new User();
    }

    @Override
    public List<User> findAll() throws IOException, InterruptedException {

        List<User> users = userRepository.findAll();

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(
                    URI.create("https://fabrikam-functions-20210530151002820.azurewebsites.net/api/httpexample?name="
                            + user.getFirstName()))
                    .header("accept", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            user.setFirstName(response.body());
            users.set(i, user);
        }

        return users;
    }

    @Override
    public User findById(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
