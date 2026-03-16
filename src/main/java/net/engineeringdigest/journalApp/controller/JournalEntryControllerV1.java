package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import org.springframework.web.bind.annotation.*;


import java.util.*;
import java.util.HashMap;

@RestController
@RequestMapping("/journalv1")
public class JournalEntryControllerV1 {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryNyId(@PathVariable Long myId){
        return journalEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable Long myId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(myId, myEntry);
    }
}

