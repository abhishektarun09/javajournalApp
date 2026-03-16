package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entry.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journalv2")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryNyId(@PathVariable String myId){

        return journalEntryService.findById(new ObjectId(myId)).orElse(null);

    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId){
        journalEntryService.deleteById(new ObjectId(myId));
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalById(@PathVariable String myId, @RequestBody JournalEntry newEntry){
        JournalEntry old = journalEntryService.findById(new ObjectId(myId)).orElse(null);

        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
        }

        journalEntryService.saveEntry(old);
        return old;
    }
}

