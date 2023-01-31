package org.dmtv.mock_postgre.model;

import java.sql.Date;

public class TabelModel {
    private long id;
    private String login;
    private String password;
    private Date date;
    private String email;

    public TabelModel() {
    }

    public TabelModel(long id, String login, String password, Date date, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }

    public TabelModel(String login, String password, Date date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }

    public TabelModel(String login, String password, Date date, String email) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Record [id=" + id + ", login=" + login + ", password=" + password +
        ", date=" + date + ", email=" + email + "]";
    }
}
