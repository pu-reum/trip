package com.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.dto.Wishlist;
import com.trip.mapper.WishlistMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class WishlistService {
	
	private final WishlistMapper wishlistMapper;
	
	public List<Wishlist> getWishlistAllList(String custid){
		return wishlistMapper.getWishlistAllList(custid);
	}
	
	public void addWishlist(Wishlist wishlist) {
		wishlistMapper.addWishlist(wishlist);
	}
	
	public void deleteByPdid(int pdid) {
		wishlistMapper.deleteByPdid(pdid);
	}
}
