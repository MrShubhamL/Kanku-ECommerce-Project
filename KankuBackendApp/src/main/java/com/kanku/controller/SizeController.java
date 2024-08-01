package com.kanku.controller;

import com.kanku.model.BatchProductSize;
import com.kanku.model.Size;
import com.kanku.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/size")
@CrossOrigin("*")
public class SizeController {

    @Autowired
    private ISizeService sizeService;

    @PostMapping("/addSize")
    public ResponseEntity<?> addSize(@RequestBody BatchProductSize batchProductSize){
        return ResponseEntity.ok(sizeService.addSize(batchProductSize));
    }

    @PostMapping("/getSizeByProductId")
    public  ResponseEntity<?> getProductSizeById(@RequestBody Size size){
        return ResponseEntity.ok(sizeService.getSizeByProductId(size));
    }
}
