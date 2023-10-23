package crystalspider.fabriceventsbackport;

import crystalspider.fabriceventsbackport.api.event.ServerLivingEntityEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

/**
 * Fabric Events Backport mod loader.
 */
public class FabricEventsBackportLoader implements ModInitializer {
  /**
   * ID of this mod.
   */
  public static final String MODID = "fabriceventsbackport";

  @Override
	public void onInitialize() {
    ServerLivingEntityEvents.ALLOW_DAMAGE.register((LivingEntity entity, DamageSource source, float amount) -> {
      System.out.println(entity);
      System.out.println(source.getSource());
      System.out.println(source.getAttacker());
      return true;
    });
  }
}
