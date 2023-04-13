package com.example.MyBookShopApp.data.struct.user;


import com.example.MyBookShopApp.data.struct.enums.ContactType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_contact")
public class UserContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", columnDefinition = "INT", nullable = false, referencedColumnName = "id")
    private UserEntity user;

    private ContactType type;

    @Column(columnDefinition = "SMALLINT", nullable = false)
    private short approved;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String code;

    @Column(name = "code_trails", columnDefinition = "INT")
    private int codeTrails;

    @Column(name = "code_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime codeTime;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public short getApproved() {
        return approved;
    }

    public void setApproved(short approved) {
        this.approved = approved;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCodeTrails() {
        return codeTrails;
    }

    public void setCodeTrails(int codeTrails) {
        this.codeTrails = codeTrails;
    }

    public LocalDateTime getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(LocalDateTime codeTime) {
        this.codeTime = codeTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
