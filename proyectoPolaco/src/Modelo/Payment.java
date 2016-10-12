package Modelo;

import java.sql.Date;

public class Payment {
    private Date date;
    private String amount;

    public Payment(Date date, String amount, String paymentKind) {
        this.date = date;
        this.amount = amount;
        this.paymentKind = paymentKind;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaymentKind() {
        return paymentKind;
    }

    public void setPaymentKind(String paymentKind) {
        this.paymentKind = paymentKind;
    }
    private String paymentKind;
}
