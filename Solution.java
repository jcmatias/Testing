import java.net.*;  
import java.io.*;  

class MyClient{  
	public static void main(String args[])throws Exception {  
		Socket s = new Socket("localhost", 5555);  

		// InputStream din = s.getInputStream();  
		OutputStream dout = s.getOutputStream();  

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
		BufferedReader din = new BufferedReader(new InputStreamReader(s.getInputStream()));
		  
		String str = "";
		String str2 = "";  

		while(!str.equals("stop")) {  
			while (din.ready()) {
				System.out.println(din.readLine());  
			}
			str = br.readLine(); 
			byte[] request = str.getBytes("UTF-8");

			dout.write(request, 0, request.length);  
			dout.flush();  
			System.out.println("Server says: " + din.readLine());  

		}  
		  
		dout.close();  
		s.close();  
	}
}  
