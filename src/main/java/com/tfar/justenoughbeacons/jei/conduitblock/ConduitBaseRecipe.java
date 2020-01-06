package com.tfar.justenoughbeacons.jei.conduitblock;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;

import java.util.List;
import java.util.stream.Collectors;

public class ConduitBaseRecipe {

  public static List<ItemStack> getConduitBlocks(){
    return Tags.Blocks.SUPPORTS_CONDUIT
            .getAllElements()
            .stream()
            .map(ItemStack::new)
            .collect(Collectors.toList());
  }
}
