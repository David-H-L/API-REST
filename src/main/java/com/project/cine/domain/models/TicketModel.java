package com.project.cine.domain.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class TicketModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_ticket")
    private Long idTicket;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private int seatNumber;

    @Column(nullable = false)
    private LocalDate saleDate;

    @Column(nullable = false)
    private LocalTime saleTime;

    @ManyToOne
    @JoinColumn(name = "id_customer_fk", nullable = false)
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "id_movie_fk", nullable = false)
    private MovieModel movie;

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public LocalTime getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(LocalTime saleTime) {
        this.saleTime = saleTime;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }
}
