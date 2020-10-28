package com.tfar.justenoughbeacons.jei.beaconpayment;

import com.tfar.justenoughbeacons.jei.AbstractRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ItemTags;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeaconPaymentRecipe extends AbstractRecipe {

  public static List<ItemStack> cache = new ArrayList<>();

  public BeaconPaymentRecipe(int index) {
    super(index);
  }

  public static void refresh() {
    cache.clear();
    cache = getBeaconPayments();
  }

  private static List<ItemStack> getBeaconPayments() {
    return ItemTags.BEACON_PAYMENT_ITEMS.getAllElements().stream().map(ItemStack::new).collect(Collectors.toList());
  }

  public List<ItemStack> getCache() {
    return cache;
  }
}
