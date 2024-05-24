package vn.hauhh.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import vn.hauhh.dto.request.UserRequestDTO;
import vn.hauhh.dto.respone.ResponseData;
import vn.hauhh.dto.respone.ResponseError;
import vn.hauhh.dto.respone.ResponseSuccess;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseData<UserRequestDTO> addUser(@RequestBody UserRequestDTO userDTO) {
        System.out.println("Requested add user: " + userDTO.getFirstName());
        //return new ResponseError(HttpStatus.BAD_REQUEST.value(), "can not create user");
        return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully",
                new UserRequestDTO("Game", "Hoang", "phone", "email"));
    }

    @PutMapping("/{userID}")
    public ResponseData updateUser(@PathVariable @Min(1) int userID, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update userID: " + userID);//In ra log để kiểm tra userID có được update hay không
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userID}")
    public ResponseData<?> changeStatus(@Min(1) @PathVariable int userID, @Min(1) @RequestParam(required = false) int status) {
        System.out.println("Request change user status, userID: " + userID);
        return new ResponseData(HttpStatus.ACCEPTED.value(), "User status changed successfully");
    }

    @DeleteMapping("/{userID}")
    public ResponseData<?> deleteuser(@Min(1) @PathVariable int userID) {
        System.out.println("Request delete userID = " + userID);
        return new ResponseData(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userID}")
    public ResponseData<UserRequestDTO> getUserByID(@PathVariable int userID) {
        System.out.println("Request get user detail by userID = " + userID);
        return new ResponseData(HttpStatus.OK.value(), "Get user: ", new UserRequestDTO("Game", "Hoang", "phone", "email"));
    }

    @GetMapping("/list")
    public ResponseData<List<UserRequestDTO>> getAllUser() {
        System.out.println("Request list user");
        return new ResponseData(HttpStatus.OK.value(), "List user: ", List.of(new UserRequestDTO("Game", "Hoang", "phone", "email"), new UserRequestDTO("Hai Hau", "Hoang", "0886431559", "hhhau1910@gmail.com")));
    }

}
