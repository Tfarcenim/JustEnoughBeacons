package com.tfar.justenoughbeacons.jei.conduitblock;

import com.tfar.justenoughbeacons.jei.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.block.Blocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ConduitBaseCategory implements IRecipeCategory<ConduitBaseRecipe> {

  private IGuiHelper guiHelper;

  public ConduitBaseCategory(IGuiHelper guiHelper) {
    this.guiHelper = guiHelper;
  }

  private static final ItemStack conduit = new ItemStack(Blocks.CONDUIT);

  @Override
  public ResourceLocation getUid() {
    return JeiPlugin.CONDUIT;
  }

  @Override
  public Class<? extends ConduitBaseRecipe> getRecipeClass() {
    return ConduitBaseRecipe.class;
  }


  @Override
  public String getTitle() {
    return I18n.format("category.conduit_bases");
  }

  @Override
  public IDrawable getBackground() {
    return guiHelper.createDrawable(JeiPlugin.BACKGROUND,
            0, 0, 128, 128);
  }

  @Override
  public IDrawable getIcon() {
    return guiHelper.createDrawableIngredient(conduit);
  }


  @Override
  public void setIngredients(ConduitBaseRecipe conduitBaseRecipe, IIngredients ingredients) {
    ingredients.setInputs(VanillaTypes.ITEM, ConduitBaseRecipe.getConduitBlocks());
  }

  @Override
  public void setRecipe(IRecipeLayout recipeLayout, ConduitBaseRecipe conduitBaseRecipe, IIngredients ingredients) {
    IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

    int xPos = 54;
    int yPos = 4;
    guiItemStacks.init(0, true, xPos, yPos);
    guiItemStacks.set(0, conduit);

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
