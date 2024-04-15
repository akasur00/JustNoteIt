package de.thb.justnoteit.controller;

import de.thb.justnoteit.entity.Notebook;
import de.thb.justnoteit.service.DeskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class NotebookController {

    private final DeskService deskService;

    @GetMapping("notebooks")
    public String showNotebooks(Model model){
        List<Notebook> notebooks = deskService.getAllNotebooks();
        model.addAttribute("notebooks", notebooks);
        return "notebooks";
    }

    @GetMapping("notebooks/{id}")
    public String showNotebookDetails(@PathVariable("id") Long id, Model model){
        Notebook notebook = deskService.getNotebookById(id);
        model.addAttribute("notebook", notebook);
        return "details";
    }

    @GetMapping("notebooks/{id}/add")
    public String addEntryToList(@PathVariable("id") Long id, Model model){
        deskService.putEntryToList(id);
        return "redirect:http://localhost:8080/notebooks/"+ id;
    }

    @PostMapping("notebooks/{id}")
    public String addEntryToListWithPost(@PathVariable("id") Long id, @RequestParam String noteEntry, Model model){
        deskService.putEntryToListWithTitle(id, noteEntry);
        return "redirect:http://localhost:8080/notebooks/"+ id;
    }

}
