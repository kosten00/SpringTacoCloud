package ru.vasilev.tacocloud.controllers;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilev.tacocloud.model.Ingredient;
import ru.vasilev.tacocloud.model.Ingredient.Type;
import ru.vasilev.tacocloud.model.Taco;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/design")
public class DesignTacoController {

    private List<Ingredient> ingredientList = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
    );

    @GetMapping
    public List<Ingredient> showDesignForm() {
        return ingredientList;
    }

    @Deprecated
    @PostMapping
    public String processDesign(Taco taco) {

        return "redirect:/orders/current";
    }
}
