package personal.practices.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by CBStubborn on 2017/11/24.
 */
public class UserFileChannel {

    public static void main(String[] args) {
        try {
            RandomAccessFile accessFile = new RandomAccessFile("D:\\git\\practice\\personal-nio\\src\\main\\resources\\README.md", "rw");
            FileChannel fileChannel = accessFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);
            while (bytesRead != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.write(buffer.get());
                }
                buffer.compact();
                bytesRead = fileChannel.read(buffer);
            }
            accessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
