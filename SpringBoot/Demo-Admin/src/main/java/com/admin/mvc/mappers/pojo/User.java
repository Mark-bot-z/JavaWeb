package com.admin.mvc.mappers.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {

    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private Character sex;
    private String email;

}
