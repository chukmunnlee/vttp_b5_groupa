package day04;

import java.net.*;
import java.io.*;

public class ReceiveFile {

   public void receiveFile(Socket sock) throws IOException {

      // Open socket for reading
      InputStream is = sock.getInputStream();
      DataInputStream dis = new DataInputStream(is);

      // File name
      String fileName = dis.readUTF();

      // File size
      long fileSize = dis.readLong();

      // Create the output file
      FileOutputStream fos = new FileOutputStream(fileName);
      BufferedOutputStream bos = new BufferedOutputStream(fos);

      byte[] buff = new byte[2 * 1024];
      int bytesRead = 0;
      int bytesRecv = 0;
      int idx = 0;

      System.out.printf("Receiving file %s of size %d\n", fileName, fileSize);

      while (bytesRecv < fileSize) {
         // Number of bytes read
         bytesRead = dis.read(buff);
         bytesRecv += bytesRead;
         
         // Write to local file
         bos.write(buff, 0, bytesRead);
         
         System.out.printf("%d> %d Recv %d of %d\n", idx, bytesRead, bytesRecv, fileSize);
         idx++;
      }

   }
   
}
