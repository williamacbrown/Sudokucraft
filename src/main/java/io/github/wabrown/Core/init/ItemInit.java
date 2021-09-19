package io.github.wabrown.Core.init;

import io.github.wabrown.SudokuCraft;
import io.github.wabrown.Common.items.SudokuBag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	// Registers items to be added to the mod
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SudokuCraft.MOD_ID);
	
	// Holds items before and after registry
	public static final RegistryObject<Item> ONE_ITEM = ITEMS.register("one_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> TWO_ITEM = ITEMS.register("two_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> THREE_ITEM = ITEMS.register("three_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> FOUR_ITEM = ITEMS.register("four_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> FIVE_ITEM = ITEMS.register("five_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> SIX_ITEM = ITEMS.register("six_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> SEVEN_ITEM = ITEMS.register("seven_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> EIGHT_ITEM = ITEMS.register("eight_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<Item> NINE_ITEM = ITEMS.register("nine_item", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	// Sudoku bag
	public static final RegistryObject<SudokuBag> SUDOKU_BAG = ITEMS.register("sudoku_bag", 
			() -> new SudokuBag(new Item.Properties().group(ItemGroup.MISC)));
	
	// Sudoku key
	public static final RegistryObject<Item> SUDOKU_KEY = ITEMS.register("sudoku_key", 
			() -> new Item(new Item.Properties().group(ItemGroup.MISC)));
	
	// Block items
	public static final RegistryObject<BlockItem> SUDOKU_BLOCK = ITEMS.register("sudoku_block", () -> new BlockItem(BlockInit.SUDOKU_BLOCK.get(), new Item.Properties().group(ItemGroup.MISC)));
	public static final RegistryObject<BlockItem> SUDOKU_BRAIN = ITEMS.register("sudoku_brain", () -> new BlockItem(BlockInit.SUDOKU_BRAIN.get(), new Item.Properties().group(ItemGroup.MISC)));
	
}
