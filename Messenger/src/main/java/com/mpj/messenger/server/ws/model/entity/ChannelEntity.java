package com.mpj.messenger.server.ws.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ChannelEntity extends ChatEntity{

    @ManyToMany
    @JoinTable(name = "channel_admin",
            joinColumns = {@JoinColumn(name = "channel_id")},
            inverseJoinColumns = {@JoinColumn(name = "admin_id")}
    )
    private List<UserEntity> admins = new ArrayList<>();


    @ManyToMany
    @JoinTable(name = "channel_subscriber" ,
            joinColumns = {@JoinColumn(name = "channel_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "subscriber_id")}
    )
    private List<UserEntity> subscribers = new ArrayList<>();

}
