![Logo](media/logo.png)

# Shifty Hotbar
[![GitHub tag](https://img.shields.io/github/v/tag/Kir-Antipov/shifty-hotbar.svg?cacheSeconds=3600&sort=date)](https://github.com/Kir-Antipov/shifty-hotbar/releases/latest)
[![GitHub build status](https://img.shields.io/github/workflow/status/Kir-Antipov/shifty-hotbar/build-artifacts/1.18.x/dev?cacheSeconds=3600)](https://github.com/Kir-Antipov/shifty-hotbar/actions/workflows/build-artifacts.yml)
[![Modrinth](https://img.shields.io/badge/dynamic/json?color=5da545&label=Modrinth&query=title&url=https://api.modrinth.com/v2/project/shifty-hotbar&style=flat&cacheSeconds=3600&logo=data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAxMSAxMSIgd2lkdGg9IjE0LjY2NyIgaGVpZ2h0PSIxNC42NjciICB4bWxuczp2PSJodHRwczovL3ZlY3RhLmlvL25hbm8iPjxkZWZzPjxjbGlwUGF0aCBpZD0iQSI+PHBhdGggZD0iTTAgMGgxMXYxMUgweiIvPjwvY2xpcFBhdGg+PC9kZWZzPjxnIGNsaXAtcGF0aD0idXJsKCNBKSI+PHBhdGggZD0iTTEuMzA5IDcuODU3YTQuNjQgNC42NCAwIDAgMS0uNDYxLTEuMDYzSDBDLjU5MSA5LjIwNiAyLjc5NiAxMSA1LjQyMiAxMWMxLjk4MSAwIDMuNzIyLTEuMDIgNC43MTEtMi41NTZoMGwtLjc1LS4zNDVjLS44NTQgMS4yNjEtMi4zMSAyLjA5Mi0zLjk2MSAyLjA5MmE0Ljc4IDQuNzggMCAwIDEtMy4wMDUtMS4wNTVsMS44MDktMS40NzQuOTg0Ljg0NyAxLjkwNS0xLjAwM0w4LjE3NCA1LjgybC0uMzg0LS43ODYtMS4xMTYuNjM1LS41MTYuNjk0LS42MjYuMjM2LS44NzMtLjM4N2gwbC0uMjEzLS45MS4zNTUtLjU2Ljc4Ny0uMzcuODQ1LS45NTktLjcwMi0uNTEtMS44NzQuNzEzLTEuMzYyIDEuNjUxLjY0NSAxLjA5OC0xLjgzMSAxLjQ5MnptOS42MTQtMS40NEE1LjQ0IDUuNDQgMCAwIDAgMTEgNS41QzExIDIuNDY0IDguNTAxIDAgNS40MjIgMCAyLjc5NiAwIC41OTEgMS43OTQgMCA0LjIwNmguODQ4QzEuNDE5IDIuMjQ1IDMuMjUyLjgwOSA1LjQyMi44MDljMi42MjYgMCA0Ljc1OCAyLjEwMiA0Ljc1OCA0LjY5MSAwIC4xOS0uMDEyLjM3Ni0uMDM0LjU2bC43NzcuMzU3aDB6IiBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGZpbGw9IiM1ZGE0MjYiLz48L2c+PC9zdmc+)](https://modrinth.com/mod/shifty-hotbar)
[![CurseForge](https://img.shields.io/badge/dynamic/json?color=%23f16436&label=CurseForge&query=title&url=https%3A%2F%2Fapi.cfwidget.com%2F633518)](https://www.curseforge.com/minecraft/mc-mods/shifty-hotbar)
[![GitHub license](https://img.shields.io/github/license/Kir-Antipov/shifty-hotbar.svg?cacheSeconds=36000)](https://github.com/Kir-Antipov/shifty-hotbar#readme)

An utility mod that adds the hotbar shifting ability inspired by Stardew Valley.

I know that there are mods like this in the wild, but none of them did suit me whatsoever. Therefore I made the ultimate version that consists of every feature a mod like this can possibly provide:

 - You can shift inventory rows in **both** directions *(`Up Arrow` and `Down Arrow` by default)*
 - You can shift inventory columns in **both** directions *(`Right Arrow` and `Left Arrow` by default)*
 - You can shift slots in your hotbar in **both** directions
 - You can shift slots in the selected column in **both** directions
 - You can shift rows, columns and slots via **mouse scroll** while pressing a `modifier` key *(`Left Alt` by default)*
 - You can quickly shift to a row, a column, or a slot via hotbar hotkeys (`1...9`) while pressing a `modifier` key *(`Left Alt` by default)*

----

## Key Binds

Key binds can be configured just like vanilla ones:

 - Go to `Options...`
 - Select `Controls...`
 - Then choose `Key Binds...`
 - Scroll down to the `Shifty Hotbar` section

| Name | Description | Default |
| ---- | ----------- | ------------- |
| `Row modifier` | When pressed, it allows you to shift rows instead of choosing a slot via mouse scroll/hotkeys (`1...9`) | `Left Alt` |
| `Previous row` | Shifts all rows in your inventory so that the topmost row in your inventory becomes the hotbar | `Down Arrow` |
| `Next row` | Shifts all rows in your inventory so that the row above your hotbar becomes the hotbar | `Up Arrow` |
| `Row-in-column modifier` | When pressed, it allows you to shift slots in the selected column instead of choosing one via mouse scroll | |
| `Previous row-in-column` | Shifts all slots in the selected column so that the topmost slot in your inventory becomes the hotbar slot | |
| `Next row-in-column` | Shifts all slots in the selected column so that the slot above your hotbar slot becomes the hotbar slot | |
| `Column modifier` | When pressed, it allows you to shift columns instead of choosing a slot via mouse scroll/hotkeys (`1...9`) | |
| `Previous column` | Shifts all columns in your inventory so that the slot before your selected slot becomes the selected slot | `Left Arrow` |
| `Next column` | Shifts all columns in your inventory so that the slot after your selected slot becomes the selected slot | `Right Arrow` |
| `Column-in-row modifier` | When pressed, it allows you to shift slots in the hotbar instead of choosing one via mouse scroll | |
| `Previous column-in-row` | Shifts all slots in your hotbar so that the slot before your selected slot becomes the selected slot | |
| `Next column-in-row` | Shifts all slots in your hotbar so that the slot after your selected slot becomes the selected slot | |

----

## Config

If you have [Cloth Config](https://www.curseforge.com/minecraft/mc-mods/cloth-config) installed, you can customize the behavior of the mod. A config is usually located at `./config/shifty_hotbar.json` and by default looks like this:

```json
{
  "invertRowScroll": false,
  "invertColumnScroll": false
}
```

| Name | Description | Default value |
| ---- | ----------- | ------------- |
| `invertRowScroll` | Inverts mouse scroll when `row` or `row-in-column` modifier is pressed | `false` |
| `invertColumnScroll` | Inverts mouse scroll when `column` or `column-in-row` modifier is pressed | `false` |

You can edit any of these values directly in the config file or via [ModMenu](https://www.curseforge.com/minecraft/mc-mods/modmenu).

----

## Installation

Requirements:
- Minecraft `1.18.x`
- Fabric Loader `>=0.12.0`
- Fabric API `>=0.43.1`

You can download the mod from:

- [GitHub Releases](https://github.com/Kir-Antipov/shifty-hotbar/releases/latest) <sup><sub>(recommended)</sub></sup>
- [Modrinth](https://modrinth.com/mod/shifty-hotbar)
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/shifty-hotbar)
- [GitHub Actions](https://github.com/Kir-Antipov/shifty-hotbar/actions/workflows/build-artifacts.yml) *(these builds may be unstable, but they represent the actual state of the development)*

## Building from sources

Requirements:
- JDK `17`

### Linux/MacOS

```cmd
git clone https://github.com/Kir-Antipov/shifty-hotbar.git
cd shifty-hotbar

chmod +x ./gradlew
./gradlew build
cd build/libs
```
### Windows

```cmd
git clone https://github.com/Kir-Antipov/shifty-hotbar.git
cd shifty-hotbar

gradlew build
cd build/libs
```
