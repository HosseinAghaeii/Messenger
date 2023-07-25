package com.mpj.messenger.server.ws.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Message")
public class MessageEntity  implements Serializable {

    @Id
    @GeneratedValue
    private long id ;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserEntity publisher;

    @ManyToOne
    @JoinColumn(name = "consumer_id")
    private ChatEntity consumer ; // user - group - channel

    @Column(nullable = false)
    private String consumerType;

    @Column(nullable = false)
    private String body;

}
