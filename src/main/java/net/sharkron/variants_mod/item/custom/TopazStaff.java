package net.sharkron.variants_mod.item.custom;

import net.minecraft.client.renderer.entity.DragonFireballRenderer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.FishingHook;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import net.sharkron.variants_mod.entity.custom.TopazStaffBolt;
import net.sharkron.variants_mod.item.ModItems;

public class TopazStaff extends Item{
    public TopazStaff(Properties pProperties){
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

            // SmallFireball proj = new SmallFireball(EntityType.SMALL_FIREBALL, level);
            // proj.setPos(spawnX, spawnY, spawnZ);
            // proj.shoot(look.x, look.y, look.z, 1.5f, 0.0f); // x, y, z, speed, inaccuracy
            // This constructor method will spawn the projectile (but it will friction out after a bit)

            // SmallFireball proj1 = new SmallFireball(level, player, look.x, look.y, look.z);

            // This constructor method will spawn the projectile with the given location NOT as position, but trajectory
            // SpectralArrow proj1 = new SpectralArrow(level, player);
            // proj1.setPos(spawnX, spawnY, spawnZ);
            // proj1.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
            // proj1.shoot(look.x, look.y, look.z, 1.5f, 0.0f);

            // DragonFireball proj1 = new DragonFireball(level, player, look.x, look.y, look.z);

            TopazStaffBolt proj1 = new TopazStaffBolt(level, player, look.x, look.y, look.z);

            // proj.setDeltaMovement(0, look.y + 0.5, 0); // Set the initial velocity
            // Apparently doing this on a projectile can make the proj have this speed before changing back to the projectile's initial speed

            level.addFreshEntity(proj1); // adding the entity into the world level
            player.getCooldowns().addCooldown(this, 10);
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
