package com.company.dao;

import com.company.model.Composition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSongDao extends DatabaseDao<Composition>{
    {
        setTable("Songs");
    }

    @Override
    public Composition parseModel(ResultSet response) {
        try {
            long id = response.getLong("id");
            String name = response.getString("name").trim();
            String performer = response.getString("performer").trim();
            short length = response.getShort("length");
            String style = response.getString("style");
            return new Composition(id, name, performer, length, style);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }

    public String makeUpdateByIDQuery(Composition composition) {
        String query = "UPDATE SONGS ";
        query += "SET NAME = " + "'" + composition.getName() + "'" + ",";
        query += "PERFORMER = " + "'" + composition.getPerformer() + "'" + ",";
        query += "LENGTH = " + composition.getLength() + ",";
        query += "STYLE = " + "'" + composition.getStyle() + "'" + " ";
        query += "WHERE ID = " + composition.getID();
        return query;
    }

    public String makeInsertQuery(Composition composition) {
        String query = "INSERT INTO SONGS ";
        query += "(NAME, PERFORMER, LENGTH, STYLE)";
        query += " VALUES ";
        query += "(";
        query += "'" + composition.getName() + "'" + ", ";
        query += "'" + composition.getPerformer() + "'" + ", ";
        query += composition.getLength() + ", ";
        query += "'" + composition.getStyle() + "'";
        query += ")";
        return query;
    }

    public String makeGetByNameQuery(String name) {
        return "SELECT * FROM SONGS WHERE NAME = " + "'" + name + "'";
    }

    public String makeDeleteByIDQuery(long id) {
        String query = "DELETE FROM SONGS WHERE ID = " + id;
        return query;
    }

    public String makeGetByIDQuery(long id) {
        String query = "SELECT * FROM SONGS WHERE ID = " + id;
        return query;
    }

    public String makeGetLastIDQuery() {
        String query = "SELECT MAX(ID) AS ID FROM SONGS";
        return query;
    }

    public List<Composition> findInRange(short minLength, short maxLength) {
        String query = "SELECT * FROM SONGS WHERE LENGTH >= " + minLength + " AND LENGTH <= " + maxLength;
        List<Composition> songs = new ArrayList<>();
        try {
            response = statement.executeQuery(query);
            while(response.next()) {
                songs.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return songs;
    }

    public List<Composition> findByDisc (long discID) {
        String query = "with t1 as (\n" +
                "select * from songs join disc_songs on songs.ID = disc_songs.song_id\n" +
                ") \n" +
                "select * from t1 where disc_ID = " + discID;
        List<Composition> songs = new ArrayList<>();
        try {
            response = statement.executeQuery(query);
            while(response.next()) {
                songs.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return songs;
    }
}
