package ru.itpark.ulmart.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.ulmart.service.ProductService;

@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService service;

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("products", service.getAll());
        return "index";
    }

    @GetMapping(params = "search")
    public String searchByName(@RequestParam String search, Model model) {
        model.addAttribute("products", service.searchByName(search));
        model.addAttribute("search", search);
        return "index";
    }

    @GetMapping("/view/{id}")
    public String detailsPage(@PathVariable int id, Model model) {
        model.addAttribute("product", service.getById(id));
        return "details";
    }

    @GetMapping("/addSmartPhone")
    public String addSmartPhonePage(Model model) {
        model.addAttribute("product", "phone");
        return "add";
    }

    @PostMapping("/addSmartPhone")
    public String addSmartPhone(@RequestParam String name,
                                @RequestParam int price,
                                @RequestParam String os,
                                @RequestParam String model,
                                @RequestParam String color,
                                @RequestParam int memorySize) {
        service.add(name, price, os, model, color, memorySize);
        return "redirect:/";
    }

    @GetMapping("/addTShirt")
    public String addTShirtPage(Model model) {
        model.addAttribute("product", "shirt");
        return "add";
    }

    @PostMapping("/addTShirt")
    public String addTShirt(@RequestParam String name,
                            @RequestParam int price,
                            @RequestParam int size,
                            @RequestParam String color) {
        service.add(name, price, size, color);
        return "redirect:/";
    }

    @GetMapping("/addStove")
    public String addStovePage(Model model) {
        model.addAttribute("product", "electrolux");
        return "add";
    }

    @PostMapping("/addStove")
    public String addStove(@RequestParam String name,
                           @RequestParam int price,
                           @RequestParam String type,
                           @RequestParam int ovenVolume,
                           @RequestParam int width,
                           @RequestParam int depth,
                           @RequestParam int height) {
        service.add(name, price, type, ovenVolume, width, depth, height);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable int id, Model model) {
        model.addAttribute("product", service.getById(id));
        return "edit";
    }

    @PostMapping("/edit/IPhone/{id}")
    public String editIPhone(@PathVariable int id,
                             @RequestParam String name,
                             @RequestParam int price,
                             @RequestParam String os,
                             @RequestParam String model,
                             @RequestParam String color,
                             @RequestParam int memorySize) {
        service.updateById(id, name, price, os, model, color, memorySize);
        return "redirect:/";
    }

    @PostMapping("/edit/TShirt/{id}")
    public String editTShirt(@PathVariable int id,
                             @RequestParam String name,
                             @RequestParam int price,
                             @RequestParam int size,
                             @RequestParam String color) {
        service.updateById(id, name, price, size, color);
        return "redirect:/";
    }

    @PostMapping("/edit/Electrolux/{id}")
    public String editElectrolux(@PathVariable int id,
                                 @RequestParam String name,
                                 @RequestParam int price,
                                 @RequestParam String type,
                                 @RequestParam int ovenVolume,
                                 @RequestParam int width,
                                 @RequestParam int depth,
                                 @RequestParam int height) {
        service.updateById(id, name, price, type, ovenVolume, width, depth, height);
        return "redirect:/";
    }

    @PostMapping("/remove/{id}")
    public String remove(@PathVariable int id) {
        service.removeById(id);
        return "redirect:/";
    }
}
