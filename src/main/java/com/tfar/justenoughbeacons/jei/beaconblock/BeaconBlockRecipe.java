package com.tfar.justenoughbeacons.jei.beaconblock;

import net.minecraft.item.ItemStack;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeaconBlockRecipe {

  public static List<ItemStack> cache = new ArrayList<>();

  public final int index;
  public BeaconBlockRecipe(int index){
    this.index = index;
  }

  public List<ItemStack> getBeaconBlockSublist() {
    return cache.subList(28 * index , Math.min(28 * index + 28, cache.size()));
  }

  public static void refresh() {
    cache.clear();
    cache = getBeaconBlocks();
  }

  private static List<ItemStack> getBeaconBlocks(){
    return ForgeRegistries.BLOCKS.getValues().stream()
            .filter(block -> block.isIn(BlockTags.BEACON_BASE_BLOCKS))
            .map(ItemStack::new).collect(Collectors.toList());
  }
}
