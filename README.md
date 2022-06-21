# XtremeAPI [![](https://jitpack.io/v/XtremePlugins/XtremeAPI.svg)](https://jitpack.io/#XtremePlugins/XtremeAPI)
XtremeAPI is a library that aims to provide numerous active and updated features for developers to simplify their code for minecraft servers.

It also includes a collection of external libraries useful for development.

## Features already added

- [External library] [Configurate](https://github.com/SpongePowered/Configurate).

## Planned features

- ActionBar
- Clickable & hoverable messages
- Titles & subtitles
- Tablist header & footer
- Holograms
- And more to come!

## Install
To install the library using maven use:
```
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>com.github.XtremePlugins</groupId>
            <artifactId>XtremeAPI</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```
To install the library using gradle use:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
	dependencies {
		implementation 'com.github.XtremePlugins:XtremeAPI:1.0.1'
	}
```
