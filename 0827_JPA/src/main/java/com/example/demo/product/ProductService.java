package com.example.demo.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.member.Member;

@Service
public class ProductService {
	@Autowired
	private ProductDao dao;
	
	//등록, 수정 : save()
	public ProductDto saveProd(ProductDto dto) {
		Product entity = dao.save(new Product(dto.getNum(), dto.getName(), 
				dto.getPrice(), dto.getAmount(), dto.getSeller(), dto.getImg()));	
		
		return new ProductDto(entity.getNum(), entity.getName(), 
				entity.getPrice(), entity.getAmount(), entity.getSeller(), entity.getImg(), null);
		//null이 생긴 이유. 지금 Dto에만   private MultipartFile f; 변수가 있다. 그래서 null이 추가됨
	}
	
	
	
	//상품 번호로 검색 : findById(num).orElse(null)
	public ProductDto getProd(int num) {
		Product entity = dao.findById(num).orElse(null); // .orElse(null 이거 안 적어주면 오류
		if (entity != null) {
			return new ProductDto(entity.getNum(), entity.getName(), entity.getPrice(), entity.getAmount(),
					entity.getSeller(), entity.getImg(), null);
		}
		return null;
	}	

	
	//전체 목록
	public ArrayList<ProductDto> getAll() {
		List<Product> l = dao.findAll();
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for (Product entity : l) {
			list.add(new ProductDto(entity.getNum(), entity.getName(), entity.getPrice(), entity.getAmount(),
					entity.getSeller(), entity.getImg(), null));
		}
		return list;
	}

	
	//삭제 : deleteById(num)
	public void delete(int num) {
		dao.deleteById(num);
	}
	
	
	//판매자로 검색
	public ArrayList<ProductDto> getBySeller(String seller) {
		List<Product> l = dao.findBySeller(new Member(seller, "", "", "", ""));
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for (Product entity : l) {
			list.add(new ProductDto(entity.getNum(), entity.getName(), 
					entity.getPrice(), entity.getAmount(),
					entity.getSeller(), entity.getImg(), null));
		}
		return list;
	}

//	가격대로 검색
	public ArrayList<ProductDto> getByPrice(int p1, int p2) {
		List<Product> l = dao.findByPriceBetween(p1, p2);
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for (Product entity : l) {
			list.add(new ProductDto(entity.getNum(), entity.getName(), entity.getPrice(), entity.getAmount(),
					entity.getSeller(), entity.getImg(), null));
		}
		return list;
	}

//	상품명으로 검색
	public ArrayList<ProductDto> getByName(String name) {
		List<Product> l = dao.findByNameLike("%" + name + "%");
		ArrayList<ProductDto> list = new ArrayList<ProductDto>();
		for (Product entity : l) {
			list.add(new ProductDto(entity.getNum(), entity.getName(), entity.getPrice(), entity.getAmount(),
					entity.getSeller(), entity.getImg(), null));
		}
		return list;
	}
	
}
