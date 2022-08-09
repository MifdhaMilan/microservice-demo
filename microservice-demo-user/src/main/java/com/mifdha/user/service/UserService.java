package com.mifdha.user.service;

import com.mifdha.user.common.Department;
import com.mifdha.user.model.User;

import com.mifdha.user.repository.UserRepository;
import com.mifdha.user.request.UserRequest;
import com.mifdha.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User createUser(UserRequest userRequest) throws Exception {

        User user = new User();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/get-department/"+userRequest.getDepartmentId(), Department.class);
        if(department != null){
            user.setName(userRequest.getName());
            user.setDepartmentId(userRequest.getDepartmentId());
           return userRepository.save(user);
        }else{
            throw new Exception("department not available");
        }
    }

    public ResponseEntity<UserResponse> getUserById(int id){
        User user = userRepository.findById(id).orElse(null);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/get-department/"+user.getDepartmentId(), Department.class);
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(user);
        userResponse.setDepartment(department);
        userResponse.setMessage("user with department returned successfully");
        return ResponseEntity.ok(userResponse);
        //return user,department, success message
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void DeleteUser(int id){
        userRepository.deleteById(id);
    }

//    public User editUser(User user){
//        User existingUser = getUserById(user.getId());
//        existingUser.setName(user.getName());
//        return userRepository.save(existingUser);
//    }
}
