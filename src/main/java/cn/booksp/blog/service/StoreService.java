package cn.booksp.blog.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

public interface StoreService {

//    void init();

//    void setUploadDir(String upload_dir);
    /**
     * 存储markdown文件到upload/md目录
     * @param multipartFile
     */
    void storeMarkdown(MultipartFile multipartFile);

    void storeModify(String text, String url);

    /**
     * 存储图像到/upload/img目录
     * @param images
     */
    void storeIMG(List<MultipartFile> images);

    /**
     * 根据文件名删除upload/md目录下的markdown文件
     * @param filename
     */
    void deleteMarkdown(String filename);

    /**
     * 根据文件名删除/upload/img目录下的图像
     * @param filename
     */
    void deleteIMG(String filename);

    /**
     * 载入markdown文件
     * @param filename
     * @return
     */
    String loadMarkdown(String filename);

    /**
     * 载入markdown文件
     * @param filename
     * @return
     */
    Resource loadMarkdownAsResource(String filename);
}
