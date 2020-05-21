package com.github.vikkingg13.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @CreatedDate
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "art_id")
    private Art art;
}
