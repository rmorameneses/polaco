package Modelo;

public class Cliente {
    private String location;
    private String name;
    private String phone;
    private String mail;

    public Cliente(String name, String phone, String mail,String location) {
        this.location = location;
        this.name = name;
        this.phone = phone;
        this.mail = mail;
    }

    Cliente() {
        
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
}
