package com.cfs.BookMyShowBE.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_seats",uniqueConstraints = @UniqueConstraint(name = "uk_show_seat",columnNames = {"show_id","seatLabel"}))
public class ShowSeat {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Show show;


    @Getter
    private String seatLabel;

    @Getter
    private boolean reserved;

    public ShowSeat()
    {

    }

    public ShowSeat(Show show, String seatLabel) {
        this.show = show;
        this.seatLabel = seatLabel;
    }

    public void reserve()
    {
        reserved=true;
    }

    public void release()
    {
        reserved=false;
    }


}
