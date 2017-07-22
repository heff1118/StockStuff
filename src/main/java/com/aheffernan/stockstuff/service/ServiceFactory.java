package com.aheffernan.stockstuff.service;

/**
 * A factory that returns a Services.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {}


    /**
     * @param defaultService
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getStockService(boolean defaultService) {
        if(defaultService){
            return new YahooAPIStockService();
        } else {
            return new DatabaseStockService();
        }
    }

    /**
     *
     * @return get a <CODE>UserService</CODE> instance
     */
    public static  UserService getUserService() {
        return new DatabaseUserService();
    }
}
