package com.tfar.justenoughbeacons.jei.beaconpayment;

import com.tfar.justenoughbeacons.jei.AbstractRecipeCategory;
import com.tfar.justenoughbeacons.jei.JeiPlugin;
import com.tfar.justenoughbeacons.jei.beaconblock.BeaconBlockCategory;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class BeaconPaymentCategory extends AbstractRecipeCategory<BeaconPaymentRecipe> {

  public BeaconPaymentCategory(IGuiHelper guiHelper) {
    super(guiHelper,BeaconBlockCategory.beacon);
  }

  @Override
  public ResourceLocation getUid() {
    return JeiPlugin.BEACON_PAYMENT;
  }

  @Override
  public Class<? extends BeaconPaymentRecipe> getRecipeClass() {
    return BeaconPaymentRecipe.class;
  }


  @Override
  public String getTitle() {
    return I18n.format("category.beacon_payments");
  }

}
