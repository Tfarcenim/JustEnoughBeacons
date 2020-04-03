package com.tfar.justenoughbeacons.jei.conduitblock;

import com.tfar.justenoughbeacons.jei.beaconblock.BeaconBlockRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.stream.Collectors;

public class ConduitBaseRecipe {

  public static List<ItemStack> getConduitBlocks(){
    return ForgeRegistries.BLOCKS.getValues().stream()
            .filter(block ->
                    {
                      try {
                        return block.isConduitFrame(
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
