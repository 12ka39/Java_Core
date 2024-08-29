package com.example.demo.product;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/prod")
public class ProductController {
	@Autowired
	private ProductService service;
	
	//${spring.servlet.multipart.location}은 애플리케이션 설정 파일에 정의된 특정 속성의 값을 참조
	@Value("${spring.servlet.multipart.location}") 
	private String path; // path = C:\shopimg


	@GetMapping("/add")
	public void addForm() {
	}

	
	
	@PostMapping("/add")
	public String add(ProductDto dto) { // 파라미터로 넘어온 dto에는 파일(file) 의 정보가 안 들어있다. 그래서 코드에서 추가
		//dto : name, price, amount, f, seller
		
		
		//newData - num, name, price, amount, seller  (입력돼서 상품번호PK가 만들어진다. PK가 필요함)
		ProductDto newData = service.saveProd(dto); // insert  <- file 없는 채로 일단 insert하고 
		//방금 추가된 dto를 newData에 저장, 
		// 근데 DB에는 f가 안 들어간다. (아예 변수가 없음) Dto만 f변수에 저장
		//그래서 DB에는 이미지 경로(img)를 넣어줘야 한다
		String fname = dto.getF().getOriginalFilename(); // 원본 파일명 가져와서
			// f는  dto의 멤버변수라 
		fname = newData.getNum() + fname; // 파일명에 상품번호(PK) + 파일명 
		File newf = new File(path +  fname); 

		try {
			dto.getF().transferTo(newf); // 업로드 파일을 newf에 복사
			newData.setImg(fname); // 파일명을 저장
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		service.saveProd(newData);//update
		return "redirect:/prod/list";
	}
	

	
	@RequestMapping("/list")
	public void list(Model m, HttpSession session) {
		String type = (String) session.getAttribute("type");
		String loginId = (String) session.getAttribute("loginId");
		ArrayList<ProductDto> list = null;
		if (type.equals("판매자")) { // session에 있는 회원 타입이 판매자일 때만
			list = service.getBySeller(loginId); // 자기 판매상품 목록 보이도록
		} else {
			list = service.getAll();
		}
		m.addAttribute("list", list);
	}
	
	
	@GetMapping("/read-img") // 이미지를 화면에 띄워달라고 요청 들어옴
	
	// <img th:src="@{/prod/read-img(fname=${p.img})}"  
	public ResponseEntity<byte[]> read_img(String fname) { // fname은 파라미터 담겨서 넘어왔음
		//ResponseEntity  바이너리 배열 값을 몸체로 보내는 클래스
		//응답으로 byte배열에 이미지 파일을 담아 보낸다
		ResponseEntity<byte[]> result = null;  
		File f = new File(path +  fname); // path는 맨 위에 전역변수로 있음
		// 응답 헤더 정보 저장 객체
		HttpHeaders header = new HttpHeaders();
		try {
			// 전송하는 데이터의 마임 타입 설정
			header.add("Content-Type", Files.probeContentType(f.toPath()));
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
				//ResponseEntity에 이런저런 정보를 넣어줌....    바이로 사용할 파일 내용,   위에서 생성한 헤더,  현재 처리 상태 넣어서 생성
				// 이 이미지 엔터티 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	
	
	@GetMapping("/detail")
	public void detail(int num, Model m) {
		m.addAttribute("p", service.getProd(num));  
	}
	
	
	//text 수정
	@PostMapping("/edit")
	public String edit(ProductDto dto, Model m) {
		ProductDto dto2 = service.getProd(dto.getNum()); // 일단 num으로 검색해서 그 결과를 가져와서
		dto2.setName(dto.getName()); // 이름, 가격, 양 수정
		dto2.setPrice(dto.getPrice()); 
		dto2.setAmount(dto.getAmount());
		service.saveProd(dto2);
		
		return "redirect:/prod/list";
		
	}
	
	
	//img 수정
	//DB에 경로는 바로바로 변경이 되는데, 파일 데이터는 dto에 이는 거라 삭제하고 새로 입력해줘야 함
	
	@PostMapping("/edit-img") // 이미지 수정 요청
	public String editImg(MultipartFile f, int num) { // 멀티파트파일과  상품번호를 파라미터로 받는다
		
		//이미지 변경할 상품을 검색해서 전체 정보를 불러옴
		ProductDto prod = service.getProd(num); // 상품 번호로 검색해서
		
		//삭제할 원본 이미지 경로를 변수에 저장
		String delFileName = path + prod.getImg(); // 삭제할 파일 경로
		System.out.println("delFileName" + delFileName);
		
		// 삭제할 파일의 파일 객체를 생성 
		File delFile = new File(delFileName); // 이건 실제로 파일이 생기는게 아니라, 
			// 파일 정보를 담은 무언가다
		
		// delete() 파일 삭제 메서드 
		delFile.delete(); //원본 파일 삭제
		
		
		// 새로 올라온 파일의 원 파일명 저장
		String fname = f.getOriginalFilename();
		
		//중복을 막기 위해 원본 파일명 앞에 상품번호를 붙임
		fname = prod.getNum() + fname;
		
		//서버에 복사할 새 파일 생성 (이제 여기다가 데이터 넣을 거다)
		File newf = new File(path + fname);
		
		try {
			
			//올라온 파일의 내용을 생성한 새 파일에 복사
			f.transferTo(newf);
			
			//변경된 이미지 경로를 수정 객체에 저장
			prod.setImg(fname);
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//save()로 db에서 수정
		service.saveProd(prod);
		
		
		//수정한 상세 페이지로 이동
		return "redirect:/prod/detail?num="+num ; 
	}
	
	
}