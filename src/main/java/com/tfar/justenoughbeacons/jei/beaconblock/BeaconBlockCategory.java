package com.tfar.justenoughbeacons.jei.beaconblock;

import com.tfar.justenoughbeacons.jei.AbstractRecipeCategory;
import com.tfar.justenoughbeacons.jei.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.block.Blocks;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class BeaconBlockCategory extends AbstractRecipeCategory<BeaconBlockRecipe> {

  public BeaconBlockCategory(IGuiHelper guiHelper) {
    super(guiHelper,beacon);
  }

  @Override
  public ResourceLocation getUid() {
    return JeiPlugin.BEACON_BLOCK;
  }

  public static final ItemStack beacon = new ItemStack(Blocks.BEACON);

  @Override
  public Class<? extends BeaconBlockRecipe> getRecipeClass() {
    return BeaconBlockRecipe.class;
  }

  @Override
  public String getTitle() {
    return I18n.format("category.beacon_blocks");
  }

}
