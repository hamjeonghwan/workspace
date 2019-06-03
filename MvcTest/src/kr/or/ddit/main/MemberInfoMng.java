package kr.or.ddit.main;

import java.util.List;
import java.util.Scanner;
import kr.or.ddit.VO.MemberVO;
import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;



/*
	회원정보를 관리하는 프로그램을 작성하는데 
	아래의 메뉴를 모두 구현하시오. (CRUD기능 구현하기)
	(DB의 MYMEMBER테이블을 이용하여 작업한다.)
	
	* 자료 삭제는 회원ID를 입력 받아서 삭제한다.
	
	예시메뉴)
	----------------------
		== 작업 선택 ==
		1. 자료 입력			---> insert
		2. 자료 삭제			---> delete
		3. 자료 수정			---> update
		4. 전체 자료 출력	---> select
		5. 작업 끝.
	----------------------
	 
	   
// 회원관리 프로그램 테이블 생성 스크립트 
create table mymember(
    mem_id varchar2(8) not null,  -- 회원ID
    mem_name varchar2(100) not null, -- 이름
    mem_tel varchar2(50) not null, -- 전화번호
    mem_addr varchar2(128)    -- 주소
);

*/
public class MemberInfoMng {
	
	// Service 객체 변수를 선언한다
	private IMemberService memberService;
	private Scanner scan = new Scanner(System.in); 
	
	public MemberInfoMng() {
		memberService = new MemberServiceImpl();
		scan = new Scanner(System.in);
	}
	
	
	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu(){
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 작업 끝");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}
	
	/**
	 * 프로그램 시작메서드
	 */
	
	public void start(){
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 자료 입력
					insertMember();
					break;
				case 2 :  // 자료 삭제
					deleteMember();
					break;
				case 3 :  // 자료 수정
					updateMember();
					break;
				case 4 :  // 전체 자료 출력
					displayMemberAll();
					break;
				case 5 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=5);
	}
	/**
	 * 회원정보를 삭제하기 위한 메서드
	 */
	
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 ID를 입력하세요 >>");
		String memId = scan.next();
		
			int cnt = memberService.deletMember(memId);
			
			if(cnt > 0 ) {
				System.out.println(memId + "회원 정보 삭제 성공");
			} else {
				System.out.println(memId + "회원 정보 삭제 실패");

			}
	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	
	private void updateMember() {
		
		boolean chk = false;
		String memId = "";	//회원아이디
		int cnt = 0;
		
		do {
			System.out.print("수정할 회원 ID를 입력하세요 >> ");
			memId = scan.next();
			
			chk = chkMemberInfo(memId);
			if(chk == false) {
				System.out.println(memId + "회원은 없는 회원입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력해 주세요.");
			}
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("새로운 회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원 주소 >> ");
		String memAddr = scan.next();
		
			MemberVO mv =new MemberVO();
			mv.setMem_id(memId);
			mv.setMem_name(memName);
			mv.setMem_tel(memTel);
			mv.setMem_addr(memAddr);
			
			 cnt = memberService.updateMember(mv);
			
			if(cnt > 0) {
				System.out.println(memName + " 회원의 정보를 수정했습니다!");
			}else {
				System.out.println(memName + " 회원의 정보 수정에 실패했습니다!");
			}
	}

	/**
	 * 회원정보를 등록하는 메서드
	 */
	
	private void insertMember() {
			
		boolean chk = false;
		String memId = "";
		int cnt = 0; // 데이터가 등록된 건수
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.print("회원 ID >> ");
			memId = scan.next();
			
			chk = chkMemberInfo(memId);
			
			if(chk) {
				System.out.println("회원 ID " + memId + "인 회원이 이미 존재합니다.");
				System.out.println("다시 입력해 주세요.");
			}
		}while(chk);
		
		System.out.print("회원 이름 >> ");
		String memName = scan.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();	//버퍼지우기
		System.out.print("회원 주소 >> ");
		String memAddr = scan.next();
		
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		

			 cnt = memberService.insertMember(mv);
			 
			if(cnt > 0) {
				System.out.println(memName + "회원 추가 작업 성공!");
			}else {
				System.out.println(memName + "회원 추가 작업 실패!");
			}
		
	}
		
	

	/**
	 * 회원아이디를 이용하여 해당 회원정보가 존재하는지 체크하는 메서드
	 * @param memId
	 * @return
	 */
	
	private boolean chkMemberInfo(String memId) {
		return memberService.chkMemberInfo(memId);

	}

	private void displayMemberAll() {
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println(" ID       이름        전화번호        주소");
		System.out.println("---------------------------------------------------");
			List<MemberVO>memList = memberService.getAllMember();
			for(MemberVO mv : memList) {
				
		System.out.println(mv.getMem_id() + "      " 
				  + mv.getMem_name() + "      " 
		          + mv.getMem_tel() + "      " 
				  + mv.getMem_addr());
		System.out.println("---------------------------------------------------");
			}
		
			System.out.println("출력작업 끝...");
	}

	public static void main(String[] args) {
		MemberInfoMng memObj = new MemberInfoMng();
		memObj.start();
	}

}