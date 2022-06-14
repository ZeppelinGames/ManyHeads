# ManyHeads
Easy to use functions to create player or custom heads (as ItemStacks) in Minecraft Spigot

# Basic Usage:  
## Creating Player Heads
Usage:   
`CreatePlayerHead("<player name>")`  
Example:  
`ItemStack playerHead = CreatePlayerHead("ZeppelinGames")`  

## Creating Custom Heads  
Custom heads can be found on multiple sites such as: https://minecraft-heads.com/custom-heads  
Make sure Minecraft-URL is used in the function, not value.

Usage:  
`CreateCustomHead("<Minecraft-URL>")`  
Example:  
`ItemStack customHead = CreatePlayerHead("e34a592a79397a8df3997c43091694fc2fb76c883a76cce89f0227e5c9f1dfe")`  

Usage:  
`CreateCustomHead("<Minecraft-URL>", "<Custom-Name>")`  
Example:  
`Item Stack customHead = CreatePlayerHead("e34a592a79397a8df3997c43091694fc2fb76c883a76cce89f0227e5c9f1dfe", "Trophy Gold")`  
