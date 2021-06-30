package com.javafx.exampl.controller;

import com.javafx.exampl.dao.DaoException;
import com.javafx.exampl.entity.Note;
import com.javafx.exampl.service.NoteService;
import com.javafx.exampl.service.ServiceException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;



public class NotesController implements Initializable {

    private NoteService noteService = new NoteService();

    @FXML
    private TextArea noteDescription;
    @FXML
    private ListView<Note> noteList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            for (Note note : noteService.findAll()) {
                noteList.getItems().add(note);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public void createNote()  {
        try {
            String noteDescriptionText = noteDescription.getText();
            Note note = new Note();
            note.setCreatedTime(LocalDateTime.now());
            note.setDescription(noteDescriptionText);
            Note createNoteId = noteService.create(note);
            noteList.getItems().add(createNoteId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }

    }

    public void deleteNote() {

        try {
            Note selectedItem = noteList.getSelectionModel().getSelectedItem();
            noteList.getItems().remove(selectedItem);
            noteService.delete(selectedItem.getId());
        } catch ( ServiceException e) {
            e.printStackTrace();
        }
    }


}
