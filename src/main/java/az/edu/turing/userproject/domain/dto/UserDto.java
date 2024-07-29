package az.edu.turing.userproject.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
        private UUID id;
        private String username;
        private int age;
        private Date creatAt;
        private Date updateAt;
        private byte[] profilePhoto;
    }


