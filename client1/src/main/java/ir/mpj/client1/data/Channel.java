package ir.mpj.client1.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Channel extends Chat {

    private List<User> admins = new ArrayList<>();

    private List<User> subscribers = new ArrayList<>();

}
