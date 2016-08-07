package com.robinmc.ublisk.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.robinmc.ublisk.utils.MessageTarget;
import com.robinmc.ublisk.utils.UUIDUtils;
import com.robinmc.ublisk.utils.exception.PlayerNotFoundException;
import com.robinmc.ublisk.utils.variable.Message;

public class MsgCommand implements CommandExecutor {
	
	// TODO Register command
	// TODO Command in plugin.yml
	// TODO Aliases
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if (!(sender instanceof Player)){
			sender.sendMessage(Message.NOT_A_PLAYER.get());
			return true;
		}
		
		Player player = (Player) sender;
		
		if (args.length >= 2){
			MessageTarget target;
			try {
				target = new MessageTarget(UUIDUtils.getPlayerFromName(args[0]));
			} catch (PlayerNotFoundException e){
				player.sendMessage(Message.PLAYER_NOT_FOUND.get());
				return true;
			}
			
			/*
			 * Send every argument with a space in between. For example:
			 * /msg RobinMC Hello world
			 * Will give you:
			 * Args0 = Hello
			 * Args1 = world
			 * 
			 * Then join these together:
			 * Hello + space + world (+ space)
			 */
			
			String msg = "";
			for (String word : args){
				msg = String.join(msg, word + " ");
			}
			
			target.sendMessage(msg);
			target.setLastSender(player);
			return true;
		} else {
			player.sendMessage(Message.WRONG_USAGE.get());
			return true;
		}
		
	}

}
