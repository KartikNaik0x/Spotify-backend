package com.kartik.wishlist.controller;

import com.kartik.wishlist.exception.AuthorizationException;
import com.kartik.wishlist.feign.AuthClient;
import com.kartik.wishlist.model.WishlistItem;
import com.kartik.wishlist.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@RestController
@RequestMapping("/wishlist")
//@CrossOrigin("http://localhost:4200")
public class WishlistController {

    private final WishlistService wishlistService;

    @Autowired
    AuthClient client;

    @Autowired
    AuthorizationException exp;
    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/items")
    public ResponseEntity<?> getAllItems()  {

            List<WishlistItem> wishlistItems = wishlistService.getAllItems();
            return new ResponseEntity<>(wishlistItems, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<?> addItemToWishlist(@RequestBody WishlistItem wishlistItem ) {

            WishlistItem wishlistItem1= wishlistService.addItem(wishlistItem);
            return new ResponseEntity<>(wishlistItem1, HttpStatus.OK);


    }

    @GetMapping("/items/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable String userId) {

            List<WishlistItem> wishlistItems= wishlistService.getByUserId(userId);
            return new ResponseEntity<>(wishlistItems,HttpStatus.OK);


    }

}
