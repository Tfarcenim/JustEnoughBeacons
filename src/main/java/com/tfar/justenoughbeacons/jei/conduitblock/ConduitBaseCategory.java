package com.tfar.justenoughbeacons.jei.conduitblock;

import com.tfar.justenoughbeacons.jei.AbstractRecipeCategory;
import com.tfar.justenoughbeacons.jei.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.block.Blocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ConduitBaseCategory extends AbstractRecipeCategory<ConduitBaseRecipe> {

  public ConduitBaseCategory(IGuiHelper guiHelper) {
    super(guiHelper,conduit);
  }

  private static final ItemStack conduit = Blocks.CONDUIT.asItem().getDefaultInstance();

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

}
