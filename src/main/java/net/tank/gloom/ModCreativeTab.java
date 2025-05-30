package net.tank.gloom;
import net.minecraft.core.registries.Registries;
import net.tank.gloom.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraft.network.chat.Component;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GloomMod.MODID);

    public static final RegistryObject<CreativeModeTab> GLOOM_TAB = TABS.register("gloom_tab", () ->
        CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.gloom_tab")) // Your tab's display name
            .icon(() -> new ItemStack(ModItems.GLOOM_STONE_ITEM.get()))
            .displayItems((itemDisplayParameters,output)->{
                output.accept(ModItems.GLOOM_STONE_ITEM.get());
                output.accept(ModItems.GLOOM_DIRT_ITEM.get());
                output.accept(ModItems.GLOOM_GRASS_ITEM.get());
                output.accept(ModItems.GLOWSHROOM.get());
                output.accept(ModItems.GLOWSHROOM_CAP.get());
                output.accept(ModItems.GLOWSHROOM_STALK.get());
                output.accept(ModItems.GLOOM_IRON_ORE.get());
                output.accept(ModItems.GLOWSHROOM_SPORE.get());
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
