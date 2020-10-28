package com.tfar.justenoughbeacons.jei;

import net.minecraft.item.ItemStack;

import java.util.List;

public abstract class AbstractRecipe {

	public final int index;

	public AbstractRecipe(int index) {
		this.index = index;
	}

	public List<ItemStack> getSublist() {
		return getCache().subList(28 * index, Math.min(28 * index + 28, getCache().size()));
	}

	public abstract List<ItemStack> getCache();

}
