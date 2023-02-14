package com.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.trip.dto.Wishlist;

@Mapper
public interface WishlistMapper {
	
	List<Wishlist> getWishlistAllList(@Param("custid") String custid);
	
	void addWishlist(Wishlist wishlist);

	void deleteByWid(Integer wid);
	

}
