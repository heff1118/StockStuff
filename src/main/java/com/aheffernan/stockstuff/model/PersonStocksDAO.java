package com.aheffernan.stockstuff.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "person_stocks", schema = "", catalog = "stocks")
public class PersonStocksDAO implements DatabasesAccessObject {

    private int id;
    private PersonDAO personDAO;

    /**
     * @return id
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
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStocksDAO that = (PersonStocksDAO) o;

        if (id != that.id) return false;

        return true;
    }

    /**
     * @return id
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * @return PersonDAO
     */
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    /**
     * @param personByPersonId
     */
    public void setPersonDAO(PersonDAO personByPersonId) {
        this.personDAO = personByPersonId;
    }
}
