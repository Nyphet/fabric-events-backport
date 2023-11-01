package crystalspider.fabricpolyfill;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import com.bawnorton.mixinsquared.MixinSquaredBootstrap;

import net.fabricmc.loader.api.FabricLoader;

public class MixinConfigPlugin implements IMixinConfigPlugin {
  @Override
  public void onLoad(String mixinPackage) {
    MixinSquaredBootstrap.init();
  }

  @Override
  public String getRefMapperConfig() {
    return null;
  }

  @Override
  public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
    return mixinClassName.equals("crystalspider.fabricpolyfill.mixin.LivingEntityMixinSquared") ? FabricLoader.getInstance().isModLoaded("fabric-entity-events-v1") : true;
  }

  @Override
  public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

  @Override
  public List<String> getMixins() {
    return null;
  }

  @Override
  public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

  @Override
  public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
