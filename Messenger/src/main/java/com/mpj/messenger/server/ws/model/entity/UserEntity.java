package com.mpj.messenger.server.ws.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "User")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 8 , max = 11)
    @Column(nullable = false)
    private String password;


    private String encryptedPassword;

    @Column(nullable = false , unique = true)
    private String userName;

    @Column( length = 20)
    private String firstName;

    @Column( length = 20)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;


    private String photoLink;

    @OneToMany(mappedBy = "publisher" )
    @ToString.Exclude
    private List<MessageEntity> sendMessages = new ArrayList<>();

    @ManyToMany(mappedBy = "admins" )
    @ToString.Exclude
    private List<ChannelEntity> adminChannel = new ArrayList<>();

    @ManyToMany(mappedBy = "subscribers" )
    @ToString.Exclude
    private List<ChannelEntity> subscriberChannel = new ArrayList<>();

    @ManyToMany(mappedBy = "members" )
    @ToString.Exclude
    private List<GroupEntity> memberGroup = new ArrayList<>();

    @ManyToMany(mappedBy = "users" , fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<PVEntity> pvs  = new ArrayList<>();

    public UserEntity(String password, String userName, String firstName, String lastName, String email, String phoneNumber) {
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
