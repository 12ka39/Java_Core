package com.example.demo.seller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.users.Users;
import com.example.demo.users.UsersDto;


@Service
public class SellerService {
	
	@Autowired
	private SellerDao dao;

	// 상품등록(상품번호, 상품명, 상품설명, 가격, 수량, 이미지)
	public void saveProduct(SellerDto dto) {
		Seller s = dao.save(new Seller(dto.getProNum(), dto.getWriter(), dto.getProName(), 
					dto.getProDescript(),dto.getProPrice(), dto.getProAmount(), dto.getProImg()));
	}
	

	
	// 상품번호로 검색
	public SellerDto getProduct(int num) {
		Seller s = dao.findById(num).orElse(null);
		if( s != null) {
			return new SellerDto(s.getProNum(), s.getWriter(), s.getProName(), s.getProDescript(), 
					s.getProPrice(), s.getProAmount(), s.getProImg(), null); // null은 데이터
		}
		return null;
	}
	

		
	// 내상품 정보수정(상품명, 상품설명, 가격, 이미지 수정)
	// 목록 가져와서??
	public SellerDto editProduct(SellerDto dto) {
		Seller s = dao.save(new Seller(dto.getProNum(), dto.getWriter(), dto.getProName(), 
				dto.getProDescript(),dto.getProPrice(), dto.getProAmount(), dto.getProImg()));
		
		if( s != null) {
			return new SellerDto(s.getProNum(), s.getWriter(), s.getProName(), s.getProDescript(),
					s.getProPrice(), s.getProAmount(), s.getProImg(), null);
		}
		return null;
}
	
	
	
	
	//내상품 상품삭제
	public void delProduct(int num) {
		dao.deleteById(num);
	}
	
	//내상품목록
	public SellerDto get() {
		List<Seller> s = dao.findAll();
		for( Seller seller : s ) {
			 SellerDto.add(new SellerDto(s.getProNum(), s.getWriter(), s.getProName(), s.getProDescript(),
					s.getProPrice(), s.getProAmount(), s.getProImg(), null));
			}
		}
		return null;
	}
	

	
}
