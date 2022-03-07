package fr.esgi.al.domain.MarketplaceAPI.PayTradesman.domain;

import fr.esgi.al.kernel.Date;

import java.util.Calendar;

public final class PaymentDate implements Date {
    private final Calendar c;
    private int year;
    private int month;

    private PaymentDate() {
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
        return new PaymentDate().toString();
    }

    public static String nextMonth(){
        return new PaymentDate().nextMonthDate().toString();
    }

    private PaymentDate nextMonthDate(){
        this.month += 1;
        return this;
    }

    public static String nextYear(){
        return new PaymentDate().nextYearDate().toString();
    }

    private PaymentDate nextYearDate(){
        this.year += 1;
        return this;
    }

    public static String afterThreeMonth(){
        return new PaymentDate().afterThreeMonthDate().toString();
    }

    private PaymentDate afterThreeMonthDate(){
        this.month += 3;
        return this;
    }


}
