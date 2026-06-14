package com.app.ecom;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.fetchAllUsers(),HttpStatus.OK);
//        return ResponseEntity<>.ok(userService.fetchAllUsers());
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
//        if(userService.fetchUser(id) == null)return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(userService.fetchUser(id));

            return userService.fetchUser(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/api/users")
    public ResponseEntity<String > createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully") ;
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,@RequestBody User updatedUser){

        boolean updated  = userService.updateUser(id,updatedUser);
        if(updated)
            return ResponseEntity.ok("User updated successfully");
        return ResponseEntity.notFound().build();
    }






}
