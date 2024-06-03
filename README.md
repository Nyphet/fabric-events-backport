![Fabric Polyfill banner](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/fabric-polyfill/banner.png)

---
![Minecraft](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/minecraft.svg)[![1.18.2](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-18-2.svg)](https://modrinth.com/mod/fabric-polyfill/versions?g=1.18.2)![Separator](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/separator.svg)[![1.16.5](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/minecraft/1-16-5.svg)](https://modrinth.com/mod/fabric-polyfill/versions?g=1.16.5)

![Loader](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/loader.svg)[![Fabric](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/loader/fabric.svg)](https://modrinth.com/mod/fabric-polyfill/versions?l=fabric)

![Overlay](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/side/client-server.svg)

![Issues](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/issues.svg)[![GitHub](https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/github.svg)](https://github.com/crystal-nest/fabric-polyfill/issues)

---
# **Deprecated**
This mod is deprecated as 1.16.5 is no longer supported and 1.18.2 backported event has been moved to [Cobweb](https://github.com/Crystal-Nest/cobweb).

## **Description**
Backport of some Fabric API events from later versions.

## **Backported events**
- `ServerLivingEntityEvents`

## **How to use**
To import this API in your project, do the following in your `build.gradle`:  
```groovy
repositories {
  // Other repositories...
  maven {
    url "https://cursemaven.com"
    content {
      includeGroup "curse.maven"
    }
  }
  maven { url = "https://jitpack.io" }
}

dependencies {
  // Other dependencies...

  // Fabric API dependency
  modImplementation "net.fabricmc.fabric-api:fabric-api:${fabric_version}"
  // Fabric Polyfill dependency (check the correct file id via CurseForge: select the file on the website, open "Curse Maven Snippet", and copy the line)
  modImplementation "curse.maven:fabric-polyfill-926195:xxxxxxx"
  // MixinSquared dependency for Fabric Polyfill
  include(api(annotationProcessor("com.github.bawnorton.mixinsquared:mixinsquared-fabric:0.1.1")))
}
```

To use the events, use them as you would with normal Fabric API events in newer Minecraft versions.

## **License and right of use**
Feel free to use this mod for any modpack or video, just be sure to give credit and possibly link [here](https://github.com/crystal-nest/fabric-polyfill#readme).  
This project is published under the [GNU General Public License v3.0](https://github.com/crystal-nest/fabric-polyfill/blob/master/LICENSE).

## **Support us**

<a href="https://crystalnest.it"><img alt="Crystal Nest Website" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/crystal-nest/pic512.png" width="14.286%"></a><a href="https://discord.gg/BP6EdBfAmt"><img alt="Discord" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/discord/discord512.png" width="14.286%"></a><a href="https://www.patreon.com/crystalspider"><img alt="Patreon" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/patreon/patreon512.png" width="14.286%"></a><a href="https://ko-fi.com/crystalspider"><img alt="Ko-fi" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/kofi/kofi512.png" width="14.286%"></a><a href="https://github.com/Crystal-Nest"><img alt="Our other projects" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/github/github512.png" width="14.286%"><a href="https://modrinth.com/organization/crystal-nest"><img alt="Modrinth" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/modrinth/modrinth512.png" width="14.286%"></a><a href="https://www.curseforge.com/members/crystalspider/projects"><img alt="CurseForge" src="https://raw.githubusercontent.com/crystal-nest/mod-fancy-assets/main/curseforge/curseforge512.png" width="14.286%"></a>

[![Bisect Hosting](https://www.bisecthosting.com/partners/custom-banners/d559b544-474c-4109-b861-1b2e6ca6026a.webp "Bisect Hosting")](https://bisecthosting.com/crystalspider)
