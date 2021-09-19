package io.github.wabrown.Common.blocks;

import io.github.wabrown.Core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class SudokuBlock extends Block {

	// The number displayed on the block
	public static IntegerProperty NUM = IntegerProperty.create("num", 0, 9);
	public static IntegerProperty MODELNUM = IntegerProperty.create("modelnum", 0, 19);
	
	// Default Constructor
	public SudokuBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(NUM, 0));
		this.setDefaultState(this.stateContainer.getBaseState().with(MODELNUM, 0));
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		ItemStack itemstack = player.getHeldItem(handIn);
		
		// Saves the current properties of the block
		int current_num = worldIn.getBlockState(pos).get(NUM);
		int current_model = worldIn.getBlockState(pos).get(MODELNUM);
		boolean isLocked = (current_model > 9);
		
		if (isLocked) {
			if(itemstack.isItemEqual(new ItemStack(ItemInit.SUDOKU_KEY.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, current_num).with(MODELNUM, current_model - 10));
			}
		} else {
			if (itemstack.isItemEqual(new ItemStack(ItemInit.SUDOKU_KEY.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, current_num).with(MODELNUM, current_model + 10));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.ONE_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 1).with(MODELNUM, 1));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.TWO_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 2).with(MODELNUM, 2));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.THREE_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 3).with(MODELNUM, 3));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.FOUR_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 4).with(MODELNUM, 4));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.FIVE_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 5).with(MODELNUM, 5));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.SIX_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 6).with(MODELNUM, 6));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.SEVEN_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 7).with(MODELNUM, 7));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.EIGHT_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 8).with(MODELNUM, 8));
			} else if(itemstack.isItemEqual(new ItemStack(ItemInit.NINE_ITEM.get()))) {
				worldIn.setBlockState(pos, this.stateContainer.getBaseState().with(NUM, 9).with(MODELNUM, 9));
			}
		}
		
		return ActionResultType.SUCCESS;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
	      builder.add(NUM);
	      builder.add(MODELNUM);
	}
}
