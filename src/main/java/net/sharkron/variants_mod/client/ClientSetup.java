package net.sharkron.variants_mod.client;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.sharkron.variants_mod.VariantsMod;
import net.sharkron.variants_mod.client.renderer.AmethystShardBoltRenderer;
import net.sharkron.variants_mod.client.renderer.DiamondStaffBoltRenderer;
import net.sharkron.variants_mod.client.renderer.NetheriteForkProjectileRenderer;
import net.sharkron.variants_mod.client.renderer.TopazStaffBoltRenderer;
import net.sharkron.variants_mod.entity.ModEntity;

@Mod.EventBusSubscriber(modid = VariantsMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    @SubscribeEvent
    public static void doSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntity.TOPAZ_BOLT.get(), TopazStaffBoltRenderer::new);
        EntityRenderers.register(ModEntity.DIAMOND_BOLT.get(), DiamondStaffBoltRenderer::new);
        EntityRenderers.register(ModEntity.NETHERITE_FORK_PROJECTILE.get(), NetheriteForkProjectileRenderer::new);
        EntityRenderers.register(ModEntity.AMETHYST_SHARD_BOLT.get(), AmethystShardBoltRenderer::new);
    }
}
