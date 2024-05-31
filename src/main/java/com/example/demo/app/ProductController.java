package com.example.demo.app;

import com.example.demo.domain.model.dto.ProductRequest;
import com.example.demo.domain.model.entity.Product;
import com.example.demo.domain.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product")
    public String product() {
        return "/product/product.html";
    }

    @GetMapping("productInsert")
    public String getProductInsert(Model model) {
        model.addAttribute("productReq", new ProductRequest());
        return "/product/productInsert.html";
    }

    @PostMapping("productInsert")
    public String postProductInsert(Model model, @ModelAttribute("ProductReq") ProductRequest productReq) {
        productService.save(productReq);
        return "redirect:/productInsert";
    }

    @GetMapping("productList")
    public String getProductList(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/product/productList.html";
    }

    @GetMapping("productUpdate")
    public String getProductUpdate(Model model, @RequestParam Map<String, Object> params) {
        long productId = Long.parseLong(params.get("id").toString());
        Product product = productService.findById(productId);
        model.addAttribute("product", product);
        model.addAttribute("productReq", new ProductRequest());
        return "/product/productUpdate.html";
    }

    @PostMapping("productUpdate")
    public String postProductUpdate(Model model, @ModelAttribute ProductRequest productReq) {
        productService.save(productReq);
        return "redirect:/productList";
    }

    @GetMapping("productDelete")
    public String postProductDelete(Model model, @RequestParam Map<String, Object> params) {
        long productId = Long.parseLong(params.get("id").toString());
        productService.deleteById(productId);
        return "redirect:/productList";
    }
}
