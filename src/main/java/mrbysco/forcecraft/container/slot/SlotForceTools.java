package mrbysco.forcecraft.container.slot;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

import mrbysco.forcecraft.blocks.infuser.InfuserTileEntity;

public class SlotForceTools extends SlotItemHandler {
    public SlotForceTools(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return InfuserTileEntity.validToolList.contains(stack.getItem());
    }

    @Override
    public int getItemStackLimit(@Nonnull ItemStack stack) {
        return 1;
    }
}
