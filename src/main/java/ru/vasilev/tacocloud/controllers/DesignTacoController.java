package ru.vasilev.tacocloud.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vasilev.tacocloud.model.Ingredient;
import ru.vasilev.tacocloud.model.Ingredient.Type;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("design")
public class DesignTacoController {

    private List<Ingredient> ingredientList = Arrays.asList(
            new Ingredient("1", "a", Type.WRAP),
            new Ingredient("2", "b", Type.WRAP),
            new Ingredient("3", "c", Type.PROTEIN),
            new Ingredient("4", "d", Type.PROTEIN),
            new Ingredient("5", "e", Type.VEGGIES),
            new Ingredient("6", "f", Type.VEGGIES),
            new Ingredient("7", "g", Type.CHEESE),
            new Ingredient("8", "h", Type.CHEESE),
            new Ingredient("9", "i", Type.SAUCE),
            new Ingredient("0", "j", Type.SAUCE)
    );

    @GetMapping
    public List<Ingredient> showDesignForm() {
        return ingredientList;
    }
}
