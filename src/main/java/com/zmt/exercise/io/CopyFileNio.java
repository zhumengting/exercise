package com.zmt.exercise.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileNio {
    public static void main(String[] args) {
        File file = new File("E:\\zmt\\temp\\my.txt");
        File copy_file = new File("E:\\zmt\\temp\\copy_my.txt");
        try {
            if (!copy_file.exists()) {
                copy_file.createNewFile();
            }
            FileInputStream fio = null;
            FileOutputStream fot = null;
            FileChannel in = null;
            FileChannel out = null;
            try {
                fio = new FileInputStream(file);
                fot = new FileOutputStream(copy_file);
                in = fio.getChannel();
                out = fot.getChannel();
                int length = -1;
                ByteBuffer byteBuffer = ByteBuffer.allocate(2);
                while ((length = in.read(byteBuffer)) != -1) {
                    byteBuffer.flip();
                    int outLength = 0;
                    while ((outLength = out.write(byteBuffer)) != 0) {
                        System.out.println("write:" + outLength);
                    }
                    byteBuffer.clear();
                }
                out.force(true);
            } finally {
                out.close();
                fot.close();
                in.close();
                fio.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
