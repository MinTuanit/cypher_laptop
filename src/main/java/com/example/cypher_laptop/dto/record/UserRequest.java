package com.example.cypher_laptop.dto.record;

import com.example.cypher_laptop.anotation.Cccd;
import jakarta.validation.constraints.*;

public record UserRequest(
        @NotBlank(message = "Tên không được để trống hoặc chỉ chứa ký tự khoảng trắng!")
        String name,

        @NotBlank(message = "Tên đăng nhập không được để trống hoặc chỉ chứa ký tự khoảng trắng!")
        String username,

        @NotBlank(message = "Mật khẩu để trống hoặc chỉ chứa ký tự khoảng trắng!")
        @Pattern(
                regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Mật khẩu phải có tối thiểu 8 ký tự, bao gồm cả chữ và số"
        )
        String password,

        @Pattern(
                regexp = "^(?:\\+84|84|0)(3|5|7|8|9)([0-9]{8})$",
                message = "Số điện thoại phải hợp lệ!"
        )
        String phonenumber,

        @Email(message = "Email phải hợp lệ")
        @NotBlank
        String email,
        String address,

        @Cccd
        String cccd
) {
}
