package hu.okrim.productratingapp.web;

import hu.okrim.productratingapp.entity.Constants;
import hu.okrim.productratingapp.entity.Brand;
import hu.okrim.productratingapp.service.BrandService;
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
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    BrandService brandService;
    @GetMapping("")
    public String listPeople(Model model) {
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "brands";
    }
    @PostMapping("/add-brand")
    public String addBrand(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        Brand brand = new Brand();
        brand.setName(name);
        brandService.addBrand(brand);
        String status = Constants.SUCCESS_STATUS;
        redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/brands";
    }
    @PostMapping("/delete-brand")
    public String deleteBrand(@RequestParam("brand") Brand brand, RedirectAttributes redirectAttributes){
        brandService.deleteBrand(brand);
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        return "redirect:/brands";
    }
}