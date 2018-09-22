import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerAndroid implements Runnable {
	
	//����������

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Thread server=new Thread(new ServerAndroid());
      server.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Socket socket=null;
		try{
			
			ServerSocket server=new ServerSocket(18888);
		//ѭ�������ͻ�����������
			while(true){
			System.out.println("start...");
			//��������
			socket=server.accept();
			System.out.println("accept...");
			//���տͻ�����Ϣ
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String message=in.readLine();
			System.out.println(message);
			//������Ϣ����ͻ���
		PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			out.println("server: "+message);
			//�ر���
			in.close();
			out.close();
			}
		
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(null!=socket){
				try{
					socket.close();
					
				}catch(IOException e){
					e.printStackTrace();
				}
				
				
			}
			
		}
	}
	
}
