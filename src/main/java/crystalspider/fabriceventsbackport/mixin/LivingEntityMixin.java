package crystalspider.fabriceventsbackport.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import crystalspider.fabriceventsbackport.api.event.ServerLivingEntityEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.world.World;

/**
 * Injects into {@link LivingEntity} to add event callback hooks.
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
  /**
   * Shadowed {@link LivingEntity#isDead()}.
   * 
   * @return
   */
  @Shadow
  public abstract boolean isDead();

  /**
   * Injects into {@link LivingEntity#onDeath(DamageSource)} at the invokation of {@link World#sendEntityStatus(Entity, byte)}.
   * <p>
   * Adds the {@link ServerLivingEntityEvents#AFTER_DEATH} callback hook.
   * 
   * @param source
   * @param ci
  */
  @Inject(method = "onDeath", at = @At(value = "INVOKE", target = "net/minecraft/world/World.sendEntityStatus(Lnet/minecraft/entity/Entity;B)V"))
	private void notifyDeath(DamageSource source, CallbackInfo ci) {
		ServerLivingEntityEvents.AFTER_DEATH.invoker().afterDeath((LivingEntity) (Object) this, source);
	}

  /**
   * Redirects the call to {@link LivingEntity#isDead()} in {@link LivingEntity#damage(DamageSource, float)}.
   * <p>
   * Adds the {@link ServerLivingEntityEvents#ALLOW_DEATH} callback hook.
   * 
   * @param livingEntity
   * @param source
   * @param amount
   * @return
  */
	@Redirect(method = "damage", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;isDead()Z", ordinal = 1))
	boolean beforeEntityKilled(LivingEntity livingEntity, DamageSource source, float amount) {
		return isDead() && ServerLivingEntityEvents.ALLOW_DEATH.invoker().allowDeath(livingEntity, source, amount);
	}

  /**
   * Injects into {@link LivingEntity#damage(DamageSource, float)} at the invokation of {@link LivingEntity#isSleeping()}.
   * <p>
   * Adds the {@link ServerLivingEntityEvents#ALLOW_DAMAGE} callback hook.
   * 
   * @param source
   * @param amount
   * @param cir
   */
	@Inject(method = "damage", at = @At(value = "INVOKE", target = "net/minecraft/entity/LivingEntity.isSleeping()Z"), cancellable = true)
	private void beforeDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
		if (!ServerLivingEntityEvents.ALLOW_DAMAGE.invoker().allowDamage((LivingEntity) (Object) this, source, amount)) {
			cir.setReturnValue(false);
		}
	}
}
