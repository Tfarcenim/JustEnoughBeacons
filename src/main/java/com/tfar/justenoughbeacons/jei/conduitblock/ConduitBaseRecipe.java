package com.tfar.justenoughbeacons.jei.conduitblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ConduitBaseRecipe {

  public static List<ItemStack> getConduitBlocks(){
    return ForgeRegistries.BLOCKS.getValues().stream()
            .filter(block ->
                    {
                      try {
                        return block.isConduitFrame(
                                block.getDefaultState(), null, null, null);
                      } catch (NullPointerException specialblock) {
                        System.out.println(block.toString()+" has special conditions");
                        return false;
                      }
                    }
            )
            .map(ItemStack::new).collect(Collectors.toList());
  }
}
