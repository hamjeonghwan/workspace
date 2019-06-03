package kr.or.ddit.main;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.VO.BoardVO;
import kr.or.ddit.service.BoardServiceImpl;
import kr.or.ddit.service.IBoardServe;

public class BoardInfoMng {

	private IBoardServe boardService;
	private Scanner scan = new Scanner(System.in);
	
	public BoardInfoMng() {
		boardService = new BoardServiceImpl();
	}
	
	public void displayMenu() {
		System.out.println("------------------------------------------");
		System.out.println("                게시판");
		System.out.println("1.전체목록출력\t 2.새글작성\t 3.수정\t 4.삭제\t 5.검색\t 6.종료");
		System.out.println("------------------------------------------");
		System.out.print("메뉴 선택 >> ");
	}
	
	private void start() {
		int inp;
		do {
			displayMenu();
			inp = Integer.parseInt(scan.nextLine());
			switch(inp) {
			case 1: //전체목록출력
				displayBoard();
				break;
			case 2: //새글작성
				insertBoard();
				break;
			case 3: //수정
				updateBoard();
				break;
			case 4: //삭제
				deleteBoard();
				break;
			case 5: //검색
				searchBoard();
				break;
			case 6: //종료
				System.out.println("작업을 마칩니다.");
				break;
			default : 
				System.out.println("번호 잘못 입력하셨습니다");
			}
		}while(inp != 6);
	}

	private void searchBoard() {
		System.out.println();
		int bNum = 0;
		boolean chk = false;
		
		do {
			System.out.println("검색할 게시물의 nember를 입력하세요 >> ");
			bNum = Integer.parseInt(scan.nextLine());
			chk = chkBoardInfo(bNum);
			if(chk == false) {
				System.out.println(bNum + "게시글은 없는 게시글입니다.");
				System.out.println("검색할 자료가 없으니 다시 입력해주세요.");
			}
		}while(chk == false);
		
		List<BoardVO> bdList = boardService.getSearchList(bNum);
		
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜\t내용");
		System.out.println("------------------------------------------------");
		
		for(BoardVO bv : bdList) {
			System.out.println(bv.getBoard_num() + "\t" + bv.getBoard_title() + "\t" +
					bv.getBoard_writer() + "\t" + bv.getBoard_date() + "\t" +
					bv.getBoard_content());
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("출력작업 끝...");
	}

	private void deleteBoard() {
		System.out.println();
		System.out.println("삭제할 게시물No를 입력하세요 >> ");
		int bdNum = Integer.parseInt(scan.nextLine());
		
		int cnt = boardService.deleteBoard(bdNum);
		
		if(cnt > 0) {
			System.out.println(bdNum + "번 게시물 삭제 성공...");
		}else {
			System.out.println(bdNum + "번 게시물 삭제 실패!!!");
		}
		
	}

	private void updateBoard() {
		boolean chk = false;
		int bdNum = 0; //게시글 번호
		
		do {
			System.out.println("수정할 게시글 번호를 입력하세요 >> ");
			bdNum = Integer.parseInt(scan.nextLine());
			chk = chkBoardInfo(bdNum);
			if(chk == false) {
				System.out.println(bdNum + "게시글은 없는 게시글입니다.");
				System.out.println("수정할 자료가 없으니 다시 입력해주세요.");
			}
		}while(chk == false);
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.println("수정할 제목 >>");
		String bTitle = scan.next();
		scan.nextLine();
		System.out.println("수정할 내용");
		String bContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(bTitle);
		bv.setBoard_content(bContent);
		
		int cnt = boardService.updateBoard(bv);
		
		if(cnt > 0) {
			System.out.println(bdNum + "번 게시물을 수정했습니다");
		}else {
			System.out.println(bdNum + "번 게시물 수정에 실패!!!");
		}
		
	}

	private void insertBoard() {
		System.out.println("제목 >> ");
		String bTitle = scan.next();
		System.out.println("작성자 >> ");
		String bWriter = scan.next();
		scan.nextLine();
		System.out.println("내용 >> ");
		String bContent = scan.nextLine();
		
		BoardVO bv = new BoardVO();
		bv.setBoard_title(bTitle);
		bv.setBoard_writer(bWriter);
		bv.setBoard_content(bContent);
		
		int cnt = boardService.insertBoard(bv); //회원정보 등록
		
		
		if(cnt > 0) {
			System.out.println("게시글 작성 완료");
		}else {
			System.out.println("게시글 작성 실패");
		}
	}
	
	private boolean chkBoardInfo(int bdNum) {
		return boardService.chkBoardInfo(bdNum);
	}

	private void displayBoard() {
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println("번호\t제목\t작성자\t작성날짜\t내용");
		System.out.println("------------------------------------------------");
		
		List<BoardVO> bdList = boardService.getAllBoardList();
		
		for(BoardVO bv : bdList) {
			System.out.println(bv.getBoard_num() + "\t" + bv.getBoard_title() + "\t" +
					bv.getBoard_writer() + "\t" + bv.getBoard_date() + "\t" +
					bv.getBoard_content());
		}
		
		System.out.println("------------------------------------------------");
		System.out.println("출력작업 끝...");
	}
	
	public static void main(String[] args) {
		BoardInfoMng bdObj = new BoardInfoMng();
		bdObj.start();
	}
}
