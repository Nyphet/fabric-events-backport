package crystalspider.fabriceventsbackport.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import crystalspider.fabriceventsbackport.api.event.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.network.ServerPlayerEntity;

/**
 * Injects into {@link ServerPlayerEntity} to add event callback hooks.
 */
@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends LivingEntityMixin {
  /**
   * Injects into {@link LivingEntity#onDeath(DamageSource)} at the end.
   * <p>
   * Adds the {@link ServerLivingEntityEvents#AFTER_DEATH} callback hook.
   * 
   * @param source
   * @param ci
   */
  @Inject(method = "onDeath", at = @At("TAIL"))
	private void notifyDeath(DamageSource source, CallbackInfo ci) {
		ServerLivingEntityEvents.AFTER_DEATH.invoker().afterDeath((ServerPlayerEntity) (Object) this, source);
	}
}
