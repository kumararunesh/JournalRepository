package com.example.journalApp.controllers;

import com.example.journalApp.entities.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {


    private Map<Long,JournalEntry> journalEntries = new HashMap();

    @GetMapping
    public List<JournalEntry> getAll()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry journalEntry)
    {
       // journalEntries.put(journalEntry.getId(),journalEntry);
        return true;
    }


    @GetMapping("id/{id}")
    public JournalEntry getJournalEntryById(@PathVariable("id") Long id)
    {
       return  journalEntries.get(id);
    }

    @DeleteMapping("id/{id}")
    public JournalEntry deleteJournalEntryById(@PathVariable("id") Long id)
    {
        return journalEntries.remove(id);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable("id") Long id,
                                          @RequestBody JournalEntry journalEntry)
    {
        return journalEntries.put(id,journalEntry);
    }

}
