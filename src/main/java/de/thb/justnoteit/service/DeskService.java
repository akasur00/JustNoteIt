package de.thb.justnoteit.service;

import de.thb.justnoteit.entity.Note;
import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.repository.NoteRepository;
import de.thb.justnoteit.repository.NotebookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DeskService {
    private final NotebookRepository notebookRepository;

    private final NoteRepository noteRepository;

    public List<Notebook> getAllNotebooks() {
        return (List<Notebook>) notebookRepository.findAll();
    }

    public Notebook getNotebookById(Long id) {
        return notebookRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Note putEntryToList (Long notebookId) {
        if(notebookRepository.findById(notebookId).isPresent()) {
            Note note = new Note();
            note.setNotebookId(notebookId);
            return noteRepository.save(note);
        } else {
            return null;
        }
    }

    public Note putEntryToListWithTitle (Long notebookId, String title) {
        if (notebookRepository.findById(notebookId).isPresent()) {
            Note note = new Note();
            note.setNotebookId(notebookId);
            note.setTitle(title);
            return noteRepository.save(note);
        } else {
            return null;
        }
    }

    /* Obsolete Methods

    public List<Notebook> putEntryToList(Long notebookId){
        return notebookRepository.addEntryToList(notebookId);
    }

    public List<Notebook> putEntryToListWithTitle(Long notebookId, String title){
        return notebookRepository.addEntryToListWithTitle(notebookId, title);
    }

    public Optional<Notebook> getNotebookById(long id){
        return notebookRepository.findById(id);
    }

    public List<Notebook> getAllNotebooks(){
        return (List<Notebook>) notebookRepository.findAll();
    }

    */
}
