package cn.booksp.blog.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    File classPath;
    Path markdownPath;
    Path imgPath;
    public StoreServiceImpl() {
        try {
            classPath = new File(ResourceUtils.getURL("classpath:").getPath() + "/static/");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(!classPath.exists()){
            classPath = new File("");
        }

        markdownPath =Paths.get(classPath.getAbsolutePath(),"/upload/md/");
        imgPath =Paths.get(classPath.getAbsolutePath(), "/upload/img/");

        try {
            if (!Files.exists(markdownPath)) {
                Files.createDirectories(markdownPath);
            }
            if (!Files.exists(imgPath)) {
                Files.createDirectories(imgPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeMarkdown(MultipartFile file) {
        store(file, markdownPath);
    }

    @Override
    public void storeIMG(List<MultipartFile> images) {
        for (MultipartFile image : images) {
            store(image, imgPath);
        }
    }

    private void store(MultipartFile file, Path filePath) {
        String filename = file.getOriginalFilename();
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, filePath.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void storeModify(String text, String url) {
        Path path = Paths.get(url);
        if(Files.exists(path)){
            try (InputStream inputStream = new ByteArrayInputStream(text.getBytes())) {
                Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteMarkdown(String filePath) {
        Path path = Paths.get(filePath);
        if(Files.exists(path)){
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteIMG(String filename) {

    }

    @Override
        public String loadMarkdown(String filePath) {
        StringBuffer markdown = new StringBuffer();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader( classPath + "/" + filePath))){
            String line = null;
            line = bufferedReader.readLine();
            while (line != null) {
                markdown.append(line + "\r\n");
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return markdown.toString();
    }

    @Override
    public Resource loadMarkdownAsResource(String filename) {
        return null;
    }
}
