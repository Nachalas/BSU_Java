package com.company.db;

import com.company.entity.Manufacturer;
import com.company.entity.Souvenir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSouvenirDao extends DatabaseDao<Souvenir> {
    {
        setTable("Souvenirs");
    }

    public Souvenir parseModel(ResultSet response) {
        try {
            long id = response.getLong("sou_id");
            long mf_id = response.getLong("mf_id");
            String name = response.getString("sou_name").trim();
            String date = response.getString("sou_date").trim();
            long price = response.getLong("sou_price");
            return new Souvenir(id, name, mf_id, date, price);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }

    public String makeUpdateByIDQuery(Souvenir souvenir) {
        String query = "UPDATE SOUVENIRS ";
        query += "SET SOU_NAME = " + "'" + souvenir.getName() + "'" + ",";
        query += "SOU_DATE = " + "'" + souvenir.getDate() + "'" + ",";
        query += "SOU_PRICE = " + souvenir.getPrice() + " ";
        query += "WHERE COURSE_ID = " + souvenir.getId();
        return query;
    }

    public String makeInsertQuery(Souvenir souvenir) {
        String query = "INSERT INTO SOUVENIRS ";
        query += "(SOU_ID, SOU_NAME, MF_ID, SOU_DATE, SOU_PRICE)";
        query += "VALUES ";
        query += "(";
        query += souvenir.getId() + ", ";
        query += "'" + souvenir.getName() + "'" + ", ";
        query += souvenir.getManufacturer_id() + ", ";
        query += "'" + souvenir.getDate() + "'" + ", ";
        query += souvenir.getPrice();
        query += ")";
        return query;
    }

    public String makeDeleteByIDQuery(long id) {
        String query = "DELETE FROM SOUVENIRS WHERE SOU_ID = " + id;
        return query;
    }

    public String makeGetByIDQuery(long id) {
        return "SELECT * FROM SOUVENIRS WHERE SOU_ID = " + id;
    }

    public String makeGetLastIDQuery() {
        String query = "SELECT MAX(SOU_ID) AS ID FROM SOUVENIRS";
        return query;
    }

    public String makeGetByNameQuery(String name) {
        return "SELECT * FROM SOUVENIRS WHERE SOU_NAME = " + "'" + name + "'";
    }

    public List<Souvenir> getByManufacturer(long id) {
        List<Souvenir> list = new ArrayList<>();
        String query = "SELECT * FROM SOUVENIRS WHERE MF_ID = " + id;
        try {
            response = statement.executeQuery(query);
            while (response.next()) {
                list.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return list;
    }

    public List<Souvenir> getByCountry(String country) {
        List<Souvenir> list = new ArrayList<>();
        String query = "with t1 as (" +
                "select sou_id, sou_name, souvenirs.mf_id mf_id, sou_date, sou_price, mf_name, mf_country from manufacturers join souvenirs on manufacturers.mf_id = souvenirs.mf_id" +
                ")" +
                "select sou_id, sou_name, mf_id, sou_date, sou_price from t1 where mf_country = '" + country + "'";
        try {
            response = statement.executeQuery(query);
            while (response.next()) {
                list.add(parseModel(response));
            }
        } catch (SQLException e) {
            log.fatal(e);
        }
        return list;
    }
}
