package org.spring.autowired.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getters setters y toString
@Component
public class Room {
    @Autowired
    private Window window;

    @Autowired
    private Door door;

}
