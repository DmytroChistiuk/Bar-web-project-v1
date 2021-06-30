package com.javafx.exampl.dao;

import com.javafx.exampl.entity.Note;
import com.javafx.exampl.util.MySQLUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NoteDao {
    private static final String DELETE = "DELETE FROM notes WHERE id = ?";
    private static final String INSERT_QUERY = "INSERT INTO notes(description, sustem_time) VALUES (?, ?)";
    private static final String QUERY_FIND_ALL="SELECT * FROM notes";

    public Note create(Note note) throws DaoException {
        try {
            Connection connection = MySQLUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, note.getDescription());
            Timestamp timestamp = Timestamp.valueOf(note.getCreatedTime());
            preparedStatement.setTimestamp(2, timestamp);
            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            generatedKeys.next();
            int id = generatedKeys.getInt(1);
            note.setId(id);
            return note;
        } catch (SQLException | ClassNotFoundException e) {
            throw new DaoException("Failed to  DAO connect");
        }

    }

    public  void delete(int id) throws DaoException {
        try (Connection connection = MySQLUtil.getConnection();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE))
        {
            prepareStatement.setLong(1, id);
            prepareStatement.executeUpdate();
        } catch(Exception e) {
            throw new DaoException("Failed to  DAO connect");
        }
       }


    public  List<Note> findAll() throws DaoException {
        try(Connection connection = MySQLUtil.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(QUERY_FIND_ALL);
            ResultSet resultSet = prepareStatement.executeQuery(QUERY_FIND_ALL)) {
            List <Note> notes = new ArrayList<>();

            while (resultSet.next()) {
                Note note = new Note();

                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
               // Timestamp timestamp = resultSet.getTimestamp("sustem_time");

                note.setId(id);
                note.setDescription(description);
                //note.setCreatedTime(LocalDateTime.from(timestamp.toInstant().atZone(zoneId).toLocalDate()));
                // timestamp = Timestamp.valueOf(note.getCreatedTime());
                //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                //LocalDateTime.parse(resultSet.getString("sustem_time"), formatter);
                  note.setCreatedTime(resultSet.getTimestamp("sustem_time").toLocalDateTime());

                notes.add(note);
            }
            return notes;
        }
        catch (Exception e){
            throw new DaoException("Failed to  DAO connect");
        }

    }


    }

