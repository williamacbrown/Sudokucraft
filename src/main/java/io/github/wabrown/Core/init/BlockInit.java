package io.github.wabrown.Core.init;

import io.github.wabrown.SudokuCraft;
import io.github.wabrown.Common.blocks.SudokuBlock;
import io.github.wabrown.Common.blocks.SudokuBrain;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SudokuCraft.MOD_ID);
	
	public static final RegistryObject<SudokuBlock> SUDOKU_BLOCK = BLOCKS.register("sudoku_block",
			() -> new SudokuBlock(AbstractBlock.Properties.create(Material.IRON)));
	public static final RegistryObject<SudokuBrain> SUDOKU_BRAIN = BLOCKS.register("sudoku_brain",
			() -> new SudokuBrain(AbstractBlock.Properties.create(Material.IRON)));
}
