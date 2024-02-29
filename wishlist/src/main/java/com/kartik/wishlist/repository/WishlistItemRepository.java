package com.kartik.wishlist.repository;

import com.kartik.wishlist.model.WishlistItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author {2095949}
 * @Date {05-12-2023}
 */
@Repository
public interface WishlistItemRepository extends MongoRepository<WishlistItem,String> {
    List<WishlistItem> findByUserId(String userId);
}
