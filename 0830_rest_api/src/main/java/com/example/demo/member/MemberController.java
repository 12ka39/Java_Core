package com.example.demo.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // rest-api는 모든 요청이 responsebody (ajax할 때 @ResponseBody가
// 다 붙어있다고 보면 된다)

 // 컨트롤러         -> 뷰페이지 전달
//  레스트 컨트롤러 -> json으로 전달 ----- 리턴값이 Map이고, Map에 JSON을 담아준다

@CrossOrigin(origins = "*") // 요청받을 ip주소 / * 모든 ip에서 요청 받겠다 - 보안상 불필요한 접근을 막으려고
@RequestMapping("/members")
public class MemberController {
	@Autowired
	private MemService service;
	
	//추가 POST
	@PostMapping("")
	public Map add(MemberDto m) {
		Map map = new HashMap();
		MemberDto m2 = service.saveMem(m);
		map.put("dto", m2); // dto란 이름으로 m2을 map에 저장
		
		return map;
	}
	
	//(PK로) 검색 GET
	@GetMapping("/{id}") //   /members/aaa
				//        /{id} 는  path variable  
	public Map get(@PathVariable("id") String id) { // {id} 값이 id란 이름으로 String id에 저장하는 코드
		Map map = new HashMap();
		MemberDto dto = service.getMem(id);
		map.put("dto", dto);
		
		return map; // 반환하는데 없으면 프론트에서 null 뜬다
	}

	
	//수정   --- PUT 전체 수정 --- 근데 여기선 비밀번호만 수정
	//포스트맨에서 put으로 요청방식 바꿔주고  주소는 /members  
	@PutMapping("")
	public Map edit(MemberDto m) {//id, 새pwd
		Map map = new HashMap();
		MemberDto old = service.getMem(m.getId());
		//pwd만 수정
		old.setPwd(m.getPwd());
		MemberDto m2 = service.saveMem(old);
		map.put("dto", m2);
		return map;
	}
	
	
	//삭제
	@DeleteMapping("/{id}")
	public Map delete(@PathVariable("id") String id) { // {id} 값이 id란 이름으로 String id에 저장하는 코드
		Map map = new HashMap();
		boolean flag = true;
		try { // try-catch 하라는 경고 안 떠도 처리결과 알려주는 코드 짜면 -> 프론트가 확인할 수 있다
			service.getMem(id);
		} catch (Exception e) {
			System.out.println(e);
			flag = false;
		}
		map.put("flag", flag);
		return map; // 결과는 true , false
	}
	
	
	
	// 로그인 (원래 토큰 주고 받아서 확인하는데 아직 안 배웠으니 flag로)
	@GetMapping("/login")
	public Map login(String id, String pwd) {
		Map map = new HashMap();
		boolean flag = false;
		MemberDto m = service.getMem(id);
		if(m !=null & m.getPwd().equals(pwd)) {
			flag = true;
			map.put("loginId", m.getId());
			map.put("type", m.getType());
		}
		
		// 프론트 단에서는 true, false로 로그인 여부 확인
		map.put("flag", flag); 
		return map;
	}
}
