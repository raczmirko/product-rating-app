package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Brand;
import hu.okrim.productratingapp.entity.Category;
import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.entity.Product;
import hu.okrim.productratingapp.service.BrandService;
import hu.okrim.productratingapp.service.CategoryService;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        // Add code to fetch and add brands and categories for dropdowns
        List<Brand> brands = brandService.getAllBrands();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        return "products";
    }

    @PostMapping("/add-product")
    public String addProduct(
            @RequestParam("productName") String productName,
            @RequestParam("brand") Integer brandId,
            @RequestParam("category") Integer categoryId,
            @RequestParam(value = "isDrink", required = false) boolean isDrink,
            RedirectAttributes redirectAttributes) {

        // Create a new Product instance and set its properties
        Product product = new Product();
        product.setName(productName);
        product.setIsDrink(isDrink);

        // Fetch the selected brand and category using their IDs
        Brand selectedBrand = brandService.getBrandById(brandId);
        Category selectedCategory = categoryService.getCategoryById(categoryId);
        // Set the brand and category for the product
        product.setBrand(selectedBrand);
        product.setCategory(selectedCategory);

        // Save the product using the ProductService
        productService.addProduct(product);

        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);

        return "redirect:/products";
    }
    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam("product") Product product, RedirectAttributes redirectAttributes){
        productService.deleteProduct(product);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/products";
    }
}
