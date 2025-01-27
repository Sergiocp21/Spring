package org.spring.autowired.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data //Getters setters y toString
@Component
public class Door {
    private int id = 1;
}
