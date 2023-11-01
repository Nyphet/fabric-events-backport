![Fabric Polyfill](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/fabric-polyfill/banner.png)

---
![Minecraft](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/minecraft/minecraft.svg)[![1.18.2](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/minecraft/1-18-2.svg)](https://modrinth.com/mod/fabric-polyfill/versions?g=1.18.2)![Separator](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/separator.svg)[![1.16.5](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/minecraft/1-16-5.svg)](https://modrinth.com/mod/fabric-polyfill/versions?g=1.16.5)

![Loader](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/loader/loader.svg)[![Fabric](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/loader/fabric.svg)](https://modrinth.com/mod/fabric-polyfill/versions?l=fabric)

![Overlay](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/side/client-server.svg)

![Issues](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/github/issues.svg)[![GitHub](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/github/github.svg)](https://github.com/Nyphet/fabric-polyfill/issues)

---
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
Feel free to use this mod for any modpack or video, just be sure to give credit and possibly link [here](https://github.com/Nyphet/fabric-polyfill#readme).  
This project is published under the [GNU General Public License v3.0](https://github.com/Nyphet/fabric-polyfill/blob/master/LICENSE).

## **Support me**
[![Twitch](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/twitch/twitch64.png "Twitch")](https://www.twitch.tv/crystal_spider_)
[![Patreon](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/patreon/patreon64.png "Patreon")](https://www.patreon.com/crystalspider)
[![Ko-fi](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/kofi/kofi64.png "Ko-fi")](https://ko-fi.com/crystalspider)
[![GitHub](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/github/github64.png "My other projects")](https://github.com/Nyphet)
[![Modrinth](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/modrinth/modrinth64.png "Modrinth")](https://modrinth.com/user/Nyphet)
[![Curseforge](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/curseforge/curseforge64.png "Curseforge")](https://www.curseforge.com/members/crystal_spider_/projects)

[![Kinetic Hosting](https://raw.githubusercontent.com/Nyphet/mod-fancy-assets/main/hosting/banner-small.png "Kinetic Hosting")](https://billing.kinetichosting.net/aff.php?aff=122)
