package GEEk;
import java.io.*;
import java.net.*;
public class Server {
	
	   private Socket          socket   = null; 
	    private ServerSocket    server   = null; 
	    private DataInputStream in       =  null; 
	    
	  
	    // constructor with port 
	    public Server(int port) 
	    { 
	        // starts server and waits for a connection 
	        try
	        { 
	            server = new ServerSocket(port); 
	            System.out.println("Server started"); 
	  
	            System.out.println("Waiting for a client ..."); 
	  
	            socket = server.accept(); 
	            System.out.println("Client accepted"); 
	  
	            // takes input from the client socket 
	            in = new DataInputStream( 
	                new BufferedInputStream(socket.getInputStream())); 

	            PrintWriter write =new PrintWriter(
	            		new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true
	            		);
	            String line = ""; 
	            String chaine ="bonjour ";
	            write.println(chaine);
	            // reads message from client until "Over" is sent 
	            while (!line.equals("Over")) 
	            { 
	                try
	                { 
	                	
							//write.println(chaine);
						
	                    line = in.readUTF(); 
	                    System.out.println(line); 
	  
	                } 
	                catch(IOException i) 
	                { 
	                    System.out.println(i); 
	                } 
	            } 
	            System.out.println("Closing connection"); 
	  
	            // close connection 
	            socket.close(); 
	            in.close(); 
	        } 
	        catch(IOException i) 
	        { 
	            System.out.println(i); 
	        } 
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(5000);
	}

}
