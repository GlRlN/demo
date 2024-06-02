package com.example.demo.app;

import com.example.demo.domain.model.dto.KKSProductRequest;
import com.example.demo.domain.model.entity.Product;
import com.example.demo.domain.service.KKSProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class KKSProductController {
    private KKSProductService KKSProductService;

    public KKSProductController(KKSProductService kksProductService) {
        this.KKSProductService = kksProductService;
    }

    @GetMapping("kks_product")
    public String getKKSProduct(Model model) {
        List<Product> kksProducts = KKSProductService.findAll();

        model.addAttribute("KKSProductList", kksProducts);
        model.addAttribute("KKSProductRequest", new KKSProductRequest());

        return "kks_product/product.html";
    }

    @PostMapping("kks_product")
    public String postKKSProduct(Model model, @ModelAttribute("KKSProductRequest") KKSProductRequest kksProduct) {
        KKSProductService.save(kksProduct);

        return "redirect:/kks_product";
    }

    @GetMapping("kks_ProductUpdate")
    public String getKKSProductUpdate(Model model, @RequestParam Map<String, Object> params) {
        long productID = Long.parseLong(params.get("productID").toString());

        Product kksProduct = KKSProductService.findById(productID);

        model.addAttribute("KKSProduct", kksProduct);
        model.addAttribute("KKSProductRequest", new KKSProductRequest());

        System.out.println("수정페이지 이동");

        return "kks_product/productUpdate.html";
    }

    @PostMapping("kks_ProductUpdate")
    public String postKKSProductUpdate(Model model, KKSProductRequest kksProduct) {
        KKSProductService.save(kksProduct);

        return "redirect:/kks_product";
    }

    @GetMapping("kks_ProductDelete")
    public String getKKSProductDelete(Model model, @RequestParam Map<String, Object> params) {
        long productID = Long.parseLong(params.get("productID").toString());

        KKSProductService.deleteById(productID);

        return "redirect:/kks_product";
    }
}
