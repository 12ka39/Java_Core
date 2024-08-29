package com.example.demo.article;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao dao;

	// 글 작성, 수정
	public ArticleDto saveArticle(ArticleDto dto) {
		Article entity = dao.save(new Article(dto.getNum(), dto.getWriter(), dto.getWdate(), dto.getTitle(),
				dto.getContent(), dto.getData(), dto.getCnt()));
		return new ArticleDto(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(),
				entity.getContent(), entity.getData(), entity.getCnt(), null);
	}		

	// 글목록
	public ArrayList<ArticleDto> getAll() {
		List<Article> l = dao.findAll();
		ArrayList<ArticleDto> list = new ArrayList<ArticleDto>();
		for (Article entity : l) {
			list.add(new ArticleDto(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(),
					entity.getContent(), entity.getData(), entity.getCnt(), null));
		}
		return list;
	}
	
	
	//번호로 검색   
	public ArticleDto getArticle(int num) {
		Article entity = dao.findById(num).orElse(null); // orElse(null) 이거 자꾸 빼먹는다
		if (entity != null) {
			return new ArticleDto(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(),
					entity.getContent(), entity.getData(), entity.getCnt(), null);
		}
		return null;
	}
	
	
	//제목으로 검색
	public ArrayList<ArticleDto> getByTitle(String title) { //like패턴 검색
		ArrayList<Article> l = dao.findByTitleLike("%" + title + "%");
		ArrayList<ArticleDto> list = new ArrayList<ArticleDto>();
		for (Article entity : l) {
			list.add(new ArticleDto(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(),
					entity.getContent(), entity.getData(), entity.getCnt(), null));
		}
		return list;
	}

	
	
	// 자료 확장자로 검색  (jpg, png...)
	public ArrayList<ArticleDto> getByData(String data) {
		ArrayList<Article> l = dao.findByDataLike("%" + data); // 확장자는 항상 마지막에 끝나니까 data가 맨 마지막에 와야 한다
																						  // data 뒤에 like 패턴 붙일 필요 없음
		ArrayList<ArticleDto> list = new ArrayList<ArticleDto>();
		for (Article entity : l) {
			list.add(new ArticleDto(entity.getNum(), entity.getWriter(), entity.getWdate(), entity.getTitle(),
					entity.getContent(), entity.getData(), entity.getCnt(), null));
		}
		return list;
	}	
	
	
	
	//삭제
	public void delArticle(int num) {
		dao.deleteById(num);
	}
		
	//cnt 1증가
	public void editCnt(int num) {
		dao.updateCnt(num);
	}		
	
}
