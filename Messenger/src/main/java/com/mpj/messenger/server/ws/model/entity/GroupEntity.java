package com.mpj.messenger.server.ws.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class GroupEntity extends ChatEntity {

    @ManyToMany
    @JoinTable(name = "group_member" ,
            joinColumns = {@JoinColumn(name = "group_id")} ,
            inverseJoinColumns = {@JoinColumn(name = "member_id")}
    )
    private List<UserEntity> members = new ArrayList<>();
}
