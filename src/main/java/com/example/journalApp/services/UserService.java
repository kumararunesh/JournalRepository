package com.example.journalApp.services;

import com.example.journalApp.entities.JournalEntry;
import com.example.journalApp.entities.User;
import com.example.journalApp.repositories.JournalEntryRepository;
import com.example.journalApp.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveEntry(User user)
    {
        return userRepository.save(user);
    }

    public List<User> getAll()
    {
        return userRepository.findAll();
    }

    public User findById(ObjectId id)
    {
        return userRepository.findById(id).get();
    }

    public void deleteById(ObjectId objectId)
    {
        userRepository.deleteById(objectId);
    }

    public User findByUserName(String username)
    {
        return userRepository.findByUsername(username);
    }

}
