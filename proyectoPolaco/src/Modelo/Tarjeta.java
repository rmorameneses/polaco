package Modelo;
import java.util.ArrayList;

public class Tarjeta {
    private String articulos;
    private Cliente client;
    private String codigo;
    private String diaPago;
    private String fechaInicial;
    private int saldoTotal;    
    private ArrayList<Payment> payments;
    private String periodicity;
    private int cuotaPeriodica;

    public String getArticulos() {
        return articulos;
    }

    public int getCuotaPeriodica() {
        return cuotaPeriodica;
    }

    public void setCuotaPeriodica(int cuotaPeriodica) {
        this.cuotaPeriodica = cuotaPeriodica;
    }

    public void setArticulos(String articulos) {
        this.articulos = articulos;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Tarjeta(String products, Cliente client, String periodicity, String codigo, String diaPago, int saldoTotal, String fechaCreacion, int prima) {
        this.articulos = products;
        this.client = client;
        this.diaPago= diaPago;
        this.codigo = codigo;
        this.periodicity = periodicity;
        this.saldoTotal = saldoTotal;
        this.fechaInicial = fechaCreacion;
        this.payments = new ArrayList<Payment>();
        this.payments.add(new Payment(fechaInicial, prima,"Prima"));
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
        return articulos;
    }

    public void setProducts(String products) {
        this.articulos = products;
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