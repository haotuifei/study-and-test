package com.buka.service.platform;

import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class DownService {
    public void down(HttpServletResponse response,String filmId) throws IOException {
        File file = new File("D:\\img", filmId);
        if (file.exists()) {
            response.setHeader("Content-Disposition", "attachment; filename=" + filmId);
            FileInputStream fis = null;
            ServletOutputStream outputStream = response.getOutputStream();
            try {
                response.setContentLengthLong(file.length());
                fis = new FileInputStream(file);
                byte[] bytes = new byte[1024 * 1024];
                int len = 0;
                while ((len = fis.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, len);
                }

            } finally {
                if (fis != null) {
                    fis.close();
                }
            }

        }
    }

}
