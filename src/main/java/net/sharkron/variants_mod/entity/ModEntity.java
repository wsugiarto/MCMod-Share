package net.sharkron.variants_mod.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sharkron.variants_mod.VariantsMod;
import net.sharkron.variants_mod.entity.custom.AmethystShardBolt;
import net.sharkron.variants_mod.entity.custom.DiamondStaffBolt;
import net.sharkron.variants_mod.entity.custom.NetheriteForkProjectile;
import net.sharkron.variants_mod.entity.custom.TopazStaffBolt;

public class ModEntity {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, VariantsMod.MODID);

    public static final RegistryObject<EntityType<TopazStaffBolt>> TOPAZ_BOLT = ENTITY_TYPES.register("topaz_bolt",
        () -> EntityType.Builder.of((EntityType.EntityFactory<TopazStaffBolt>) TopazStaffBolt::new, MobCategory.MISC).sized(0.5F, 0.5F).build("topaz_bolt"));

    public static final RegistryObject<EntityType<DiamondStaffBolt>> DIAMOND_BOLT = ENTITY_TYPES.register("diamond_bolt",
        () -> EntityType.Builder.of((EntityType.EntityFactory<DiamondStaffBolt>) DiamondStaffBolt::new, MobCategory.MISC).sized(1F, 1F).build("diamond_bolt"));
    
        public static final RegistryObject<EntityType<NetheriteForkProjectile>> NETHERITE_FORK_PROJECTILE = ENTITY_TYPES.register("netherite_fork_projectile",
        () -> EntityType.Builder.of((EntityType.EntityFactory<NetheriteForkProjectile>) NetheriteForkProjectile::new, MobCategory.MISC).sized(1F, 1F).build("netherite_fork_projectile"));
    
    public static final RegistryObject<EntityType<AmethystShardBolt>> AMETHYST_SHARD_BOLT = ENTITY_TYPES.register("amethyst_shard",
        () -> EntityType.Builder.of((EntityType.EntityFactory<AmethystShardBolt>) AmethystShardBolt::new, MobCategory.MISC).sized(1F, 1F).build("amethyst_shard"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
