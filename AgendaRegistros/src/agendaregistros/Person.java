/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package agendaregistros;

/**
 *
 * @author tona
 * Created on 17/02/2019
 */
public class Person {
    private String name;
    private String lastName;
    private String telephone;
    private String cellPhone;
    private String address;
    private String photo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String toString() {
        return "Person{" + "name=" + name + ", lastName=" + lastName 
                + ", telephone=" + telephone + ", cellPhone=" + cellPhone 
                + ", address=" + address + ", photo=" + photo + '}';
    }
    
    
}
