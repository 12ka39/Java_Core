package com.example.demo.guestbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestbookService {
	@Autowired
	private GuestbookDao dao;
	
	//글 작성, 글 수정   
	// dao.save(): 방금 추가/수정 된 행을 entity에 담아서 반환
	public GuestbookDto saveBook(GuestbookDto dto) { //guestbook 클래스는 테이블 생성시에만
		//GuestbookDto로 입력받은 걸 Guestbook에 넣고
		Guestbook entity = dao.save(new Guestbook(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getPwd(), dto.getContent()));
		
		//Guestbook에 입력된 값을 GuestbookDto 타입으로 생성
		return new GuestbookDto(entity.getNum(), entity.getWriter() , entity.getWdate(), entity.getPwd(), entity.getContent());
	}
	
	
	//전체목록  - dao.findAll();
	public ArrayList<GuestbookDto> getAll(){
		ArrayList<Guestbook> l = (ArrayList<Guestbook>) dao.findAll(); //전체 검색
		ArrayList<GuestbookDto> list = new ArrayList<>(); 
		for(Guestbook entity : l) { // entity 하나씩 꺼내서 dto로 변환 후 list에 추가
			list.add(new GuestbookDto(entity.getNum(), entity.getWriter() , entity.getWdate(), entity.getPwd(), entity.getContent()));
		}
		return list;
	}
	
	
	//num 검색
	public GuestbookDto getBook(int num) {
		Guestbook entity = dao.findById(num).orElse(null); // 엔터티로 반환 -> 
		if(entity != null) { // 검색된 결과가 null이 아니면 
			return new GuestbookDto(entity.getNum(), entity.getWriter() , entity.getWdate(), entity.getPwd(), entity.getContent()); // dto로 반환
		}
		return null; // 검색 결과가 null이면 null 반환
	}
	
	
	//삭제  - dao.deleteById(num);
	public void delBook(int num) {
		dao.deleteById(num); // 반환값 없음
	}
	
	
	//사용자 정의
	//service에 getByWriter() 구현
	public ArrayList<GuestbookDto> getByWriter(String writer){
		ArrayList <Guestbook> l = dao.findByWriter(writer); // 엔터티 arrayList 반환
		ArrayList<GuestbookDto> list = new ArrayList<>(); 
		for(Guestbook entity : l) { // entity 하나씩 꺼내서 dto로 변환 후 list에 추가
			list.add(new GuestbookDto(entity.getNum(), entity.getWriter() , entity.getWdate(), entity.getPwd(), entity.getContent()));
		}
		return list;
	}
	
	
}
