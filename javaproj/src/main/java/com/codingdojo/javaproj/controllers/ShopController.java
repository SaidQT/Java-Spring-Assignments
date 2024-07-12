package com.codingdojo.javaproj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.javaproj.models.Shop;
import com.codingdojo.javaproj.services.ShopService; // Import ShopService

import jakarta.validation.Valid;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService; // Ensure ShopService is imported and defined

    @GetMapping("/admin/add")
    public String addShop(@ModelAttribute("shop") Shop shop) {
        return "addshop.jsp";
    }

    @PostMapping("/shops/new")
    public String createShop(@Valid @ModelAttribute("shop") Shop shop, BindingResult result) {
        if (result.hasErrors()) {
            return "addshop.jsp";
        } else {
            shopService.createShop(shop);
            return "redirect:/admin/home";
        }
    }

    @GetMapping("/admin/home")
    public String showShops(Model model) {
        List<Shop> shops = shopService.findAll();
        model.addAttribute("shops", shops);
        return "shop.jsp";
    }

    @GetMapping("/admin/{id}/edit")
    public String showInfo(@PathVariable("id") Long id, Model model) {
        Shop shop = shopService.findShop(id);
        model.addAttribute("shop", shop);
        return "editshop.jsp";
    }

    @PutMapping("/admin/{id}")
    public String editInfo(@Valid @ModelAttribute("shop") Shop shop, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("shop", shop);
            return "editshop.jsp";
        } else {
            shopService.updateShop(shop);
            return "redirect:/admin/home";
        }
    }

    @GetMapping("/admin/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        shopService.deleteShop(id);
        return "redirect:/admin/home";
    }

    @GetMapping("/aboutus")
    public String AboutUs(Model model) {
        model.addAttribute("allPartners", shopService.findAll());
        return "AboutUs.jsp";
    }
}
