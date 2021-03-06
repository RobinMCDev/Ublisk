package xyz.derkades.ublisk.commands.ublisk;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import net.md_5.bungee.api.ChatColor;
import xyz.derkades.ublisk.utils.MaterialLists;
import xyz.derkades.ublisk.utils.UPlayer;

public class FixGrassCommand extends UbliskCommand {


	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCommand(UPlayer player, String[] args) {
		Location location = player.getLocation();
		List<Block> blocks = new ArrayList<Block>();
		for (int x = -10; x < 11; x++){
			for (int y = -10; y < 11; y++){
				for (int z = -10; z < 11; z++){
					blocks.add(new Location(location.getWorld(), location.getX() + x, location.getY() + y, location.getZ() + z).getBlock());
				}
			}
		}
		
		int changed = 0;
		for (Block block : blocks){
			if (block.getType() == Material.GRASS){
				// If the block above a grass block is under water, change grass to dirt
				if (block.getRelative(BlockFace.UP).getType() == Material.WATER){
					block.setType(Material.DIRT);
					changed++;
				} else if (MaterialLists.PARTIAL_BLOCKS.contains(block.getRelative(BlockFace.UP).getType())){
					return;
				} else if (block.getRelative(BlockFace.UP).getType().isSolid()){
					// If the block above a grass block is solid, change grass to dirt
					block.setType(Material.DIRT);
					changed++;
				}
			} else if (block.getType() == Material.DIRT && block.getData() == 0){
				if (block.getRelative(BlockFace.UP).getType() == Material.WATER){
					// Don't do anything if the dirt block is under water
					continue;
				}
				
				// If the block above the dirt block is not solid, change dirt to grass
				if (!block.getRelative(BlockFace.UP).getType().isSolid() ||
						MaterialLists.PARTIAL_BLOCKS.contains(block.getRelative(BlockFace.UP).getType())){
					block.setType(Material.GRASS);
					changed++;
				}
			}
		}
		
		player.sendMessage(ChatColor.AQUA + "Changed " + changed + " blocks.");
	}

	@Override
	protected String getDescription() {
		return "Fixes grass in a 10x10x10 area";
	}

	@Override
	protected String[] getAliases() {
		return new String[]{"fixgrass", "grass", "growgrass"};
	}

}
