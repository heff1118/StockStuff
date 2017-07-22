package com.aheffernan.stockstuff.model;

import javax.persistence.*;

/**
 *  Models person table
 */
@Entity
@Table(name = "person", schema = "", catalog = "stocks")
public class PersonDAO implements DatabasesAccessObject{
    private int id;
    private String userName;

    /**
     * @return userid
     */
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return username
     */
    @Basic
    @Column(name = "user_name", nullable = false, insertable = true, updatable = true, length = 256)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDAO personDAO = (PersonDAO) o;

        if (id != personDAO.id) return false;
        if (userName != null ? !userName.equals(personDAO.userName) : personDAO.userName != null)
            return false;

        return true;
    }

    /**
     * @return id
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
