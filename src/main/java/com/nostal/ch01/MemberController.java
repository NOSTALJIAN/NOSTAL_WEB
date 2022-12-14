package com.nostal.ch01;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*	@RestController는 Data를 반환하기 위해 사용
	@Controller는 view를 반환하기 위해 사용
	@RestController == @Controller + @ResponseBody */
@RestController
/*	들어온 요청을 특정 method와 매핑
	@GetMapping("URL")
	@PostMapping("URL")
	@PutMapping("URL")
	@DeleteMapping("URL")
	공통 URL은 class에 @RequestMapping으로 설정하고
	요청 method 별로 URL을 설정 후 사용도 가능 */
//@RequestMapping("/nostal/*")
public class MemberController {
	
	private MemberMapper mapper;
	public MemberController() { super(); }
	
	//	회원정보 조회
	@GetMapping("/member/{uid}")		//	localhost:8080/member/uid
	public MemberVO findMember(@PathVariable("uid") String uid) {
		return mapper.findMember(uid);
	}
	
	//	회원정보 전체 조회
	@GetMapping("/member/all")
	public List<MemberVO> listMembers() {
		return mapper.listMembers();
	}
	
	//	회원정보 수정
	@PutMapping("/member/{uid}")
	/*	@PathVariable은 Type2의 URL을 처리할 때 사용(각 구분자에 들어오는 값)
	 	여기서는 /member 뒤에 오는 {uid}에 들어오는 값을 처리 */
	public void modMember(@PathVariable("uid") String uid,
	/*	@RequestParam -> 매개변수가 A면 그 값을 변수 A에 자동으로 설정
	 	@RequestParam("실제값") String 설정할 변수 이름
	 	URL 뒤에 붙는 파라미터의 값을 가져올 때 사용
	 	
	 	여기선 /member/{uid}?uid={uid}의 데이터를 가져옴 */
				@RequestParam("uid") String name,
				@RequestParam("pwd") String pwd,
				@RequestParam("uname") String uname, 
				@RequestParam("birth") Date birth, 
				@RequestParam("email") String email, 
				@RequestParam("gender") String gender, 
				@RequestParam("hobby") String hobby,
				@RequestParam("joinDate") LocalDate joinDate) {
		mapper.modMember(uid, pwd, birth, email, hobby);
	}
	
	//	회원정보 등록
	@PutMapping("/member/{uid}")
	public void addMember(@PathVariable("uid") String uid,
			@RequestParam("uid") String name,
			@RequestParam("pwd") String pwd,
			@RequestParam("uname") String uname, 
			@RequestParam("birth") Date birth, 
			@RequestParam("email") String email, 
			@RequestParam("gender") String gender, 
			@RequestParam("hobby") String hobby,
			@RequestParam("joinDate") LocalDate joinDate) {
		mapper.addMember(uid, pwd, uname, birth, email, gender, hobby);
	}
	
	//	회원정보 삭제
	@DeleteMapping("/member/{uid}")
	public void delMember(@PathVariable("uid") String uid) {
		mapper.delMember(uid);
	}
	
	//	ID 중복여부 확인
	@PutMapping("/member/{uid")
	public void overlappedID(@PathVariable("uid") String uid,
			@RequestParam("uid") String name) {
		mapper.overlappedID(uid);
	}
	
	//	로그인
	@PutMapping("/member/{uid")
	public void loginMember(@PathVariable("uid") String uid,
			@RequestParam("uid") String name,
			@RequestParam("pwd") String pwd) {
		mapper.loginMember(uid);
	}
}
