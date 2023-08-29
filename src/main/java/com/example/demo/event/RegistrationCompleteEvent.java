package com.example.demo.event;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {
    private User user;
    private String applicationUrl;
    private String email;

    public RegistrationCompleteEvent(User user, String applicationUrl, String email) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
        this.email = email;
    }
}
