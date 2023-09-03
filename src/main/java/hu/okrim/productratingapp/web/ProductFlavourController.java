package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.*;
import hu.okrim.productratingapp.service.FlavourService;
import hu.okrim.productratingapp.service.ProductFlavourService;
import hu.okrim.productratingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product-flavours")
public class ProductFlavourController {
    @Autowired
    ProductFlavourService productFlavourService;
    @Autowired
    ProductService productService;
    @Autowired
    FlavourService flavourService;
    @GetMapping("")
    public String listProductFlavours (Model model) {
        List<ProductFlavour> productFlavours = productFlavourService.getAllProductFlavours();
        model.addAttribute("productFlavours", productFlavours);
        // Fetch and add products and flavours to dropdowns
        List<Product> products = productService.getAllProducts();
        List<Flavour> flavours = flavourService.getAllFlavours();
        model.addAttribute("products", products);
        model.addAttribute("flavours", flavours);
        return "product-flavours";
    }

    @PostMapping("/add-product-flavours")
    public String addProductFlavour (
            @RequestParam("product") Integer productId,
            @RequestParam("flavour") Integer flavourId,
            RedirectAttributes redirectAttributes) {

        // Create a new ProductFlavour instance and set its properties
        Product product = productService.getProductById(productId);
        Flavour flavour = flavourService.getFlavourById(flavourId);
        ProductFlavourId productFlavourId = new ProductFlavourId(product.getId(),flavour.getId());
        ProductFlavour  productFlavour = new ProductFlavour (product,flavour);

        // Save the product using the ProductFlavour Service
        productFlavourService.addProductFlavour(productFlavour);

        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);

        return "redirect:/product-flavours";
    }
    @PostMapping("/delete-product-flavour")
    public String deleteProductFlavour (@RequestParam("productFlavourId") ProductFlavourId  productFlavourId, RedirectAttributes redirectAttributes){
        productFlavourService.deleteProductFlavour(productFlavourId);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/product-flavours";
    }
}