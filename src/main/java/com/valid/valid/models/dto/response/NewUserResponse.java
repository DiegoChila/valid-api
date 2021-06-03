package com.valid.valid.models.dto.response;

import com.valid.valid.models.entity.User;

import java.util.List;

public class NewUserResponse {
    private boolean success;
    private List<String> errors;
    private User user;

    public NewUserResponse(boolean success, List<String> errors, User user) {
        this.success = success;
        this.errors = errors;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
