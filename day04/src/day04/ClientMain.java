package day04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ClientMain {

   public static void main(String[] args) throws IOException {

      // Create a socket to connect to the server 
      Socket sock = new Socket("localhost", 5000);

      System.out.println(">>>> connected to server\n");

      Console cons = System.console();

      // Read a message
      String msg = cons.readLine(">>> ");

      // Output stream
      OutputStream os = sock.getOutputStream();
      Writer writer = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(writer);

      // Input stream
      InputStream is = sock.getInputStream();
      Reader reader = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(reader);

      // Write the message to the server
      // Add a new line to the writer
      bw.write(msg + "\n");
      // Force it into the network
      bw.flush();

      // Read the result back in
      msg = br.readLine();

      System.out.printf(">>> FROM SERVER: %s\n", msg);

      // Close the connection
      sock.close();
      
   }
   
}
