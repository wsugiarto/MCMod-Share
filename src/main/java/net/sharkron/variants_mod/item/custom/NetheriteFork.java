package net.sharkron.variants_mod.item.custom;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.sharkron.variants_mod.entity.custom.NetheriteForkProjectile;
import net.sharkron.variants_mod.item.ModItems;

public class NetheriteFork extends Item{
    public NetheriteFork(Properties pProperties){
        super(pProperties);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        int maxUseBeforeBroken = itemstack.getMaxDamage() - 1;

        if (!level.isClientSide && itemstack.getDamageValue() < maxUseBeforeBroken) {
            Vec3 look = player.getLookAngle(); // Get the player's look vector
            double spawnX = player.getX();
            double spawnY = player.getY() + player.getEyeHeight();
            double spawnZ = player.getZ();

            // WitherSkull proj1 = new WitherSkull(level, player, look.x, look.y, look.z);
            NetheriteForkProjectile proj1 = new NetheriteForkProjectile(level, player, look.x, look.y, look.z);

            level.addFreshEntity(proj1);
            player.getCooldowns().addCooldown(this, 30);
            itemstack.hurtAndBreak(1, player, 
                    p -> p.broadcastBreakEvent(hand));

            player.awardStat(Stats.ITEM_USED.get(this));
            player.gameEvent(GameEvent.ITEM_INTERACT_START);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }

    public boolean isValidRepairItem(ItemStack p_41134_, ItemStack p_41135_) {
        return p_41135_.is(ModItems.NIGHT_STAR.get());
    }
}
