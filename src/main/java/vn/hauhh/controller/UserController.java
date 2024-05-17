package vn.hauhh.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vn.hauhh.dto.request.UserRequestDTO;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
public class UserController {


    /*
     * Có hai cách để viết Mapping
     *   Cách 1: PostMapping như bình thường
     *   Cách 2: Define Mapping bằng @RequestMapping()
     *
     * */


    //
    // @RequestMapping(method = POST, path = "/")
    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    /*
     *
     * Có 2 cách để dùng PathVariable
     *   Cách 1: @PathVariable ánh xạ với tham số của URL ở đây là /{userID}
     *   Cách 2: @PathVariable đặt tên khác nhưng phải ánh xạ đến với tham số của URL
     *           VD: @PathVariable("userID") int id
     *
     * */
    @PutMapping("/{userID}")
    public String updateUser(@PathVariable int userID, @Valid @RequestBody UserRequestDTO userDTO) {
        System.out.println("Request update userID: " + userID);//In ra log để kiểm tra userID có được update hay không
        return "User updated";
    }

    //Note trong CRUD để cập nhật toàn bộ field thì mình phải dùng PutMapping
    //      còn nếu muốn cập nhật một field thì mình phải dùng PatchMapping
    //                                                   Nếu mà RequestParam để mặc định vậy thì nó là bắt buộc (required)
    //                                                  để kh cần bắt buộc nhập vào thì thêm @RequestParam(required = false)
    @PatchMapping("/{userID}")
    public String changeStatus(@PathVariable int userID, @RequestParam(required = false) boolean status) {
        System.out.println("Request change user status, userID: " + userID);
        return "User status change";
    }

    @DeleteMapping("/{userID}")
    public String deleteuser(@PathVariable int userID) {
        System.out.println("Request delete userID = " + userID);
        return "Deleted user successful";
    }

    @GetMapping("/{userID}")
    public UserRequestDTO getUserByID(@PathVariable int userID) {
        System.out.println("Request get user detail by userID = " + userID);
        return new UserRequestDTO("Game", "Hoang", "phone", "email");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUser() {
        System.out.println("Request list user");
        return List.of(new UserRequestDTO("Game", "Hoang", "phone", "email"),
                new UserRequestDTO("Hai Hau", "Hoang", "0886431559", "hhhau1910@gmail.com"));
    }

    @GetMapping("/list2nd")
    public List<UserRequestDTO> getAllUser2nd(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request list user");
        return List.of(new UserRequestDTO("Game", "Hoang", "phone", "email"),
                new UserRequestDTO("Hai Hau", "Hoang", "0886431559", "hhhau1910@gmail.com"));
    }

}
