package me.harborss.hungrypeaceful.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.Difficulty;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

/*
* Disables passive health and saturation regen.
*/
@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

    // implement constructor so the IDE will stop whining at me
    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "tickHunger()V", at = @At("HEAD"), cancellable = true)
    protected void onTickHunger(CallbackInfo ci) {
        if (this.getWorld().getDifficulty().equals(Difficulty.PEACEFUL)) {
            ci.cancel();
        }
    }

}
