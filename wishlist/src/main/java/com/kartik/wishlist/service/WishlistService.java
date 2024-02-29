package com.kartik.wishlist.service;

import com.kartik.wishlist.model.WishlistItem;
import com.kartik.wishlist.repository.WishlistItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */

@Service
public class WishlistService {
    private final WishlistItemRepository wishlistItemRepository;

    public WishlistService(WishlistItemRepository wishlistItemRepository) {
        this.wishlistItemRepository = wishlistItemRepository;
    }

    public List<WishlistItem> getByUserId(String userId){
        return wishlistItemRepository.findByUserId(userId);
    }

    public List<WishlistItem> getAllItems(){
        return wishlistItemRepository.findAll();
    }

    public WishlistItem addItem(WishlistItem wishlistItem){
        wishlistItem.setId(null);
        return wishlistItemRepository.save(wishlistItem);
    }
}
