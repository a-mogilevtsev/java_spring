package com.example.MyBookShopApp.data.struct.payments;

import com.example.MyBookShopApp.data.struct.user.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "balance_transaction")
public class BalanceTransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id",columnDefinition = "INT", nullable = false)
    private UserEntity user;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime time;

    @Column(columnDefinition = "INT DEFAULT 0", nullable = false)
    private int value;

    @Column(name = "book_id", columnDefinition = "INT", nullable = false)
    private int bookId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
