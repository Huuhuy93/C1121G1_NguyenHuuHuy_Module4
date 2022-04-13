package com.add_product_cart.controller;

import com.add_product_cart.model.Cart;
import com.add_product_cart.model.Product;
import com.add_product_cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", iProductService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = iProductService.findById(id);

        if (!productOptional.isPresent()) {
            return "/error.404";
        }

        if (action.equals("show")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }

        if (productOptional.get().getQuantity() == 0) {
            redirectAttributes.addFlashAttribute("msg", "sản phẩm này đã hết, vui lòng chọn sản phẩm khác !");
            return "redirect:/shop";
        } else {
            cart.addProduct(productOptional.get());
            productOptional.get().setQuantity(productOptional.get().getQuantity()-1);
            iProductService.save(productOptional.get());
            return "redirect:/shop";
        }
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("productView", iProductService.findById(id).get());
        return "/view";
    }
}
