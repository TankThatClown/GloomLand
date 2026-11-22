package net.tank.gloom.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.tank.gloom.item.ModEquipmentItems;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class ShadowsteelArmorItem extends ArmorItem {
    public ShadowsteelArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide || player.tickCount % 20 != 0||getType() != ArmorItem.Type.HELMET) {
            return;
        }
        if(hasFullSet(player)&&level.isNight()){
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,260,0,false,false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,260,0,false,false));
        }

    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(
                Component.literal("Full set bonus: Night Vision + Speed I")
                        .withStyle(ChatFormatting.LIGHT_PURPLE));
    }

    private boolean hasFullSet(Player player)
    {
        ItemStack boots =player.getInventory().getArmor(0);
        ItemStack leggings =player.getInventory().getArmor(1);
        ItemStack chestplate =player.getInventory().getArmor(2);
        ItemStack helmet =player.getInventory().getArmor(3);
        return (!boots.isEmpty()&&boots.is(ModEquipmentItems.SHADOWSTEEL_BOOTS.get())
                &&!leggings.isEmpty()&&leggings.is(ModEquipmentItems.SHADOWSTEEL_LEGGINGS.get())
                &&!chestplate.isEmpty()&&chestplate.is(ModEquipmentItems.SHADOWSTEEL_CHESTPLATE.get())
                &&!helmet.isEmpty()&&helmet.is(ModEquipmentItems.SHADOWSTEEL_HELMET.get())
        );

    }

}
