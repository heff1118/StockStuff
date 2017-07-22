package com.aheffernan.stockstuff.model.pojo;

/**
 * Created by aheffernan on 7/2/17.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stock"
})
@XmlRootElement(name = "stocks")
public class StockList implements StockInterface {

    private List<Stock> stock;

    /**
     ** @return List<Stock>
     */
    public List<Stock> getStocks() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStocks(List<Stock> stock) {
        this.stock = stock;
    }
}
