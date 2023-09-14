/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toanpg.dtos;

/**
 *
 * @author Gia Toan
 */
public class RoomDTO {
    private String roomID;
    private int price, quantity;
    private String roomDescription, hName;

    public RoomDTO() {
    }

    public RoomDTO(String roomID, int price, int quantity, String roomDescription, String hName) {
        this.roomID = roomID;
        this.price = price;
        this.quantity = quantity;
        this.roomDescription = roomDescription;
        this.hName = hName;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    
    
    
    
}
