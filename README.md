<div align="center">
    <img src="/media/Orbital.svg" />
    <h1>Orbital</h1>
    <p> Orbital is a under-development 2D game engine. </p>
</div>

# Installation

Orbital is avaliable on [Jitpack](https://jitpack.io). See below for the installation:

## Gradle
```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}

dependencies {
    implementation 'uk.co.electronstudio.jaylib:jaylib:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-windows-x86_64:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-macosx-x86_64:4.0.+'
    implementation 'uk.co.electronstudio.jaylib:jaylib-natives-linux-x86_64:4.0.+'
    implementation 'com.github.OrbitalEngine:Orbital:v.0.1'
}
```

## Maven
```xml
<repositories>
	<repository>
		   <id>jitpack.io</id>
		   <url>https://jitpack.io</url>
	</repository>
</repositories>


<dependency>
    <groupId>com.github.OrbitalEngine</groupId>
    <artifactId>Orbital</artifactId>
    <version>v.0.1</version>
</dependency>
```

## Contributing

Orbital is in its very early stages currently, and all contributions are more than welcome! However, before creating a pull request, first consider
opening an issue on the matter, so that the rest of the community can discuss it.

## Community

You can find us on Discord at https://discord.gg/khDKxYX9RM