package com.kartik.wishlist.service;


import com.kartik.wishlist.model.WishlistItem;
import com.kartik.wishlist.repository.WishlistItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class WishlistServiceTest {
    @Mock
    private WishlistItemRepository wishlistItemRepository;
    @InjectMocks
    private WishlistService wishlistService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void getByUserId_Success() {
        // Mock repository response
        String userId = "user123";
        List<WishlistItem> expectedItems = Arrays.asList(new WishlistItem(), new WishlistItem());
        when(wishlistItemRepository.findByUserId(userId)).thenReturn(expectedItems);
        // Call service method
        List<WishlistItem> result = wishlistService.getByUserId(userId);
        // Verify repository method called and result
        verify(wishlistItemRepository).findByUserId(userId);
        assertEquals(expectedItems, result);
    }
    @Test
    void getAllItems_Success() {
        // Mock repository response
        List<WishlistItem> expectedItems = Arrays.asList(new WishlistItem(), new WishlistItem());
        when(wishlistItemRepository.findAll()).thenReturn(expectedItems);
        // Call service method
        List<WishlistItem> result = wishlistService.getAllItems();
        // Verify repository method called and result
        verify(wishlistItemRepository).findAll();
        assertEquals(expectedItems, result);
    }
    @Test
    void addItem_Success() {
        // Mock repository save response
        WishlistItem inputItem = new WishlistItem();
        WishlistItem expectedItem = new WishlistItem();
        when(wishlistItemRepository.save(inputItem)).thenReturn(expectedItem);
        // Call service method
        WishlistItem result = wishlistService.addItem(inputItem);
        // Verify repository method called and result
        verify(wishlistItemRepository).save(inputItem);
        assertEquals(expectedItem, result);
    }
}