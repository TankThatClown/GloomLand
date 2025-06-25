package net.tank.gloom.entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tank.gloom.GloomMod;
import net.tank.gloom.entity.custom.*;
public class ModEntities {
     public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, GloomMod.MODID);

    public static final RegistryObject<EntityType<MuckBombEntity>> MUCK_BOMB_ENTITY =
            ENTITY_TYPES.register("muck_bomb_entity", () -> EntityType.Builder.<MuckBombEntity>of(MuckBombEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f).build("muck_bomb_entity"));

     public static final RegistryObject<EntityType<GlowToadEntity>> GLOW_TOAD_ENTITY =
            ENTITY_TYPES.register("glow_toad", () -> EntityType.Builder.of(GlowToadEntity::new, MobCategory.CREATURE)
                    .sized(1.2f, 1.2f).build("glow_toad"));
    

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
