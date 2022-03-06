package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import java.util.Calendar;

public final class Date {
    private final Calendar c;
    private int year;
    private int month;

    private Date() {
        this.c = Calendar.getInstance();;
        this.year = c.get(Calendar.YEAR);
        this.month = c.get(Calendar.MONTH) + 1;
    }

    @Override
    public String toString() {
        if(this.month >= 1 && this.month <= 9){
            return "0" + month + "/" + year;
        }
        return month + "/" + year;
    }

    public static String now(){
        return new Date().toString();
    }

    public static String nextMonth(){
        return new Date().nextMonthDate().toString();
    }

    private Date nextMonthDate(){
        this.month += 1;
        return this;
    }

    public static String nextYear(){
        return new Date().nextYearDate().toString();
    }

    private Date nextYearDate(){
        this.year += 1;
        return this;
    }

    public static String afterThreeMonth(){
        return new Date().afterThreeMonthDate().toString();
    }

    private Date afterThreeMonthDate(){
        this.month += 3;
        return this;
    }
}
