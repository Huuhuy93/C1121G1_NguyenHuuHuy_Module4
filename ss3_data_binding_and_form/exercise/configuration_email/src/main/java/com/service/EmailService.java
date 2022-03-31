package com.service;

import com.model.Email;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService implements IEmailService {
    private static Map<Integer, Email> emails;
    static {
        emails = new HashMap<>();
        emails.put(1, new Email(101, "English", 10, false, "King"));
        emails.put(2, new Email(202, "Vietnamese", 25, true, "John"));
        emails.put(3, new Email(321, "Japanese", 50, false, "Alan"));
    }

    @Override
    public List<Email> findAll() {
        return new ArrayList<>(emails.values());
    }


    @Override
    public void save(Email email) {
        Integer idAutoIcrement = (int) (Math.random() * 1000);
        email.setId(idAutoIcrement);
        emails.put(email.getId(), email);
    }

}
