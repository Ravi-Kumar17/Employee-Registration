package com.sb.mvc.emp;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    // Display the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "register";
    }

    // Process the submitted form
    @PostMapping("/register")
    public String registerEmployee(
            @Valid @ModelAttribute("employee") Employee employee,
            BindingResult result,
            Model model) {

        // If validation fails, show the form again
        if (result.hasErrors()) {
            return "register";
        }

        // Demo only: no database is used
        model.addAttribute("registeredEmployee", employee);

        return "success";
    }
}