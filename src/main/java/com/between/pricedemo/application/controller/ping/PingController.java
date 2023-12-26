package com.between.pricedemo.application.controller.ping;

import com.between.pricedemo.application.controller.ping.response.EmptyResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @Operation(hidden = true)
    @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmptyResponse> ping() {
        return ResponseEntity.ok(new EmptyResponse());
    }

}
