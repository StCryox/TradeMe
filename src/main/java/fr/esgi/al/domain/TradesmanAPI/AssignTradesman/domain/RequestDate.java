package fr.esgi.al.domain.TradesmanAPI.AssignTradesman.domain;

import fr.esgi.al.kernel.Date;

import java.util.Calendar;

public class RequestDate implements Date {
    private final Calendar c;
    private int year;
    private int month;

    public RequestDate(Calendar c, int year, int month) {
        this.c = c;
        this.year = year;
        this.month = month;
    }

    @Override
    public String toString() {
        if(this.month >= 1 && this.month <= 9){
            return "0" + month + "/" + year;
        }
        return month + "/" + year;
    }
}
