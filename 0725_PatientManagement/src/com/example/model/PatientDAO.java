package com.example.model;

import java.sql.SQLException;
import java.util.List;



// 인터페이스. 추상 메소드만 선언
public interface PatientDAO {

	boolean createPatient(PatientVO p) throws SQLException;
	/**
	 *새로운 환자를 등록한다. 이미 등록된 환자가 있다면 false를 리턴하고, (그래서 반환타입 boolean)
	 *등록에 성공하면 true를 리턴한다
	 *
	 *@param PatientVO
	 *@return 등록 성공하면 true, 그렇지 않으면 false
	 */
	

	

	PatientVO readPatient(int number);
	/**
	 * 환자 등록번호를 입력받아서 해당 번호의 환자 한 명을 리턴한다
	 * @param 환자 등록번호
	 * @return 해당 환자 1명
	 */
	
	
	List<PatientVO> readAllPatient();
	/**
	 * 지금까지 등록된 모든 환자 리스트를 반환한다
	 * @return 환자형 리스트
	 */	
	
	
	boolean updatePatient(PatientVO p);
	
	/**
	 * 수정할 환자정보를 입력받아서 수정 성공하면 true를 리턴하고 실패하면 false를 리턴한다
	 * @param 수정할 환자
	 * @return 성공여부
	 */	
	
	
	
	boolean deletePatient(int number);
	/**
	 * 환자 등록번호를 받아서 해당 환자를 삭제한다.
	 * @param 삭제할 환자 등록정보
	 * @return 성공여부
	 */	
}
