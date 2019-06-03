package kr.or.ddit.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.service.IMemberService;
import kr.or.ddit.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberInfoMng {

	// Service객체 변수를 선언한다.
	private IMemberService memberService;

	public MemberInfoMng() {
		memberService = MemberServiceImpl.getInstance();
	}

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 자료 입력");
		System.out.println("  2. 자료 삭제");
		System.out.println("  3. 자료 수정");
		System.out.println("  4. 전체 자료 출력");
		System.out.println("  5. 회원정보 검색");
		System.out.println("  6. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do {
			displayMenu(); // 메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch (choice) {
			case 1: // 자료 입력
				insertMember();
				break;
			case 2: // 자료 삭제
				deleteMember();
				break;
			case 3: // 자료 수정
				updateMember();
				break;
			case 4: // 전체 자료 출력
				displayMemberAll();
				break;
			case 5: // 회원정보 검색
				searchMember();
				break;
			case 6: // 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		} while (choice != 6);
	}

	/**
	 * 회원정보를 검색하기 위한 메서드
	 * 검색할 회원ID, 회원이름, 전화번호, 주소 등을 입력하면
	 * 입력한 정보만 사용하여 검색하는 기능을 구현하시오.
	 * 주소는 입력한 값이 포함만 되어도 검색되도록 한다.
	 * 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
	 */
	private void searchMember() {
		scan.nextLine(); //버퍼비우기용
		
		System.out.println();
		System.out.println("검색할 회원정보를 입력하세요.");
		System.out.println("회원 ID >>");
		String memId = scan.nextLine().trim();
		
		System.out.println("회원 이름 >> ");
		String memName = scan.nextLine().trim();
		
		System.out.println("회원 전화번호 >> ");
		String memTel = scan.nextLine().trim();
		
		System.out.println("회원 주소 >> ");
		String memAddr = scan.nextLine().trim();
		
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);
		
		
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("ID      이름     전화번호     주소");
		System.out.println("-----------------------------------");

		//입력한 정보로 검색한 내용을 출력하는 부분
		List<MemberVO> memList = memberService.getSearchMember(mv);
		
		for(MemberVO temMv : memList) {
			
			System.out.println(temMv.getMem_id() + "     " + temMv.getMem_name() + "    " + temMv.getMem_tel() + "     " + temMv.getMem_addr()+ "      ");
			System.out.println("-----------------------------");
		}
		
	}

	private void deleteMember() {
		System.out.println();
		System.out.println("삭제 할 회원ID를 입력하세요 >> ");
		String memId = scan.next();
		
		int cnt = memberService.deleteMember(memId);
			if (cnt > 0) {
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
		String memId = ""; // 회원아이디

		do {
			System.out.println("수정할 회원 ID를 입력하세요 >> ");
			memId = scan.next();

			chk = chkMemberInfo(memId);
			if (chk == false) {
				System.out.println(memId + "회원은 없는 회원입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력해 주세요.");
			}
		} while (chk == false);

		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("새로운 회원 이름 >> ");
		String memName = scan.next();

		System.out.println("새로운 회원 전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 버퍼 지우기
		System.out.println("새로운 회원 주소 >> ");
		String memAddr = scan.nextLine();
		
		MemberVO mv = new MemberVO();
		mv.setMem_id(memId);
		mv.setMem_name(memName);
		mv.setMem_tel(memTel);
		mv.setMem_addr(memAddr);

		int cnt = memberService.updateMember(mv);
		if (cnt > 0) {
			System.out.println(memName + " 회원의 정보를 수정했습니다.");
		} else {
			System.out.println(memName + " 회원의 정보를 수정하는데 실패하였습니다.");
		}
	}

	/**
	 * 회원정보를 등록하는 메서드
	 */
	private void insertMember() {
		boolean chk = false;
		String memId = "";
		int cnt = 0; //데이터가 등록된 건 수
		
		do {
			System.out.println();
			System.out.println("추가할 회원 정보를 입력하세요.");
			System.out.println("회원 ID >> ");
			memId = scan.next();
			chk = chkMemberInfo(memId);
			
			if(chk) {
				System.out.println("회원ID가 " + memId + "인 회원이 이미 존재합니다.");
				System.out.println("다시 입력해 주세요.");
			}
		}while(chk);
		
			System.out.println("회원 이름 >> ");
			String memName = scan.next();
			
			System.out.println("회원 전화번호 >> ");
			String memTel = scan.next();
			
			scan.nextLine(); //버퍼 지우기
			System.out.println("회원 주소 >> ");
			String memAddr = scan.nextLine();
			
			MemberVO mv = new MemberVO();
			mv.setMem_id(memId);
			mv.setMem_name(memName);
			mv.setMem_tel(memTel);
			mv.setMem_addr(memAddr);
		
			cnt = memberService.insertMember(mv); //회원정보 등록
			
			if(cnt > 0) {
				System.out.println(memId + "회원 추가 작업 성공!");
			}else {
				System.out.println(memId + "회원 추가 작업 실패!");
			}
		}

	/**
	 * 회원아이디를 이용하여 해당 회원정보가 존재하는지 체크하는 메서드
	 * 
	 * @param memId
	 * @return
	 */
	private boolean chkMemberInfo(String memId) {
		return memberService.chkMemberInfo(memId);
	}

	private void displayMemberAll() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("ID      이름     전화번호     주소");
		System.out.println("-----------------------------------");

		List<MemberVO> memList = memberService.getAllMemberList();
		
		for(MemberVO mv : memList) {
			
			System.out.println(mv.getMem_id() + "     " + mv.getMem_name() + "    " + mv.getMem_tel() + "     " + mv.getMem_addr()+ "      ");
		}
		System.out.println("-----------------------------");
		System.out.println("출력작업 끝.");
	}

	public static void main(String[] args) {
		MemberInfoMng memObj = new MemberInfoMng();
		memObj.start();
	}

}
