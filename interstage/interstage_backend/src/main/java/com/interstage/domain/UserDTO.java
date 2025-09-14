package com.interstage.domain;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data // 보일러플레이트를 자동 생성
@NoArgsConstructor //디폴트 생성자 자동 생성
@AllArgsConstructor //모든 필드 값을 파라미터로 받는 생성자 자동 생성
public class UserDTO {
	@NotBlank(message = "아이디는 필수입니다.")
	@Size(min = 4, max = 12, message = "아이디는 4~12자여야 합니다.")
	@Pattern(regexp = "^(?=.*[A-Za-z])[A-Za-z0-9]+$", 
	         message = "아이디에는 최소 한 글자 이상의 영문이 포함되어야 하며, 숫자는 선택 가능합니다.")
	private String username;

	@NotBlank(message = "비밀번호는 필수입니다.")
	@Pattern(
	    regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
	    message = "비밀번호는 최소 8자 이상, 최소 한 글자 이상의 영문, 숫자, 특수문자를 포함해야 합니다."
	)
	private String password;


    @NotBlank(message = "비밀번호 확인은 필수입니다.")
    private String confirmPassword;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "유효한 이메일을 입력해주세요.")
    private String email;
}
