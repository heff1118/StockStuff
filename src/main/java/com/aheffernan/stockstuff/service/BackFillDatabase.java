package com.aheffernan.stockstuff.service;


import com.aheffernan.stockstuff.model.pojo.StockList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class BackFillDatabase {

    /**
     * ParseXML
     */
    public static void parseXML(){
        try {

            File file = new File("/resources/stock_info.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(StockList.class);
            System.out.println(file.toString());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StockList qouteDAO = (StockList) unmarshaller.unmarshal(new StringReader(stringifyFile(file)));
            System.out.println(qouteDAO.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file
     * @return string
     * @throws IOException
     */
    private static String stringifyFile(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder sb = new StringBuilder();

        while((line=br.readLine())!= null){
            sb.append(line.trim());
        }

        return sb.toString();
    }
}
