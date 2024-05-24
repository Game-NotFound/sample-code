package vn.hauhh.dto.request;

import jakarta.validation.constraints.*;
import vn.hauhh.util.*;

import java.io.Serializable;

import static vn.hauhh.util.Gender.*;


public class UserRequestDTO implements Serializable {

    @NotBlank(message = "First name can not blank")
    private String firstName;

    @NotNull(message = "Last name can not null")
    private String lastName;

    // @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    @PhoneNumber
    private String phone;

    @Email(message = "Email is invalid format")
    private String email;

    //Pattern nay dung regexp de check userStatus nhung ma la` String kh phai la Enum
    // @Pattern(regexp = "^ACTIVE|INACTIVE|NONE$", message = "status must be one in {ACTIVE, INACTIVE, NONE}")
    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus userStatus;

    @GenderSubset(anyOf = {MALE, FEMALE, GAY})
    private Gender gender;

    @NotNull(message = "type must be not null")
    @EnumValue(name = "type", enumClass = UserType.class)
    private String type;


    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
