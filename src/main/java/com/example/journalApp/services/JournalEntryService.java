package com.example.journalApp.services;

import com.example.journalApp.entities.JournalEntry;
import com.example.journalApp.repositories.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public JournalEntry saveEntry(JournalEntry journalEntry)
    {
        return journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAll()
    {
        return journalEntryRepository.findAll();
    }

    public JournalEntry findById(ObjectId id)
    {
        return journalEntryRepository.findById(id).get();
    }

    public void deleteById(ObjectId objectId)
    {
         journalEntryRepository.deleteById(objectId);
    }

    public JournalEntry updateJournalEntry(ObjectId id,JournalEntry journalEntry)
    {
        JournalEntry journalEntry1=journalEntryRepository.findById(id).get();
        journalEntry1.setContent(journalEntry.getContent());
        journalEntry1.setTitle(journalEntry.getTitle());

        return journalEntryRepository.save(journalEntry1);
    }
}
