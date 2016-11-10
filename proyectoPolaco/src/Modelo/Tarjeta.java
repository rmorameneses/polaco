package Modelo;
import java.util.ArrayList;

public class Tarjeta {
    private String products;
    private Cliente client;
    private String codigo;
    private String diaPago;
    private int saldoTotal;    
    private ArrayList<Payment> payments;
    private String periodicity;

    public Tarjeta(String products, Cliente client, String periodicity, String codigo, String diaPago) {
        this.products = products;
        this.client = client;
        this.diaPago= diaPago;
        this.codigo = codigo;
        this.payments = new ArrayList<Payment>();
    }

    public int getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(int saldoTotal) {
        this.saldoTotal = saldoTotal;
    }
    
    public Tarjeta() {
        this.payments = new ArrayList<Payment>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDiaPago() {
        return diaPago;
    }
    
    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }
    
    public void setDiaPago(String diaPago) {
        this.diaPago = diaPago;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }    
}