package com.example.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getNames() {
        return List.of("ebihara", "yamada", "suzuki", "tanaka");
    }

    @PostMapping("/names")
    public ResponseEntity<String> createName(@RequestBody NameCreateForm nameCreateForm) {
        // 登録処理は割愛
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/names/id")
                .build()
                .toUri();

        return ResponseEntity.created(url).body("name successfully created");
    }
}
