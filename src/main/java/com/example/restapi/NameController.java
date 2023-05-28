package com.example.restapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class NameController {

    @GetMapping("/names")
    public List<String> getNames() {
        return List.of("ebihara", "yamada", "suzuki", "tanaka");
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> createName(@RequestBody NameCreateForm nameCreateForm) {
        // 登録処理は割愛
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080").path("/names/id")
                .build()
                .toUri();

        System.out.println("==================");
        System.out.println(nameCreateForm.getName());
        System.out.println(nameCreateForm.getAddress());
        System.out.println(nameCreateForm.getAge());
        System.out.println("===================");

        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> updateName(@PathVariable("id") int id, @RequestBody NameUpdateForm nameUpdateForm) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> deleteName(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleteed"));
    }

}
