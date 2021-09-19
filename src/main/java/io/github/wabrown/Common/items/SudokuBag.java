package io.github.wabrown.Common.items;

import io.github.wabrown.Core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SudokuBag extends Item{
	

	// Default constructor
	public SudokuBag(Properties properties) {
		super(properties);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		playerIn.getHeldItem(handIn).shrink(1);
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.ONE_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.TWO_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.THREE_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.FOUR_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.FIVE_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.SIX_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.SEVEN_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.EIGHT_ITEM.get()));
		playerIn.addItemStackToInventory(new ItemStack(ItemInit.NINE_ITEM.get()));
		return ActionResult.resultSuccess(playerIn.getHeldItem(handIn));
	}
	
}
