package com.tfar.justenoughbeacons.jei.beaconpayment;

import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeaconPaymentRecipe {


  public static List<ItemStack> cache = new ArrayList<>();
  public final int index;

  public BeaconPaymentRecipe(int index) {
    this.index = index;
  }

  public List<ItemStack> getBeaconPaymentSublist() {
    return cache.subList(28 * index, Math.min(28 * index + 28, cache.size()));
  }

  public static void refresh() {
    cache.clear();
    cache = getBeaconPayments();
  }

  private static List<ItemStack> getBeaconPayments() {
    return ForgeRegistries.ITEMS
            .getValues()
            .stream()
            .filter(item -> item.isIn(ItemTags.field_232908_Z_))
            .map(ItemStack::new).collect(Collectors.toList());
  }
}
