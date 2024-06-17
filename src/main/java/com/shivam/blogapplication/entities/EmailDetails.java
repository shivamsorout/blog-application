package com.shivam.blogapplication.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class EmailDetails {
    private Set<String> recipient;
    private String msgBody;
    private String subject;
    private String attachment;

}
