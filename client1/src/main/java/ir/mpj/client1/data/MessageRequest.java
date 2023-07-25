package ir.mpj.client1.data;

import lombok.Data;

@Data
public class MessageRequest {

        private String publisherId;

        private String consumerId; // user - group - channel

        private String consumeType;

        private String body;
}
