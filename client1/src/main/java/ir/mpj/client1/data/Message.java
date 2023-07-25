package ir.mpj.client1.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private long id ;

    private User publisher;

    private Chat consumer ; // user - group - channel

    private String consumerType;

    private String body;

    private String messageStatus;

}
