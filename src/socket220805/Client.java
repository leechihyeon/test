package socket220805;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
	
			Socket socket = new Socket("127.0.0.1", 1111);
			System.out.println("클라이언트 ");
			
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);

			Member member = new Member();
			member.setId("admin");
			member.setName("lee");
			member.setKor(80);
			member.setEng(70);
			member.setMath(80);
			//데이터를 보내기 전 시간 측정
			//받은 쪽은 데이터를 받은 후 시간을 측정하고 
			//보낸시간과 받은시간을 뺴면 전송시간 계산 
			long beforeTime=
					System.currentTimeMillis();
			System.out.println("beforeTime:"+beforeTime);
			DataOutputStream out=new DataOutputStream(os);
			out.writeUTF(String.valueOf(beforeTime));
			out.flush();
			
			oos.writeObject(member);
			oos.flush();
			
			oos.close();
			os.close();
	}

}
