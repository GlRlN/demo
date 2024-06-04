package com.example.demo.app;

import com.example.demo.domain.model.dto.KKSProductRequest;
import com.example.demo.domain.model.dto.SalesRequest;
import com.example.demo.domain.model.entity.Menu;
import com.example.demo.domain.model.entity.Sales;
import com.example.demo.domain.service.KKSProductService;
import com.example.demo.domain.service.SalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class KKSProductController {
    private KKSProductService KKSProductService;
    private SalesService salesService;

    public KKSProductController(KKSProductService kksProductService, SalesService salesService) {
        this.KKSProductService = kksProductService;
        this.salesService = salesService;
    }

    @GetMapping("kks_product")
    public String getKKSProduct(Model model) {
        List<Menu> kksProducts = KKSProductService.findAll();

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

        Menu kksProduct = KKSProductService.findById(productID);

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

    @GetMapping("productOrder")
    public String getProductOredr(Model model) {

        List<Object[]> productOrder = salesService.findSalesByProcess(0);

        List<Sales> sales = productOrder.stream()
                .map(objects -> (Sales) objects[0])
                .collect(Collectors.toList());

        List<String> menuNames = productOrder.stream()
                .map(objects -> (String) objects[1])
                .collect(Collectors.toList());

        List<String> categoryNames = productOrder.stream()
                .map(objects -> (String) objects[1])
                .collect(Collectors.toList());

        for (Object o : productOrder) {
            System.out.println(o);
        }

        model.addAttribute("orderList", sales);
        model.addAttribute("menuName", menuNames);
        model.addAttribute("categoryName", categoryNames);
        model.addAttribute("orderRequest", new SalesRequest());

        return "kks_product/productOrder.html";
    }
}
