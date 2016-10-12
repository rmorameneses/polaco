package Modelo;
import java.util.ArrayList;

public class Tarjeta {
    private String products;
    private Client client;
    private ArrayList<Payment> payments;
    private String periodicity;

    public Tarjeta(String products, Client client, String periodicity) {
        this.products = products;
        this.client = client;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public Tarjeta() {
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }    
}