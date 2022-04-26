<div align="center">
    <img src="/media/Orbital.svg" />
    <h1>Orbital</h1>
    <p> Orbital is a under-development 2D game engine. </p>
</div>

# Installation

Orbital is avaliable on [Jitpack](https://jitpack.io). See below for the installation.

## Gradle
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
        maven {  url "https://dl.cloudsmith.io/public/electron-studio/jaylib/maven/" }
    }
}

dependencies {
    implementation 'uk.co.electronstudio.jaylib:jaylib:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-windows-x86_64:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-macosx-x86_64:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-linux-x86_64:4.0.+'
    implementation 'com.github.OrbitalEngine:Orbital:1.3.3'
}
```

## Maven
```xml
<repositories>
    <repository>
        <id>electron-studio-jaylib</id>
        <url>https://dl.cloudsmith.io/public/electron-studio/jaylib/maven/</url>
        <releases>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </releases>
        <snapshots>
            <enabled>true</enabled>
            <updatePolicy>always</updatePolicy>
        </snapshots>
    </repository>

    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>uk.co.electronstudio.jaylib</groupId>
        <artifactId>jaylib</artifactId>
        <version>3.7.0</version>
    </dependency>


    <dependency>
        <groupId>uk.co.electronstudio.jaylib</groupId>
        <artifactId>jaylib-natives-windows-x86_64</artifactId>
        <version>3.7.0</version>
    </dependency>


    <dependency>
        <groupId>uk.co.electronstudio.jaylib</groupId>
        <artifactId>jaylib-natives-macosx-x86_64</artifactId>
        <version>3.7.0</version>
    </dependency>


    <dependency>
        <groupId>uk.co.electronstudio.jaylib</groupId>
        <artifactId>jaylib-natives-linux-x86_64</artifactId>
        <version>3.7.0</version>
    </dependency>

    <dependency>
        <groupId>com.github.OrbitalEngine</groupId>
        <artifactId>Orbital</artifactId>
        <version>1.3.3</version>
    </dependency>
</dependencies>
```

## Contributing

Orbital is in its very early stages currently, and all contributions are more than welcome! However, before creating a pull request, first consider
opening an issue on the matter, so that the rest of the community can discuss it.

## Community

You can find us on Discord at https://discord.gg/khDKxYX9RM

## Backed By

<p align="center"> 
    <img src="https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg" alt="Jetbrains Logo">
</p>