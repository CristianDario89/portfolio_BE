package com.abmlAPI.Portfolio.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="loginUser")
@AllArgsConstructor
@Data
@NoArgsConstructor

public class User {
    @Id
    private Long id;
    private String userId;
    private String  password;
}
