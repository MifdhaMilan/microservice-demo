package com.mifdha.user.response;

import com.mifdha.user.common.Department;
import com.mifdha.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private User user;
    private Department department;
    private String message;
}
