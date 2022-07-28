package com.typyz.mysticanvil.item;

import com.typyz.mysticanvil.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab MYSTICANVIL_TAB = new CreativeModeTab("mysticAnvil") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.MYSTIC_ANVIL.get());
        }
    };
}
