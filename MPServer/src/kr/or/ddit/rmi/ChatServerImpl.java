package kr.or.ddit.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import kr.or.ddit.rmi.inf.ChatClient;
import kr.or.ddit.rmi.inf.ChatServer;
import kr.or.ddit.rmi.vo.ChatVO;

@SuppressWarnings("serial")
public class ChatServerImpl extends UnicastRemoteObject implements ChatServer {

   Vector<ChatVO> clientList = new Vector<>();

   public ChatServerImpl() throws RemoteException{} 

   public static void main(String args[]){

       try{

          System.out.println("ChatServerImpl.main:creating registry");
          
          //System.setProperty("java.rmi.server.hostname","192.168.201.45");

          ChatServerImpl Server = new ChatServerImpl();    
          
          Registry reg = LocateRegistry.createRegistry(8888);

          reg.rebind("RMIChatServer", Server);

          System.out.println("ChatServerImpl is running...");

       } catch (Exception e){

          System.out.println("ChatServerImpl error: " + e.getMessage());

          e.printStackTrace();

       }

   }

   public void addClient(ChatClient client, String name) throws RemoteException{
	   
	   ChatVO chatVO = new ChatVO(client, name);
	   
       clientList.addElement(chatVO);

       say("님이 접속하셨습니다.", name);

       System.out.println("접속함. 현재 접속중인 사용자수는 " + clientList.size());

   }
   
   
   public void disconnect(ChatClient client, String name) throws RemoteException{
	   
       int i = 0;
       for(ChatVO tmpChatVO : clientList) {
    	   if(tmpChatVO.getNickName().equals(name)) { // 동일한 사용자가 존재하면
    		   
    		   clientList.removeElementAt(i);
    		   
    		   say("님이 퇴장하셨습니다.", name);
    		   
    		   System.out.println("퇴장함. 현재 접속중인 사용자수는 " + clientList.size());
    		   
    		   break;
    	   }
    	   i++;
       }
   }
   

   public void say(String msg, String nickName) throws RemoteException {

       int numOfConnect = clientList.size();
       ChatVO chatVO = null;
       for(int i = 0; i < numOfConnect; i++){

    	   chatVO = clientList.elementAt(i);
    	   
    	   if(msg.indexOf("님이 접속하셨습니다.") > -1 
    			   || msg.indexOf("님이 퇴장하셨습니다.") > -1) {
    		   if(!chatVO.getNickName().equals(nickName)) { // 본인이 아닌경우에만 메시지 출력하기
    			   chatVO.getClient().printMessage(nickName + " " + msg);
    		   }
    	   }else {
    		   chatVO.getClient().printMessage(nickName + " : " + msg);
    	   }
       }
   }

}
