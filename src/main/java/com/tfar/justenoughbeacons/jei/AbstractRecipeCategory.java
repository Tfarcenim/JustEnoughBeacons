package com.tfar.justenoughbeacons.jei;

import com.tfar.justenoughbeacons.jei.beaconblock.BeaconBlockCategory;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;

public abstract class AbstractRecipeCategory<T extends AbstractRecipe> implements IRecipeCategory<T> {

    protected IGuiHelper guiHelper;
    protected final ItemStack icon;

    public AbstractRecipeCategory(IGuiHelper guiHelper, ItemStack icon) {
        this.guiHelper = guiHelper;
        this.icon = icon;
    }

    @Override
    public void setIngredients(T beaconBlockRecipe, IIngredients ingredients) {
        ingredients.setInputs(VanillaTypes.ITEM, beaconBlockRecipe.getSublist());
    }

    @Override
    public IDrawable getBackground() {
        return guiHelper.createDrawable(JeiPlugin.BACKGROUND,
                0, 0, 128, 128);
    }

    @Override
    public IDrawable getIcon() {
        return guiHelper.createDrawableIngredient(icon);
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, T beaconPaymentRecipe, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        int xPos = 54;
        int yPos = 4;
        guiItemStacks.init(0, true, xPos, yPos);
        guiItemStacks.set(0, icon);

        xPos = 1;
        yPos = 52;
        int count = ingredients.getInputs(VanillaTypes.ITEM).size();
        for (int y = 0; y < Math.ceil(count/7d);y++) {
            for (int x = 0; x < 7; x++) {
                int index = 7 * y + x;
                if (index >= count)break;
                guiItemStacks.init(index+ 1, false, xPos + 18 * x, yPos + 18 * y);
                guiItemStacks.set(index+ 1, ingredients.getInputs(VanillaTypes.ITEM).get(index));
            }
        }
    }
}
