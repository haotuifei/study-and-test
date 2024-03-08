package com.buka.service.platform;

import com.buka.mapper.FilmMapper;
import com.buka.pojo.Film;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class AddFilmService {
    @Autowired
    private FilmMapper filmMapper;

    public ResponseJson addfilm(String filmName, int filmTime, MultipartFile file) throws IOException {
        Film film = new Film();
        film.setFilmName(filmName);
        film.setFilmTime(filmTime * 60);
        File savePath = new File("D:\\img");
        String filename = file.getOriginalFilename();
        file.transferTo(new File(savePath, filename));
        film.setFilmPosters("http://localhost:8080/chwk/platform/down?filmId=" + filename);
        int i = filmMapper.addFilm(film);
        if (i > 0) {
            return ResponseJson.getOK(200, "添加成功");
        } else {
            return ResponseJson.getError(-1, "添加失败");
        }

    }
}
