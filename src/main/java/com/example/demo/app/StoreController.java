package com.example.demo.app;

import com.example.demo.domain.model.dto.StoreRequest;
import com.example.demo.domain.model.entity.Store;
import com.example.demo.domain.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StoreController {
    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/storeInput")
    public String storeInput(Model model) {
        model.addAttribute("store", new StoreRequest());
        return "storeInput.html";
    }

    @PostMapping("/storeInput")
    public String storePost(Model model,@ModelAttribute("store") StoreRequest store) {
        storeService.save(store);
        return "redirect:/storeList";
    }

    @GetMapping("/storeList")
    public String getStoreList(Model model) {
        List<Store> stores = storeService.findAll();
        model.addAttribute("stores", stores);
        return "storeList.html";
    }
}
