package com.phonebook.dao;

import com.phonebook.entity.Contacts;
import com.phonebook.entity.ContactsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository

public class ContactsDAO implements IContactsDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Contacts getContactById(int articleId) {
        String sql = "SELECT id, name, number, popular FROM contacts WHERE id = ?";
        RowMapper<Contacts> rowMapper = new BeanPropertyRowMapper<Contacts>(Contacts.class);
        Contacts contact = jdbcTemplate.queryForObject(sql, rowMapper, articleId);
        return contact;
    }
    @Override
    public List<Contacts> getAllContacts() {
        String sql = "SELECT id, name, number, popular FROM articles";
        //RowMapper<Article> rowMapper = new BeanPropertyRowMapper<Article>(Article.class);
        RowMapper<Contacts> rowMapper = new ContactsRowMapper();
        return this.jdbcTemplate.query(sql, rowMapper);
    }
    @Override
    public void addContact(Contacts contact) {
        //Add article
        String sql = "INSERT INTO contacts (id, name, number, popular) values (?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getId(), contact.getName(), contact.getNumber(), contact.getPopular());

        //Fetch article id
        sql = "SELECT id FROM articles WHERE name = ? and number=?";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, contact.getName(), contact.getNumber());

        //Set article id
        contact.setId(id);
    }
    @Override
    public void updateContact(Contacts contact) {
        String sql = "UPDATE contacts SET name=?, number=?, popular=? WHERE id=?";
        jdbcTemplate.update(sql, contact.getName(), contact.getNumber(), contact.getPopular(), contact.getId());
    }
    @Override
    public void deleteContact(int id) {
        String sql = "DELETE FROM contacts WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
//    @Override
//    public boolean contactExists(String title, String category) {
//        String sql = "SELECT count(*) FROM articles WHERE title = ? and category=?";
//        int count = jdbcTemplate.queryForObject(sql, Integer.class, title, category);
//        if(count == 0) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
