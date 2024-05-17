package vn.hauhh.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserRequestDTO implements Serializable {

    @NotBlank(message = "First name can not blank")
    private String firstName;

    @NotNull(message = "Last name can not null")
    private String lastName;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
    private String phone;

    @Email(message = "Email is invalid format")
    private String email;

//    @NotNull(message = "dateOfBirth must be not null")
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    @JsonFormat(pattern = "MM/dd/yyyy")
//    private Date dateOfBirth;

   // @NotEmpty()
    private List<String> permission;

    public UserRequestDTO(String firstName, String lastName, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

//    public Date getDateOfBirth() {
//        return dateOfBirth;
//    }

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
}
