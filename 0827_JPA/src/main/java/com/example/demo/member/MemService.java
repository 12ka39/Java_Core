package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.BoardDto;

@Service
public class MemService {
	
	@Autowired
	private MemberDao dao;
	
	//	 save()  멤버 추가, 수정: 모든 컬럼 수정 (한 컬럼만 수정하면 다른 건 null이 되니까 그 부분은 코드를 짜야 함..)
	/* 이건 다른 데서 가져온 건데 대충 이런 식
	 		BoardDto ob = service.getBoard(b.getNum()); // 원본 글 검색해서
			ob.setTitle(b.getTitle()); // 수정할 정보 타이틀, 내용(content)만 수정
			ob.setContent(b.getContent());
			service.saveBoard(ob);
	 */
	
	// dao에 save()라는 함수가 정의되어 있어서 알아서 실행된다
	
	public MemberDto saveMem(MemberDto dto) {
		Member entity = dao.save(new Member(dto.getId(), dto.getPwd(), dto.getName(), dto.getEmail(), dto.getType()));
		// 화면 view단에 나타낼 필요 없고, db에 저장만 할 거면 여기까지만 쓰고 return 타입 없음...
		
		return new MemberDto(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
	}
	
	
	//회원 1명 조회
	public MemberDto getMem(String id) {
		Member entity = dao.findById(id).orElse(null);
		if(entity !=null) {
			return new MemberDto(entity.getId(), entity.getPwd(), entity.getName(), entity.getEmail(), entity.getType());
		}
		return null;
	}

	public void delMem(String id) {
		dao.deleteById(id);
	}

}
