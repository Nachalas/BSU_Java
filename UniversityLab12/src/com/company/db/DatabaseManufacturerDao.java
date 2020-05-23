package com.company.db;

import com.company.entity.Manufacturer;
import com.company.entity.Souvenir;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManufacturerDao extends DatabaseDao<Manufacturer> {
    {
        setTable("Manufacturers");
    }

    @Override
    public Manufacturer parseModel(ResultSet response) {
        try {
            long id = response.getLong("mf_id");
            String name = response.getString("mf_name").trim();
            String country = response.getString("mf_country").trim();
            return new Manufacturer(id, name, country);
        } catch (SQLException e) {
            log.fatal(e);
        }
        return null;
    }

    public String makeUpdateByIDQuery(Manufacturer manufacturer) {
        String query = "UPDATE MANUFACTURERS ";
        query += "SET MF_NAME = " + "'" + manufacturer.getName() + "'" + ",";
        query += "MF_COUNTRY = " + "'" + manufacturer.getCountry() + "' ";
        query += "WHERE MF_ID = " + manufacturer.getId();
        return query;
    }

    public String makeInsertQuery(Manufacturer manufacturer) {
        String query = "INSERT INTO MANUFACTURERS ";
        query += "(MF_ID, MF_NAME, MF_COUNTRY)";
        query += " VALUES ";
        query += "(";
        query += manufacturer.getId() + ", ";
        query += "'" + manufacturer.getName() + "'" + ", ";
        query += "'" + manufacturer.getCountry() + "'";
        query += ")";
        return query;
    }

    public String makeGetByNameQuery(String name) {
        return "SELECT * FROM MANUFACTURERS WHERE MF_NAME = " + "'" + name + "'";
    }

    public String makeDeleteByIDQuery(long id) {
        String query = "DELETE FROM MANUFACTURERS WHERE MF_ID = " + id;
        return query;
    }

    public String makeGetByIDQuery(long id) {
        String query = "SELECT * FROM MANUFACTURERS WHERE MF_ID = " + id;
        return query;
    }

    public String makeGetLastIDQuery() {
        String query = "SELECT MAX(MF_ID) AS ID FROM MANUFACTURERS";
        return query;
    }

    public List<Manufacturer> getByPrice(Long price) {
        List<Manufacturer> list = new ArrayList<>();
        String query = "with t1 as (\n" +
                "select sou_id, sou_name, souvenirs.mf_id mf_id, sou_date, sou_price, mf_name, mf_country from manufacturers join souvenirs on manufacturers.mf_id = souvenirs.mf_id\n" +
                ")\n" +
                "select distinct mf_id, mf_name, mf_country from t1 where sou_price < " + price;
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

    public List<Manufacturer> getByNameAndDate(String name, String date) {
        List<Manufacturer> list = new ArrayList<>();
        String query = "with t1 as (\n" +
                "select sou_id, sou_name, souvenirs.mf_id mf_id, sou_date, sou_price, mf_name, mf_country from manufacturers join souvenirs on manufacturers.mf_id = souvenirs.mf_id\n" +
                ")\n" +
                "select distinct mf_id, mf_name, mf_country from t1 where sou_date = '" + date  + "' and sou_name = '" + name + "'";
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
