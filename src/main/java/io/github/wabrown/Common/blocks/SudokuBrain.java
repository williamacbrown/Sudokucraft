package io.github.wabrown.Common.blocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SudokuBrain extends Block{

	public SudokuBrain(Properties properties) {
		super(properties);
	}
	
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		if(worldIn.isRemote) {
			
			// Starting position, in the bottom left corner of the grid
			BlockPos current_pos = pos.north().west(4);
			
			// Sudoku grid positions, starts at bottom left corner at 0,0
			int[][] sgrid = new int[9][9];
			
			// Iterates through entire grid, saving it to the array
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					
					if(worldIn.getBlockState(current_pos).hasProperty(SudokuBlock.NUM)) {
						int num = worldIn.getBlockState(current_pos).get(SudokuBlock.NUM);
						if (num != 0) {
							sgrid[i][j] = num;
						} else {
							player.sendMessage(new TranslationTextComponent(
									"Cell at position " + Integer.toString(i+1) + ", " + Integer.toString(j+1) + " is empty!"), player.getUniqueID());
							return ActionResultType.SUCCESS;
						}
					} else {
						player.sendMessage(new TranslationTextComponent(
								"Block at position " + Integer.toString(i+1) + ", " + Integer.toString(j+1) + " is invalid!"), player.getUniqueID());
						return ActionResultType.SUCCESS;
					}
					current_pos = current_pos.north();
				}
				current_pos = current_pos.south(9);
				current_pos = current_pos.east();
			}
			
			// Debug message
			// player.sendMessage(new TranslationTextComponent("Sudoku successfully scanned!"), player.getUniqueID());
			
			// Checks for problems with the sudoku puzzle
			boolean solved = true;
			Set<Integer> numset = new HashSet<>();
			Set<Integer> colset = new HashSet<>();
			
			player.sendMessage(new TranslationTextComponent("--------------"), player.getUniqueID());
			// Columns
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					if(!numset.add(sgrid[i][j])) {
						if( colset.add(sgrid[i][j])) {
							player.sendMessage(new TranslationTextComponent(
									"§cRepeated " + Integer.toString(sgrid[i][j]) + " in column " + Integer.toString(i+1) + "!"), player.getUniqueID());
							solved = false;
						}
					}
				}
				numset.clear();
				colset.clear();
			}
			
			// Rows
			for(int j = 0; j < 9; j++) {
				for(int i = 0; i < 9; i++) {
					if(!numset.add(sgrid[i][j])) {
						if( colset.add(sgrid[i][j])) {
							player.sendMessage(new TranslationTextComponent(
									"§cRepeated " + Integer.toString(sgrid[i][j]) + " in row " + Integer.toString(j+1) + "!"), player.getUniqueID());
							solved = false;
						}
					}
				}
				numset.clear();
				colset.clear();
			}
			
			// Squares
			for(int isq = 0; isq < 3; isq++) {
				for(int jsq = 0; jsq < 3; jsq++) {
					for(int i = isq*3; i < (isq*3) + 3; i++) {
						for(int j = jsq*3; j < (jsq*3) + 3; j++) {
							if(!numset.add(sgrid[i][j])) {
								if( colset.add(sgrid[i][j])) {
									player.sendMessage(new TranslationTextComponent(
											"§cRepeated " + Integer.toString(sgrid[i][j]) + " in square "
											+ Integer.toString(isq+1) + ", " + Integer.toString(jsq+1) + "!"), player.getUniqueID());
									solved = false;
								}
							}
						}
					}
					numset.clear();
					colset.clear();
				}
			}
			
			if(solved) { player.sendMessage(new TranslationTextComponent("§aPUZZLE SOLVED!"), player.getUniqueID()); }
			player.sendMessage(new TranslationTextComponent("--------------"), player.getUniqueID());
		}
		return ActionResultType.SUCCESS;
	}

}
