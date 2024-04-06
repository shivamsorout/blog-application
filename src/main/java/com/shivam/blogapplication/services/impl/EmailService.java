package com.shivam.blogapplication.services.impl;
import com.shivam.blogapplication.entities.EmailDetails;

import java.util.Set;
public interface EmailService {
    public Set<String> sendEmails(EmailDetails emailDetails);
}
