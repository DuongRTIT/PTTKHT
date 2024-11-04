/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Customer072  extends User072{
    private boolean member;
    
    public Customer072(int id, String name, String role, boolean Member) {
        super(id, name, role);
        this.member = Member;
    }
    
    public Customer072(String name){
        super(name);
    }

    public boolean isMember() {
        return member;
    }

    public void setTheThanhVien(boolean Member) {
        this.member = Member;
    }
}
