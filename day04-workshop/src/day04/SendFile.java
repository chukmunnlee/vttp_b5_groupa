package day04;

import java.net.*;
import java.io.*;

public class SendFile {

   public void upload(Socket sock, File toUpload) throws IOException {
      String fileName = toUpload.getName();
      long fileSize = toUpload.length();

      // Open the file for reading
      InputStream is = new FileInputStream(toUpload);
      BufferedInputStream bis = new BufferedInputStream(is);

      // Open a connection to the server
      OutputStream os = sock.getOutputStream();
      DataOutputStream dos = new DataOutputStream(os);

      // Write the file name
      dos.writeUTF(fileName);

      // Write the file size
      dos.writeLong(fileSize);

      // Create a 4K buffer
      byte[] buff = new byte[4 * 1024];
      int bytesRead = 0;
      int sendBytes = 0;
      int idx = 0;

      while ((bytesRead = bis.read(buff)) > 0) {
         dos.write(buff, 0, bytesRead);
         sendBytes += bytesRead;
         System.out.printf("%d > %d Send %d of %d\n", idx, bytesRead, sendBytes, fileSize);
         idx++;
      } 

      dos.flush();
      os.flush();
   }
   
}
