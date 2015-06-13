package techreborn.client.hud;

import ic2.api.item.IElectricItem;
import ic2.api.item.IElectricItemManager;
import ic2.core.item.ElectricItemManager;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class ChargeHud 
{
	public static final ChargeHud instance = new ChargeHud();
	private static Minecraft mc = Minecraft.getMinecraft();
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOW)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) 
	{
		if (event.isCancelable() || event.type != ElementType.ALL)
			return;
		
		if (mc.inGameHasFocus || (mc.currentScreen != null && mc.gameSettings.showDebugInfo))
			drawChargeHud(event.resolution);
	}
	
	public void drawChargeHud(ScaledResolution res)
	{
		EntityPlayer player = mc.thePlayer;
		ItemStack stack = player.getCurrentArmor(2);;
		if(stack != null)
		{
			if((stack.getItem() instanceof IElectricItem))
			{
				double MaxCharge = ((IElectricItem) stack.getItem()).getMaxCharge(stack);
				//TODO find a way to get current charge 
				double CurrentCharge = ((IElectricItem) stack.getItem()).getMaxCharge(stack);
				mc.fontRenderer.drawString(Double.toString(CurrentCharge) + "/" + Double.toString(MaxCharge), 0, 0, 0);
			}
		}
	}
}
