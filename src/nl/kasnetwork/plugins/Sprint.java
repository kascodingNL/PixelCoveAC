package nl.kasnetwork.plugins;

import javax.tools.DocumentationTool.Location;

import net.horizoncode.anticheat.checkbase.Check;
import net.horizoncode.anticheat.management.FlagPlayer;

public class Sprint extends Check {
	
	public Sprint() {
		super("Sprint");
	}
	
	
	public void onMove(FlagPlayer p, Location from, Location to) {
		if(p.canBypass())
			return;
		
	if(p.getPlayer().isSprinting() && p.getPlayer().getFoodLevel() < 6) {
		p.flag(this, "tried to Sprint when S(he) was hungry! S(he) is setted back");
		p.flag(this, "moved incorrectly(VL: 1)");
		p.flag(this, "moved incorrectly(VL: 2)");
		p.flag(this, "moved incorrectly(VL: 3)");
		p.flag(this, "moved incorrectly(VL: 4)");
	}
	}

}
