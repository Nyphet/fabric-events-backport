package crystalspider.fabricpolyfill.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.bawnorton.mixinsquared.TargetHandler;

import crystalspider.fabricpolyfill.api.event.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

/**
 * Injects into the Fabric API LivingEntityMixin to alter event handling.
 */
@Mixin(value = LivingEntity.class, priority = 2000)
public abstract class LivingEntityMixinSquared {
  /**
   * Shadowed {@link LivingEntity#isDead()}.
   * 
   * @return
   */
  @Shadow
  public abstract boolean isDead();

  /**
   * Injects into {@link net.fabricmc.fabric.mixin.entity.event.LivingEntityMixin#beforePlayerKilled(LivingEntity, DamageSource, float)} at the start.
   * <p>
   * Basically overwrites the original handler and instead triggers the {@link ServerLivingEntityEvents#ALLOW_DEATH} event.
   * 
   * @param livingEntity
   * @param source
   * @param amount
   * @param cir
   */
  @TargetHandler(mixin = "net.fabricmc.fabric.mixin.entity.event.LivingEntityMixin", name = "beforePlayerKilled")
  @Inject(method = "@MixinSquared:Handler", at = @At(value = "HEAD"), cancellable = true)
  private void beforeEntityKilled(LivingEntity livingEntity, DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
    cir.setReturnValue(isDead() && ServerLivingEntityEvents.ALLOW_DEATH.invoker().allowDeath(livingEntity, source, amount));
  }
}
