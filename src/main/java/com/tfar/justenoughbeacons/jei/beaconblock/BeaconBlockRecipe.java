package com.tfar.justenoughbeacons.jei.beaconblock;

import com.tfar.justenoughbeacons.jei.AbstractRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeaconBlockRecipe extends AbstractRecipe {

  public static List<ItemStack> cache = new ArrayList<>();

  public BeaconBlockRecipe(int index) {
    super(index);
  }

  public static void refresh() {
    cache.clear();
    cache = getBeaconBlocks();
  }

  private static List<ItemStack> getBeaconBlocks() {
    return BlockTags.BEACON_BASE_BLOCKS.getAllElements().stream().map(ItemStack::new).collect(Collectors.toList());
  }

  public List<ItemStack> getCache() {
    return cache;
  }

}
