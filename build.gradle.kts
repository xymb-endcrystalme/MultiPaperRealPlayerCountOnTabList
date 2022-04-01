plugins {
  `java-library`
  id("io.papermc.paperweight.userdev") version "1.3.5"
  id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
  maven("https://repo.dmulloy2.net/repository/public/")
  maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
  maven("https://clojars.org/repo")
}

group = "io.papermc.paperweight"
version = "1.0"
description = "Show real player count in MultiPaper's TabList"

java {
  // Configure the java toolchain. This allows gradle to auto-provision JDK 17 on systems that only have JDK 8 installed for example.
  toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

dependencies {
  paperDevBundle("1.18.1-R0.1-SNAPSHOT")
  implementation("com.github.puregero:multilib:1.1.2")

  compileOnly("com.comphenix.protocol:ProtocolLib:4.8.0")
  compileOnly("me.clip:placeholderapi:2.10.6")
}

tasks {
  // Configure reobfJar to run when invoking the build task
  assemble {
    dependsOn(reobfJar)
  }

  compileJava {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

    // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
    // See https://openjdk.java.net/jeps/247 for more information.
    options.release.set(17)
  }
  javadoc {
    options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  processResources {
    filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
  }
  /*
  reobfJar {
    // This is an example of how you might change the output location for reobfJar. It's recommended not to do this
    // for a variety of reasons, however it's asked frequently enough that an example of how to do it is included here.
    outputJar.set(layout.buildDirectory.file("libs/PaperweightTestPlugin-${project.version}.jar"))
  }
   */
}
