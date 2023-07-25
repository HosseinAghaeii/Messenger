package ir.mpj.client1.data;

import lombok.Data;

@Data
public class MessageDto {
    private long id;

    private User publisher;

    private Chat consumer; // user - group - channel

    private String consumerType;

    private String body;

    private String messageStatus;
}
