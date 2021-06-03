package com.valid.valid.models.dto.response;

import java.util.List;

public class ChangeProcessResponse {
    private boolean success;
    private List<String> errors;

    public ChangeProcessResponse(boolean success, List<String> errors) {
        this.success = success;
        this.errors = errors;
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
}
