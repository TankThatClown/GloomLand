package net.tank.gloom.entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;
public class ModEntities {
     public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GloomMod.MODID);
            public static final RegistryObject<EntityType<MuckBombEntity>> MUCK_BOMB_ENTITY =
            ENTITY_TYPES.register("muck_bomb_entity", () -> EntityType.Builder.<MuckBombEntity>of(MuckBombEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("muck_bomb_entity"));
    

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
