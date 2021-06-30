package com.javafx.exampl.service;

import com.javafx.exampl.dao.DaoException;
import com.javafx.exampl.dao.NoteDao;
import com.javafx.exampl.entity.Note;

import java.util.List;

public class NoteService {

    private NoteDao noteDao = new NoteDao();

    public Note create(Note note) throws ServiceException {
        try {
            return noteDao.create(note);
        } catch (DaoException e) {
            throw new ServiceException("failed to create in service");
        }
    }

    public List<Note> findAll() throws ServiceException {

        try {
            return noteDao.findAll();
        } catch (DaoException e) {
            throw new ServiceException("failed to find in service");
        }

    }
    public void delete(int id) throws ServiceException {
        try {
            noteDao.delete(id);
        } catch (DaoException e) {
            throw new ServiceException("failed to delete in service");
        }
    }

}
