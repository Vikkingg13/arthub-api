package com.github.vikkingg13.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class Art {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String filePath;
    private String title;
    private String description;
    private int countLike;
    private List<String> tag;

    @CreatedDate
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private Album album;

    @OneToMany(mappedBy = "art")
    private List<Comment> comment;
}
