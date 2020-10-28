package com.tfar.justenoughbeacons.jei;

import com.tfar.justenoughbeacons.JustEnoughBeacons;
import com.tfar.justenoughbeacons.jei.beaconblock.BeaconBlockCategory;
import com.tfar.justenoughbeacons.jei.beaconblock.BeaconBlockRecipe;
import com.tfar.justenoughbeacons.jei.beaconpayment.BeaconPaymentCategory;
import com.tfar.justenoughbeacons.jei.beaconpayment.BeaconPaymentRecipe;
import com.tfar.justenoughbeacons.jei.conduitblock.ConduitBaseCategory;
import com.tfar.justenoughbeacons.jei.conduitblock.ConduitBaseRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {

  public static final ResourceLocation BEACON_PAYMENT = new ResourceLocation(JustEnoughBeacons.MODID,"payment");
  public static final ResourceLocation BEACON_BLOCK = new ResourceLocation(JustEnoughBeacons.MODID,"block");

  public static final ResourceLocation CONDUIT = new ResourceLocation(JustEnoughBeacons.MODID,"conduit");
  public static final ResourceLocation BACKGROUND = new ResourceLocation(JustEnoughBeacons.MODID, "textures/gui/arrow.png");

  @Override
  public ResourceLocation getPluginUid() {
    return new ResourceLocation(JustEnoughBeacons.MODID, JustEnoughBeacons.MODID);
  }

  @Override
  public void registerCategories(IRecipeCategoryRegistration registration) {
    IJeiHelpers jeiHelpers = registration.getJeiHelpers();
    IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
    registration.addRecipeCategories(new BeaconBlockCategory(guiHelper),new BeaconPaymentCategory(guiHelper),new ConduitBaseCategory(guiHelper));
  }

  @Override
  public void registerRecipes(IRecipeRegistration registration) {

    BeaconBlockRecipe.refresh();
    int beaconblockpages = (int)Math.ceil(BeaconBlockRecipe.cache.size()/28d);
    List<BeaconBlockRecipe> beaconBlockRecipes = new ArrayList<>();
    IntStream.range(0,beaconblockpages).forEach(i -> beaconBlockRecipes.add(new BeaconBlockRecipe(i)));
    registration.addRecipes(beaconBlockRecipes, BEACON_BLOCK);

    BeaconPaymentRecipe.refresh();
    int beaconpaymentpages = (int)Math.ceil(BeaconPaymentRecipe.cache.size()/28d);
    List<BeaconPaymentRecipe> recipes = new ArrayList<>();
    IntStream.range(0,beaconpaymentpages).forEach(i -> recipes.add(new BeaconPaymentRecipe(i)));
    registration.addRecipes(recipes, BEACON_PAYMENT);

    ConduitBaseRecipe.refresh();
    int conduitpaymentpages = (int)Math.ceil(BeaconPaymentRecipe.cache.size()/28d);
    List<ConduitBaseRecipe> conduitBaseRecipes = new ArrayList<>();
    IntStream.range(0,conduitpaymentpages).forEach(i -> conduitBaseRecipes.add(new ConduitBaseRecipe(i)));
    registration.addRecipes(conduitBaseRecipes, CONDUIT);
  }

  @Override
  public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    registration.addRecipeCatalyst(new ItemStack(Blocks.BEACON), BEACON_BLOCK);
    registration.addRecipeCatalyst(new ItemStack(Blocks.BEACON), BEACON_PAYMENT);
    registration.addRecipeCatalyst(new ItemStack(Blocks.CONDUIT), CONDUIT);
  }
}
