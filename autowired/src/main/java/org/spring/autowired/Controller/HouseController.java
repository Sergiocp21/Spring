package org.spring.autowired.Controller;
import org.spring.autowired.components.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private House house;

    @GetMapping
    public ResponseEntity<House> getHouse() {
        return ResponseEntity.ok(house);
    }
}
