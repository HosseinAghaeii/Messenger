package com.mpj.messenger.server.ws.model.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Chat")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class ChatEntity  implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false , length = 30)
    private String name;


    @OneToMany(mappedBy = "consumer")
    private List<MessageEntity> receiveMessagesIds = new ArrayList<>();


}
