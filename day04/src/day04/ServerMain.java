package day04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {

   public static void main(String[] args) throws IOException {

      // Default port number
      int port = 3000;
      if (args.length > 0)
         port = Integer.parseInt(args[0]);

      System.out.printf(">> Listening on port %d\n", port);

      // Create the server
      ServerSocket server = new ServerSocket(port);

      while (true) {
         System.out.println("Waiting for connection");

         // Wait for incoming connection, block
         Socket conn = server.accept();

         System.out.println("Got a client connection");

         // Get the input stream
         InputStream is = conn.getInputStream();
         Reader reader = new InputStreamReader(is);
         BufferedReader br = new BufferedReader(reader);

         // Get output stream
         OutputStream os = conn.getOutputStream();
         Writer writer = new OutputStreamWriter(os);
         BufferedWriter bw = new BufferedWriter(writer);

         // Blocking read
         String msg = br.readLine();
         System.out.printf(">>> MSG from client: %s\n", msg);

         msg = "timestamp=%s, msg=%s \n".formatted(
            (new Date()).toString(), msg.toUpperCase()
         );

         bw.write(msg);
         bw.flush();

         conn.close();
      }
   }

}