package com.example.demo.domain.service;

import com.example.demo.domain.model.dto.ProductRequest;
import com.example.demo.domain.model.entity.Product;
import com.example.demo.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
            return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void save(ProductRequest productRequest) {
        productRepository.save(productRequest.toEntity());
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void saveImage(ProductRequest request, MultipartFile file) {
        //파일이 저장될 곳 -> src/resources/static/image 폴더
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\image\\";

        //서버에서 파일을 불러 올 곳 = DB에 저장될 경로
        String serverPath = path.split("static\\\\")[1];

        //파일명용 UUID 생성
        UUID uuid = UUID.randomUUID();

        //업로드 받은 파일명을 UUID.확장자로 재정의
        String fileName = uuid + "." + file.getOriginalFilename().split("\\.")[1];

        //재정의 된 이름으로 임시 파일 생성
        File saveTo = new File(path + fileName);

        //DB에 저장될 이름도 재정의
        serverPath = serverPath + fileName;
        try {

            //파일 저장
            file.transferTo(saveTo);

            //DB에 저장
            productRepository.save(request.toEntity(serverPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
