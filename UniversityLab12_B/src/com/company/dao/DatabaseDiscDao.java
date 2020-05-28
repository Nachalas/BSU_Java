package com.company.dao;

import com.company.model.Disc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseDiscDao extends DatabaseDao<Disc>{
    {
        setTable("Discs");
    }

    @Override
    public Disc parseModel(ResultSet response) {
        try {
            long id = response.getLong("ID");
            String name = response.getString("name").trim();
            return new Disc(id, name);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }

    public String makeUpdateByIDQuery(Disc disc) {
        String query = "UPDATE DISCS ";
        query += "SET NAME = " + "'" + disc.getName() + "'" + " ";
        query += "WHERE ID = " + disc.getID();
        return query;
    }

    public String makeInsertQuery(Disc disc) {
        String query = "INSERT INTO DISCS ";
        query += "(NAME)";
        query += " VALUES ";
        query += "(";
        query += "'" + disc.getName() + "'";
        query += ")";
        return query;
    }

    public String makeGetByNameQuery(String name) {
        return "SELECT * FROM DISCS WHERE NAME = " + "'" + name + "'";
    }

    public String makeDeleteByIDQuery(long id) {
        String query = "DELETE FROM DISCS WHERE ID = " + id;
        return query;
    }

    public String makeGetByIDQuery(long id) {
        String query = "SELECT * FROM DISCS WHERE ID = " + id;
        return query;
    }

    public String makeGetLastIDQuery() {
        String query = "SELECT MAX(ID) AS ID FROM DISCS";
        return query;
    }

    public void addSongToDisc(long songID, long discID) {
        String query = "INSERT INTO DISC_SONGS (DISC_ID, SONG_ID) VALUES ("
                + discID + ", " + songID + ")";
        try {
            statement.executeQuery(query);
        } catch (SQLException e) {
            log.fatal(e);
        }
    }

    public Long countLength(long ID) {
        String query = "with t1 as (\n" +
                "select * from songs join disc_songs on songs.ID = disc_songs.song_id\n" +
                ") \n" +
                "select sum(length) as sum from t1 where disc_ID = " + ID;
        try {
            response = statement.executeQuery(query);
            while(response.next()) {
                return response.getLong("sum");
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }
}
