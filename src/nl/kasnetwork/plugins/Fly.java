
///////////////////////////////
// Don't change below this   //
//							 //
//							 //
//		All right to		 //
//		IkasCoding			 //
///////////////////////////////

package nl.kasnetwork.plugins;

import javax.tools.DocumentationTool.Location;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;

import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

public class Fly extends Check {
	
	
	public Fly() {
		super("Fly");
	}
	
	//Code of PlaceBack Holder
	
	public void onMove(FlagPlayer p, Location from, Location to) {
		if(p.canBypass())
			return;
		
		
		//Code of Checker!
		p.getPlayer().isBanned();
		String target = null;
		Bukkit.getBanList(Type.NAME).addBan(target, "You tried logging in while you are banned! You are banned again XD!", null, null);
			
			p.flag(this, "tried to log in while (S)he was banned!!");
		}
	}
