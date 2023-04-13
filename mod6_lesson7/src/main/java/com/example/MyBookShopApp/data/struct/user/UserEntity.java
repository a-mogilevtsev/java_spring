package com.example.MyBookShopApp.data.struct.user;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.book.review.BookReviewLikeEntity;
import com.example.MyBookShopApp.data.struct.book.review.MessageEntity;
import com.example.MyBookShopApp.data.struct.payments.BalanceTransactionEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String hash;

    @Column(name = "reg_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime regTime;

    @Column(columnDefinition = "INT", nullable = false)
    private int balance;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "book2user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<BookEntity> books;

    @OneToMany(mappedBy = "user")
    private Set<MessageEntity> messages;

    @OneToMany(mappedBy = "user")
    private Set<BookReviewLikeEntity> bookReviewLikes;

    @OneToOne(mappedBy = "user")
    private UserContactEntity userContact;

    @OneToOne(mappedBy = "user")
    private BalanceTransactionEntity balanceTransaction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public LocalDateTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalDateTime regTime) {
        this.regTime = regTime;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    public Set<BookReviewLikeEntity> getBookReviewLikes() {
        return bookReviewLikes;
    }

    public Set<MessageEntity> getMessages() {
        return messages;
    }

    public void setMessages(Set<MessageEntity> messages) {
        this.messages = messages;
    }

    public UserContactEntity getUserContact() {
        return userContact;
    }

    public BalanceTransactionEntity getBalanceTransaction() {
        return balanceTransaction;
    }

    public void setBalanceTransaction(BalanceTransactionEntity balanceTransaction) {
        this.balanceTransaction = balanceTransaction;
    }

    public void setUserContact(UserContactEntity userContact) {
        this.userContact = userContact;
    }

    public void setBookReviewLikes(Set<BookReviewLikeEntity> bookReviewLikes) {
        this.bookReviewLikes = bookReviewLikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
