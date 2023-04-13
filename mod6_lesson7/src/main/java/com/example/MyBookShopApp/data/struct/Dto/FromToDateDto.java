package com.example.MyBookShopApp.data.struct.Dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by a.sosnina on 1/29/2023.
 */
public class FromToDateDto {
    private String dateFrom;
    private String dateTo;


    public String getDateFrom() {
        return dateFrom;
    }
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Date getDateFromConverted() {
        return convertToDateFormat(dateFrom);
    }

    public Date getDateToConverted() {
        return convertToDateFormat(dateTo);
    }

    public static Date convertToDateFormat(String dateString) {
        SimpleDateFormat dateParser = new SimpleDateFormat("dd.MM.yyyy");
        Date result = new Date();
        try{
           result = new Date(dateParser.parse(dateString).getTime());
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        return result;
    }
}
