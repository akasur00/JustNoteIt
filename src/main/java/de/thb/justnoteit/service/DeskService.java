package de.thb.justnoteit.service;

import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.repository.NotebookDA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeskService {
    private NotebookDA source;

    public DeskService(){
        source = new NotebookDA();
    }

    public List<Notebook> putEntryToList(Long notebookId){
        return source.addEntryToList(notebookId);
    }

    public List<Notebook> putEntryToListWithTitle(Long notebookId, String title){
        return source.addEntryToListWithTitle(notebookId, title);
    }

    public Notebook getNotebookById(long id){
        return source.findById(id);
    }

    public List<Notebook> getAllNotebooks(){
        return source.findAll();
    }
}
