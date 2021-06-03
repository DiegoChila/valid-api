package com.valid.valid.controllers;

import com.valid.valid.models.dto.request.UserIdsRequest;
import com.valid.valid.models.dto.response.ChangeProcessResponse;
import com.valid.valid.models.dto.response.NewUserResponse;
import com.valid.valid.models.entity.User;
import com.valid.valid.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    public List<String> getErrors(BindingResult result) {
        List<ObjectError> objectsErrors = result.getAllErrors();
        List<String> errors = new ArrayList<String>();
        for (ObjectError error: objectsErrors) {
            errors.add(error.getDefaultMessage());
        }
        return errors;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NewUserResponse> save(@RequestBody @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = getErrors(result);
            return new ResponseEntity<>(new NewUserResponse(false, errors, null), HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PostMapping("/process")
    public ResponseEntity<ChangeProcessResponse> changeProcess(@RequestBody @Valid UserIdsRequest userIds, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = getErrors(result);
            return new ResponseEntity<>(new ChangeProcessResponse(false, errors), HttpStatus.OK);
        }
        return new ResponseEntity<>(userService.changeState(userIds), HttpStatus.OK) ;
    }
}
