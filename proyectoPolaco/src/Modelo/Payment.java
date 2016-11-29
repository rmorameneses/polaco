package Modelo;

import java.sql.Date;

public class Payment {
    private String date;
    private int amount;
    private String nota;
    private int id;

    public Payment(String date, int amount, String nota) {
        this.date = date;
        this.amount = amount;
        this.nota = nota;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Payment(int abono, int id, String fecha) {
        this.amount = abono;
        this.id= id;
        this.date = fecha;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
