package com.aheffernan.stockstuff.model;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "stock_symbol", schema = "", catalog = "stocks")
public class StockSymbolDAO implements DatabasesAccessObject {
    private int id;
    private String symbol;

    /**
     * @return id
     */
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockSymbolDAO that = (StockSymbolDAO) o;

        if (id != that.id) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        return result;
    }
}
