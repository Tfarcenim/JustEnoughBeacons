package com.tfar.justenoughbeacons.jei.beaconblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BeaconBlockRecipe {

  public static final List<Block> special = new ArrayList<>();

  public static List<ItemStack> cache = new ArrayList<>();

  public final int index;
  public BeaconBlockRecipe(int index){
    this.index = index;
  }

  public List<ItemStack> getBeaconBlockSublist(){
    return cache.subList(28 * index , Math.min(28 * index + 28, cache.size()));
  }

  public static void refresh(){
    special.clear();
    cache.clear();
    cache = getBeaconBlocks();
  }

  private static List<ItemStack> getBeaconBlocks(){
    return ForgeRegistries.BLOCKS.getValues().stream()
            .filter(block ->
                    {
                      try {
                        return block.isBeaconBase(
                                block.getDefaultState(), null, null, null);
                      } catch (NullPointerException specialblock){
                        BeaconBlockRecipe.special.add(block);
                        return false;
                      }
                    }
            )
            .map(ItemStack::new).collect(Collectors.toList());
  }
}
