package Modelo;

import java.sql.Date;

public class Payment {
    private String date;
    private String amount;
    private String paymentKind; 
    private String nota;

    public Payment(String date, String amount, String paymentKind, String nota) {
        this.date = date;
        this.amount = amount;
        this.paymentKind = paymentKind;
        this.nota = nota;
    }

    Payment(String abono) {
        this.amount = abono;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
