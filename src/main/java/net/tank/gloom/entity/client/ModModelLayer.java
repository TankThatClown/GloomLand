package net.tank.gloom.entity.client;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.tank.gloom.GloomMod;
import net.minecraft.resources.ResourceLocation;
public class ModModelLayer {
    public static final ModelLayerLocation GLOW_TOAD_LAYER = 
    new ModelLayerLocation(new ResourceLocation(GloomMod.MODID, "glow_toad"), "main");

    public static final ModelLayerLocation CRYSTAL_BOAR_LAYER =
            new ModelLayerLocation(new ResourceLocation(GloomMod.MODID, "crystal_boar"), "main");
}
