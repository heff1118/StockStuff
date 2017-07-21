package com.aheffernan.stockstuff.model.pojo;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "symbol",
        "price",
        "date"
})
@XmlRootElement(name = "stock")
public class Stock implements StockInterface {
    @XmlElement(name = "symbol", required = false)
    private String symbol;
    @XmlElement(name = "price", required = false)
    private BigDecimal price;
    @XmlElement(name = "date", required = false)
    private LocalDateTime date;

    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    /**
     * @param date
     */
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }

    /**
     * @param symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}

