package com.valid.valid.services;

import com.valid.valid.models.dto.request.UserIdsRequest;
import com.valid.valid.models.dto.response.ChangeProcessResponse;
import com.valid.valid.models.dto.response.NewUserResponse;
import com.valid.valid.models.entity.User;
import com.valid.valid.repositories.classes.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public NewUserResponse save(User user) {
        return new NewUserResponse(true, null, userRepository.save(user));
    }

    public ChangeProcessResponse changeState(UserIdsRequest userIdsRequest){
        String userIdsString = userIdsRequest.getUserIds();
        String[] userIds = userIdsString.substring(1,userIdsString.length()-1).split(",");
        boolean existsAllUsers = true;
        boolean correctData = true;
        if (!userIdsString.equals("[]")) {
            for (String userId : userIds) {
                if (StringUtils.isNumeric(userId)) {
                    Long id = Long.parseLong(userId);
                    if (!userRepository.existsById(id)) existsAllUsers = false;
                } else correctData = false;
            }
        }
        List<String> errors = new ArrayList<>();
        if (!correctData) errors.add("Datos de entrada invalidos");
        if (!existsAllUsers) errors.add("Algunos de los usuarios no existe");
        if (userIdsString.equals("[]")) errors.add("No ha seleccionado usuarios");
        if (!correctData || !existsAllUsers || userIdsString.equals("[]")) return new ChangeProcessResponse(false, errors);
        else {
            for (String userId : userIds) {
                Long id = Long.parseLong(userId);
                User user = userRepository.getById(id);
                user.setProcess(!user.getProcess());
                userRepository.save(user);
            }
            return new ChangeProcessResponse(true, errors);
        }
    }
}
