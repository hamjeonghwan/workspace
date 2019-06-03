package kr.or.ddit.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

public class BoardInfoMng {

	// Service객체 변수를 선언한다.
	private IBoardService boardService;

	public BoardInfoMng() {
		boardService = BoardServiceImpl.getInstance();
	}

	private Scanner scan = new Scanner(System.in);

	/**
	 * 메뉴를 출력하는 메서드
	 */
	public void displayMenu() {
		System.out.println();
		System.out.println("----------------------");
		System.out.println("  === 작 업 선 택 ===");
		System.out.println("  1. 전체목록");
		System.out.println("  2. 새글작성");
		System.out.println("  3. 수정");
		System.out.println("  4. 삭제");
		System.out.println("  5. 검색");
		System.out.println("  0. 작업 끝.");
		System.out.println("----------------------");
		System.out.print("원하는 작업 선택 >> ");
	}

	/**
	 * 프로그램 시작메서드
	 */
	public void start() {
		int choice;
		do{
			displayMenu(); //메뉴 출력
			choice = scan.nextInt(); // 메뉴번호 입력받기
			switch(choice){
				case 1 :  // 전체목록
					displayBoardAll();
					break;
				case 2 :  // 새글작성
					insertBoard();
					break;
				case 3 :  // 글 수정
					updateBoard();
					break;
				case 4 :  // 글 삭제
					deleteBoard();
				case 5 :  // 글 검색
					searchBoard();
					break;
				case 0 :  // 작업 끝
					System.out.println("작업을 마칩니다.");
					break;
				default :
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
			}
		}while(choice!=6);
	}

	/**
	 * 회원정보를 검색하기 위한 메서드
	 * 검색할 회원ID, 회원이름, 전화번호, 주소 등을 입력하면
	 * 입력한 정보만 사용하여 검색하는 기능을 구현하시오.
	 * 주소는 입력한 값이 포함만 되어도 검색되도록 한다.
	 * 입력을 하지 않을 자료는 엔터키로 다음 입력으로 넘긴다.
	 */
	private void searchBoard() {
		scan.nextLine(); //버퍼비우기용
		
		boolean chk = false;
		int num = 0;
		
		do {
			System.out.print("검색할 글 번호를 입력 >> ");
			num = Integer.parseInt(scan.nextLine());
			System.out.println();
			
			chk = chkBoardInfo(num);
			
			if(!chk) {
				System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
			}
			
		}while(!chk);
		
		BoardVO bv = new BoardVO();
		bv.setBoard_no(num);
	
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("번호\t제목\t\t작성자\t작성날짜");
		System.out.println("-----------------------------------");

		//입력한 정보로 검색한 내용을 출력하는 부분
		List<BoardVO> boardList = boardService.getSearchBoard(bv);
		
		for(BoardVO temMv : boardList) {
			
			System.out.println(bv.getBoard_no() + "     " + bv.getBoard_title() + "    " + bv.getBoard_writer() + 
					"     " + bv.getBoard_date()+ "      ");
			System.out.println("-----------------------------");
		}
		
	}

	private void deleteBoard() {
		displayBoardAll();
		boolean chk = false;
		int num = 0;
		
		System.out.println();
		do {
			System.out.println("삭제 할 글의 번호를 입력하세요 >> ");
			num = scan.nextInt();
			scan.nextLine();
			System.out.println();
			
			chk = chkBoardInfo(num);
			
			if(!chk) {
				System.out.println("없는 글 번호입니다. 다시 입력해주세요.");
			}
			
			}while(!chk);
		
		int cnt = boardService.deleteBoard(num);
			if (cnt > 0) {
				System.out.println(num + "번 글 삭제 성공");
			} else {
				System.out.println(num + "번 글 삭제 실패");
			}
	}

	/**
	 * 회원정보를 수정하기 위한 메서드
	 */
	private void updateBoard() {
		displayBoardAll();
		int num = 0;
		boolean chk = false;
		String memId = ""; // 회원아이디

		do {
			System.out.println("수정할 글의 번호를 입력하세요 >> ");
			num= scan.nextInt();
			
			chk = chkBoardInfo(num);
			if(chk==false) {
				System.out.println(num + "번은 없는 게시글입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력해 주세요.");
			}
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("수정할 제목 >> ");
		String title = scan.next();
		
		System.out.println("수정할 내용 >> ");
		String content = scan.next();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(title);
		bv.setBoard_content(content);

		int cnt = boardService.insertBoard(bv);
		if (cnt > 0) {
			System.out.println(num + " 번의 글을 수정했습니다.");
		} else {
			System.out.println(num + " 번의 글을 수정하는데 실패하였습니다.");
		}
	}

	/**
	 * 회원정보를 등록하는 메서드
	 */
	private void insertBoard() {
		int num = 0;
		int cnt = 0; //데이터가 등록된 건 수
		
			System.out.println("작성할 새 글의 정보를 입력하세요.");
		
			System.out.println("제목 >> ");
			String title = scan.next();
			
			System.out.println("작성자 >> ");
			String writer = scan.next();
		
		
			scan.nextLine(); //버퍼 지우기
			System.out.println("내용 >> ");
			String content = scan.nextLine();
		
			
			BoardVO bv = new BoardVO();
			bv.setBoard_no(num);
			bv.setBoard_title(title);
			bv.setBoard_writer(writer);
			bv.setBoard_content(content);
		
			cnt = boardService.insertBoard(bv); //회원정보 등록
			
			if(cnt > 0) {
				System.out.println(title + " 글이 성공적으로 작성되었습니다!");
			}else {
				System.out.println(title + " 글 작성 실패!");
			}
		}

	/**
	 * 회원아이디를 이용하여 해당 회원정보가 존재하는지 체크하는 메서드
	 * 
	 * @param memId
	 * @return
	 */
	private boolean chkBoardInfo(int num) {
		return boardService.chkBoardInfo(num);
	}

	private void displayBoardAll() {
		System.out.println();
		System.out.println("------------------------------------");
		System.out.println("번호      제목     작성자     날짜");
		System.out.println("-----------------------------------");

		List<BoardVO> boardList = boardService.getAllBoardList();
		
		for(BoardVO bv : boardList) {
			
			System.out.println(bv.getBoard_no() + "     " + bv.getBoard_title() + "    " + bv.getBoard_writer() + 
					"     " + bv.getBoard_date()+ "      ");
		}
		System.out.println("-----------------------------");
		System.out.println("출력작업 끝.");
	}

	public static void main(String[] args) {
		BoardInfoMng boardObj = new BoardInfoMng();
		boardObj.start();
	}

}
