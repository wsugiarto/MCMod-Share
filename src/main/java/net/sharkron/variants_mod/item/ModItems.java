package net.sharkron.variants_mod.item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sharkron.variants_mod.VariantsMod;
import net.sharkron.variants_mod.entity.custom.AmethystShardBolt;
import net.sharkron.variants_mod.item.custom.AmethystSpellbook;
import net.sharkron.variants_mod.item.custom.DiamondStaff;
import net.sharkron.variants_mod.item.custom.MetalDetectorItem;
import net.sharkron.variants_mod.item.custom.NetheriteFork;
import net.sharkron.variants_mod.item.custom.TNTGun;
import net.sharkron.variants_mod.item.custom.TopazStaff;
import net.sharkron.variants_mod.item.custom.WitherCannon;
import net.minecraft.world.item.Item;

public class ModItems {
    // basically just registers the MODID's items (like in /give @p [MODID]:shit_block)
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VariantsMod.MODID);

    // adding the actual items
    public static final RegistryObject<Item> NIGHT_STAR = ITEMS.register("night_star",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TNT_GUN = ITEMS.register("tnt_gun",
        () -> new TNTGun(new Item.Properties().durability(64)));
    
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
        () -> new MetalDetectorItem(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> TOPAZ_STAFF = ITEMS.register("topaz_staff",
        () -> new TopazStaff(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> DIAMOND_STAFF = ITEMS.register("diamond_staff",
        () -> new DiamondStaff(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> NETHERITE_FORK = ITEMS.register("netherite_fork",
        () -> new NetheriteFork(new Item.Properties().durability(64)));

    public static final RegistryObject<Item> AMETHYST_SPELLBOOK = ITEMS.register("amethyst_spellbook",
        () -> new AmethystSpellbook(new Item.Properties().durability(64)));

    //NEW
    public static final RegistryObject<Item> WITHER_CANNON = ITEMS.register("wither_cannon",
        () -> new WitherCannon(new Item.Properties().durability(64)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
