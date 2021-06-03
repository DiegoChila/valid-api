package com.valid.valid.models.dto.request;

import javax.validation.constraints.NotNull;

public class UserIdsRequest {
    private String userIds;

    @NotNull(message = "Por favor seleccione usuarios")
    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }
}
