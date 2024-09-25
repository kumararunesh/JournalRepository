package com.example.journalApp.controllers;

import com.example.journalApp.entities.JournalEntry;
import com.example.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(journalEntry);
        return true;
    }


    @GetMapping("id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable("id") ObjectId id) {
        return journalEntryService.findById(id);
    }

    @DeleteMapping("id/{id}")
    public boolean deleteJournalEntryById(@PathVariable("id") ObjectId id) {
         journalEntryService.deleteById(id);
         return true;

    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable("id") ObjectId id,
                                          @RequestBody JournalEntry journalEntry) {
        return journalEntryService.updateJournalEntry(id,journalEntry);
    }

}
