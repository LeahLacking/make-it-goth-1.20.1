package net.leah.makeitgoth.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public class BeerBrewingRecipe implements Recipe<RecipeInput> {
    private final ItemStack output;
    private final List<Ingredient> RecipeItems;

    public BeerBrewingRecipe(List<Ingredient> ingredients,ItemStack itemStack){
        this.output=itemStack;
        this.RecipeItems=ingredients;
    }

    @Override
    public boolean matches(RecipeInput input, World world) {
        if(world.isClient){
            return false;
        }
        return RecipeItems.get(0).test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(RecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> ingredients = DefaultedList.ofSize(this.RecipeItems.size());
        ingredients.addAll(RecipeItems);
        return ingredients;
    }

    public static class Type implements RecipeType<BeerBrewingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "beer_brewing";
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }


}
