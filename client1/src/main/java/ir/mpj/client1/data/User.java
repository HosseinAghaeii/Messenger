package ir.mpj.client1.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.mpj.client1.data.Channel;
import ir.mpj.client1.data.Group;
import ir.mpj.client1.data.Message;
import ir.mpj.client1.data.PV;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class User implements Serializable {

    private long id;
    private String password;


    private String encryptedPassword;

    private String userName;


    private String firstName;


    private String lastName;


    private String email;


    private String phoneNumber;

    private String photoLink;


    private List<Message> sendMessages = new ArrayList<>();


    private List<Channel> adminChannel = new ArrayList<>();


    private List<Channel> subscriberChannel = new ArrayList<>();


    private List<Group> memberGroup = new ArrayList<>();


    private List<PV> pvs  = new ArrayList<>();

    public User(String password, String userName, String firstName, String lastName, String email, String phoneNumber) {
        this.password = password;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
