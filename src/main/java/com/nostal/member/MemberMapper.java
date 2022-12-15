package com.nostal.member;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/*	@Mapper
	Interface를 매퍼로 등록하기 위해 사용 */
@Mapper
public interface MemberMapper {
	
	//	회원정보 조회
	@Select("SELECT * FROM member WHERE uid=#{uid}")
	MemberVO findMember(@Param("uid") String _uid);
	
	//	회원정보 전체 조회
	@Select("SELECT * FROM member")
	List<MemberVO> listMembers();
	
	//	회원 등록
	@Insert("INSERT INTO member VALUES "
			+ "(#{uid}, #{pwd}, #{uname}, #{birth}, #{email}, #{gender}, #{hobby}, CURRENT_DATE)")
	//	param = request.getParameter(), 한 개의 값을 전달하는 요청 매개변수 처리
	//	paramValues = request.getParameterValues(), 여러 개의 값을 전달하는 요청 매개변수 처리
	int addMember(	@Param("uid") String uid, 
					@Param("pwd") String pwd, 
					@Param("uname") String uname, 
					@Param("birth") Date birth, 
					@Param("email") String email, 
					@Param("gender") String gender, 
					@Param("hobby") String hobby);
	
	//	ID 중복여부 확인
	@Select("SELECT IF(COUNT(*) = 1, 'true', 'false') AS result FROM member WHERE uid=#{uid}")
	int overlappedID(@Param("uid") String uid);
	
	//	로그인
	@Select("SELECT PWD FROM member WHERE UID=#{uid}")
	int loginMember(@Param("uid") String uid);

	//	회원정보 수정
	@Update("UPDATE member SET pwd=#{pwd},birth=#{birth},email=#{email},hobby=#{hobby} "
			+ "WHERE uid=#{uid}")
	int modMember(	@Param("uid") String uid,
					@Param("pwd") String pwd,
					@Param("birth") Date birth,
					@Param("email") String email,
					@Param("hobby") String hobby);

	//	회원정보 삭제
	@Delete("DELETE FROM member WHERE uid=#{uid}")
	int delMember(@Param("uid") String uid);
}
