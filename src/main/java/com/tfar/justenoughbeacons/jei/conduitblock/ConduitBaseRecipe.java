package com.tfar.justenoughbeacons.jei.conduitblock;

import com.tfar.justenoughbeacons.jei.AbstractRecipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConduitBaseRecipe extends AbstractRecipe {

	public static List<ItemStack> cache = new ArrayList<>();

	public ConduitBaseRecipe(int index) {
		super(index);
	}

	public static void refresh() {
		cache.clear();
		cache = getConduitBlocks();
	}

	private static List<ItemStack> getConduitBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream()
						.filter(block ->
										{
											try {
												return block.isConduitFrame(
																block.getDefaultState(), null, null, null);
											} catch (NullPointerException specialblock) {
												System.out.println(block.toString() + " has special conditions");
												return false;
											}
										}
						)
						.map(ItemStack::new).collect(Collectors.toList());
	}

	public List<ItemStack> getCache() {
		return cache;
	}
}
