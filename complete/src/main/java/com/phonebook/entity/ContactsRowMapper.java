package com.phonebook.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class ContactsRowMapper implements RowMapper<Contacts> {
    @Override
    public Contacts mapRow(ResultSet row, int rowNum) throws SQLException {
        Contacts contact = new Contacts();
        contact.setId(row.getInt("id"));
        contact.setName(row.getString("name"));
        contact.setNumber(row.getString("number"));
        contact.setPopular(row.getInt("popular"));
        return contact;
    }
}
