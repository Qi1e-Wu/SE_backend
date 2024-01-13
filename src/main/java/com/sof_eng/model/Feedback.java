package com.sof_eng.model;

import lombok.Data;

@Data
public class Feedback {
    private Integer id;
    private String message;
    private String username;
    private String email;
}
